package rmigroupchat.helpers;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import rmigroupchat.model.Config;

public class RmiNamingUtils {
    public static String getMessageServiceName() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        Config config = ConfigHelper.getConfig();
        return String.format("rmi://%s:%d/Message", config.getRmiRegistryHost(), config.getRmiRegistryPort());
    }
}