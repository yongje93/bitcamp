package kr.co.bit;

import java.nio.file.Path;
import java.nio.file.Paths;
// path
public class Example02 {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\file\\aaa.txt");
		System.out.println("[���ϸ�] "+path.getFileName());
		System.out.println("[�θ� ���丮��] "+path.getParent());
		System.out.println("[��ø ��� ��] "+path.getNameCount());
		
		System.out.println();
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
	}
}

// ���̷�Ʈ �޸� �׼��� (�ϵ����/Ŀ�ο� �ٷ�����)
// new�� ���� �����ϴ°� �ƴ�