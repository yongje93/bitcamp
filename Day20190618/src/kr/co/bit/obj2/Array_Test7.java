package kr.co.bit.obj2;

import java.util.ArrayList;
import java.util.HashMap;

public class Array_Test7 {
	public static void main(String[] args) {
//		int[][] multi = new int[2][5];
//		Scanner input = new Scanner(System.in);
//		
//		for (int i = 0; i < multi.length; i++) {
//			for (int j = 0; j < multi[i].length; j++) {
//				System.out.println("숫자입력");
//				multi[i][j] = input.nextInt();
//			}
//		}
//		
//		for (int i = 0; i < multi.length; i++) { // 첫번째 행을 말함. 0행의 길이
//			for (int j = 0; j < multi[i].length; j++) { // i행의 개수.
//				System.out.println(multi[i][j]);
//			}
//		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("안녕하세요", "비트입니다.");
		System.out.println(hash.get("안녕하세요"));
		
		list.add(hash);
	}

}
