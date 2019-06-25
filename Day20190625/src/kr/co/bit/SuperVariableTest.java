package kr.co.bit;

class Sawon3 {
	String name;

	public Sawon3() {
		name = "¹ÚÃµ¼ö";
	}
}

class Sales3 extends Sawon3 {
	String name;

	public Sales3() {
		name = "À±Á¾Çõ";
	}

	public String displayInfoLocal() {
		String name = "±è½Â¼®";
		return name;
	}

	public String displayInfoThis() {
		String name = "¼®½ÂÈÆ";
		return this.name;
	}

	public String displayInfoSuper() {
		String name = "¿ÀÁ¤¿ø";
		return super.name;
	}
}

public class SuperVariableTest {

	public static void main(String[] args) {
		Sales3 sales = new Sales3();
		System.out.println("·ÎÄÃ ÀÌ¸§ = " + sales.displayInfoLocal());
		System.out.println("this ÀÌ¸§ = " + sales.displayInfoThis());
		System.out.println("super ÀÌ¸§ = " + sales.displayInfoSuper());
	}

}
