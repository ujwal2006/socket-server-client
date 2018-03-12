package sockets.messaging.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import sockets.messaging.BoundaryType;
import sockets.messaging.Converter;

public class MessageOut {

	private Map<BoundaryType, MessageWriter> writers = new HashMap<>();

	private OutputStream out;

	public MessageOut(OutputStream out) {
		this.out = out;
	}

	public void write(byte[] data, BoundaryType boundaryType, Object[] extraArgs) throws IOException {
		out.write(Converter.intToByteArr(boundaryType.ordinal()));
		
		MessageWriter writer = null;
		writer = writers.get(boundaryType);
		if (writer == null) {
			writer = MessageWriterFactory.getMessageWriter(boundaryType, out);
			writers.put(boundaryType, writer);
		}
		if (null == writer) {
			throw new RuntimeException("No Writer could be found for Boundary: " + boundaryType.toString());
		}
		writer.write(data, extraArgs);
	}

}
