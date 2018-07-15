package rmigroupchat.rmi;

import java.rmi.Naming;

import rmigroupchat.helpers.ConfigHelper;
import rmigroupchat.helpers.RmiNamingUtils;
import rmigroupchat.model.Config;
import rmigroupchat.model.Message;

/**
 * Client for RMI message exchanges
 * @author yagotome
 *
 */
public class MessageClient {
	static MessageService messageService = null;

	public static void main(String args[]) {
		try {
			messageService = (MessageService) Naming.lookup(RmiNamingUtils.getMessageServiceName());
			messageService.send(new Message("Yago", "Hello guys"));
			System.out.println("Sent message to RMI server successfully");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}