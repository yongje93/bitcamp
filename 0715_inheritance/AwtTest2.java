import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

class AwtTest2 extends Frame {
	private Button newB, exitB;

	public void init() {
		newB = new Button("새로 만들기");
		exitB = new Button("종료");
		
		Panel p = new Panel();	// 잠깐 쓰니까 필드로 올리지마라. FlowLayout(순서배치 - 중앙)
		p.setLayout(new GridLayout(1,2,5,0)); //(줄, 칸, 가로여백, 새로여백)
		p.setBackground(new Color(255,255,0));
		p.add(newB);
		p.add(exitB);

		add("North", p);
		
		setBounds(1100, 600, 300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtTest2().init();
	}
}
