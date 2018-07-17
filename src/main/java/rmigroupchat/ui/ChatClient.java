package rmigroupchat.ui;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Scanner;
import rmigroupchat.model.Message;
import rmigroupchat.rmi.MessageClient;
import rmigroupchat.socket.SocketClient;
import rmigroupchat.socket.SocketServer;

public class ChatClient {
	private static final String WELCOMING_MESSAGE = "Olá! Bem vindo ao groupchat!\nDigite seu username para entrar no chat:";
	private static final String USER_JOIN_MESSAGE = "*** %s entrou na conversa ***";
	private static final String USER_LEAVE_MESSAGE = "*** %s saiu da conversa ***";
	private static final String SENDING_ERROR_MESSAGE = "*** Erro ao tentar enviar mensagem ***";
	public static void print(String text) {
		System.out.print(text);
	}
	public static void println(String text) {
		System.out.println(text);
	}	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		try {
			startInteractiveUI(scanner);
		} catch (IOException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void startInteractiveUI(Scanner scanner) throws IOException, NotBoundException {
		String messageText = null;

		print(WELCOMING_MESSAGE);
		
		
		String username = scanner.nextLine();
		// TODO: join above user to multicast group and start to listen RMI to print other user messages
		
		MessageClient msgClient = new MessageClient();
		msgClient.send(new Message(null, String.format(USER_JOIN_MESSAGE, username)));
		
		while (messageText != "/exit") {
			messageText = scanner.nextLine();
			Message message = new Message(username, messageText);
			try { 
				msgClient.send(message);
			} catch (IOException e) {
				println(SENDING_ERROR_MESSAGE);
			}
		}

		msgClient.send(new Message(null, String.format(USER_LEAVE_MESSAGE, username)));		
	}
}
