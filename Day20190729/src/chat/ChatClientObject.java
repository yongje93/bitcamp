package chat;

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

public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextField input;
	private JTextArea output;
	private JButton send;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ChatClientObject() {	// 생성자
		input = new JTextField();

		output = new JTextArea();
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		send = new JButton("보내기");

		JPanel p = new JPanel(new BorderLayout());
		p.add("Center", input);
		p.add("East", send);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		setBounds(200, 100, 300, 300);
		setVisible(true);
		// 종료버튼 눌렀을 때 서버에 exit 보내기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT);
				try {
					oos.writeObject(dto);
					oos.flush();
				} catch (IOException io) {io.printStackTrace();}
			}
		});
	}
	
	public void service() {
		// server IP
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요", "192.168.0.49");
		if (serverIP == null || serverIP.length() == 0) { // 서버 IP 입력안됨
			System.out.println("서버IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		// NickName
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) { // 닉네임 입력안됨
			nickName = "guest"; // 입력안했을때 기본값(guest)
		}
		try {
			// Socket 생성
			socket = new Socket(serverIP, 9500);	// IP주소, 포트번호
			// oos, ois 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);		
		}
		// Server에 NickName 보내주기
		InfoDTO dto = new InfoDTO();	// dto 객체 생성
		dto.setCommand(Info.JOIN);
		dto.setNickName(nickName);	
		try {
			oos.writeObject(dto); 	// 닉네임, 연결상태 서버로 전송
			oos.flush();
		} catch (IOException e) {e.printStackTrace();}	
	
		// Event
		send.addActionListener(this);
		input.addActionListener(this);
		// Thread
		Thread thread = new Thread(this); // 스레드 생성
		thread.start();	// 스레드 시작
	}

	@Override
	public void run() {
		try {
			while(true) {
				// 서버에게 받음
				InfoDTO dto = (InfoDTO) ois.readObject();
				if (dto.getMessage() == null || dto.getCommand() == Info.EXIT) { // 메세지가 없거나 상태가 종료일때
					ois.close();
					oos.close();
					socket.close();
					System.exit(0);
				} else {
					output.append(dto.getMessage() + "\n");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int position = output.getText().length();	// 스크롤 자동
		output.setCaretPosition(position);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField의 내용 서버에 보내기
		InfoDTO dto = new InfoDTO();
		String message = input.getText();	// 텍스트필드 내용 가지고오기
		dto.setCommand(Info.SEND);	// 전송 상태
		dto.setMessage(message);	// 메세지 보내기
		
		try {
			oos.writeObject(dto);	// 서버로 전송상태, 메시지 객체 보내기
			oos.flush();			// 버퍼 비워주기
		} catch (IOException io) {io.printStackTrace();}
		
		input.setText("");	// 서버에 보내주고 텍스트필드 비우기
	}
	
	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}
