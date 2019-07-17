import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class RGBTest extends Frame implements ActionListener, WindowListener {
	private Button redB, greenB, blueB;
	
	public void init() {
		redB = new Button("»¡°­");
		greenB = new Button("ÃÊ·Ï");
		blueB = new Button("ÆÄ¶û");
		
		Panel p = new Panel();
		p.add(redB);
		p.add(greenB);
        p.add(blueB);
        
		this.add("North", p);

		setBounds(100,80,300,300);
		setVisible(true);
		
		// ÀÌº¥Æ®
		this.addWindowListener(this);

		redB.addActionListener(this);
		greenB.addActionListener(this);
		blueB.addActionListener(this);

	} //init()

	//ActionListener Override
	public void actionPerformed(ActionEvent e){	
		if(e.getSource() == redB) 
			this.setBackground(Color.RED);
		else if(e.getSource() == greenB)
			this.setBackground(Color.GREEN);
		else if(e.getSource() == blueB) 
			this.setBackground(Color.BLUE);
	}
	
	//WindowListener Override
	public void windowActivated(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		System.exit(0);	
	} //Ã¢´Ý±â
	public void windowClosed(WindowEvent e) { }	// Ã¢´ÝÀºµÚ Ã³¸®
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }
	

	public static void main(String[] args) {
		new RGBTest().init();
	}
}
