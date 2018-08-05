package rmigroupchat.ui;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import rmigroupchat.helpers.RmiClientHelper;
import rmigroupchat.helpers.RmiNamingUtils;
import rmigroupchat.helpers.TimeUtils;
import rmigroupchat.model.Message;
import rmigroupchat.rmi.MessageService;
import rmigroupchat.rmi.MessageServiceClientImpl;

public class ChatClient {
	private static final String WELCOMING_MESSAGE = "Olá! Bem vindo ao groupchat!\nDigite seu username para entrar no chat: ";
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
			System.err.println("Ocorreu um erro inesperado e a aplicação está sendo encerrada. Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void startInteractiveUI(Scanner scanner) throws IOException, NotBoundException {
		String messageText = null;

		print(WELCOMING_MESSAGE);

		String username = scanner.nextLine();
		MessageService messageService = new MessageServiceClientImpl();
		String userRmiRegistry = RmiNamingUtils.getMessageServiceName(username);
		Naming.rebind(userRmiRegistry, messageService);

		RmiClientHelper msgClient = new RmiClientHelper();
		msgClient.send(new Message(null, String.format(USER_JOIN_MESSAGE, username), TimeUtils.now()));

		while (!(messageText = scanner.nextLine()).equals("/exit")) {
			Message message = new Message(username, messageText, TimeUtils.now());
			try {
				msgClient.send(message);
			} catch (IOException e) {
				println(SENDING_ERROR_MESSAGE);
			}
		}

		Naming.unbind(userRmiRegistry);
		UnicastRemoteObject.unexportObject(messageService, true);

		msgClient.send(new Message(null, String.format(USER_LEAVE_MESSAGE, username),TimeUtils.now()));
	}
}
