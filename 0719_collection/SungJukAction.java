import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukAction {
	private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();;
	private Scanner scan = new Scanner(System.in);

	public void menu() {
		int number; // 선택번호
		while (true) {
			System.out.println("\n------------------");
			System.out.println("   1.입력\n   2.출력\n   3.검색\n   4.삭제\n   5.정렬\n   6.끝");
			System.out.println("------------------");
			System.out.print("번호 : ");
			number = scan.nextInt();
			System.out.println();

			if (number == 1) { // 입력
				insertArticle();
			} else if (number == 2) { // 출력
				printArticle();
			} else if (number == 3) { // 검색
				searchArticle();
			} else if (number == 4) { // 삭제
				deleteArticle();
			} else if (number == 5) { // 정렬
				sortArticle();
			} else if (number == 6) { // 끝
				break;
			} else {
				System.out.println("1~6 중에 선택하세요.");
			}
		}
	}

	public void insertArticle() {
		System.out.print("번호 입력 : ");
		int no = scan.nextInt();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int korea = scan.nextInt();
		System.out.print("영어 입력 : ");
		int english = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();

		SungJukDTO dto = new SungJukDTO(no, name, korea, english, math);
		list.add(dto);
	}

	public void printArticle() {
		System.out.print("번호\t이름\t국어\t영어\t수학\t총점\t평균\n");
		for (SungJukDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println();
	}

	public void searchArticle() {
		int count = 0;
		System.out.print("검색 할 이름 입력 : ");
		String name = scan.next();
		for (SungJukDTO data : list) {
			if (name.equals(data.getName())) {
				count++;
				if (count == 1)
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(data);
			}
		}
		if (count == 0) {
			System.out.println("찾고자 하는 이름이 없습니다.");
		}
	}

	public void deleteArticle() {
		System.out.print("삭제 할 이름 입력 : ");
		String name = scan.next();
		int sw = 0; // switch
		Iterator<SungJukDTO> it = list.iterator();
		while (it.hasNext()) {
			SungJukDTO dto = it.next();
			if (dto.getName().equals(name)) {
				it.remove(); // remove 메소드는 next()가 호출한 데이터를 삭제합니다.
				sw = 1;
			}
		}
		if (sw == 0) {
			System.out.println("삭제할 이름이 없습니다.");
		} else {
			System.out.println("데이터를 삭제하였습니다.");
		}
	}

	public void sortArticle() {
		while (true) {
			System.out.println("1. 이름으로 오름차순");
			System.out.println("2. 총점으로 내림차순");
			System.out.println("3. 이전메뉴");
			System.out.print(" 번호 입력: ");
			int number = scan.nextInt();
			
			System.out.println();
			
			if (number == 1) {
				Comparator<SungJukDTO> sortName = new Comparator<SungJukDTO>() {
					@Override
					public int compare(SungJukDTO o1, SungJukDTO o2) {
						return o1.getName().compareTo(o2.getName());
					}
				};
				Collections.sort(list, sortName);
				printArticle();
			} else if (number == 2) {
				Collections.sort(list);
				printArticle();
			} else if (number == 3) {
				break;
			}
		}
	}
}