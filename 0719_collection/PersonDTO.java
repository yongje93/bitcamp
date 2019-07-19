class PersonDTO implements Comparable<PersonDTO> {
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
	
	@Override
	public String toString() {
		return "�̸�="+name+"\t����="+age;
	}

	@Override
	public int compareTo(PersonDTO o) {
		/* ��������
		if(this.age < o.age) return -1;
		else if(this.age > o.age) return 1;
		else return 0;
		*/

		// ��������
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1;
		else return 0;
	}

}

//DTO	- Data Transfer Object �����͸� �̵��Ҷ� �ϳ��� ��ü�� �����ִ°�
//VO	- Value Object