import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

class AwtTest2 extends Frame {
	private Button newB, exitB;

	public void init() {
		newB = new Button("���� �����");
		exitB = new Button("����");
		
		Panel p = new Panel();	// ��� ���ϱ� �ʵ�� �ø�������. FlowLayout(������ġ - �߾�)
		p.setLayout(new GridLayout(1,2,5,0)); //(��, ĭ, ���ο���, ���ο���)
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
