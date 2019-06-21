package kr.co.bit;

import java.util.Scanner;

public class DoWhile_Test6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String result = "서울";
		String inputString = "";
		
		do {
			System.out.println("대한민국의 수도를 입력하세요.");
			inputString = input.next();
			if(inputString.equals(result)) {
				System.out.println("대한민국의 수도는 " + result + " 입니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}while(true);
	}
	
}
