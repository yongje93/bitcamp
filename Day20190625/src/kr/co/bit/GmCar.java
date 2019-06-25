package kr.co.bit;

public class GmCar extends Car {	//상속
	public int cnt;

	public GmCar() {
		cnt = 1;
		engine.kind = "GM엔진";
		for (int i = 0; i < door.length; i++) {
			door[i].window = cnt++;
		}
	}

	public static void main(String[] args) {
		GmCar gmCar = new GmCar();
		System.out.println(gmCar.engine.kind);
		for (int i = 0; i < gmCar.door.length; i++) {
			System.out.print(gmCar.door[i].window + " ");
		}
	}

}
