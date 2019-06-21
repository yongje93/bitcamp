package kr.co.bit;

public class Logic4 {
	public static void main(String[] args) {
		int age = Integer.parseInt(args[0]);
		String result = "";
		if(age/10 == 0) {
			result = "10대 이하";
		} else if(age/10 == 1) {
			result = "10대";
		} else if(age/10 == 2) {
			result = "20대";
		} else if(age/10 == 3) {
			result = "30대";
		} else if(age/10 == 4) {
			result = "40대";
		} else if(age/10 == 5) {
			result = "50대";
		} else if(age/10 == 6) {
			result = "60대";
		} else if(age/10 == 7) {
			result = "70대";
		} else {
			result = "사람이 아니다.";
		}
		System.out.println("당신은 "+result);
	}
}
