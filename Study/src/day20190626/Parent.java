package day20190626;

public interface Parent {
	// 상수 필드
	public static final int MAX_VALUE = 100;
	public static final int MIN_VLAUE = 0;
	
	// 추상 메소드
	public abstract void run();
	
	// 디폴트 메소드 -> 실행 내용까지 작성이 가능하다. 
	public default void setState(boolean state) {
		if(state) {
			System.out.println("정상 상태");
		} else {
			System.out.println("비정상 상태");
		}
	}
	
	// 정적 메소드
	public static void change() {
		System.out.println("상태를 변경합니다.");
	}
}
