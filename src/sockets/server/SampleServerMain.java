package sockets.server;

import java.io.IOException;

import sockets.ClientHandler;
import sockets.messaging.readers.MessageParserFactory;
import sockets.messaging.writers.MessageWriterFactory;
import sockets.util.FactoryInitializer;

public class SampleServerMain {

	public static void main(String[] args) throws IOException {
		FactoryInitializer.initializeFactories(MessageWriterFactory.class);
//		FactoryInitializer.initializeFactories(MessageParserFactory.class);
		Server server;
		if (args.length != 1) {
			System.out.println("Ideal Usage: java Server <port>");
			server = new Server();
		} else {
			server = new Server(Integer.parseInt(args[0]));
		}
		server.start(new ClientHandler());
	}
}