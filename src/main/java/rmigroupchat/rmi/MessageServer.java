package rmigroupchat.rmi;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import rmigroupchat.helpers.RmiMultiClientHelper;
import rmigroupchat.helpers.RmiNamingUtils;
import rmigroupchat.model.Message;
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
				try {
					sendMessageToClients(message);
				} catch (RemoteException | MalformedURLException | FileNotFoundException e) {
					System.out.println("Não possível enviar a mensagem: `" + message.toString() + "`");
					System.err.println("Error: " + e.getMessage());
					e.printStackTrace();
				}
			});
			socketServer.start();
			MessageService messageService = new MessageServiceServerImpl();
			Naming.rebind(RmiNamingUtils.getMessageServiceName(), messageService);
			System.out.println("MessageService bound into rmiregistry");
		} catch (Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void sendMessageToClients(Message message)
			throws RemoteException, MalformedURLException, FileNotFoundException {
		List<String> userRegistries = Arrays.asList(Naming.list(RmiNamingUtils.getMessageServiceName()));
		String serverName = RmiNamingUtils.getMessageServiceName();
		userRegistries = userRegistries.parallelStream().filter(registry -> !registry.equals(serverName))
				.collect(Collectors.toList());
		RmiMultiClientHelper msgMultiClient = new RmiMultiClientHelper(userRegistries);
		msgMultiClient.send(message);
	}
}