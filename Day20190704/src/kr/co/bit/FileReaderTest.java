package kr.co.bit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\eclipse\\workspace\\Day20190704\\src\\kr\\co\\bit\\FileReaderTest.txt");
			int readChar = -1;
			while((readChar = fr.read())!= -1) {
				System.out.print((char)readChar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}

}
