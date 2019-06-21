package kr.co.bit;

public class While_Test3 {

	public static void main(String[] args) {
		int danNumber = Integer.parseInt(args[0]);
		if (danNumber >= 2 && danNumber <= 9) {
			int num = 1;
			int result = 0;
			while (num <= 9) {
				result = danNumber * num;
				System.out.println(danNumber + "*" + num + "=" + result);
				num++;
			}
		} else {
			System.out.println("단값이 잘못되었습니다.");
		}
	}

}
