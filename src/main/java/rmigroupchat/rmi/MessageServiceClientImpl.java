package rmigroupchat.rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmigroupchat.model.Message;
import rmigroupchat.ui.ChatClient;

/**
 * Implementation for message exchanges by RMI
 * 
 * @author yagotome
 *
 */
public class MessageServiceClientImpl extends UnicastRemoteObject implements MessageService {
	private static final long serialVersionUID = 6017125996997698789L;

	public MessageServiceClientImpl() throws RemoteException {
		super();
	}

	public void send(Message message) throws IOException {
		ChatClient.println(message.getFormattedMessage());
	}
}