package kr.co.bit;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) {
		FileWriter fw = null;
		String msg = "FileWriter 테스트입니다.\r\n";
		try {
			fw = new FileWriter("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\fileWriter.txt", true);
			fw.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
