package kr.co.bit;

import java.util.Scanner;

public class SearchMain {
	
	public static void main(String[] args) {
		SearchService sv = new SearchService();
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("검색할 회원 이름을 입력하세요.");
			String name = input.next();
			boolean searchResult = sv.searchMember(name);
			if(searchResult) break;
			System.out.println("해당회원이 없습니다.");
		} while(true);
	}
	
}
