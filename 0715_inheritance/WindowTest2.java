import java.awt.Frame;
import java.awt.Graphics;

class WindowTest2 extends Frame {
	public void init() {
		setBounds(1200, 200, 500, 500);
		setVisible(true);
	}
	public void paint(Graphics g) {
		g.drawString("¿ÃπÃ¡ˆ", 100, 80);	
	}
	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
