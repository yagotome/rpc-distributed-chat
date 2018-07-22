package rmigroupchat.rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmigroupchat.model.Message;
import rmigroupchat.socket.SocketClient;

/**
 * Implementation for message exchanges by RMI
 * 
 * @author yagotome
 *
 */
public class MessageServiceServerImpl extends UnicastRemoteObject implements MessageService {
	private static final long serialVersionUID = 6017125996997698789L;

	public MessageServiceServerImpl() throws RemoteException {
		super();
	}

	public void send(Message message) throws IOException {
		SocketClient.spreadMessage(message);
		System.out.println("Spreading message: " + message.getFormattedMessage());
	}
}