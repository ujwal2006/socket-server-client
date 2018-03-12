package sockets.messaging.writers;

import java.io.OutputStream;

import sockets.messaging.BoundaryType;

public class SizeMessageWriterFactoryImpl extends AbstractMessageWriterFactory {

	private BoundaryType boundaryType;

	public SizeMessageWriterFactoryImpl() {
		super(BoundaryType.LENGTH);
		boundaryType = BoundaryType.LENGTH;
	}

	@Override
	public MessageWriter generateMessageWriter(OutputStream out) {
		return new SizeMessageWriter(out);
	}

	@Override
	public BoundaryType getBoundaryType() {
		return boundaryType;
	}

}
