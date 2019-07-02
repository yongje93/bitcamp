package day20190701;

import java.util.ArrayList;

class LandAnimal {
	public void crying() {
		System.out.println("À°Áöµ¿¹°");
	}
}

class Cat extends LandAnimal {
	public void crying() {
		System.out.println("³Ä¿Ë³Ä¿Ë");
	}
}

class Dog extends LandAnimal {
	public void crying() {
		System.out.println("¸Û¸Û");
	}
}

class Sparrow extends LandAnimal {
	public void crying() {
		System.out.println("Â±Â±");
	}
}

class AnimalList<T> {
	ArrayList<T> al = new ArrayList<T>();

	public static void cryingAnimalList(AnimalList<? extends LandAnimal> al) {
		LandAnimal la = al.get(0);
		la.crying();
	}

	void add(T animal) {
		al.add(animal);
	}

	T get(int index) {
		return al.get(index);
	}

	boolean remove(T animal) {
		return al.remove(animal);
	}

	int size() {
		return al.size();
	}
}

public class GenericTest {
	public static void main(String[] args) {
		AnimalList<Cat> catList = new AnimalList<Cat>();
		catList.add(new Cat());
		AnimalList<Dog> dogList = new AnimalList<Dog>();
		dogList.add(new Dog());
		AnimalList<Sparrow> sparrowList = new AnimalList<Sparrow>();
		sparrowList.add(new Sparrow());

		AnimalList.cryingAnimalList(catList);
		AnimalList.cryingAnimalList(dogList);
		AnimalList.cryingAnimalList(sparrowList);
	}
}
