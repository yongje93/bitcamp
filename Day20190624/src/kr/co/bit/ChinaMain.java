package kr.co.bit;

import java.util.Scanner;

public class ChinaMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		SeoulChina seoulChina = new SeoulChina();
		SeongnamChina seongnamChina = new SeongnamChina();

		while (true) {
			System.out.println("1.���� �߱��� 2.���� �߱���");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("���� �߱���");
				seoulChina.setJajang(3000);
				seoulChina.setJampong(6000);
				seoulChina.setTang(10000);
				seoulChina.setJengban(18000);
				System.out.println("���� \n" + "¥��� : " + seoulChina.jajang + " «�� : " + seoulChina.jampong 
						+ " ������ : " + seoulChina.tang + " ���¥�� : " + seoulChina.jengban);
			} else if (protocol == 2) {
				System.out.println("���� �߱���");
				seongnamChina.setJajang(3000);
				seongnamChina.setJampong(5000);
				seongnamChina.setTang(6000);
				seongnamChina.setSamsun(20000);
				System.out.println("���� \n" + "¥��� : " + seongnamChina.jajang + " «�� : " + seongnamChina.jampong
						+ " ������ : " + seongnamChina.tang + " �Ｑ«�� : " + seongnamChina.samsun);
			}
		}
	}

}
