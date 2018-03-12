package sockets;

import java.util.Scanner;

public class Address {

	private String hostname = "";
	private int port = -1;
	// private String ip;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
		// resolveAddress();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Address(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
		if (this.port < 0 || this.port > 65535) {
			System.out.println("Wrong Port Number");
			throw new RuntimeException();
		}
		// resolveAddress();
	}

	// public void resolveAddress() throws UnknownHostException {
	// InetAddress address;
	// address = InetAddress.getByName(this.hostname);
	// this.ip = address.getHostAddress();
	// }

	public Address() {
		takeInputIpAndPort();
	}

	public void takeInputIpAndPort() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hostname: ");
		this.hostname = scanner.nextLine();
		System.out.print("Port: ");
		this.port = Integer.parseInt(scanner.nextLine());
		scanner.close();
		if (port < 0 || port > 65535) {
			System.out.println("Wrong Port Number");
			throw new RuntimeException();
		}
		// resolveAddress();
	}

}
