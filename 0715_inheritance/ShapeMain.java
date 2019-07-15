import java.util.Scanner;

class ShapeTest {
	protected double area;

	public ShapeTest() {
		System.out.println("ShapeTest �⺻������"); 
	}

	public void calcArea() {
		System.out.println("������ ����մϴ�");
	}
	
	public void dispArea() {
		System.out.println("������ ����մϴ�");
	}

}
//-------------
class SamTest extends ShapeTest {
	private int base, height;

	public SamTest() {
		System.out.println("samTest �⺻������");
		Scanner scan = new Scanner(System.in);
		System.out.print("�غ� : ");
		base = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = base*height/2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " + area);
	}

}
//-------------
class SaTest extends ShapeTest {
	private int width, height;
	
	public SaTest() {
		System.out.println("SaTest �⺻������");
		Scanner scan = new Scanner(System.in);
		System.out.print("���� : ");
		width = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = width*height;
	}

	@Override
	public void dispArea() {
		System.out.println("�簢�� ���� = " + area);
	}
}
//-------------
class SadariTest extends ShapeTest {
	private int top, bottom, height;
	
	public SadariTest() {
		System.out.println("SadariTest �⺻������");
		Scanner scan = new Scanner(System.in);
		System.out.print("���� : ");
		top = scan.nextInt();
		System.out.print("�غ� : ");
		bottom = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}

	@Override
	public void calcArea() {
		area = (top + bottom)*height/2.0;
	}

	@Override
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " + area);
	}
}
//-------------
class ShapeMain {
	public static void main(String[] args) {
		ShapeTest shape;
		shape = new SamTest();	//���յ� ���̱�, ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SaTest();	//���յ� ���̱�, ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		shape = new SadariTest();	//���յ� ���̱�, ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();

		/*
		SamTest sam = new SamTest();	//1:1����, ���յ� 100%
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
