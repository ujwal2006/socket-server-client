package sockets.messaging.writers;

import java.io.OutputStream;

public class DelimiterMessageWriter implements MessageWriter {
	
	private OutputStream out;
	
	public DelimiterMessageWriter(OutputStream out) {
		this.out = out;
	}

	@Override
	public void write(byte[] data, Object[] extraArgs) {
		throw new RuntimeException("Operation not yet supported");
	}
	
}
