package sockets.messaging.readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import sockets.messaging.BoundaryType;
import sockets.messaging.Converter;

public class MessageIn {

	private Map<BoundaryType, MessageParser> parsers = new HashMap<>();

	private InputStream in;

	public MessageIn(InputStream in) {
		this.in = in;
	}

	public byte[] read() throws IOException {
		byte[] boundaryBytes = new byte[4];
		int len = in.read(boundaryBytes, 0, 4);
		if (len == -1) {
			throw new RuntimeException("Couldn't read data");
		}
		if (len < 4) {
			throw new RuntimeException("Improper data format");
		}
		int boundary = Converter.ByteArrToInt(boundaryBytes);
		MessageParser parser = null;
		BoundaryType boundaryType = BoundaryType.getByOrdinal(boundary);
		if (null == boundaryType) {
			throw new RuntimeException("No BoundaryType could be found for ordinal: " + boundary);
		}
		parser = parsers.get(boundaryType);
		if (parser == null) {
			parser = MessageParserFactory.getMessageParser(boundaryType, in);
			parsers.put(boundaryType, parser);
		}
		if (null == parser) {
			throw new RuntimeException("No Parser could be found for Boundary: " + boundaryType.toString());
		}
		return parser.read();
	}

}
