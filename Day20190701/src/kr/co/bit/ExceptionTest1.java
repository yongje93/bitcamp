package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest1 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���ڿ� �Է�.");
		try {
			String str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
