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
		// ������
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "ȫ�浿", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "�ڳ�", "333", "010-777-7777"));
		list.add(new PersonDTO("test1", "�׽�Ʈ1", "333", "010-777-7777"));
		list.add(new PersonDTO("test2", "�׽�Ʈ2", "333", "010-777-7777"));
		list.add(new PersonDTO("test3", "�ڳ�", "333", "010-777-7777"));

		// Ÿ��Ʋ
		vector = new Vector<String>();
		vector.addElement("���̵�"); // addElement, add ���̰� ����.
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");

		model = new DefaultTableModel(vector, 0) { // ������ ������ �����.
			@Override
			public boolean isCellEditable(int r, int c) { // ���� �����ϰ� �Ѵ�.
				return (c != 0) ? true : false;
			}
		};

		// ���̺� - ������
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

		// ��ư
		insertB = new JButton("�߰�");
		deleteB = new JButton("����");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(insertB);
		p.add(deleteB);
		
		getContentPane().add("Center", scroll);
		getContentPane().add("South", p);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//�̺�Ʈ
		insertB.addActionListener(this);
		deleteB.addActionListener(this);
		
	}// ������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertB) insert();
		else if(e.getSource() == deleteB) delete();
	}
	
	public void insert() {
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���.");	//�Է� ���̾�α�
		//id �ߺ�üũ
		for(int i = 0; i < model.getRowCount(); i++) {
			if(id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�.");
				return;
			}
		}
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���.");
		String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���.");
		String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���.");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		
		JOptionPane.showMessageDialog(this, "��ϿϷ�");
	}
	
	public void delete() {
		String name = JOptionPane.showInputDialog(this, "������ �̸��� �Է��ϼ���.");	//�Է� ���̾�α�
		
		for(int i = 0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				i--;
			}
		}
	}
	
	public static void main(String[] args) {
		new JTableEx2();
	}
}
