package kr.co.bit;

import java.util.Scanner;

public class DoWhile_Test6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String result = "����";
		String inputString = "";
		
		do {
			System.out.println("���ѹα��� ������ �Է��ϼ���.");
			inputString = input.next();
			if(inputString.equals(result)) {
				System.out.println("���ѹα��� ������ " + result + " �Դϴ�.");
				break;
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}while(true);
	}
	
}
