package sockets.messaging.readers;

import java.io.IOException;
import java.io.InputStream;

import sockets.messaging.Converter;

public class SizeMessageParser implements MessageParser {

	InputStream in;

	public SizeMessageParser(InputStream in) {
		this.in = in;
	}

	private byte[] readFixedBytes(int size) throws IOException {
		byte[] data = new byte[size];
		if (size != in.read(data, 0, size)) {
			throw new RuntimeException("Unable to read required number of bytes: " + size);
		}
		return data;
	}

	@Override
	public byte[] read() throws IOException {
		int messageSize = Converter.ByteArrToInt(readFixedBytes(4));
		return readFixedBytes(messageSize);
	}

}
