package sockets.messaging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sockets.messaging.readers.MessageIn;
import sockets.messaging.writers.MessageOut;

public class IOMessaging {

	private MessageIn reader;

	private MessageOut writer;

	public IOMessaging(InputStream in, OutputStream out) {
		reader = new MessageIn(in);
		writer = new MessageOut(out);
	}

	public byte[] read() throws IOException {
		return reader.read();
	}

	public String readString() throws IOException {
		byte[] data = reader.read();
		return new String(data);
	}

	public int[] readIntegerChunk() throws IOException {
		byte[] data = reader.read();
		int[] dataInt = null;
		if (data.length % 4 == 0) {
			dataInt = new int[data.length / 4];
			for (int i = 0; i < data.length / 4; i++) {
				dataInt[i] = Converter
						.ByteArrToInt(new byte[] { data[i * 4], data[i * 4 + 1], data[i * 4 + 2], data[i * 4 + 3] });
			}
		}
		return dataInt;
	}

	// TODO: Need to change the default charset implementation
	public void writeString(String data, BoundaryType boundaryType, Object... extraArgs) throws IOException {
		writer.write(data.getBytes(), boundaryType, extraArgs);
	}

	public void write(byte[] data, BoundaryType boundaryType, Object... extraArgs) throws IOException {
		writer.write(data, boundaryType, extraArgs);
	}

	public void writeIntegerChunk(int[] data, BoundaryType boundaryType, Object... extraArgs) throws IOException {
		byte[] byteData = new byte[data.length * 4];
		byte[] valueInt;
		for (int i = 0; i < data.length; i++) {
			valueInt = Converter.intToByteArr(data[i]);
			byteData[i * 4] = valueInt[0];
			byteData[i * 4 + 1] = valueInt[1];
			byteData[i * 4 + 2] = valueInt[2];
			byteData[i * 4 + 3] = valueInt[3];
		}
		writer.write(byteData, boundaryType, extraArgs);
	}

}
