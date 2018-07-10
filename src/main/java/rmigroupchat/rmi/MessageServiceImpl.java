package rmigroupchat.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementation for message exchanges by RMI
 * @author yagotome
 *
 */
public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {
    private static final long serialVersionUID = 6017125996997698789L;

    public MessageServiceImpl() throws RemoteException {
        super();
    }

    public void send(String message) {
        System.out.println(String.format("Message received: %s", message));
    }
}