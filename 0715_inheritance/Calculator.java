//private Button[] btn; //18��
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
		setTitle("����");
		
		btn = new Button[18];
		

		setBounds(1000, 500, 300, 400);
		setVisible(true);		// ������ ���̰�.
		setResizable(false);	// ũ�� ���� ���ϰ�.
	}

	public static void main(String[] args) {
		new Calculator().init();
	}
}
