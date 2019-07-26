package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) throws IOException {
		// BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("result.txt"));
		// DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));

		FileOutputStream fos = new FileOutputStream("C:\\eclipse\\workspace\\Day20190726\\src\\IO\\result.txt");
		DataOutputStream dos = new DataOutputStream(fos);

		dos.writeUTF("홍길동");
		dos.writeInt(25);
		dos.writeDouble(185.3);
		dos.close();

	}

}
