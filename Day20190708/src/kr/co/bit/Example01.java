package kr.co.bit;

import java.lang.reflect.Method;

public class Example01 {

	public static void main(String[] args) {
		// Service 클래스로부터의 메소드 정보를 얻음
		Method[] dMethod = Service.class.getDeclaredMethods();
		for (Method method : dMethod) {
			// Annotation 객체 여부 확인
			if (method.isAnnotationPresent(PrintAnnotation.class)) { // 해당 메서드에 어노테이션이 있냐없냐
				// 각각의 메서드 안에 존재하는 PrintAnnotatopn 객체 얻기
				PrintAnnotation pa = method.getAnnotation(PrintAnnotation.class); // 해당 메서드안에 있는 어노테이션의 정보를 객체로 가지고 온다.
				// 메서드 이름 출력
				System.out.println("[" + method.getName() + "]");
				// 구분선 출력
				for (int i = 0; i < pa.number(); i++) {
					System.out.print(pa.value());
				}
				System.out.println();
			}

			try {
				method.invoke(new Service());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}
