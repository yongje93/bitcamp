class AbstractMain extends AbstractTest {
	@Override
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		AbstractTest aa = new AbstractMain();	//���� �θ� = �ڽ� (��� �θ�� �ڽ�Ŭ������ ������ �� �ִ�)
		aa.setName("ȫ�浿");
		System.out.println("�̸� = " + aa.getName());
	}
}
