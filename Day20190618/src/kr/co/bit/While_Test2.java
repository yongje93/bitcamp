package kr.co.bit;

public class While_Test2 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while (true) {
			sum += i;
			i++;
			if (i == 50)
				break;
		}
		System.out.println("1���� 50������ ���� = " + sum + " �Դϴ�.");
	}

}
