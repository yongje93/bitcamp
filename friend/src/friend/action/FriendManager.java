package friend.action;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import friend.bean.FriendDTO;

public class FriendManager extends JFrame {
	private JLabel mainL, nameL, telL, sexL, hobbyL, listL, areaL, hyphenL1, hyphenL2;
	private JTextField nameT, tel2T, tel3T;
	private JComboBox<String> tel1C;
	private JRadioButton manR, womanR;
	private JCheckBox readCB, movieCB, musicCB, gameCB, shoppingCB; 
	private JButton addB, updateB, deleteB, clearB;
	private JList<FriendDTO> list;
	private JTextArea area;
	
	public FriendManager() {
		mainL = new JLabel("개인정보입력");
		nameL = new JLabel("이       름 :");
		telL = new JLabel("전화번호 :");
		sexL = new JLabel("성       별 :");
		hobbyL = new JLabel("취       미 :");
		listL = new JLabel("전체목록");
		areaL = new JLabel("개인정보분석");
		hyphenL1 = new JLabel("-");
		hyphenL2 = new JLabel("-");
		
		nameT = new JTextField(10);
		tel2T = new JTextField(5);
		tel3T = new JTextField(5);
		
		String[] tel = {"010","011","019"};
		tel1C = new JComboBox<String>(tel);
		
		ButtonGroup group = new ButtonGroup();
		manR = new JRadioButton("남성");
		womanR = new JRadioButton("여성");
		group.add(manR);
		group.add(womanR);
		
		readCB = new JCheckBox("독서");
		movieCB = new JCheckBox("영화");
		musicCB = new JCheckBox("음악");
		gameCB = new JCheckBox("게임");
		shoppingCB = new JCheckBox("쇼핑");
		
		addB = new JButton("등록");
		updateB = new JButton("수정");
		deleteB = new JButton("삭제");
		clearB = new JButton("지우기");
		
		list = new JList<FriendDTO>();
		JScrollPane scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		area = new JTextArea(10,55);
		
		
		JPanel mainP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainP.add(mainL);
		
		JPanel listP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		listP.add(listL);
		
		JPanel topP = new JPanel(new GridLayout(1,2,0,0));
		topP.add(mainP);
		topP.add(listP);
		
		JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameP.add(nameL);
		nameP.add(nameT);
		
		JPanel telP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		telP.add(telL);
		telP.add(tel1C);
		telP.add(hyphenL1);
		telP.add(tel2T);
		telP.add(hyphenL2);
		telP.add(tel3T);
		
		JPanel sexP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sexP.add(sexL);
		sexP.add(manR);
		sexP.add(womanR);
		
		JPanel hobbyP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		hobbyP.add(hobbyL);
		hobbyP.add(readCB);
		hobbyP.add(movieCB);
		hobbyP.add(musicCB);
		hobbyP.add(gameCB);
		hobbyP.add(shoppingCB);
		
		JPanel buttonP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel buttonP2 = new JPanel(new GridLayout(1,4,5,5));
		buttonP2.add(addB);
		buttonP2.add(updateB);
		buttonP2.add(deleteB);
		buttonP2.add(clearB);
		buttonP.add(buttonP2);
		
		JPanel leftP = new JPanel(new GridLayout(5,1,0,0));
		//leftP.add(topP);
		leftP.add(nameP);
		leftP.add(telP);
		leftP.add(sexP);
		leftP.add(hobbyP);
		leftP.add(buttonP);

		JPanel scrollP = new JPanel();
		scrollP.add(scroll);
		
		JPanel rightP = new JPanel(new BorderLayout());
		rightP.add("Center",scrollP);
		
		JPanel centerP = new JPanel(new FlowLayout());
		centerP.add(leftP);
		centerP.add(rightP);
		
		JPanel bottomP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomP.add(areaL);
		
		JPanel southP = new JPanel(new BorderLayout());
		southP.add(bottomP, "North");
		southP.add(area, "Center");
		
		JPanel centerP2 = new JPanel(new FlowLayout());
		centerP2.add(centerP);
		centerP2.add(southP);
		
		Container con = this.getContentPane();
		con.add(topP, "North");
		con.add(centerP2, "Center");
		
		setBounds(200, 300, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	public static void main(String[] args) {
		FriendManager friendManager = new FriendManager();
		
	}
}
