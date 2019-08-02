package friend.action;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener {
	private JLabel mainL, nameL, telL, sexL, hobbyL, listL, areaL, hyphenL1, hyphenL2;
	private JTextField nameT, tel2T, tel3T;
	private JComboBox<String> tel1C;
	private JRadioButton manR, womanR;
	private JCheckBox readCB, movieCB, musicCB, gameCB, shoppingCB;
	private JButton addB, updateB, deleteB, clearB;
	private JList<FriendDTO> list;
	private DefaultListModel<FriendDTO> model;
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

		String[] tel = { "010", "011", "019" };
		tel1C = new JComboBox<String>(tel);

		ButtonGroup group = new ButtonGroup();
		manR = new JRadioButton("남성", true);
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
		
		addB.setEnabled(true);
		updateB.setEnabled(false);
		deleteB.setEnabled(false);
		clearB.setEnabled(false);
		
		list = new JList<FriendDTO>(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>) list.getModel();
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(300, 200));
		area = new JTextArea(10, 55);

		JPanel mainP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainP.add(mainL);

		JPanel listP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		listP.add(listL);

		JPanel topP = new JPanel(new GridLayout(1, 2, 0, 0));
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
		JPanel buttonP2 = new JPanel(new GridLayout(1, 4, 5, 5));
		buttonP2.add(addB);
		buttonP2.add(updateB);
		buttonP2.add(deleteB);
		buttonP2.add(clearB);
		buttonP.add(buttonP2);

		JPanel leftP = new JPanel(new GridLayout(5, 1, 0, 0));
		leftP.add(nameP);
		leftP.add(telP);
		leftP.add(sexP);
		leftP.add(hobbyP);
		leftP.add(buttonP);

		JPanel scrollP = new JPanel();
		scrollP.add(scroll);

		JPanel rightP = new JPanel(new BorderLayout());
		rightP.add("Center", scrollP);

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
		
		//DB에서 모든 레코드를 꺼내서 JList에 뿌리기
		FriendDAO dao = FriendDAO.getInstance();
		ArrayList<FriendDTO> arrayList = dao.getFriendList();
		
		for (FriendDTO dto : arrayList) {
			model.addElement(dto);
		}
		
	}

	public void event() {
		addB.addActionListener(this);
		updateB.addActionListener(this);
		deleteB.addActionListener(this);
		clearB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addB) {
			// 데이터
			String name = nameT.getText();
			String tel1 = (String) tel1C.getSelectedItem();
			String tel2 = tel2T.getText();
			String tel3 = tel3T.getText();

			int gender = 0;
			if (manR.isSelected())
				gender = 0;
			else if (womanR.isSelected())
				gender = 1;

			int read = readCB.isSelected() ? 1 : 0;
			int movie = movieCB.isSelected() ? 1 : 0;
			int music = musicCB.isSelected() ? 1 : 0;
			int game = gameCB.isSelected() ? 1 : 0;
			int shopping = shoppingCB.isSelected() ? 1 : 0;

			FriendDTO dto = new FriendDTO();
			dto.setName(name);
			dto.setTel1(tel1);
			dto.setTel2(tel2);
			dto.setTel3(tel3);
			dto.setGender(gender);
			dto.setRead(read);
			dto.setMovie(movie);
			dto.setMusic(music);
			dto.setGame(game);
			dto.setShopping(shopping);

			// DB
			FriendDAO dao = FriendDAO.getInstance(); // 싱글톤
			
			int seq = dao.getseq();
			
			dto.setSeq(seq);
			int su = dao.insertFriend(dto);

			clear();
			// 응답
			if(su==1)
				area.setText("\n\t\t데이터 등록 완료");
			else
				area.setText("\n\t\t데이터 등록 실패");
			
			model.addElement(dto);	// JList에 뿌려줌
		} else if (e.getSource() == updateB) {
			
		} else if (e.getSource() == deleteB) {
			
		} else if (e.getSource() == clearB) {
			clear();
		}		

	}
	
	public void clear() {
		nameT.setText("");
		tel1C.setSelectedItem("010");
		tel2T.setText("");
		tel3T.setText("");
		manR.setSelected(true);
		readCB.setSelected(false);
		movieCB.setSelected(false);
		musicCB.setSelected(false);
		gameCB.setSelected(false);
		shoppingCB.setSelected(false);
	
		area.setText("");
		// 버튼 초기화
		addB.setEnabled(true);
		updateB.setEnabled(false);
		deleteB.setEnabled(false);
		clearB.setEnabled(false);
	}

	public static void main(String[] args) {
		new FriendManager().event();
	}

}// class
