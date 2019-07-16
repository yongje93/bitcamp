import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Font;
import java.awt.TextArea;

//Frame은 BorderLayout(동서남북)
class AwtTest extends Frame {
	private Button newB, exitB;
	private TextArea area;

	public void init() {
		newB = new Button("새로 만들기");
		exitB = new Button("종료");
		area = new TextArea();
		area.setForeground(new Color(255,0,255));
		//area.setFont(new Font("고딕체", Font.BOLD, 20));	//글꼴, 스타일, 크기
		area.setFont(new Font("고딕체", 1, 20));	//글꼴, 스타일, 크기

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
