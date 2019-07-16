/*
5문제를 채점하는 프로그램
필드 : name, dap, ox[], score
	정답 public static finalJUNK = "11111";
메소드 : 생성자 - Scanner
	   comp()
	   getter()
실행결과
이름 입력 : 홍길동 (name)
답안지 입력 : 11321 (dap)

이름		1 2 3 4 5	점수
홍길동	O O X X O	60
*/
import java.util.Scanner;

class Exam {
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	public static final String JUNK = "11111";	//정답

	public Exam() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("답안지 입력 : ");
		dap = scan.next();
		ox = new char[5];
	}

	public void comp() {
		//for( int i = 0; i < ox.length; i++) {	
		for(int i = 0; i < dap.length(); i++) {	// 문자열의 크기는 length()로 씀.
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
		System.out.print("인원 수 입력 : ");
		int size = scan.nextInt();
		Exam[] ar = new Exam[size];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = new Exam();
			ar[i].comp();
		}
		System.out.println();
		System.out.println("이름\t1 2 3 4 5\t점수");
		
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
		System.out.println("이름\t1 2 3 4 5\t점수");
		System.out.print(exam.getName()+"\t");
		for(int i = 0; i < exam.getOx().length; i++) {
			System.out.print(exam.getOx()[i]+ " ");
		}
		System.out.print("\t"+exam.getScore()+"\n");
*/
	}
}
