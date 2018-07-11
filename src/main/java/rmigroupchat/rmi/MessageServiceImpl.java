package rmigroupchat.rmi;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmigroupchat.helpers.ConfigHelper;
import rmigroupchat.model.Config;
import rmigroupchat.model.Message;

/**
 * Implementation for message exchanges by RMI
 * 
 * @author yagotome
 *
 */
public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {
	private static final long serialVersionUID = 6017125996997698789L;

	public MessageServiceImpl() throws RemoteException {
		super();
	}

	public void send(Message message) throws IOException {
		System.out.println(message.getFormattedMessage());
		Config config = ConfigHelper.getConfig();
		try (Socket clientSocket = new Socket(InetAddress.getLocalHost(), config.getSocketPort());
				ObjectOutputStream objOutputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
			objOutputStream.writeObject(message);
		}

	}
}