package kr.co.bit;

import java.util.Scanner;

public class LotteriaMain {
	
	public static void main(String[] args) {
		LotteriaProcess lp = new LotteriaProcess();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("찾을 상품 이름: ");
			String sangpumName = input.next();
			boolean searchResult = lp.sangpumProcess(sangpumName);
			if(searchResult) break;
			System.out.println("찾는 상품이 없습니다.");
			
		} while(true);
	}
	
}
