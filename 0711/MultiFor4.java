/*
3�� for if(������2����) �̿�
2�� 3�� 4��
5�� 6�� 7��
8�� 9��

1-9���� ���ϴ� for �� 3����� for�� 1-9����� for
*/

class MultiFor4 {
	public static void main(String[] args) {
		int i, j, k;
		for (k = 2; k < 9; k += 3) {
			for (j = 1; j < 10; j++) {
				for (i = k; i < k + 3; i++) {
					if (i == 10) break;
					System.out.print(i +" * " + j + " = " + (i*j) +"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
