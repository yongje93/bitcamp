import java.util.Scanner;

class Exam {
	private String name;
	private String dap;
	private char[] ox = new char[5];
	private int score;

	public static final String JUNK = "11111";

	public Exam() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("답안지 입력 : ");
		dap = scan.next();
		System.out.println();
	}

	public void comp() {
		for (int i = 0; i < dap.length(); i++) {
			if (dap.charAt(i) == JUNK.charAt(i)) {
				ox[i] = 'O';
				score += 20;
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
class ExamMain2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("인원 수 입력 : ");
		int count = scan.nextInt();
		Exam[] exam = new Exam[count];
		for (int i = 0; i < count; i++) {
			exam[i] = new Exam();
			exam[i].comp();
		}
		System.out.println();
		System.out.println("이름\t1 2 3 4 5\t점수");
		for (int i = 0; i < exam.length; i++) {
			char[] arr = exam[i].getOx();
			System.out.print(exam[i].getName()+"\t");
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]+ " ");
			}
			System.out.print("\t"+exam[i].getScore()+"\n");
		}
	}
}
