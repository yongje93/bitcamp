package kr.co.bit;

public class ExceptionTest7 {
	public static void main(String[] args) {
		try {
			if (args.length != 2) {
				ArgsException ae = new ArgsException("���ڸ� �ΰ� �Է��ؾ� �մϴ�.");
				ae.setArgsNumber(args.length);
				throw ae;
			} else {
				int num1 = Integer.parseInt(args[0]);
				int num2 = Integer.parseInt(args[1]);
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ArgsException e) {
			System.out.println(e.getMessage());
			System.out.println("����� �Է��� ���� ���� " + e.getArgsNumber() + "�� �Դϴ�.");
		}
	}
}
