package mobi.ms3.service;

import lombok.extern.slf4j.Slf4j;
import mobi.ms3.enums.Ms;
import mobi.ms3.model.Message;
import mobi.ms3.model.ReceivedMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    RestTemplate restTemplate;

    public MessageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ReceivedMessage sendingMessage(Message message) {


        //Before sending message generating a new Id
        message.setId("ms3");

        message.setBody(message.getBody().concat("-> MS3"));

        log.info("message with id : {} and body : {} | from source : {} | next destination {}", message.getId(),message.getBody(),message.getSource().toString(),message.getDestination());

        //sending message
        return sendingProcess(message, "lb://"+message.getDestination().toString()+"/received");
    }

    @Override
    public List<ReceivedMessage> random(int repetition) {
        List<ReceivedMessage> receivedMessages = new ArrayList<>();

        for (int i = 0; i < repetition ; i++ ){
            int randomNumber2 = (int) (Math.random() *3);
            Ms dst = Ms.values()[randomNumber2];
            Message message =Message.builder().id("ms3").body("Random Message").source(Ms.MS3).destination(dst).build();
            receivedMessages.add(sendingProcess(message, "lb://"+message.getDestination().toString()+"/received")) ;
        }

        return receivedMessages;
    }

    @Override
    public ReceivedMessage receivingMessage(Message message) {
        for (int i = 0; i<500; i++){};
        return new ReceivedMessage("ms3", "The Message is received correctly");
    }


    public ReceivedMessage sendingProcess(Message message, String destination){
        //Exception to insure the sending of the message to the destination
        try {
            //sending message
            return restTemplate.postForObject(destination,message,ReceivedMessage.class);
        }catch (Exception e){

            return new ReceivedMessage(message.getDestination().toString(), "The Message does not sent as it should");
        }
    }
}
