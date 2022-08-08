package mobi.dispatcher.service;

import lombok.extern.slf4j.Slf4j;
import mobi.dispatcher.enums.Ms;
import mobi.dispatcher.model.Message;
import mobi.dispatcher.model.ReceivedMessage;
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
    public void sendingMessage(Message message) {


            //Before sending message generating a new Id
            message.setId(UUID.randomUUID().toString());

            message.setBody(message.getBody().concat("-> MS1"));

            log.info("message with id : {} and body : {} | from source : {} | next destination {}", message.getId(),message.getBody(),message.getSource().toString(),message.getDestination());

            //sending message
            sendingProcess(message, "lb://"+message.getDestination().toString()+"/process");
    }

//    @Override
//    public void receivingMessage(ReceivedMessage receivedMessage) {
//        log.info(receivedMessage.getReachingMsg());
//
//        try {
//            restTemplate.postForObject("lb://"+receivedMessage.getSource().toString()+"/reaching",receivedMessage,ReceivedMessage.class);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//


    public void sendingProcess(Message message, String destination){
        //Exception to insure the sending of the message to the destination
        try {
            //sending message
            restTemplate.postForObject(destination,message,Message.class);
        }catch (Exception e){
            log.info(e.toString());
        }
    }


}
