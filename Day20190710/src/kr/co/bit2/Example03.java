package kr.co.bit2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// FileChannel 복사 양방향...ByteBuffer는 블로킹이라 번거로움
public class Example03 {

	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:\\file\\aaa.txt");
		Path to = Paths.get("C:\\file\\ccc.txt");
		
		FileChannel fromChannel = FileChannel.open(from, StandardOpenOption.READ);
		FileChannel toChannel = FileChannel.open(to, 
				StandardOpenOption.CREATE, 
				StandardOpenOption.WRITE);
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
		int byteCount;
		
		while(true) {
			byteBuffer.clear();
			byteCount= fromChannel.read(byteBuffer);
			if(byteCount==-1) break;
			byteBuffer.flip();
			toChannel.write(byteBuffer);
		}
		fromChannel.close();
		toChannel.close();
		System.out.println("파일 복사 성공");
	}
}
