package mobi.ms2.controller;

import mobi.ms2.model.Message;
import mobi.ms2.model.ReceivedMessage;
import mobi.ms2.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MessageController {

    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    ReceivedMessage initialProcess(@RequestBody Message message)
    {
        return messageService.sendingMessage(message);
    }

    @PostMapping("/received")
    ReceivedMessage processMessage(@RequestBody Message message)
    {
        return messageService.receivingMessage(message);
    }

    @PostMapping("/random/{repetition}")
    List<ReceivedMessage> random(@PathVariable(name = "repetition") int repetition)
    {
        return messageService.random(repetition);
    }
}
