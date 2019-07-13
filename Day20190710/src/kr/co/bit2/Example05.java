package kr.co.bit2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Example05 {
	public static void main(String[] args) {
		Path from = Paths.get("C:\\file\\aaa.txt");
		Path to = Paths.get("C:\\file\\eee.txt");
		//패스트 방식
		try {
			Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("끝");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
