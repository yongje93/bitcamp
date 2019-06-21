package kr.co.bit;

public class For_Test7 {
	public static void main(String[] args) {
		
		aaa: for (char c = 'A'; c <= 'C'; c++) {
			for (int x = 1; x <= 3; x++) {
				if (x == 2)
					continue;	//continue를 만나면 반복문의 시작부분으로 돌아간다.
				if (c == 'B')
					continue aaa;
				System.out.println("c=" + c + ", x=" + x);
			}
		}

	}
}
