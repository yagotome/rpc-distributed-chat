package rmigroupchat.model;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 3478724667335818598L;
	private String sender;
	private String message;
	private String title;

	public Message() {
	}
	
	public Message(String sender, String message) {
		super();
		this.sender = sender;
		this.message = message;
	}

	public Message(String sender, String message, String title) {
		super();
		this.sender = sender;
		this.message = message;
		this.title = title;
	}

	public String getFormattedMessage() {
		return String.format("%s: (%s)\n%s", sender, title, message);
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getBody() {
		return message;
	}

	public void setBody(String body) {
		this.message = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
