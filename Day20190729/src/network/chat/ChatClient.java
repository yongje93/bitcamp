package network.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	private JTextField input;
	private JTextArea output;
	private JButton send;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	public ChatClient() {
		input = new JTextField(15);

		output = new JTextArea();
		output.setEditable(false); // JTextArea 읽기전용으로 만들기.
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 세로 스크롤 항상 고정.

		send = new JButton("보내기");

		JPanel p = new JPanel(new BorderLayout());
		p.add("Center", input);
		p.add("East", send);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		setBounds(200, 100, 300, 300);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 종료버튼 눌렀을 때 서버에 exit 보내기.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("exit");
				pw.flush();
			}
		});
	}

	public void service() {
		// 서버 IP
		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.49"); // "서버IP", JOptionPane.INFORMATION_MESSAGE);
		if (serverIP == null || serverIP.length() == 0) {
			System.out.println("서버IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		// 닉네임
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}

		// 소켓 생성
		try {
			socket = new Socket("192.168.0.49", 9500);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 서버 보내기
			pw.println(nickName);// println이니까 "\n"따로 안줘도됨
			pw.flush();// 버퍼비우기

		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		// 이벤트
		send.addActionListener(this); // 보내기 버튼
		input.addActionListener(this); // textfield에서 엔터 버튼
		// 쓰레드
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// send, input 하는 역할이 똑같음.
		// JTextField의 내용을 얻어서 서버에 보내기
		String line = input.getText();
		pw.println(line);
		pw.flush();
		input.setText("");
	}

	@Override
	public void run() {
		// 받는쪽
		String line = null;
		try {
			while (true) {
				// 서버로 오는 내용을 받아서 JTextArea에 뿌리기
				line = br.readLine();
				if (line == null || line.toLowerCase().equals("exit")) {
					br.close();
					pw.close();
					socket.close();

					System.exit(0);
				}
				output.append(line + "\n"); // bufferedreader는 개행이 필요함.
				
				int pos = output.getText().length();
				output.setCaretPosition(pos);
			} // while
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatClient().service();
	}

}
