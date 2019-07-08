package kr.co.bit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메소드에게만 적용이 가능하도록 대상을 정함.
@Retention(RetentionPolicy.RUNTIME) // 유지정책. 소스, 클래스. 런타임
public @interface MyAnnotation1 {
	String value();

	int elemName2() default 5; // 값을 넣지 않으면 5로가짐
}
