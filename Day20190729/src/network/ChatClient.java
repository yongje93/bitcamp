package network;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
	private JTextField input;
	private JTextArea output;
	private JButton send;
	
	public ChatClient() {
		//JTextArea는 편집 불가
		//JTextArea는 세로 스크롤 항상떠있게.
		//Frame 늘리거나 줄이면 JTextField는 같이 늘어나고 줄어든다.
		input = new JTextField();
		
		output = new JTextArea();
		output.setEditable(false); // JTextArea 읽기전용으로 만들기.
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);	//세로 스크롤 항상 고정.
		
		send = new JButton("보내기");
		
		JPanel downP = new JPanel(new GridBagLayout());	// 레이아웃 생성자
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;	//x, t축 다 채움
		
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		downP.add(input, gbc);
		
		gbc.weightx = 0.1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		downP.add(send, gbc);
		
		//JPanel downP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//downP.add(input);
		//downP.add(send);
		
		getContentPane().add("Center", scroll);
		getContentPane().add("South", downP);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
}
