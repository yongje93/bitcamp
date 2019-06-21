package kr.co.bit.obj2;

public class Array_Test4 {
	
	public static void main(String[] args) {
		String cities[] = {"서울", "대구", "춘천", "울산", "광주" };
		String nations[] = new String[] {"대한민국", "미국", "영국", "일본", "프랑스" };
		
		for(int i = 0; i<cities.length; i++) {
			System.out.println("cities [" + i + "] =" +cities[i]);
		}
		for(int i = 0; i<nations.length; i++) {
			System.out.println("nations [" + i + "] =" +nations[i]);
		}
	}
	
}
