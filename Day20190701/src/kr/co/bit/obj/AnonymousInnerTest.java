package kr.co.bit.obj;

import java.util.Scanner;

public class AnonymousInnerTest {

	public static void main(String[] args) {
		CommandProcess cp = new CommandProcess();
		// class Anonymouse extends Object implements Command
		// Anonymouse anonoymouse = new ListCommand();
		// anonoymouse.execute();
		Scanner input = new Scanner(System.in);
		System.out.println("1.글쓰기 2.목록보기");
		int protocol = input.nextInt();
		// 한번만 사용할 용도로 만듬. 이름이 없어서 한번만 가능. 무명클래스
		if (protocol == 1) {	
			cp.process(new Command() {

				@Override
				public void execute() {
					System.out.println("글쓰기실행");
				}
			});
		} else {
			cp.process(new Command() {

				@Override
				public void execute() {
					System.out.println("목록보기실행");
				}

			});
		}
	}

}
