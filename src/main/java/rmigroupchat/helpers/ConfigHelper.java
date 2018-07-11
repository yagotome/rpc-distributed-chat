package rmigroupchat.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import rmigroupchat.model.Config;

public class ConfigHelper {
	private static final String CONFIG_URI = "config.json";
	private static Gson gson = new Gson();
	
	public static Config getConfig() throws JsonSyntaxException, JsonIOException, FileNotFoundException  {
		return gson.fromJson(new FileReader(CONFIG_URI), Config.class);
	}
}
