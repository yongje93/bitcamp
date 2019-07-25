import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class JListEx extends JFrame {
	public JListEx() {
		super("JList Test");
		setLayout(new FlowLayout());
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);

		//JList list2 = new JList(new DefaultListModel());
		//DefaultListModel model = (DefaultListModle)list2.getModel();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list2 = new JList<String>(model);
		model.addElement("���"); model.addElement("��");
		model.addElement("����"); model.addElement("�ٳ���");
		list2.setSelectedIndex(1);

		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("�౸"); vListData.add("�߱�");
		vListData.add("��"); vListData.add("�豸"); 
		vListData.add("�״Ͻ�"); vListData.add("����");
		vListData.add("����"); vListData.add("�±ǵ�");
		vListData.add("����");

		class Student{
			String id;
			String name;
			String department;
			public Student(String id, String name, String department) {
				this.id = id;
				this.name = name;
				this.department = department;
			}

			public String toString() {
				return name;
			}
		}

		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		model2.addElement(new Student("100", "ȫ�浿", "�����"));
		model2.addElement(new Student("200", "�տ���", "�����"));
		model2.addElement(new Student("300", "�����", "����"));
		model2.addElement(new Student("400", "���Ȱ�", "�濵��"));
		list4.setSelectedIndex(1);

		add(list1); add(list2);
		add(scroll); add(list4);
		setBounds(300, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JListEx();
	}
}
