import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

class WindowTest extends Frame implements MouseListener, MouseMotionListener, ActionListener {
	private Button exitB;
	private int x, y;

	public WindowTest(){
		exitB = new Button("������");

		add("North", exitB);

		setBounds(100,80,500,500);
		setVisible(true);

		//�̺�Ʈ
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());
		exitB.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}

	public void mouseClicked(MouseEvent e){
		System.out.println("���콺 Ŭ��");
		x = e.getX();
		y = e.getY();
		System.out.println("X"+ x+"   Y:"+ y);
		repaint(); //paint() �ٽ� ȣ��.
	}
	public void mouseEntered(MouseEvent e){
		System.out.println("���콺 IN");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("���콺 OUT");
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	public void mouseDragged(MouseEvent e){
		System.out.println("���콺 �巡��");
	}
	public void mouseMoved(MouseEvent e){}

	public void paint(Graphics g) {	//setVisible() �� �ѹ��� �����.
		g.drawString(("X:"+ x +"   Y:"+ y), x, y);
	}


	public static void main(String[] args) {
		new WindowTest();
	}
}
