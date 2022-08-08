package mobi.ms2.service;

import mobi.ms2.model.Message;
import mobi.ms2.model.ReceivedMessage;

public interface MessageService {
    ReceivedMessage sendingMessage(Message message);

    ReceivedMessage receivingMessage(Message message);
}
