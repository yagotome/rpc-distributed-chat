package rmigroupchat.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for message exchanges by RMI
 * @author yagotome
 *
 */
public interface MessageService extends Remote {
    public void send(String message) throws RemoteException;
}