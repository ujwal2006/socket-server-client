package sockets.messaging.writers;

import java.io.OutputStream;

import sockets.messaging.BoundaryType;

public class DelimiterMessageWriterFactoryImpl extends AbstractMessageWriterFactory {

	private BoundaryType boundaryType;

	public DelimiterMessageWriterFactoryImpl() {
		super(BoundaryType.DELIMITER);
		boundaryType = BoundaryType.DELIMITER;
	}

	@Override
	public MessageWriter generateMessageWriter(OutputStream out) {
		return new DelimiterMessageWriter(out);
	}

	@Override
	public BoundaryType getBoundaryType() {
		return boundaryType;
	}

}
