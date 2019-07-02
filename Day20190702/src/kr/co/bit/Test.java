package kr.co.bit;

public class Test {

	public static void main(String[] args) {
		String originalString = new String("Java");
		String lastString = originalString.concat("Fighting");
		System.out.println(originalString);
		System.out.println(lastString);
		System.out.println("originalString == last String : "+ (originalString == lastString));
	}
	
}
