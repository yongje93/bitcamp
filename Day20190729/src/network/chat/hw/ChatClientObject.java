package network.chat.hw;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextField input;
	private JTextArea output;
	private JButton send;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ChatClientObject(){
		input = new JTextField(15);

		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);
		
		send = new JButton("보내기");

		JPanel p = new JPanel(new BorderLayout());
		p.add("Center",input);
		p.add("East",send);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);
		
		setBounds(100, 80, 300, 300);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void	windowClosing(WindowEvent e){
				if(oos==null || ois==null) System.exit(0);

				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT);

				try{
					oos.writeObject(dto);
					oos.flush();
				}catch(IOException io){
					io.printStackTrace();
				}
			}
		});
	}
	
	public void service(){
		//서버IP
		//String serverIP = JOptionPane.showInputDialog(this,"서버IP를 입력하세요","서버IP",JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this,"서버IP를 입력하세요","192.168.0.10");
		if(serverIP==null || serverIP.length()==0){
			System.out.println("서버IP가 입력되지 않았습니다");
			System.exit(0);
		}

		//닉네임
		String nickName = JOptionPane.showInputDialog(this,"닉네임을 입력하세요","닉네임",JOptionPane.INFORMATION_MESSAGE);
		if(nickName==null || nickName.length()==0){
			nickName="guest";
		}
		
		//소켓 생성
		try{
			socket = new Socket(serverIP, 9500);

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			//서버로 nickName 보내기
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			oos.writeObject(dto);
			oos.flush();

		}catch(UnknownHostException e){
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}

		//이벤트
		send.addActionListener(this);
		input.addActionListener(this);

		//스레드 생성
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		//서버로 보내기
		String line = input.getText();
		
		InfoDTO dto = new InfoDTO();
		if(line.toLowerCase().equals("exit")){
			dto.setCommand(Info.EXIT);
		}else{
			dto.setCommand(Info.SEND);
			dto.setMessage(line);
		}
		try{
			oos.writeObject(dto);
			oos.flush();
		}catch(IOException io){
			io.printStackTrace();
		}

		input.setText("");
	}

	@Override
	public void run(){
		//받는쪽
		InfoDTO dto = null;

		while(true){
			try{
				dto = (InfoDTO)ois.readObject();
				if(dto.getCommand()==Info.EXIT){
					ois.close();
					oos.close();
					socket.close();

					System.exit(0);

				}else if(dto.getCommand()==Info.SEND){
					output.append(dto.getMessage() +"\n");

					int pos = output.getText().length();
					output.setCaretPosition(pos);
				}
			}catch(IOException io){
				io.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}//while
	}

	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}

