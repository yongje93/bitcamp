package kr.co.bit;

abstract class Vehicle {
	abstract void move();
}

class Car extends Vehicle {

	@Override
	void move() {
		System.out.println("������ �ٴѴ�");
	}

}

class Plane extends Vehicle {

	@Override
	void move() {
		System.out.println("�ϴ÷� �ٴѴ�.");
	}
	
}

class Ship extends Vehicle {

	@Override
	void move() {
		System.out.println("���η� �ٴѴ�.");
	}
	
}

class VehicleUse {
	void getMoveStyle(Vehicle vehicle) {
		vehicle.move();
	}
}

public class AbstractTest3 {
	public static void main(String[] args) {
		Car car = new Car();
		Ship ship = new Ship();
		Plane plane = new Plane();
		VehicleUse vUse = new VehicleUse();
		vUse.getMoveStyle(car);
		vUse.getMoveStyle(ship);
		vUse.getMoveStyle(plane);
	}
}
