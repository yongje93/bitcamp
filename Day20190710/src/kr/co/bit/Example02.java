package kr.co.bit;

import java.nio.file.Path;
import java.nio.file.Paths;
// path
public class Example02 {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\file\\aaa.txt");
		System.out.println("[파일명] "+path.getFileName());
		System.out.println("[부모 디렉토리명] "+path.getParent());
		System.out.println("[중첩 경로 수] "+path.getNameCount());
		
		System.out.println();
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
	}
}

// 다이렉트 메모리 액세서 (하드웨어/커널에 바로접근)
// new를 통해 접근하는게 아님