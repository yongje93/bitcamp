package kr.co.bit.obj2;

import java.util.Scanner;

public class JuExecuter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {// 반복문
			String ju = JuFunction.juSelect(input);
			if (ju.equals("yes") || ju.equals("YES")) {
				JuFunction.juDisp(1);
				int menu = JuFunction.menuSelect(input);
				if (menu == 1) {
					JuFunction.menuDisp(1);
					String gob = JuFunction.gobSelect(input);
					if (gob.equals("yes") || gob.equals("YES")) {
						JuFunction.gobDisp(1);
					} else {
						JuFunction.gobDisp(2);
					}
				} else if (menu == 2) {
					JuFunction.menuDisp(2);
					String gob = JuFunction.gobSelect(input);
					if (gob.equals("yes") || gob.equals("YES")) {
						JuFunction.gobDisp(3);
					} else {
						JuFunction.gobDisp(4);
					}
				} else if (menu == 3) {
					JuFunction.menuDisp(3);
					int tang = JuFunction.tangSelect(input);
					if (tang == 1) {
						JuFunction.tangDisp(1);
					} else if (tang == 2) {
						JuFunction.tangDisp(2);
					} else if (tang == 3) {
						JuFunction.tangDisp(3);
					}
				}
			} else {
				JuFunction.juDisp(2);
				break;
			}
		} // 반복문

	}
}
