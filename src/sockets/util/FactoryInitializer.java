package sockets.util;

import sockets.messaging.readers.SizeMessageParserFactoryImpl;
import sockets.messaging.writers.SizeMessageWriterFactoryImpl;

public class FactoryInitializer {
	
	public static void initializeFactories(Class factoryInterface) {
		new SizeMessageParserFactoryImpl();
		new SizeMessageWriterFactoryImpl();
	}
}
