package rmigroupchat.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmigroupchat.model.Message;
import rmigroupchat.rmi.MessageService;

/**
 * Client for RMI message exchanges
 * @author yagotome
 *
 */
public class RmiClientHelper {
	private MessageService messageService;
	private String serverName;

	public RmiClientHelper() throws NotBoundException, MalformedURLException, RemoteException, FileNotFoundException {
		this(RmiNamingUtils.getMessageServiceName());
	}
	
	public RmiClientHelper(String serverName) throws NotBoundException, MalformedURLException, RemoteException, FileNotFoundException {
		this.serverName = serverName; 
		messageService = (MessageService) Naming.lookup(serverName);
	}
	
	public void send(Message message) throws IOException {
		messageService.send(message);
	}

	public String getServerName() {
		return serverName;
	}
}