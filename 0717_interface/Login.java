import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Login extends Frame implements ActionListener, WindowListener {
	private TextField idT, pwdT;
	private Button loginB, cancelB;

	public Login() {
		setLayout(null);

		Label idL= new Label("아이디");
		Label pwdL= new Label("비밀번호");

		idT = new TextField();
		pwdT = new TextField();
        
		loginB = new Button("로그인");
		cancelB = new Button("취소");
		
		idL.setBounds(50,80,60,30);	//x위치, y위치, 너비, 높이
		idT.setBounds(120,80,100,30);
		
		pwdL.setBounds(50,130,60,30);	//x위치, y위치, 너비, 높이
		pwdT.setBounds(120,130,100,30);
		
		loginB.setBounds(80,200,60,30);
		cancelB.setBounds(150,200,60,30);

		add(idL);
		add(idT);
		add(pwdL);
		add(pwdT);
		add(loginB);
		add(cancelB);
		
		setBounds(100,80,300,300);
		setVisible(true);

		// 이벤트
		this.addWindowListener(this);

		loginB.addActionListener(this);
		cancelB.addActionListener(this);
	}
	//ActionListener Override
	public void actionPerformed(ActionEvent e){	
		if(e.getSource()==loginB) {
			//id가 angel, pwd가 1004 로그인 성공
			String id = idT.getText();
			String pwd = pwdT.getText();
			System.out.println(id +" "+ pwd);
			new LoginResult(id, pwd);
		}
		else if(e.getSource()==cancelB) {
			idT.setText(" "); idT.setText("");
			pwdT.setText(" "); pwdT.setText("");
		}
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
		new Login();
	}
}
