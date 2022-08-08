package mobi.ms3.service;

import mobi.ms3.model.Message;
import mobi.ms3.model.ReceivedMessage;

public interface MessageService {

    ReceivedMessage sendingMessage(Message message);

    ReceivedMessage receivingMessage(Message message);
}
