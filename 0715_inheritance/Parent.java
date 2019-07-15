class Parent {
	protected double weight, height;
	
	public Parent() { 
		System.out.println("Parent 扁夯积己磊");
	}
	public Parent(double weight, double height) {
		System.out.println("Parent 积己磊");
		this.weight = weight;
		this.height = height;
	}
	public void disp() {
		System.out.println("个公霸 = " + weight);
		System.out.println("虐 = " + height);
	}
}
