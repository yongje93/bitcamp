package user.main;

import java.util.Scanner;

import user.action.UserAction;
import user.action.UserDeleteAction;
import user.action.UserInsertAction;
import user.action.UserSelectAction;
import user.action.UserUpdateAction;

public class UserMain {

	public void menu() {
		Scanner scan = new Scanner(System.in);
		UserAction userAction = null;
		int menu = 0;

		while (true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("    1. 입력");
			System.out.println("    2. 출력");
			System.out.println("    3. 수정");
			System.out.println("    4. 삭제");
			System.out.println("    5. 끝");
			System.out.println("****************");
			System.out.print("    번호 입력 : ");
			menu = scan.nextInt();

			if (menu == 5) break;
			if (menu == 1) {
				userAction = new UserInsertAction();
			} else if (menu == 2) {
				userAction = new UserSelectAction();
			} else if (menu == 3) {
				userAction = new UserUpdateAction();
			} else if (menu == 4) {
				userAction = new UserDeleteAction();
			} else {
				System.out.println("1~5까지 가능합니다.");
				continue;
			}
			
			userAction.execute();	// 호출
		}
	}

	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
		System.out.println("프로그램을 종료합니다");
	}

}
