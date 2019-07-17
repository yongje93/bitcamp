//private Button[] btn; //18개
//private Label  upL, downL;
//
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.Panel;

class Calculator extends Frame {
	private Button[] btn;
	private Label upL, downL;

	public void init() {
		setTitle("계산기");
		
		btn = new Button[18];
		

		setBounds(1000, 500, 300, 400);
		setVisible(true);		// 프레임 보이게.
		setResizable(false);	// 크기 변경 못하게.
	}

	public static void main(String[] args) {
		new Calculator().init();
	}
}
