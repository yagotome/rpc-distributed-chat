package rmigroupchat.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import rmigroupchat.model.Message;

public class RmiMultiClientHelper {
	private List<RmiClientHelper> messageClient;
	private List<String> serverNames;

	public RmiMultiClientHelper(List<String> serverNames) {
		this.setServerNames(serverNames);
		messageClient = new ArrayList<>(serverNames.size());
		for (String serverName : serverNames) {
			try {
				messageClient.add(new RmiClientHelper(serverName));
			} catch (MalformedURLException | RemoteException | FileNotFoundException | NotBoundException e) {
				System.out.println("Erro ao bindar server \"" + serverName + '"');
				System.err.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void send(Message message) {
		messageClient.parallelStream().forEach(msgClient -> {
			try {
				msgClient.send(message);
			} catch (IOException e) {
				System.out.println(String.format("Erro ao enviar mensagem `%s` ao server %s", message.toString(), msgClient.getServerName()));
				System.err.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		});
	}

	public List<String> getServerNames() {
		return serverNames;
	}

	public void setServerNames(List<String> serverNames) {
		this.serverNames = serverNames;
	}
}
