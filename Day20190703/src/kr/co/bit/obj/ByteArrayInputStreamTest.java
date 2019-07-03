package kr.co.bit.obj;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) {
		byte[] datas = new byte[] { 10, 20, 30, 40 };
		ByteArrayInputStream bai = new ByteArrayInputStream(datas);
		int var_readbyte = -1;
		while ((var_readbyte = bai.read()) != -1) {
			System.out.print(var_readbyte + " ");
		}
	}

}
