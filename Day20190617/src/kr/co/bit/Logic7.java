package kr.co.bit;

public class Logic7 {
	public static void main(String[] args) {
		int kor = Integer.parseInt(args[0]);
		int mat = Integer.parseInt(args[1]);
		int eng = Integer.parseInt(args[2]);
		int total = 0;
		
		total = kor + mat + eng;
		
		if(total >= 180) {
			if(kor<40 || mat<40 || eng<40) {
				System.out.println("����� �����Դϴ�. ���հ��Դϴ�.");
			} else {
				System.out.println("����� �հ��Դϴ�.");
			}
		}
		else {
			System.out.println("����� ������ �����մϴ�. ���հ��Դϴ�.");
		}
	}
}
