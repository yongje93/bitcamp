package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:/eclipse/workspace/Day20190726/src/IO/data.txt"));
		int data;
		while ((data = bis.read()) != -1) { // 한글자씩 읽어서 data에 집어넣기, -1이면 더이상 읽을게 없음.
			System.out.print((char) data);
		}
		bis.close();
	}
}
