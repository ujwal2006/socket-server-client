package sockets.messaging.readers;

import sockets.messaging.BoundaryType;

public abstract class AbstractMessageParserFactory implements MessageParserFactory {
	
	public AbstractMessageParserFactory(BoundaryType boundary) {
		factoryMap.put(boundary, this);
	}
}
