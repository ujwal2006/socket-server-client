package sockets.messaging.writers;

import java.io.IOException;

public interface MessageWriter {

	public void write(byte[] data, Object[] extraArgs) throws IOException;
}
