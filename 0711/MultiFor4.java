/*
3중 for if(마지막2개라서) 이용
2단 3단 4단
5단 6단 7단
8단 9단

1-9까지 곱하는 for 랑 3개찍는 for랑 1-9단찍는 for
*/

/*
class MultiFor4 {
	public static void main(String[] args) {
		int i, j, k;
		for (k = 2; k < 9; k += 3) {
			for (j = 1; j < 10; j++) {
				for (i = k; i < k + 3; i++) {
					if (i == 10) break;
					System.out.print(i +" * " + j + " = " + (i*j) +"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
*/

class MultiFor4 {
	public static void main(String[] args) {
		int dan, i, k;
		for(k = 2; k <= 8; k+=3) {	
			for(i = 1; i <=9; i++) {
				for(dan = k; dan <= k+2; dan++){
					if(dan != 10) System.out.print(dan +" * " + i + " = " + (dan*i) +"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}