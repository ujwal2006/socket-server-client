package sockets.client;

import java.io.IOException;
import java.net.UnknownHostException;

import sockets.messaging.BoundaryType;
import sockets.messaging.IOMessaging;
import sockets.messaging.readers.MessageParserFactory;
import sockets.messaging.writers.MessageWriterFactory;
import sockets.util.FactoryInitializer;

public class ClientMain {

	public static void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i != 0)
				System.out.print(", ");
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		FactoryInitializer.initializeFactories(MessageWriterFactory.class);
		// FactoryInitializer.initializeFactories(MessageParserFactory.class);
		Client client;
		if (args.length != 2) {
			System.out.println("Ideal Usage: java Client <ip> <port>");
			client = new Client();
		} else {
			client = new Client(args[0], Integer.parseInt(args[1]));
		}
		client.connect();
		IOMessaging messenger = client.getMessenger();
		messenger.writeString("Hello there, Howdie?", BoundaryType.LENGTH);
		System.out.println(messenger.readString());
		messenger.writeString("Hello there, Howdie?", BoundaryType.LENGTH);
		System.out.println(messenger.readString());
		messenger.writeIntegerChunk(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, BoundaryType.LENGTH);
		System.out.println(messenger.readString());
		printIntArray(messenger.readIntegerChunk());
		messenger.writeString("Yeah, Bye!!", BoundaryType.LENGTH);
		System.out.println(messenger.readString());
		client.close();
	}
}
