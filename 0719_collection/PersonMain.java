import java.util.ArrayList;

class PersonMain {
	public ArrayList<PersonDTO> init() { //����
		PersonDTO aa = new PersonDTO("�ڳ�", 13);
		PersonDTO bb = new PersonDTO("��ġ", 30);
		PersonDTO cc = new PersonDTO("�浿", 25);
		
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
			System.out.println("�̸�="+list.get(i).getName()+"\t����="+list.get(i).getAge());
		}
		System.out.println();

		for(PersonDTO dto : list) {
			System.out.println("�̸�="+dto.getName()+"\t����="+dto.getAge());	
		}
		System.out.println();
		
		for(PersonDTO dto : list) {
			System.out.println(dto);	
		}
		System.out.println();
		

	}
}
