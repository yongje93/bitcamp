// 10진수 입력 : 13
// 2진수 =
// 8진수 =
// 16진수 =
import java.util.Scanner;

class MethodTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("10진수 입력 : ");
		int num = scan.nextInt();
		
		String binary = Integer.toBinaryString(num);
		String octor = Integer.toOctalString(num);
		String hexa = Integer.toHexString(num);

		System.out.println("2진수 = " + binary);
		System.out.println("8진수 = " + octor);
		System.out.println("16진수 = " + hexa);		
	}
}
