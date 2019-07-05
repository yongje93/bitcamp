package kr.co.bit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
 
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\random", "rw");
			System.out.println("�������� ������: "+raf.getFilePointer());
			raf.writeInt(75);
			raf.writeBoolean(false);
			raf.writeChar('A');
			raf.writeLong(100);
			System.out.println("������ ��� �� ����������: " + raf.getFilePointer());
			raf.seek(0);
			System.out.println("int�� ���: " + raf.readInt());
			System.out.println("boolean�� ���: " + raf.readBoolean());
			raf.skipBytes(2);
			System.out.println("long�� ���: " + raf.readLong());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
