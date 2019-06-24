package kr.co.bit.obj;

public class Car {
	public Engine engine; // 부분
	public Door[] door; // 부분

	public Car() { // 전체
		engine = new Engine();
		door = new Door[4];
		for (int i = 0; i < door.length; i++) {
			door[i] = new Door();
		}
	}

	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.engine.kind);
		car.door[0].window = 1;
		car.door[1].window = 2;
		car.door[2].window = 3;
		car.door[3].window = 4;

		for (int i = 0; i < car.door.length; i++) {
			System.out.println("차문 : " + car.door[i].window);
		}
	}
}
