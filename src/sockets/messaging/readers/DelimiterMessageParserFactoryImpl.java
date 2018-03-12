package sockets.messaging.readers;

import java.io.InputStream;

import sockets.messaging.BoundaryType;

public class DelimiterMessageParserFactoryImpl extends AbstractMessageParserFactory{

	private BoundaryType boundaryType;
	
	public DelimiterMessageParserFactoryImpl() {
		super(BoundaryType.DELIMITER);
		boundaryType = BoundaryType.DELIMITER;
	}
	
	@Override
	public MessageParser generateMessageParser(InputStream in) {
		return new DelimiterMessageParser(in);
	}

	@Override
	public BoundaryType getBoundaryType() {
		return boundaryType;
	}

}
