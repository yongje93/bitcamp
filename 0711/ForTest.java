/*
	����(��ǻ�Ͱ� �ұ�Ģ�ϰ� �߻��ϴ� ��)
	0 <= ���� <1
	Math.random()
	new Random()
*/

class ForTest {
	public static void main(String[] args) {
		int[] intArr = new int[6];
		for(int i = 0; i < 6; i++) {
			int x = (int)(Math.random()*45) + 1;
			intArr[i] = x;
		}

		for(int i = 0; i <intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
		
		System.out.println();
		
		int a = 0;
		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			//a = (int)(Math.random()*100) + 1;	// 1~100
			a = (int)(Math.random()*26) + 65;	// 65~90	//���� ��� �κ��� 0~25 ������ ����.
			if(a == 'A') cnt++;
			System.out.print((char)a +" ");		// ���ĺ����� ����ȯ
			if(i%10 == 0) System.out.println();		
		}
		System.out.println("\n'A'�� ���� = " + cnt);
	}
}
