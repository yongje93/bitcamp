/*	10~99������ ������ 2�� �߻��Ͽ� ���� ���ߴ� ����
	�� ������ 5����
	1������ ������ 20��
	Ʋ���� 1�� �� ��ȸ�� �����Ѵ�.

	[������]
	[1] 12 + 36 = XX
	Ʋ�ȴ�
	[1] 12 + 36 = XXX
	Ʋ�ȴ�...������ 48

	[2] 10 + 15 = XX
	������
	..
	[5] 90 + 88 = xx
	Ʋ�ȴ�
	[5] 90 + 88 = 178
	������
	�� ���������� 2�����̰� ������ 40���Դϴ�.

	���ҷ�(Y/N) : n
	���α׷��� �����մϴ�.
*/
import java.util.Scanner;

class Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		int count = 0;
		int xcount = 0;
		String yn;
		while(true) {
			for(int i = 1; i <= 5; i++) {
				int random1 = (int)(Math.random()*90) + 10;
				int random2 = (int)(Math.random()*90) + 10;
				while(true) {
					System.out.print("["+i+"] "+random1 + " + " + random2 + " = ");
					answer = scan.nextInt();
					if(answer == (random1 + random2)) {
						count++;
						System.out.println("������");	
						xcount = 0;
						break;
					} else {
						if(xcount == 0) {
							System.out.println("Ʋ�ȴ�.");
							xcount++;
							continue;
						}
						else if(xcount == 1) {
							xcount = 0;
							System.out.println("Ʋ�ȴ�...������ " + (random1 + random2) +"�̴�.");
							break;
						}
					}
				 }
			}
			System.out.println("�� ���������� "+ count+ "�����̰� ������ "+(count*20) + "���Դϴ�.");
			System.out.print("�� �Ͻðڽ��ϱ�?(y/n) ");
			yn = scan.next();
			if(yn.equals("n") || yn.equals("N")) break;
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
