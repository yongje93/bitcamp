package kr.co.bit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Files
public class Example04 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:\\file\\aaa.txt"); // Files는 Path라는 인터페이스를 통해서만 사용가능
		System.out.println("디렉토리 여부: "+Files.isDirectory(path));
		System.out.println("파일 여부: "+Files.isRegularFile(path));
		System.out.println("마지막 수정 시간: "+Files.getLastModifiedTime(path));
		System.out.println("파일 크기: "+Files.size(path));
		System.out.println("소유자: "+Files.getOwner(path));
		System.out.println("숨김 파일 여부: "+Files.isHidden(path));
		System.out.println("읽기 파일 여부: "+Files.isReadable(path));
		System.out.println("쓰기 파일 여부: "+Files.isWritable(path));
	}
}