package kr.co.bit;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class DataStreamTest1 {
	public static void main(String[] args) {
		FileOutputStream fo = null;	//���ھ���, ���ϻ���
		FileInputStream fi = null;	//����������, �����б�
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			fo = new FileOutputStream("C:\\eclipse\\workspace\\Day20190704\\src\\kr\\co\\bit\\dataFile.txt");
			fi = new FileInputStream("C:\\eclipse\\workspace\\Day20190704\\src\\kr\\co\\bit\\dataFile.txt");
			
			dos = new DataOutputStream(fo);
			dis = new DataInputStream(fi);
			
			dos.writeShort(-1);
			dos.writeByte(2);
			dos.writeDouble(3.14);
			dos.writeLong(30);
			dos.writeUTF("dataStreamTest");
			System.out.println(dis.readUnsignedShort());
			dis.skip(1);
			System.out.println(dis.readDouble());
			System.out.println(dis.readLong());
			System.out.println(dis.readUTF());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				fo.close();
				dis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
	}
}
