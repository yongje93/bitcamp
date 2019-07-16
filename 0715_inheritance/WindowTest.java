import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;

class WindowTest extends Frame {
	public WindowTest() {
		//new Frame("내가만든윈도우").setVisible(true);	// 창 새로 하나더 만들기.
		super("내가만든윈도우"); //setTitle("내가만든윈도우"); super는 항상 첫째줄
				
		setForeground(new Color(220, 220, 0));
		setBackground(new Color(205, 171, 214));
		//setBackground(Color.MAGENTA);	//바탕색
		//this.setSize(300, 400); // 가로, 세로
		setBounds(1000, 200, 300, 400);
		setVisible(true);
	}

	public void paint(Graphics g) {	//구현	
		g.drawString("도형만들기", 100, 100);	
		g.drawLine(100, 150, 250, 200);	//선
		g.drawRect(100, 200, 80, 50);	//사각형 drawRect(x, y, 너비, 길이)
		g.drawOval(125, 225, 100, 50);	//원 
	}

	public static void main(String[] args) {
		WindowTest windowTest = new WindowTest();
	}
}

//POJO (Plain Old Java Object)
//어떤 일정한 시점이 되면 JVM(운영체제)이 호출 - Call Back 메소드. ex) main() // Run()  