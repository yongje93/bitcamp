package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject { 
	
	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); // arraylist 1���� �迭
																								// hashmap 2�����迭
		Scanner input = new Scanner(System.in);
		
		Register register = new Register();
		
		while (true) {
			System.out.println("========�޴� ����========");
			System.out.println("1.��� ");
			System.out.println("2.ã�� ");
			System.out.println("3.���� ");
			System.out.println("4.��ü��� ");
			System.out.println("----------------");
			System.out.println("0.����");
			System.out.println("----------------");
			System.out.print("��ȣ�� ���� ���ּ���.. ");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("���");
				System.out.println("========�޴� ����========");
				System.out.println("1.�л�");
				System.out.println("2.����");
				System.out.println("3.������");
				System.out.println("4.�����޴�");
				System.out.print("��ȣ�� ���� ���ּ���.. ");
				protocol = input.nextInt();

				register.registerProcess(protocol);

				if (protocol == 4) {
					System.out.println("�����޴�");
					continue;
				}

			} else if (protocol == 2) {
//				haksa.search(input, haksaList);
			} else if (protocol == 3) {
//				haksa.delete(input, haksaList);
			} else if (protocol == 4) {
//				haksa.list(input, haksaList);
			} else if (protocol == 0) {
				System.out.println("�����մϴ�.");
				System.exit(0); // ���α׷� ����
			} else {
				System.out.println("�޴��� �ٽ� �������ּ���.");
			}
		}

	}

}
