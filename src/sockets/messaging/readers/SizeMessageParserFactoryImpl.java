package sockets.messaging.readers;

import java.io.InputStream;

import sockets.messaging.BoundaryType;

public class SizeMessageParserFactoryImpl extends AbstractMessageParserFactory{

	private BoundaryType boundaryType;
	
	public SizeMessageParserFactoryImpl() {
		super(BoundaryType.LENGTH);
		boundaryType = BoundaryType.LENGTH;
	}
	
	@Override
	public MessageParser generateMessageParser(InputStream in) {
		return new SizeMessageParser(in);
	}

	@Override
	public BoundaryType getBoundaryType() {
		return boundaryType;
	}

}
