package kr.co.bit2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Example05 {
	public static void main(String[] args) {
		Path from = Paths.get("C:\\file\\aaa.txt");
		Path to = Paths.get("C:\\file\\eee.txt");
		//�н�Ʈ ���
		try {
			Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("��");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
