package kr.co.bit;

import java.io.File;
import java.io.IOException;

// file

public class Example01 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\file\\aaa.txt");
		
//		������ �ִ��� ������ üũ
//		if(f.exists()) {
//			System.out.println("������ �����մϴ�.");
//		}else {
//			System.out.println("������ �������� �ʽ��ϴ�.");
//		}
		
		if(!f.exists()) {
			f.createNewFile(); //���ϻ���
		}
		System.out.println(f.isFile()); //�������� �ƴ��� Ȯ��
		System.out.println(f.getAbsolutePath()); //������
		System.out.println(f.getCanonicalPath()); //�����
		System.out.println(f.getPath()); //�����
		System.out.println(f.getName()); //�����̸�
		System.out.println(f.getParent()); //�������
		System.out.println(f.length()); //����ũ��
		
//		f.mkdir() //���丮 ����
//		f.setExecutable() //�������� ���� ������ �ش�.
//		f.delete() //���ϻ���
	}	
}
