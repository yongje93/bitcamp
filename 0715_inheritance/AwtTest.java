import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Font;
import java.awt.TextArea;

//Frame�� BorderLayout(��������)
class AwtTest extends Frame {
	private Button newB, exitB;
	private TextArea area;

	public void init() {
		newB = new Button("���� �����");
		exitB = new Button("����");
		area = new TextArea();
		area.setForeground(new Color(255,0,255));
		//area.setFont(new Font("���ü", Font.BOLD, 20));	//�۲�, ��Ÿ��, ũ��
		area.setFont(new Font("���ü", 1, 20));	//�۲�, ��Ÿ��, ũ��

		add("North", newB);
		add("South", exitB);
		add("Center", area);

		setBounds(1100, 600, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AwtTest().init();
	}
}
