/*
for를 이용하여 합을 구하시오
[실행결과]
-1+2-3+4-5+6-7+8-9+10 = 5
*/

class ForTest2 {
	public static void main(String[] args) {
		int result = 0;
		for(int i = 1; i <= 10; i++) {
			if(i%2 == 1) {
				result -= i;
				System.out.print("-"+i);
			} else if (i%2 == 0) {
				result +=i;
				System.out.print("+"+i);
			}
		}
		System.out.print(" = " + result);
	}
}
