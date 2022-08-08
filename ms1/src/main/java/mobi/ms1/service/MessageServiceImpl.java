package mobi.ms1.service;

import lombok.extern.slf4j.Slf4j;
import mobi.ms1.model.Message;
import mobi.ms1.model.ReceivedMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        message.setId(UUID.randomUUID().toString());

        message.setBody(message.getBody().concat("-> MS1"));

        log.info("message with id : {} and body : {} | from source : {} | next destination {}", message.getId(),message.getBody(),message.getSource().toString(),message.getDestination());

        //sending message
        return sendingProcess(message, "lb://"+message.getDestination().toString()+"/received");
    }

    @Override
    public ReceivedMessage receivingMessage(Message message) {
        return new ReceivedMessage(UUID.randomUUID().toString(), "The Message is received correctly");
    }


    public ReceivedMessage sendingProcess(Message message, String destination){
        //Exception to insure the sending of the message to the destination
        try {
            //sending message
            return restTemplate.postForObject(destination,message,ReceivedMessage.class);
        }catch (Exception e){

            return new ReceivedMessage(UUID.randomUUID().toString(), "The Message does not sent as it should");
        }
    }


}
