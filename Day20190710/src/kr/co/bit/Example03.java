package kr.co.bit;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

//FileSystem
public class Example03 {
	public static void main(String[] args) throws IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		for (FileStore store : fileSystem.getFileStores()) {
			System.out.println("드라이버 명: "+store.name());
			System.out.println("파일 시스템: "+store.type());
			System.out.println("전체 공간: "+store.getTotalSpace());
			System.out.println("사용 가능한 공간: "+store.getUsableSpace());
			System.out.println("사용중인 공간: "+(store.getTotalSpace()-store.getUsableSpace()));
		}
		System.out.println("파일 구분자: "+fileSystem.getSeparator());
	}
}

// 내 하드웨어의 상태값을 볼 수 있다