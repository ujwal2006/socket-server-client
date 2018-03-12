package sockets.messaging.writers;

import java.io.IOException;
import java.io.OutputStream;

import sockets.messaging.Converter;

public class SizeMessageWriter implements MessageWriter {

	OutputStream out;

	public SizeMessageWriter(OutputStream out) {
		this.out = out;
	}

	@Override
	public void write(byte[] data, Object[] extraArgs) throws IOException {
		int messageSize = data.length;
		out.write(Converter.intToByteArr(messageSize));
		out.write(data);
	}

}
