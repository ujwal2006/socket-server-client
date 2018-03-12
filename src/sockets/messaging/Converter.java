package sockets.messaging;

public class Converter {

	public static byte[] intToByteArr(int x) {
		return new byte[] { (byte) (x >> 24), (byte) (x >> 16), (byte) (x >> 8), (byte) x };
	}

	public static int ByteArrToInt(byte[] byteValue) {
		return byteValue[0] << 24 | (byteValue[1] & 0xFF) << 16 | (byteValue[2] & 0xFF) << 8 | (byteValue[3] & 0xFF);
	}
}
