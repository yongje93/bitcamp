package kr.co.bit;

public class Car {	
	public Engine engine;	//����
	public Door[] door;		//����

	public Car() {
		engine = new Engine();
		door = new Door[4];
		for (int i = 0; i < door.length; i++) {
			door[i] = new Door();
		}
	}

}
