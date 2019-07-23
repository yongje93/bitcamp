import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Packman extends Frame implements KeyListener, Runnable {
	private int sel = 2;
	private int x = 225, y = 225;
	private int mx, my;
	private int[] foodX, foodY;

	public Packman() {
		foodX = new int[5];
		foodY = new int[5];

		for (int i = 0; i < foodX.length; i++) {
			foodX[i] = (int) (Math.random() * 461) + 20; // 20~480
			foodY[i] = (int) (Math.random() * 461) + 20; // 20~480
		}

		setBounds(100, 200, 500, 500);
		setVisible(true);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 이벤트
		this.addKeyListener(this);
		// 스레드 생성
		Thread t = new Thread(this);
		// 스레드 시작
		t.start();

	} // 생성자

	@Override
	public void run() {
		while (true) {
			if (sel % 2 == 0)
				sel++;
			else
				sel--;

			x = x + mx;
			y = y + my;

			if (x < 0) x = 500;
			else if (x > 500) x = 0;
			if (y < 0) y = 500;
			else if (y > 500) y = 0;

			repaint();
			try {
				Thread.sleep(100); // 단위: 1/1000
			} catch (InterruptedException e) {e.printStackTrace();}
			
			//먹기.
			for (int i = 0; i < foodX.length; i++) {
				if (x + 25 >= foodX[i] - 10 && y + 25 >= foodY[i] - 10 && 
					x + 25 <= foodX[i] + 30	&& y + 25 <= foodY[i] + 30) {
					foodX[i] = 0;
					foodY[i] = 0;
				}
			}						
		}
	}
	
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("C:/java_se/0722_thread/packman.jpg");
		Image foodImg = Toolkit.getDefaultToolkit().getImage("C:/java_se/0722_thread/food.jpg");
		for (int i = 0; i < foodX.length; i++) {
			g.drawImage(foodImg, foodX[i], foodY[i], foodX[i] + 20, foodY[i] + 20, 0, 0, 20, 20, this);
		}
		g.drawImage(img, x, y, x + 50, y + 50, // 화면위치
				sel * 50, 0, sel * 50 + 50, 50, // 메모리
				this);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ESCAPE)
			System.exit(0); // 27번
		else if (e.getKeyCode() == e.VK_LEFT) {
			sel = 0;
			mx = -10;
			my = 0;
		} else if (e.getKeyCode() == e.VK_RIGHT) {
			sel = 2;
			mx = 10;
			my = 0;
		} else if (e.getKeyCode() == e.VK_UP) {
			sel = 4;
			mx = 0;
			my = -10;
		} else if (e.getKeyCode() == e.VK_DOWN) {
			sel = 6;
			mx = 0;
			my = 10;
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new Packman();
	}
}
