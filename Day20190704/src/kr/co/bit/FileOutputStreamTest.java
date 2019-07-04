package kr.co.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		FileOutputStream fo = null;
		String msg = "FileOutputStreamTest";
		byte[] byteArray = msg.getBytes();
		try {
			fo = new FileOutputStream("C:\\eclipse\\workspace\\Day20190704\\src\\kr\\co\\bit\\fileoutput.txt", true);
			fo.write(byteArray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
