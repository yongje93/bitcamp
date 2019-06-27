package kr.co.bit;

public class ChildMethodCall {
	
	public static void main(String[] args) {
		Person person = new Student();	// 부모에 자식을 넣음. (축소)
		//person.study();			// 자식에만 존재하는 일반함수
		person.showSleepStyle();	// override 함수				
	}
	
}
