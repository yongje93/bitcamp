import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class WindowTest2 extends Frame {
	public void init() {
		setBounds(1200, 200, 500, 500);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawString("이미지", 100, 100);	
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("C:/java_se/0716_abstract/tube.jpg");
		//이미지 불러오기
		//g.drawImage(img, 80, 150, this);
		//이미지 그리기
		g.drawImage(img,
			50,50,250,250,	//화면위치 
			250,250,0,0,	//이미지위치
			this);
	}

	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
