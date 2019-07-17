package day20190716;

// 판넬 8개로 수정
import java.awt.Button;
import java.awt.Color;
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

		upL = new Label();
		upL.setBackground(new Color(255, 255, 0));
		
		downL = new Label();
		downL.setBackground(new Color(111, 111, 0));
		
		Panel[] p = new Panel[8];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel();
		}

		p[0].setLayout(new GridLayout(7, 1, 0, 0));

		p[1].add(upL);
		p[2].add(downL);
		
		
		btn[0] = new Button("BackSpace");
		btn[1] = new Button("C");
		
		p[3].add(btn[0]);
		p[3].add(btn[1]);
		
		p[0].add(p[1]);
		p[0].add(p[2]);
		p[0].add(p[3]);
		
		add(p[0]);

		setBounds(1000, 500, 300, 400);
		setVisible(true); // 프레임 보이게.
		setResizable(false); // 크기 변경 못하게.
	}

	public static void main(String[] args) {
		new Calculator().init();
	}
}
