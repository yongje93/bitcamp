package kr.co.bit2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//FileChannel create/write �ܹ���
public class Example01 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:\\file\\aaa.txt");
//		���丮 ����
//		Files.createDirectories(path.getParent());
		FileChannel fileChannel = FileChannel.open(path,
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "�ȳ��ϼ���";
		Charset charSet = Charset.defaultCharset();
		ByteBuffer byteBuffer = charSet.encode(data);
		
		int byteCount = fileChannel.write(byteBuffer);
		System.out.println("aaa.txt: "+byteCount);
		
		fileChannel.close();
	}
}
