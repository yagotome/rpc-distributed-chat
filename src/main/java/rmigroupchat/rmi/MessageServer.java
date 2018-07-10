package rmigroupchat.rmi;

import java.rmi.Naming;

import rmigroupchat.helpers.ConfigHelper;
import rmigroupchat.helpers.model.Config;

/**
 * Server for RMI message exchanges
 * @author yagotome
 *
 */
public class MessageServer {

    public static void main(String args[]) {
        try {
            MessageService messageService = new MessageServiceImpl();
            Config config = ConfigHelper.getConfig();
            String rmiregistryHost = String.format("rmi://%s/Message", config.getRmiRegistryHost());
			Naming.rebind(rmiregistryHost , messageService);
            System.out.println("MessageService bound into rmiregistry");
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}