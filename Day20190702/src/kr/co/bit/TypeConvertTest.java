package kr.co.bit;

public class TypeConvertTest {

	public static void main(String[] args) {
		int num1 = 3;
		String num2 = "4";
		System.out.println("Ÿ�Ժ����� 3+4 = " +(num1+num2));
		int intNum = Integer.parseInt(num2);
		System.out.println("Ÿ�Ժ����� 3+4 = " +(num1+intNum));
		String numStr = "3.11";
		System.out.println("Ÿ�Ժ����� 3+3.11 = " +(num1+numStr));
		double numDouble = Double.parseDouble(numStr);
		System.out.println("Ÿ�Ժ����� 3+3.11 = " + (num1 + numDouble));

	}

}
