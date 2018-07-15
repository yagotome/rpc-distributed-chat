package rmigroupchat.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtils {
	public static byte[] serialize(Object obj) throws IOException {
		try (ByteArrayOutputStream bytesOutputStream = new ByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(bytesOutputStream);) {
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
			return bytesOutputStream.toByteArray();
		}
	}

	public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
				ObjectInputStream in = new ObjectInputStream(bis)) {
			return in.readObject();
		}
	}
}
