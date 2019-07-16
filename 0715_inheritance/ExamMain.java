/*
5������ ä���ϴ� ���α׷�
�ʵ� : name, dap, ox[], score
	���� public static finalJUNK = "11111";
�޼ҵ� : ������ - Scanner
	   comp()
	   getter()
������
�̸� �Է� : ȫ�浿 (name)
����� �Է� : 11321 (dap)

�̸�		1 2 3 4 5	����
ȫ�浿	O O X X O	60
*/
import java.util.Scanner;

class Exam {
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	public static final String JUNK = "11111";	//����

	public Exam() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		name = scan.next();
		System.out.print("����� �Է� : ");
		dap = scan.next();
		ox = new char[5];
	}

	public void comp() {
		//for( int i = 0; i < ox.length; i++) {	
		for(int i = 0; i < dap.length(); i++) {	// ���ڿ��� ũ��� length()�� ��.
			if(dap.charAt(i) == JUNK.charAt(i)) {
				ox[i] = 'O';
				score+=20;
			} else {
				ox[i] = 'X';
			}
		}
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public char[] getOx() {
		return ox;
	}
}
//-------------
class ExamMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�ο� �� �Է� : ");
		int size = scan.nextInt();
		Exam[] ar = new Exam[size];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = new Exam();
			ar[i].comp();
		}
		System.out.println();
		System.out.println("�̸�\t1 2 3 4 5\t����");
		
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i].getName()+"\t");
			for(int j = 0; j < ar[i].getOx().length; j++) {
				System.out.print(ar[i].getOx()[j]+ " ");
			}
			System.out.print("\t"+ar[i].getScore()+"\n");	
		}
/*
		Exam exam = new Exam();
		exam.comp();
		System.out.println("�̸�\t1 2 3 4 5\t����");
		System.out.print(exam.getName()+"\t");
		for(int i = 0; i < exam.getOx().length; i++) {
			System.out.print(exam.getOx()[i]+ " ");
		}
		System.out.print("\t"+exam.getScore()+"\n");
*/
	}
}
