import java.util.Scanner;

class IfTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("알파벳을 입력하세요->");
		char input = scan.next().charAt(0);
		
		if(input >= 65 && input <= 90) {
			System.out.println("ch=" + (char)(input+32));	
		} else if (input >=97 && input <= 120) {
			System.out.println("ch=" + (char)(input-32));
		}

		char ch = 'e';
		int result = 0;
		if(ch >= 'A' && ch <='Z') result = ch + 32;		// char, short, int 계산결과는 무조건 int형.
		else if (ch >= 'a' && ch <='z') result = ch - 32;
		System.out.println(ch + " -> " + (char)result);
	}
}
