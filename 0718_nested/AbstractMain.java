class AbstractMain {
	public static void main(String[] args) {
		AbstractTest at = new AbstractTest(){ //�͸� inner class
			@Override
			public void setName(String name) {//����
				this.name = name;
			}
		};

		InterA ia = new InterA() { //�������̽��� new�Ѱ� �ƴ϶� inner Ŭ������ new �Ѱ�. �������̽��� new �ȵ�. 
			public void aa() {}
			public void bb() {}
		};

		AbstractExam ae = new AbstractExam(){};	//�������̵� �ϰ� �����͸� �� �� ����. �߻�޼ҵ尡 ���� ������ �ص� �׸� ���ص� �׸�.

	}
}
