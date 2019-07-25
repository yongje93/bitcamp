package day20190725;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx2 extends JFrame implements ActionListener {
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton insertB, deleteB;

	public JTableEx2() {
		// 데이터
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "코난", "333", "010-777-7777"));
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("angel", "천사", "333", "010-124-7777"));

		// 타이틀
		vector = new Vector<String>();
		vector.addElement("아이디"); // addElement, add 차이가 없음.
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");

		model = new DefaultTableModel(vector, 0) { // 빈행의 개수를 만든다.
			@Override
			public boolean isCellEditable(int r, int c) { // 편집 가능하게 한다.
				return (c != 0) ? true : false;
			}
		};

		// 테이블 - 데이터
		for (PersonDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getpwd());
			v.add(dto.getTel());

			model.addRow(v);
		}
		
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		// 버튼
		insertB = new JButton("추가");
		deleteB = new JButton("삭제");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(insertB);
		p.add(deleteB);
		
		getContentPane().add("Center", scroll);
		getContentPane().add("South", p);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//이벤트
		insertB.addActionListener(this);
		deleteB.addActionListener(this);
		
	}// 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertB) insert();
		else if(e.getSource() == deleteB) delete();
	}
	
	public void insert() {
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요.");	//입력 다이얼로그
		//id 중복체크
		for(int i = 0; i < model.getRowCount(); i++) {
			if(id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디입니다.");
				return;
			}
		}
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요.");
		String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력하세요.");
		String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요.");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		
		JOptionPane.showMessageDialog(this, "등록완료");
	}
	
	public void delete() {
		int sw = 0;
		String name = JOptionPane.showInputDialog(this, "삭제할 이름을 입력하세요.");	//입력 다이얼로그
		
		for(int i = 0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				i--;
				sw = 1;
			}
		}
		if(sw == 0) 
			JOptionPane.showMessageDialog(this, "삭제할 이름이 없습니다.");
		else
			JOptionPane.showMessageDialog(this, "삭제완료");
	}
	
	public static void main(String[] args) {
		new JTableEx2();
	}
}
