import java.util.Scanner;

class ShapeTest {
	protected double area;

	public ShapeTest() {
		System.out.println("ShapeTest 기본생성자"); 
	}

	public void calcArea() {
		System.out.println("도형을 계산합니다");
	}
	
	public void dispArea() {
		System.out.println("도형을 출력합니다");
	}

}
//-------------
class SamTest extends ShapeTest {
	private int base, height;

	public SamTest() {
		System.out.println("samTest 기본생성자");
		Scanner scan = new Scanner(System.in);
		System.out.print("밑변 : ");
		base = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = base*height/2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("삼각형 넓이 = " + area);
	}

}
//-------------
class SaTest extends ShapeTest {
	private int width, height;
	
	public SaTest() {
		System.out.println("SaTest 기본생성자");
		Scanner scan = new Scanner(System.in);
		System.out.print("가로 : ");
		width = scan.nextInt();
		System.out.print("세로 : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = width*height;
	}

	@Override
	public void dispArea() {
		System.out.println("사각형 넓이 = " + area);
	}
}
//-------------
class SadariTest extends ShapeTest {
	private int top, bottom, height;
	
	public SadariTest() {
		System.out.println("SadariTest 기본생성자");
		Scanner scan = new Scanner(System.in);
		System.out.print("윗변 : ");
		top = scan.nextInt();
		System.out.print("밑변 : ");
		bottom = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = (top + bottom)*height/2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("사다리꼴 넓이 = " + area);
	}
}
//-------------
class ShapeMain {
	public static void main(String[] args) {
		ShapeTest shape;
		shape = new SamTest();	//결합도 줄이기, 다형성
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest();	//결합도 줄이기, 다형성
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest();	//결합도 줄이기, 다형성
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		/*
		SamTest sam = new SamTest();	//1:1관계, 결합도 100%
		sam.calcArea();
		sam.dispArea();
		System.out.println();
		
		SaTest sa = new SaTest();
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadari = new SadariTest();
		sadari.calcArea();
		sadari.dispArea();
		System.out.println();
		*/
	}
}
