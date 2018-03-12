package sockets.messaging.readers;

import java.io.IOException;

public interface MessageParser {

	public byte[] read() throws IOException;
}
