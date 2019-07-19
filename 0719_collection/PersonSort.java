import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PersonSort {
	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};		
		Arrays.sort(ar);
		for(String data : ar) {
			System.out.print(data + "	");
		}
		System.out.println();

		PersonDTO aa = new PersonDTO("코난", 13);
		PersonDTO bb = new PersonDTO("또치", 30);
		PersonDTO cc = new PersonDTO("길동", 25);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		Collections.sort(list);
		System.out.println("\n 나이로 정렬 = " + list);	//toString 생략되어있음.
		
		System.out.print ("\n 이름으로 정렬 = ");	
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() { //새로운 기준으로 정렬
			@Override
			public int compare(PersonDTO p1, PersonDTO p2) {
				//오름차순
				//return p1.getName().compareTo(p2.getName()); //compareTo가 값을 비교하고 -1, 0, 1 출력해줌.
				//내림차순
				//return p2.getName().compareTo(p1.getName());
				return p1.getName().compareTo(p2.getName())*-1;
			}
		};		
		
		Collections.sort(list, com);//그냥 list면 PersonDTO의 compareTo니까 뒤에 com을 넣어줘서 Comparator를 이용하게 해줌
		System.out.println(list);
	}
}
