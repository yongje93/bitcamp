import java.awt.Frame;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat; 
import java.util.Date;


class Clock extends Frame implements Runnable {
	public Clock(String title) {
		setFont(new Font("고딕체", Font.BOLD, 36));
		setTitle(title);
		
		setBounds(800, 200, 340, 120);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});

		//스레드 생성 - Runnalbe를 가진 클래스를 생성해야한다.
		Thread t = new Thread(this);	// 나를 스레드로 만들어 달라. this 사용
		//스레드 시작
		t.start();	// run()메소드로 이동
	}

	@Override
	public void run() {	//오버라이드 된 메소드는 throws 가 안된다.
		while(true) {
			repaint(); // paint()로 이동
			try {
				Thread.sleep(1000);	// 단위: 1/1000
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

	public void paint(Graphics g) {	
		SimpleDateFormat sdf = new SimpleDateFormat("a hh : mm : ss");
		Date date = new Date();
		g.drawString(sdf.format(date),30,80);
	}

	public static void main(String[] args) {
		new Clock("시계");


	}
}
