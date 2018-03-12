package sockets;

import java.io.IOException;
import java.util.ArrayList;

import sockets.messaging.Converter;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
//		int i = 0xF000007F;
//		System.out.println(0x0FFFFF81);
		for(int i=-100000; i<100000; i++) {
			if(Converter.ByteArrToInt(Converter.intToByteArr(i)) != i)
				System.out.println(Converter.ByteArrToInt(Converter.intToByteArr(i)));
		}
		System.out.println("Done");
//		System.out.println(ByteArrToInt(intToByteArr(i)));
//		byte b = (byte) i;
//		System.out.println(b); // -22
//		int i2 = b & 0xFF;
//		System.out.println(i2); // 234
	}

}
