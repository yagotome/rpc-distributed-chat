package rmigroupchat.rmi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmigroupchat.helpers.RmiNamingUtils;
import rmigroupchat.model.Message;

/**
 * Client for RMI message exchanges
 * @author yagotome
 *
 */
public class MessageClient {
	private MessageService messageService;

	public MessageClient() throws NotBoundException, MalformedURLException, RemoteException, FileNotFoundException {
		messageService = (MessageService) Naming.lookup(RmiNamingUtils.getMessageServiceName());
	}
	
	public void send(Message message) throws IOException {
		messageService.send(message);
	}
}