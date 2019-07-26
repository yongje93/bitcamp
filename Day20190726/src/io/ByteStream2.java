package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:/eclipse/workspace/Day20190726/src/IO/data.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		int size = (int) file.length();
		
		byte[] b = new byte[size];
		bis.read(b, 0 , size);
		System.out.println(new String(b));
		bis.close();
	}
}
