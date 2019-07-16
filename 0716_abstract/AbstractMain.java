class AbstractMain extends AbstractTest {
	@Override
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		AbstractTest aa = new AbstractMain();	//생성 부모 = 자식 (모든 부모는 자식클래스를 참조할 수 있다)
		aa.setName("홍길동");
		System.out.println("이름 = " + aa.getName());
	}
}
