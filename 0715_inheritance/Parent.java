class Parent {
	protected double weight, height;
	
	public Parent() { 
		System.out.println("Parent �⺻������");
	}
	public Parent(double weight, double height) {
		System.out.println("Parent ������");
		this.weight = weight;
		this.height = height;
	}
	public void disp() {
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
	}
}
