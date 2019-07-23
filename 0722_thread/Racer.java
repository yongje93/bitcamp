import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Racer extends Canvas implements Runnable {// component - main문 없음
	private int pos;
	private static int rank;
	private String name;

	public Racer(String name) { // 수정.
		// setBackground(new Color((int)(Math.random()*256),200,200));
		this.name = name;
	}

	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\java_se\\0722_thread\\horse.gif");
		g.drawImage(img, pos, 0, 120, this.getSize().height, this);
	}

	@Override
	public void run() {
		Thread.currentThread().setName(name);
		for (int i = 0; i < 600; i += ((int) (Math.random() * 10) + 1)) {
			pos = i;
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 등수	
		System.out.print(++rank + "등 " +Thread.currentThread().getName()+"\n");
	}
}
