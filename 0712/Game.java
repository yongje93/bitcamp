/* ���� ���� �� ����.
	1: ���� 
	2: ����
	3: ��
	��ǻ�Ͱ� 1~3�� ������ �߻��Ѵ�. 
	�⺻�ݾ��� 10,000��
	�ݾ��� 0���̰ų� ���̳ʽ��� �ݾ��� �ٽ� �Է�

	[������]
	����, ����, ��(1~3) : 1 (System.in.read() ���)
	���� �ݾ�: 3000
	Enter�� ġ����...
	
	��ǻ�� : ����, �� ����
	����
	����� �ݾ��� 7000���Դϴ�.
	
	insert coin(y/n) : n
	���α׷��� �����մϴ�.

	insert coin(y/n) : y
	�󸶸� �����ұ��? 
*/
import java.util.Scanner;

class Game {
	public static void main(String[] args) throws java.io.IOException {
		Scanner scan = new Scanner(System.in);
		int com, user;
		int money = 10000;
		int battingMoney;
		int chargeMoney;
		String yn;
	
		while(true) {
			com = (int)(Math.random()*3) + 1;	
			
			System.out.print("����, ����, �� (1~3) : ");
			user = System.in.read()-'0';
			do {
				System.out.print("���� �ݾ� : ");
				battingMoney = scan.nextInt();
				System.out.print("Enter�� ġ����...");
				System.in.read();
				System.in.read();
				if(money > battingMoney) {
					break;
				}
			} while(money < battingMoney);

			if(com == 1) {	//����
				if(user == 1) { //����
					System.out.println("��ǻ�� : ����, �� : ����");
					System.out.println("����.");
				} else if(user == 2) { //����
					System.out.println("��ǻ�� : ����, �� : ����");
					System.out.println("�̰��.");
					money+=battingMoney;
				} else if(user == 3) { //��
					System.out.println("��ǻ�� : ����, �� : ��");
					System.out.println("����.");
					money-=battingMoney;
				}
			} else if (com == 2) {	//����
				if(user == 1) { //����
					System.out.println("��ǻ�� : ����, �� : ����");
					System.out.println("����.");
					money-=battingMoney;
				} else if(user == 2) { //����
					System.out.println("��ǻ�� : ����, �� : ����");
					System.out.println("����.");
				} else if(user == 3) { //��
					System.out.println("��ǻ�� : ����, �� : ��");
					System.out.println("�̰��.");
					money+=battingMoney;
				}
			} else if (com == 3) {	//��
				if(user == 1) { //����
					System.out.println("��ǻ�� : ��, �� : ����");
					System.out.println("�̰��.");
					money+=battingMoney;
				} else if(user == 2) { //����
					System.out.println("��ǻ�� : ��, �� : ����");
					System.out.println("����.");
					money-=battingMoney;
				} else if(user == 3) { //��
					System.out.println("��ǻ�� : ��, �� : ��");
					System.out.println("����.");
				}
			}
			System.out.println("����� �ݾ��� : " + money+ "�� �Դϴ�.");
			System.out.println();
			if(money <= 0) {
				System.out.print("insert coin(y/n) : ");
				yn = scan.next();
				if(yn.equals("n") || yn.equals("N")) break;
				else if(yn.equals("y") || yn.equals("Y")) {
					System.out.print("�󸶸� �����ұ��? ");
					chargeMoney = scan.nextInt();
					money += chargeMoney;
				}
			}
		}//while
		System.out.println("���α׷��� �����մϴ�.");
	}
}
