import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class NumberTest {
	public NumberTest() {
		NumberFormat nf = new DecimalFormat();	//NumberFormat�� �߻�Ŭ������. DecimalFormat�� sub class
		//3�ڸ�����, �Ҽ����� 3°�ڸ�
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.#��"); //sub class	
		//3�ڸ�����, �Ҽ����� 1°�ڸ�. ��ȿ���ڰ� �ƴѰ��� ǥ������ �ʴ´�.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		NumberFormat nf3 = new DecimalFormat("#,###.0��"); //sub class	
		//3�ڸ�����, �Ҽ����� 1°�ڸ�. 0�� ������ ǥ��
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//NumberFormat nf4 = NumberFormat.getInstance(); // �޼ҵ带 �̿��� ����
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		// �⺻ 3�ڸ�����, �Ҽ����� 3°�ڸ�
		nf4.setMaximumFractionDigits(1);	// �ִ� 1�ڸ������� ������ �ϱ�.
		nf4.setMinimumFractionDigits(1);	// �ּ� 1�ڸ������� ������ �ϱ�.
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		// �⺻ 3�ڸ�����, �Ҽ����� 3°�ڸ�
		nf5.setMaximumFractionDigits(1);	// �ִ� 1�ڸ������� ������ �ϱ�.
		nf5.setMinimumFractionDigits(1);	// �ּ� 1�ڸ������� ������ �ϱ�.
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();

	}
	
	public static void main(String[] args) {
		new NumberTest();	//�ܹ߼� gc�� ����.

	}
}
