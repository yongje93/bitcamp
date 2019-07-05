package kr.co.bit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest2 {
	public static void main(String[] args) {
		FileWriter fileW = null;
		BufferedWriter buW = null;
		try {
			fileW = new FileWriter("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\bufferWriter2.txt");
			buW = new BufferedWriter(fileW, 4);
			buW.write("������1");
			buW.newLine();
			buW.write("������2");
			buW.newLine();
			buW.write("������3");
			buW.newLine();
			buW.write("������4");
			buW.newLine();
			
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
