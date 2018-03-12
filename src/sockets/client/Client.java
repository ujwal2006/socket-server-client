package sockets.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import sockets.Address;
import sockets.messaging.IOMessaging;

public class Client {

	private Address address;

	private Socket socket;

	private IOMessaging messenger;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	Client() {
		address = new Address();
	}

	Client(String hostname, int port) {
		address = new Address(hostname, port);
	}

	public void connect() throws UnknownHostException, IOException {
		socket = new Socket(address.getHostname(), address.getPort());
		messenger = new IOMessaging(socket.getInputStream(), socket.getOutputStream());
	}

	public IOMessaging getMessenger() {
		return messenger;
	}
	
	public void close() {
		System.out.println("Closing the connection.");
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("Couldn't close the socket.");
			e.printStackTrace();
		}
	}

}
