package kr.co.bit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest1 {
	public static void main(String[] args) {
		FileWriter fileW = null;
		BufferedWriter buW = null;
		try {
			fileW = new FileWriter("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\bufferWriter.txt");
			buW = new BufferedWriter(fileW, 4);
			buW.write('A');
			buW.write('B');
			buW.write('C');
			buW.write('D');
			buW.write('E');
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
