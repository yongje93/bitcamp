package kr.co.bit;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterTest {

	public static void main(String[] args) {
		FileOutputStream fileOutputS = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter buffW = null;
		try {
			fileOutputS = new FileOutputStream("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\outputStream.txt");
			outWriter = new OutputStreamWriter(fileOutputS);
			buffW = new BufferedWriter(outWriter);
			buffW.write("OutputStreamWriter �׽�Ʈ");
			buffW.newLine();
			buffW.write("OutputStreamWriter �׽�Ʈ");
			buffW.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
