package kr.co.bit2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Example03 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동", 83), new Student("김삿갓", 85));

		Iterator<Student> it = list.iterator(); // 기존에 사용하던 방식.
		while (it.hasNext()) {
			Student std = it.next();
			System.out.println(std.getName() + "-" + std.getScore());
		}

		Stream<Student> stream = list.stream();
		stream.forEach(s -> System.out.println(s.getName() + "-" + s.getScore()));

	}
}
