package kr.co.bit;

public class Car {	
	public Engine engine;	//포함
	public Door[] door;		//포함

	public Car() {
		engine = new Engine();
		door = new Door[4];
		for (int i = 0; i < door.length; i++) {
			door[i] = new Door();
		}
	}

}
