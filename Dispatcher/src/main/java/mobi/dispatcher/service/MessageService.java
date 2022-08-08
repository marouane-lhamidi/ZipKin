package mobi.dispatcher.service;

import mobi.dispatcher.model.Message;
import mobi.dispatcher.model.ReceivedMessage;

public interface MessageService {
    void sendingMessage(Message message);
//    public void receivingMessage(ReceivedMessage receivedMessage) ;

}
