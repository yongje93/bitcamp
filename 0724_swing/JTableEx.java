import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel { 
	Object[][] data = {{"Nari", "����ġ", new Integer(1234), "����ģ��"}, 
						{"One", "������", new Integer(1111), "������"}, 
						{"two", "������", new Integer(2222), "�Ϳ�����"}, 
						{"three", "�ƶ�ġ", new Integer(3333), "���Ƹ�ģ��"}};
	
	String[] name = {"���̵�","�̸�","��й�ȣ","����"};
	
	public int getColumnCount() {	// ���̺��� ���� ��
		return name.length;
	}
	
	public int getRowCount(){	// ���̺��� ���Ǽ�
		return data.length;
	}

	public Object getValueAt(int r, int c) {	// ���� ������ ����
		return data[r][c];
	}

	public boolean isCellEditable(int r, int c) {	// ���� �����ϰ� �Ѵ�.
		return (c!=0) ? true: false;
	}

	public String getColumnName(int c) {	// ���̺��� Ÿ��Ʋ�� �ο�
		return name[c];
	}

	public void setValueAt(Object obj, int r, int c) {	//�ʵ尪 ����
		data[r][c] = obj;
	}
		
}

public class JTableEx extends JFrame {
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20,200,300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTableEx();
	}
}
