package sockets.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sockets.ClientHandler;

public class Server {

	private int poolSize = 10;

	private int port;

	private ExecutorService pool;

	private ServerSocket serverSocket;

	public Server() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Port: ");
		this.port = Integer.parseInt(scanner.nextLine());
		scanner.close();
		if (port < 0 || port > 65535) {
			System.out.println("Wrong Port Number");
			throw new RuntimeException();
		}
	}

	public Server(int port) {
		if (this.port < 0 || this.port > 65535) {
			System.out.println("Wrong Port Number");
			throw new RuntimeException();
		}
		this.port = port;
	}

	public void start(ClientHandler handler) throws IOException {
		pool = Executors.newFixedThreadPool(poolSize);
		serverSocket = new ServerSocket(port);
		System.out.println("Server started");

		System.out.println("Waiting for a client ...");

		while (true) {
			Socket socket = serverSocket.accept();
			handler.setSocket(socket);
			pool.execute(handler);
			System.out.println("A Client Accepted, Polling for more!");
		}

	}
}
