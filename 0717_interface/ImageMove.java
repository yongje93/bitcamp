import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ImageMove extends Frame implements ActionListener, WindowListener {
	private Button newB, leftB, upB, downB, rightB;
	private int x=100, y=100;
	
	public ImageMove() {
		newB = new Button("초기화");
		leftB = new Button(" ← ");
		upB = new Button(" ↑ ");
		downB = new Button(" ↓ ");
		rightB = new Button(" → ");
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(1,5,3,0));//행,열,가로여백,세로여백
		p.add(newB);
		p.add(leftB);
		p.add(upB);
		p.add(downB);
		p.add(rightB);

		add("North",p);

		setTitle("이미지 이동");
		setBounds(100,80,500,500);
		setVisible(true);
		
		//이벤트
		this.addWindowListener(this);
		newB.addActionListener(this);
		leftB.addActionListener(this);
		upB.addActionListener(this);
		downB.addActionListener(this);
		rightB.addActionListener(this);
	}	
	
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("tube.jpg");
		g.drawImage(img, x, y, 150, 150, this);
	}

	//ActionListener Override
	public void actionPerformed(ActionEvent e){	
		//if(e.getSource()==newB){
		if(e.getActionCommand()=="초기화") x=y=100;
		else if(e.getSource()==leftB){ 
			x -= 10;
			if(x < -120) x=450;
		}else if(e.getSource()==upB){
			y -= 10;
			if(y < -70) y=450;
		}else if(e.getSource()==downB){
			y += 10;
			if(y>450) y=-70;
		}else if(e.getSource()==rightB){
			x += 10;
			if(x>460) x=-120;
		}
		System.out.println("x:"+x+"   y:"+y);

		repaint();
	}
	
	//WindowListener Override - Event Handler
	public void windowActivated(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		System.exit(0);	// 프로그램 강제종료
	}
	public void windowClosed(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }
	
	public static void main(String[] args) {
		new ImageMove();
	}
}
