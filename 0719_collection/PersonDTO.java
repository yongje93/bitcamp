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
		return "이름="+name+"\t나이="+age;
	}

	@Override
	public int compareTo(PersonDTO o) {
		/* 오름차순
		if(this.age < o.age) return -1;
		else if(this.age > o.age) return 1;
		else return 0;
		*/

		// 내림차순
		if(this.age < o.age) return 1;
		else if(this.age > o.age) return -1;
		else return 0;
	}

}

//DTO	- Data Transfer Object 데이터를 이동할때 하나의 객체로 묶어주는거
//VO	- Value Object