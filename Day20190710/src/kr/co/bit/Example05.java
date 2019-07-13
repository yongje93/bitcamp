package kr.co.bit;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Path와 Files
public class Example05 {
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("C:\\file\\dir");
		Path path2 = Paths.get("C:\\file\\bbb.txt");
		
//		if(Files.notExists(path1)) Files.createDirectories(path1);
//		if(Files.notExists(path2)) Files.createFile(path2);
		
		Path path3 = Paths.get("C:\\file");
		DirectoryStream<Path> ditrctoryStream = Files.newDirectoryStream(path3);
		for (Path path : ditrctoryStream) {
			if(Files.isDirectory(path)) {
				System.out.println("[디렉토리] "+path.getFileName());
			}else {
				System.out.println("[파일] "+path.getFileName());
			}
		}
	}
}
