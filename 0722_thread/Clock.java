import java.awt.Frame;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat; 
import java.util.Date;


class Clock extends Frame implements Runnable {
	public Clock(String title) {
		setFont(new Font("���ü", Font.BOLD, 36));
		setTitle(title);
		
		setBounds(800, 200, 340, 120);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});

		//������ ���� - Runnalbe�� ���� Ŭ������ �����ؾ��Ѵ�.
		Thread t = new Thread(this);	// ���� ������� ����� �޶�. this ���
		//������ ����
		t.start();	// run()�޼ҵ�� �̵�
	}

	@Override
	public void run() {	//�������̵� �� �޼ҵ�� throws �� �ȵȴ�.
		while(true) {
			repaint(); // paint()�� �̵�
			try {
				Thread.sleep(1000);	// ����: 1/1000
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
		new Clock("�ð�");


	}
}
