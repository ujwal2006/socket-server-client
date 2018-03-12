package sockets;

import java.io.IOException;
import java.net.Socket;

import sockets.messaging.BoundaryType;
import sockets.messaging.IOMessaging;

public class ClientHandler implements Runnable {

	private IOMessaging messenger;

	private Socket socket;
	
	public void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i != 0)
				System.out.print(", ");
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}

	public ClientHandler() {

	}

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			messenger = new IOMessaging(socket.getInputStream(), socket.getOutputStream());
			System.out.println(messenger.readString());
			messenger.writeString("We shall try that again.", BoundaryType.LENGTH);
			System.out.println(messenger.readString());
			messenger.writeString("It seems things are working fine.", BoundaryType.LENGTH);
			int[] data = messenger.readIntegerChunk();
			printIntArray(data);
			messenger.writeString("Is that all you know?", BoundaryType.LENGTH);
			messenger.writeIntegerChunk(data, BoundaryType.LENGTH);
			System.out.println(messenger.readString());
			messenger.writeString("Ok, Bye!!", BoundaryType.LENGTH);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Closing the connection.");
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("Unable to close the socket just yet.");
				e.printStackTrace();
			}
		}
	}
}
