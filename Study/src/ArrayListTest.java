import java.util.ArrayList;

class PersonDTO {
	private String name;
	private int age;

	public PersonDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class ArrayListTest {
	public ArrayList<PersonDTO> init() {
		PersonDTO aa = new PersonDTO("코난", 13);
		PersonDTO bb = new PersonDTO("또치", 30);
		PersonDTO cc = new PersonDTO("길동", 25);

		ArrayList<PersonDTO> arr = new ArrayList<PersonDTO>();
		arr.add(aa);
		arr.add(bb);
		arr.add(cc);
		
		return arr;
	}

	public static void main(String[] args) {
		ArrayListTest pm = new ArrayListTest();
		ArrayList<PersonDTO> array = pm.init();
		
		for(int i = 0; i < array.size(); i++) {
			System.out.println("이름 = " +array.get(i).getName() +  "	나이 = " +array.get(i).getAge() );
		}
	}
}


