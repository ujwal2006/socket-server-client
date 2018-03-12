package sockets.messaging.writers;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import sockets.messaging.BoundaryType;

public interface MessageWriterFactory {

	public static Map<BoundaryType, MessageWriterFactory> factoryMap = new HashMap<>();

	public MessageWriter generateMessageWriter(OutputStream out);

	public BoundaryType getBoundaryType();

	public static MessageWriter getMessageWriter(BoundaryType boundaryType, OutputStream out) {
		if (factoryMap.get(boundaryType) == null) {
			throw new RuntimeException("Unsupported Boundary Type");
		}
		return factoryMap.get(boundaryType).generateMessageWriter(out);
	}
}
