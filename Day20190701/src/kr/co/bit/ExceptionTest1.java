package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest1 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문자열 입력.");
		try {
			String str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
