class Person {
	private String name;
	private int age;

	public void setName(String n) {	//����
		name = n;
	}

	public void setAge(int n) {	//����
		age = n;
	}

	public void setData(String n, int a) {
		name = n;
		age = a;
	}

	public void setData() { }	// �����ε�

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
//---------------
class PersonMain {
	public static void main(String[] args) {
		Person aa;	
		aa = new Person();
		System.out.println("��ü aa = " + aa);
		System.out.println("��ü aa = " + aa.toString());
		System.out.println("��ü aa = " + aa.hashCode());	//10������ �ٲ��ش�.
		
		aa.setName("ȫ�浿"); //ȣ��
		System.out.println("�̸�=" + aa.getName());
		aa.setAge(27);
		System.out.println("����=" + aa.getAge());	
		System.out.println();
		//-------------------
		
		Person bb = new Person();
		System.out.println("��ü bb = " + bb);
		bb.setName("�ڳ�");
		System.out.println("�̸�=" + bb.getName());
		bb.setAge(15);
		System.out.println("����=" + bb.getAge());
		System.out.println();

		Person cc = new Person();
		cc.setData("��ġ", 30);
		System.out.println("�̸�=" + cc.getName());
		System.out.println("����=" + cc.getAge());
		System.out.println();

		Person dd = new Person();
		dd.setData();
		System.out.println("�̸�=" + dd.getName());
		System.out.println("����=" + dd.getAge());
		System.out.println();
	}
}

// int aa; //������ ����	int[] ar; //������ �迭
// double aa; //�Ǽ��� ����
// Person aa; // ��ü	Person[] ar; //��ü �迭