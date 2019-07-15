class SungJuk {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public void setData(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void calc() {
		tot = kor + eng + math;
		avg = (double)tot / 3.0;
	}

	public String getName() { return name; }
	public int getKor() { return kor; }
	public int getEng() { return eng; }
	public int getMath() { return math; }
	public int getTot() { return tot; }
	public double getAvg() { return avg; }
	
	@Override
	public String toString() {
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+ String.format("%.2f", avg);
	}
}
//---------------------------
class SungJukMain {
	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[3];	//�迭����

		for(int i = 0; i < ar.length; i++) {
			ar[i] = new SungJuk();	//��ü����
		}
		ar[0].setData("ȫ�浿", 95, 92, 100);
		ar[1].setData("�ڳ�", 85, 72, 63);
		ar[2].setData("��ġ", 70, 92, 60);
		
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		for(SungJuk data : ar) {
			data.calc();
			System.out.println(data);
		}
		
		/*
		SungJuk aa = new SungJuk();
		aa.setData("ȫ�浿", 95, 92, 100); // ȣ��
		aa.calc();
		
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		System.out.println(aa.toString());
		
		//-------------
		SungJuk bb = new SungJuk();
		bb.setData("�ڳ�", 85, 72, 63);
		bb.calc();
		System.out.println(bb.toString());

		SungJuk cc = new SungJuk();
		cc.setData("��ġ", 70, 92, 60);
		cc.calc();
		System.out.println(cc.toString());
		*/
	}
}

//���� %d
//�Ǽ� %f
//���� %c
//���ڿ� %s