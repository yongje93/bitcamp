package kr.co.bit;

import java.util.Scanner;

public class ChinaMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		SeoulChina seoulChina = new SeoulChina();
		SeongnamChina seongnamChina = new SeongnamChina();

		while (true) {
			System.out.println("1.¼­¿ï Áß±¹Áý 2.¼º³² Áß±¹Áý");
			int protocol = input.nextInt();

			if (protocol == 1) {
				System.out.println("¼­¿ï Áß±¹Áý");
				seoulChina.setJajang(3000);
				seoulChina.setJampong(6000);
				seoulChina.setTang(10000);
				seoulChina.setJengban(18000);
				System.out.println("°¡°Ý \n" + "Â¥Àå¸é : " + seoulChina.jajang + " Â«»Í : " + seoulChina.jampong 
						+ " ÅÁ¼öÀ° : " + seoulChina.tang + " Àï¹ÝÂ¥Àå : " + seoulChina.jengban);
			} else if (protocol == 2) {
				System.out.println("¼º³² Áß±¹Áý");
				seongnamChina.setJajang(3000);
				seongnamChina.setJampong(5000);
				seongnamChina.setTang(6000);
				seongnamChina.setSamsun(20000);
				System.out.println("°¡°Ý \n" + "Â¥Àå¸é : " + seongnamChina.jajang + " Â«»Í : " + seongnamChina.jampong
						+ " ÅÁ¼öÀ° : " + seongnamChina.tang + " »ï¼±Â«»Í : " + seongnamChina.samsun);
			}
		}
	}

}
