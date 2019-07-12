/*
	난수(컴퓨터가 불규칙하게 발생하는 수)
	0 <= 난수 <1
	Math.random()
	new Random()
*/

class ForTest {
	public static void main(String[] args) {
		int[] intArr = new int[6];
		for(int i = 0; i < 6; i++) {
			int x = (int)(Math.random()*45) + 1;
			intArr[i] = x;
		}

		for(int i = 0; i <intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
		
		System.out.println();
		
		int a = 0;
		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			//a = (int)(Math.random()*100) + 1;	// 1~100
			a = (int)(Math.random()*26) + 65;	// 65~90	//난수 계산 부분이 0~25 까지만 나옴.
			if(a == 'A') cnt++;
			System.out.print((char)a +" ");		// 알파벳으로 형변환
			if(i%10 == 0) System.out.println();		
		}
		System.out.println("\n'A'의 개수 = " + cnt);
	}
}
