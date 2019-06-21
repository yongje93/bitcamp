package kr.co.bit;

import java.util.Scanner;

public class JazzangMain {
	
	public static void main(String[] args) {
		JazzangProcess jp = new JazzangProcess();	//1
		Scanner input = new Scanner(System.in);		//2
		
		do {
			System.out.println("찾을 상품 이름: ");
			String sangpumName = input.next();		//3
			boolean searchResult = jp.sangpumProcess(sangpumName);	//4
			if(searchResult) break;
			System.out.println("찾는 상품이 없습니다.");
			
		} while(true);
	}

}
