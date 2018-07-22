package rmigroupchat.helpers;

import java.io.FileNotFoundException;

import rmigroupchat.model.Config;

public class RmiNamingUtils {
	public static String getMessageServiceName() throws FileNotFoundException {
		return getMessageServiceName(null);
	}

	public static String getMessageServiceName(String id) throws FileNotFoundException {
		Config config = ConfigHelper.getConfig();
		id = id != null && !id.isEmpty() ? "Client_" + id : "Server";
		return String.format("//%s:%d/Message%s", config.getRmiRegistryHost(), config.getRmiRegistryPort(), id);
	}
}