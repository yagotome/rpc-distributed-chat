package rmigroupchat.socket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import rmigroupchat.helpers.ConfigHelper;
import rmigroupchat.helpers.SerializationUtils;
import rmigroupchat.model.Config;
import rmigroupchat.model.Message;

public class SocketClient {
	public static void spreadMessage(Message message) throws FileNotFoundException, IOException, UnknownHostException {
		Config config = ConfigHelper.getConfig();
		try (MulticastSocket socketClient = new MulticastSocket()) {
			byte[] buffer = SerializationUtils.serialize(message);
			InetAddress address = InetAddress.getByName(config.getMulticastAddress());
			socketClient.send(new DatagramPacket(buffer, buffer.length, address, config.getSocketPort()));
		}
	}
}
