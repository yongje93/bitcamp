// A~Z까지 출력하되 한줄에 7줄씩
class WhileTest {
	public static void main(String[] args) {
		char ch = 'A';
		int count = 0;
		while(ch<='Z') {
			System.out.print(ch+" ");
			ch++;
			count++;
			if(count%7 == 0) System.out.println();
		}
/*		
		int a = 65;
		int cnt = 0;
		while(true) {
			System.out.print((char)a + " ");
			a++;
			cnt++;
			if(a == 91) break;
			if(cnt%7 == 0) System.out.println();
		} 
*/
	}
}
