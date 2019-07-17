import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class LoginResult extends Frame implements WindowListener {
	public String id, pwd;
	public LoginResult(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

		setBounds(500,80,200,200);
		setVisible(true);
		
		this.addWindowListener(this);
	}
	//WindowListener Override - Event Handler
	public void windowActivated(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		setVisible(false);
	}
	public void windowClosed(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }
	
	public void paint(Graphics g) {
		if(id.equals("angel") && pwd.equals("1004")) {
			g.drawString("로그인 성공", 50, 50);
		} else {
			g.drawString("로그인 실패", 50, 50);
		}
	}
}
