package rmigroupchat.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Message is the model of a message
 * @author yagotome
 *
 */
public class Message implements Serializable {
	private static final long serialVersionUID = 3478724667335818598L;
	private String sender;
	private String message;
	private String title;
	private LocalDateTime createdTime;

	public Message(String sender, String message, LocalDateTime createdTime) {
		super();
		this.sender = sender;
		this.message = message;
		this.createdTime = createdTime;
	}

	public Message(String sender, String message, LocalDateTime createdTime, String title) {
		super();
		this.sender = sender;
		this.message = message;
		this.title = title;
		this.createdTime = createdTime;
	}

	/**
	 * Formats message data to be printed
	 * @return Message prettily formatted
	 */
	@Override
	public String toString() {
		if (sender == null)
			return message;
		String _title = title != null ? "(" + title + ")" : "";
		return String.format("[%s] %s: (%s)\n%s", getFormattedCreatedTime(), sender, _title, message);
	}

	private String getFormattedCreatedTime() {
		return createdTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
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

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
}
