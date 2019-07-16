abstract class AbstractTest{
	protected String name;

	public String getName() {	//구현
		return name;
	}

	public abstract void setName(String name);	//추상메소드
}

//추상메소드가 있는 클래스는 반드시 추상클래스이어야 한다.
//추상클래스는 new 생성 할 수 없다.