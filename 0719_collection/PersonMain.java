import java.util.ArrayList;

class PersonMain {
	public ArrayList<PersonDTO> init() { //구현
		PersonDTO aa = new PersonDTO("코난", 13);
		PersonDTO bb = new PersonDTO("또치", 30);
		PersonDTO cc = new PersonDTO("길동", 25);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list;
	}

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("이름="+list.get(i).getName()+"\t나이="+list.get(i).getAge());
		}
		System.out.println();

		for(PersonDTO dto : list) {
			System.out.println("이름="+dto.getName()+"\t나이="+dto.getAge());	
		}
		System.out.println();
		
		for(PersonDTO dto : list) {
			System.out.println(dto);	
		}
		System.out.println();
		

	}
}
