package sockets.messaging.writers;

import sockets.messaging.BoundaryType;

public abstract class AbstractMessageWriterFactory implements MessageWriterFactory {

	public AbstractMessageWriterFactory(BoundaryType boundary) {
		factoryMap.put(boundary, this);
	}
}
