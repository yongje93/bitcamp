/*
Scanner�� �̿��ؼ� a,b,c�� �Է¹޾Ƽ� ������� ����Ͻÿ�.
(if���� �̿�)

[������]
a�� �Է� : 25
b�� �Է� : 12
c�� �Է� : 78
12 25 78
*/
import java.util.Scanner;

class IfTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		int temp = 0;

		System.out.print("a�� �Է� : ");
		a = scan.nextInt();
		System.out.print("b�� �Է� : ");
		b = scan.nextInt();
		System.out.print("c�� �Է� : ");
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
		if(a<b && a<c) {//a�� ���� �۴ٸ�
			if(b<c) System.out.println(a+","+b+","+c);
			else System.out.println(a+","+c+","+b);
		} else if(b<c) {//b�� ���� �۴ٸ�
			if(a<c) System.out.println(b+","+a+","+c);
			else System.out.println(b+","+c+","+a);
		} else{//c�� ���� �۴ٸ�
			if(a<b) System.out.println(c+","+a+","+b);
			else System.out.println(c+","+b+","+a);
		}
	}
}