import java.util.Arrays;

class MethodTest {
	public static void main(String[] args) {
		System.out.println("�ִ밪 = " + Math.max(25,36));
		
		int small = Math.min(25,36);
		System.out.println("�ּҰ� = " + small);
		
		int a = Integer.parseInt("25");
		double b = Double.parseDouble("43.8");
		System.out.println(a + " + " + b + " = " + (a+b));
		
		int[] ar = {25,48,56,32,30};
		System.out.println("�迭�� ar = " + ar);	//Ŭ������@16���� (�����ּ�)
		Arrays.sort(ar);
		for(int i:ar) {
			System.out.print(i + " ");
		}
	}
}
