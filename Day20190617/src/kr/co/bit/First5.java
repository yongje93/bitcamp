package kr.co.bit;

public class First5 {
	public static void main(String[] args) {
		char logic1 = 'A';
		String str = (logic1 == 'A'||logic1 == 'a')?"�빮�ڿ� �ҹ��ڴ� ����.":"�빮�ڿ� �ҹ��ڰ� �ٸ���.";
		System.out.println(str);
		
		System.out.println("�ֹ����� y/n");
		char ju = 'n';
		String str1 = (ju == 'y'||ju == 'Y')?"�ֹ�����":"�ֹ����";
		System.out.println(str1);
	}
}
