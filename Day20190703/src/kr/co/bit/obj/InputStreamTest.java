package kr.co.bit.obj;

import java.io.IOException;

public class InputStreamTest {
	public static void main(String[] args) {
		int var_byte = 0;
		System.out.println("���� �ϳ��� �Է��Ͻÿ�.");
		do {
			try {
				var_byte = System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (var_byte == 10 || var_byte == 13)
				continue;
			if (var_byte == '-')
				break;
			System.out.println("������ : " + (char) var_byte);
		} while (true);

	}
}
