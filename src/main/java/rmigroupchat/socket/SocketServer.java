package rmigroupchat.socket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.function.Consumer;

import rmigroupchat.helpers.ConfigHelper;
import rmigroupchat.helpers.SerializationUtils;
import rmigroupchat.model.Config;
import rmigroupchat.model.Message;

public class SocketServer {
	private static Config config;
	private Thread thread;

	public SocketServer(Consumer<Message> callback) {
		thread = new Thread(() -> {
			try (MulticastSocket socketClient = new MulticastSocket(config.getSocketPort())) {
				InetAddress address = InetAddress.getByName(config.getMulticastAddress());
				socketClient.joinGroup(address);
				byte[] buffer = new byte[1024];
				while (true) {
					DatagramPacket dgpkt = new DatagramPacket(buffer, buffer.length);
					socketClient.receive(dgpkt);
					assert (dgpkt.getData() == buffer);
					Message message = (Message) SerializationUtils.deserialize(buffer);
					callback.accept(message);
				}
			} catch (IOException | ClassNotFoundException e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		});
	}

	public void start() throws FileNotFoundException {
		config = ConfigHelper.getConfig();
		thread.start();
	}
}
