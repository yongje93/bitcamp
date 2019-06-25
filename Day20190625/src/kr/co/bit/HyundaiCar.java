package kr.co.bit;

public class HyundaiCar extends Car {	//상속
	public int cnt;

	public HyundaiCar() {
		cnt = 1;
		engine.kind = "현대엔진";
		for (int i = 0; i < door.length; i++) {
			door[i].window = cnt++;
		}
	}

	public static void main(String[] args) {
		HyundaiCar hynda = new HyundaiCar();
		System.out.println(hynda.engine.kind);
		for (int i = 0; i < hynda.door.length; i++) {
			System.out.print(hynda.door[i].window + " ");
		}
	}
}
