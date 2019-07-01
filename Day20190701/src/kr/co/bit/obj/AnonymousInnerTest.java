package kr.co.bit.obj;

import java.util.Scanner;

public class AnonymousInnerTest {

	public static void main(String[] args) {
		CommandProcess cp = new CommandProcess();
		// class Anonymouse extends Object implements Command
		// Anonymouse anonoymouse = new ListCommand();
		// anonoymouse.execute();
		Scanner input = new Scanner(System.in);
		System.out.println("1.�۾��� 2.��Ϻ���");
		int protocol = input.nextInt();
		// �ѹ��� ����� �뵵�� ����. �̸��� ��� �ѹ��� ����. ����Ŭ����
		if (protocol == 1) {	
			cp.process(new Command() {

				@Override
				public void execute() {
					System.out.println("�۾������");
				}
			});
		} else {
			cp.process(new Command() {

				@Override
				public void execute() {
					System.out.println("��Ϻ������");
				}

			});
		}
	}

}
