package mobi.ms1.service;

import mobi.ms1.model.Message;
import mobi.ms1.model.ReceivedMessage;

public interface MessageService {
    //
    ReceivedMessage sendingMessage(Message message);

    ReceivedMessage receivingMessage(Message message);
}
