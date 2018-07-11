package rmigroupchat.rmi;

import java.io.IOException;
import java.rmi.Remote;

import rmigroupchat.model.Message;

/**
 * Interface for message exchanges by RMI
 * @author yagotome
 *
 */
public interface MessageService extends Remote {
    public void send(Message message) throws IOException ;
}