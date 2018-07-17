package rmigroupchat.rmi;

import java.rmi.Naming;

import rmigroupchat.helpers.RmiNamingUtils;
import rmigroupchat.socket.SocketServer;

/**
 * Server for RMI message exchanges
 * 
 * @author yagotome
 *
 */
public class MessageServer {
	private static SocketServer socketServer;

	public static void main(String args[]) {
		try {
			socketServer = new SocketServer(message -> {
				// TODO: Send message to all registered users in rmiregistry
			});
			socketServer.start();
			MessageService messageService = new MessageServiceImpl();
			Naming.rebind(RmiNamingUtils.getMessageServiceName(), messageService);
			System.out.println("MessageService bound into rmiregistry");
		} catch (Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}