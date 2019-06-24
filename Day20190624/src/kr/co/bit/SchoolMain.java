package kr.co.bit;

import java.util.Scanner;

public class SchoolMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ManSchool manSchool = new ManSchool(90, 80, 70, 60);
		WomanSchool womanSchool = new WomanSchool(100, 90, 80, 70);
		ManGongupSchool manGongup = new ManGongupSchool(97, 85, 75, 65, 50);
		WomanSangupSchool womanSang = new WomanSangupSchool(88, 99, 77, 66, 100);

		while (true) {
			System.out.println("1.남자중학교 2.여자중학교 3.남자공업고등학교 4.여자상업고등학교");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("남자중학교");
				System.out.print("국어 = " + manSchool.getKor() + " 영어 = " + manSchool.getEng() + " 수학 = "
						+ manSchool.getMat() + " 기술 = " + manSchool.getGisul() + " 총합 = " + manSchool.total() 
						+ " 평균 = " 	+ manSchool.average() + "\n");
				// System.out.println(manSchool.toString());
			} else if (protocol == 2) {
				System.out.println("여자중학교");
				System.out.print("국어 = " + womanSchool.getKor() + " 영어 = " + womanSchool.getEng() + " 수학 = "
						+ womanSchool.getMat() + " 가정 = " + womanSchool.getGajung() + " 총합 = " + womanSchool.total()
						+ " 평균 = " + womanSchool.average() + "\n");
				// System.out.println(womanSchool.toString());
			} else if (protocol == 3) {
				System.out.println("남자공업고등학교");
				System.out.print("국어 = " + manGongup.getKor() + " 영어 = " + manGongup.getEng() + " 수학 = "
						+ manGongup.getMat() + " 기술 = " + manGongup.getGisul() + "" + " 공업 = " + manGongup.getGongup()
						+ " 총합 = " + manGongup.total() + " 평균 = " + manGongup.average() + "\n");
				// System.out.println(manGongup.toString());
			} else if (protocol == 4) {
				System.out.println("여자상업고등학교");
				System.out.print("국어 = " + womanSang.getKor() + " 영어 = " + womanSang.getEng() + " 수학 = "
						+ womanSang.getMat() + " 가정 = " + womanSang.getGajung() + "" + " 상업 = " + womanSang.getSangup()
						+ " 총합 = " + womanSang.total() + " 평균 = " + womanSang.average() + "\n");
				// System.out.println(womanSang.toString());
			}
			System.out.println();
		}

	}
}
