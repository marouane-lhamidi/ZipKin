package mobi.ms2.service;

import lombok.extern.slf4j.Slf4j;
import mobi.ms2.enums.Ms;
import mobi.ms2.model.Message;
import mobi.ms2.model.ReceivedMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService{
    RestTemplate restTemplate;

    public MessageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ReceivedMessage sendingMessage(Message message) {


        //Before sending message generating a new Id
        message.setId("ms2");

        message.setBody(message.getBody().concat("-> MS2"));

        log.info("message with id : {} and body : {} | from source : {} | next destination {}", message.getId(),message.getBody(),message.getSource().toString(),message.getDestination());

        //sending message
        return sendingProcess(message, "lb://"+message.getDestination().toString()+"/received");
    }

    @Override
    public ReceivedMessage receivingMessage(Message message) {
        return new ReceivedMessage("ms2", "The Message is received correctly");
    }

    @Override
    public List<ReceivedMessage> random(int repetition) {
        List<ReceivedMessage> receivedMessages = new ArrayList<>();

        for (int i = 0; i < repetition ; i++ ){
            int randomNumber2 = (int) (Math.random() *3);
            Ms dst = Ms.values()[randomNumber2];
            Message message =Message.builder().id("ms2").body("Random Message").source(Ms.MS2).destination(dst).build();
            receivedMessages.add(sendingProcess(message, "lb://"+message.getDestination().toString()+"/received")) ;
        }

        return receivedMessages;
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
