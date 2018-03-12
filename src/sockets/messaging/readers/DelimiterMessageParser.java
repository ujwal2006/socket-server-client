package sockets.messaging.readers;

import java.io.InputStream;

public class DelimiterMessageParser implements MessageParser {
	
	private InputStream in;
	
	public DelimiterMessageParser(InputStream in) {
		this.in = in;
	}

	@Override
	public byte[] read() {
		throw new RuntimeException("Operation not yet supported");
	}
	
}
