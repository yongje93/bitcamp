/*
10~99������ ������ 2�� �߻��Ͽ� ���� ���ߴ� ����
�� ������ 5������ �����Ѵ�
1������ ���� 20���Դϴ�
Ʋ���� 1�� �� ��ȸ�� �����Ѵ�

[������]
[1] 12 + 36 = xx
Ʋ�ȴ�
[1] 12 + 36 = xxx
Ʋ�ȴ�...������ 48

[2] 10 + 15 = xx
������

[5] 90 + 88 =
Ʋ�ȴ�
[5] 90 + 88 = 178
������

�� ���������� 2�����̰� ������ 40���Դϴ�

�� �ҷ�(Y/N) : n
���α׷��� �����մϴ�
*/

import java.util.Scanner;
class Quiz_Answer {
	public static void main(String[] args) {
		int a,b,dab,score=0;
		String again;

		Scanner input = new Scanner(System.in);
		while(true) {
			score=0;

			for(int i=1; i<=5; i++){//5����
				a = (int)(Math.random()*90) + 10;//10~99
				b = (int)(Math.random()*90) + 10;//10~99
		
				for(int j=1; j<=2; j++){//Ʋ���� 1�� �� ��ȸ�� �ش�
					System.out.print("["+i+"] "+a+" + "+b+" = ");
					dab = input.nextInt();

					if(dab==a+b){
						System.out.println("�¾ҽ��ϴ�!!!");
						score++;
						break;//for j�� �����
					}else{
						if(j==2)
							System.out.println("Ʋ�Ƚ��ϴ�...������ "+(a+b));
						else
							System.out.println("Ʋ�Ƚ��ϴ�...");
					}
				}//for j
				System.out.println();
			}//for i
			System.out.println("�� ���������� "+score+"�����̰� ������ "+score*20+"���Դϴ�");
			System.out.println();
			do{
				System.out.print("�ٽ��ϰڽ��ϱ�? (Y/N) : ");
				again = input.next();
				if(again.equals("Y") || again.equals("y") || again.equals("N") || again.equals("n")) break;			
			} while(true);
			if(again.equals("N") || again.equals("n")) break;			
		}//while
		System.out.println("���α׷��� �����մϴ�.");
	}
}