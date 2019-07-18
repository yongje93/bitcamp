import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class WindowTest extends Frame {
	public WindowTest() {
		setBounds(100,80,300,400);
		setVisible(true);
		
		//�̺�Ʈ
		this.addWindowListener(new WindowAdapter() {	//�͸� inner class 
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("���콺 IN");
			}
			
			public void	mouseExited(MouseEvent e) {
				System.out.println("���콺 OUT");
			}

		});
	}
	
	public static void main(String[] args) {
		new WindowTest();
	}
}
