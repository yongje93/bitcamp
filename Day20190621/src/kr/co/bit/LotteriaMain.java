package kr.co.bit;

import java.util.Scanner;

public class LotteriaMain {
	
	public static void main(String[] args) {
		LotteriaProcess lp = new LotteriaProcess();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("ã�� ��ǰ �̸�: ");
			String sangpumName = input.next();
			boolean searchResult = lp.sangpumProcess(sangpumName);
			if(searchResult) break;
			System.out.println("ã�� ��ǰ�� �����ϴ�.");
			
		} while(true);
	}
	
}
