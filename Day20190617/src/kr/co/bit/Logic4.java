package kr.co.bit;

public class Logic4 {
	public static void main(String[] args) {
		int age = Integer.parseInt(args[0]);
		String result = "";
		if(age/10 == 0) {
			result = "10�� ����";
		} else if(age/10 == 1) {
			result = "10��";
		} else if(age/10 == 2) {
			result = "20��";
		} else if(age/10 == 3) {
			result = "30��";
		} else if(age/10 == 4) {
			result = "40��";
		} else if(age/10 == 5) {
			result = "50��";
		} else if(age/10 == 6) {
			result = "60��";
		} else if(age/10 == 7) {
			result = "70��";
		} else {
			result = "����� �ƴϴ�.";
		}
		System.out.println("����� "+result);
	}
}
