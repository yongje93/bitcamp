package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("제목|내용");
			String titleContent = br.readLine();
			int indexI = titleContent.indexOf("|");
			String title = titleContent.substring(0, indexI);
			String content = titleContent.substring(indexI+1);
			System.out.println(title);
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
