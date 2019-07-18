class AbstractMain {
	public static void main(String[] args) {
		AbstractTest at = new AbstractTest(){ //익명 inner class
			@Override
			public void setName(String name) {//구현
				this.name = name;
			}
		};

		InterA ia = new InterA() { //인터페이스를 new한게 아니라 inner 클래스를 new 한것. 인터페이스는 new 안됨. 
			public void aa() {}
			public void bb() {}
		};

		AbstractExam ae = new AbstractExam(){};	//오버라이드 하고 싶은것만 할 수 있음. 추상메소드가 없기 때문에 해도 그만 안해도 그만.

	}
}
