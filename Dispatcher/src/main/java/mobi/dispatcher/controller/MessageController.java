package mobi.dispatcher.controller;

import mobi.dispatcher.model.Message;
import mobi.dispatcher.model.ReceivedMessage;
import mobi.dispatcher.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {

    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/process")
    void processMessage(@RequestBody Message message)
    {
        messageService.sendingMessage(message);
    }

    @PostMapping("/reaching")
    void reachingMessage(@RequestBody ReceivedMessage receivedMessage ){
        messageService.receivingMessage(receivedMessage);
    }
}
