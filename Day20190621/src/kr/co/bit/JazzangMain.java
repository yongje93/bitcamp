package kr.co.bit;

import java.util.Scanner;

public class JazzangMain {
	
	public static void main(String[] args) {
		JazzangProcess jp = new JazzangProcess();	//1
		Scanner input = new Scanner(System.in);		//2
		
		do {
			System.out.println("ã�� ��ǰ �̸�: ");
			String sangpumName = input.next();		//3
			boolean searchResult = jp.sangpumProcess(sangpumName);	//4
			if(searchResult) break;
			System.out.println("ã�� ��ǰ�� �����ϴ�.");
			
		} while(true);
	}

}
