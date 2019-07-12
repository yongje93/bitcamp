/*
Scanner를 이용해서 a,b,c를 입력받아서 순서대로 출력하시오.
(if문만 이용)

[실행결과]
a값 입력 : 25
b값 입력 : 12
c값 입력 : 78
12 25 78
*/
import java.util.Scanner;

class IfTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		int temp = 0;

		System.out.print("a값 입력 : ");
		a = scan.nextInt();
		System.out.print("b값 입력 : ");
		b = scan.nextInt();
		System.out.print("c값 입력 : ");
		c = scan.nextInt();
		
		if(a>b) {
			temp = a; a = b; b = temp;
		}
		if(a>c) {
			temp = a; a = c; c = temp;
		}
		if(b>c) {
			temp = b; b = c; c = temp;
		}
		System.out.println(a + "," + b + "," + c);
		//------------------------------------------------------
		if(a<b && a<c) {//a가 가장 작다면
			if(b<c) System.out.println(a+","+b+","+c);
			else System.out.println(a+","+c+","+b);
		} else if(b<c) {//b가 가장 작다면
			if(a<c) System.out.println(b+","+a+","+c);
			else System.out.println(b+","+c+","+a);
		} else{//c가 가장 작다면
			if(a<b) System.out.println(c+","+a+","+b);
			else System.out.println(c+","+b+","+a);
		}
	}
}