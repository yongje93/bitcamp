import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class NumberTest {
	public NumberTest() {
		NumberFormat nf = new DecimalFormat();	//NumberFormat은 추상클래스다. DecimalFormat은 sub class
		//3자리마다, 소수이하 3째자리
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.#원"); //sub class	
		//3자리마다, 소수이하 1째자리. 유효숫자가 아닌것은 표시하지 않는다.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		NumberFormat nf3 = new DecimalFormat("#,###.0원"); //sub class	
		//3자리마다, 소수이하 1째자리. 0을 강제로 표시
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//NumberFormat nf4 = NumberFormat.getInstance(); // 메소드를 이용한 생성
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		// 기본 3자리마다, 소수이하 3째자리
		nf4.setMaximumFractionDigits(1);	// 최대 1자리까지만 나오게 하기.
		nf4.setMinimumFractionDigits(1);	// 최소 1자리까지만 나오게 하기.
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		// 기본 3자리마다, 소수이하 3째자리
		nf5.setMaximumFractionDigits(1);	// 최대 1자리까지만 나오게 하기.
		nf5.setMinimumFractionDigits(1);	// 최소 1자리까지만 나오게 하기.
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();

	}
	
	public static void main(String[] args) {
		new NumberTest();	//단발성 gc가 지움.

	}
}
