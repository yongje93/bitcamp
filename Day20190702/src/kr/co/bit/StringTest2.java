package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest2 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("����|���� �Է�");
		try {
			String titleContent = bf.readLine();
			int index = titleContent.indexOf("|");
			String title = titleContent.substring(0, index);
			String content = titleContent.substring(index + 1);
			System.out.println("����: " + title);
			System.out.println("����: " + content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
