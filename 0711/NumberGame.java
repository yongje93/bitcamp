/*
���� ���߱� ����
1~100 ������ ������ �߻��Ͽ� ���ߴ� ����
[������]
1~100 ������ ������ �߻��Ͽ����ϴ�. 87
���� �Է� : 50
50���� Ů�ϴ�.

���� �Է� : 90
90���� �۽��ϴ�.
..
.

���� �Է� : 87
XX�� ���� ���߼̽��ϴ�.
*/
import java.util.Scanner;

class NumberGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number;
		String yn;
		while(true) {
			int random = (int)(Math.random()*100) + 1;			
			int count = 0;
			System.out.println(random);
			while(true) {
				System.out.print("���� �Է� : ");
				number = scan.nextInt();
				count++;
				if(random > number) {
					System.out.println(number+"���� Ů�ϴ�.");
				} else if(random < number) {
					System.out.println(number+"���� �۽��ϴ�.");
				} else 
					break;
			}
			System.out.println(count+"�� ���� ���߼̽��ϴ�.");
			System.out.print("�� �Ͻðڽ��ϱ�?(y/n) ");
			yn = scan.next();
			if(yn.equals("n") || yn.equals("N")) break;
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
