package sockets.messaging.readers;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import sockets.messaging.BoundaryType;

public interface MessageParserFactory {

	public static Map<BoundaryType, MessageParserFactory> factoryMap = new HashMap<>();

	public MessageParser generateMessageParser(InputStream in);

	public BoundaryType getBoundaryType();

	public static MessageParser getMessageParser(BoundaryType boundaryType, InputStream in) {
		if (factoryMap.get(boundaryType) == null) {
			throw new RuntimeException("Unsupported Boundary Type");
		}
		return factoryMap.get(boundaryType).generateMessageParser(in);
	}
}
