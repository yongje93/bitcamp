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
			System.out.println("����̹� ��: "+store.name());
			System.out.println("���� �ý���: "+store.type());
			System.out.println("��ü ����: "+store.getTotalSpace());
			System.out.println("��� ������ ����: "+store.getUsableSpace());
			System.out.println("������� ����: "+(store.getTotalSpace()-store.getUsableSpace()));
		}
		System.out.println("���� ������: "+fileSystem.getSeparator());
	}
}

// �� �ϵ������ ���°��� �� �� �ִ�