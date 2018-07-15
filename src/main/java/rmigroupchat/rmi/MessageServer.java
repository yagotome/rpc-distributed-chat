package rmigroupchat.rmi;

import java.rmi.Naming;

import rmigroupchat.helpers.ConfigHelper;
import rmigroupchat.helpers.RmiNamingUtils;
import rmigroupchat.model.Config;

/**
 * Server for RMI message exchanges
 * @author yagotome
 *
 */
public class MessageServer {

    public static void main(String args[]) {
        try {
            MessageService messageService = new MessageServiceImpl();
			Naming.rebind(RmiNamingUtils.getMessageServiceName(), messageService);
            System.out.println("MessageService bound into rmiregistry");
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}