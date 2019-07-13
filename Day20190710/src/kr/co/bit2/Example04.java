package kr.co.bit2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Channel에서 제공하는 논블로킹 복사
public class Example04 {
	public static void main(String[] args) {
		
		try {
			FileChannel from = FileChannel.open(Paths.get("C:\\file\\aaa.txt"), StandardOpenOption.READ);
			FileChannel to = FileChannel.open(Paths.get("C:\\file\\ddd.txt"), 
					StandardOpenOption.CREATE, 
					StandardOpenOption.WRITE);

			from.transferTo(0, from.size(), to);
//			to.transferFrom(from, o, from.size()); // 위와 동일한 내용
			
			from.close();
			to.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
