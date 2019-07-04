package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
	public InputStreamReader isr = null;
	public BufferedReader bfr = null;

	public static void main(String[] args) {
		InputStreamReaderTest isrt = new InputStreamReaderTest();
		User user = isrt.getUserInfo();
		System.out.println("�Է��� ����� ����");
		System.out.println(user);
	}

	private User getUserInfo() {
		User user = null;
		isr = new InputStreamReader(System.in);
		bfr = new BufferedReader(isr);

		try {
			System.out.println("����� ������ �Է��ϼ���.");
			System.out.print("���̵� : ");
			String id = bfr.readLine();
			System.out.print("��й�ȣ : ");
			String passwd = bfr.readLine();
			System.out.print("�� : ");
			String dong = bfr.readLine();
			System.out.print("���� : ");
			int age = Integer.parseInt(bfr.readLine());
			System.out.print("�̸� : ");
			String name = bfr.readLine();
			user = new User(id, passwd, dong, age, name);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
				bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
