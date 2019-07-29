import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ScoreForm extends JFrame implements ActionListener {
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JTextArea output;
	private JButton addB, dispB, searchB, tot_descB, saveB, loadB; // tot_desc �������� ��������
	private ScoreImpl impl;

	public ScoreForm() {
		hakL = new JLabel("�й�", JLabel.RIGHT);
		nameL = new JLabel("�̸�", JLabel.RIGHT);
		korL = new JLabel("����", JLabel.RIGHT);
		engL = new JLabel("����", JLabel.RIGHT);
		mathL = new JLabel("����", JLabel.RIGHT);

		hakT = new JTextField(15);
		nameT = new JTextField(15);
		korT = new JTextField(15);
		engT = new JTextField(15);
		mathT = new JTextField(15);

		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);

		impl = new ScoreImpl();

		Border border = BorderFactory.createLineBorder(Color.GRAY);
		output.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		output.setBorder(border);

		addB = new JButton("�Է�");
		dispB = new JButton("���");
		searchB = new JButton("�й��˻�");
		tot_descB = new JButton("����");
		saveB = new JButton("��������");
		loadB = new JButton("�����б�");

		addB.setBackground(Color.YELLOW);
		dispB.setBackground(Color.YELLOW);
		searchB.setBackground(Color.YELLOW);
		tot_descB.setBackground(Color.YELLOW);
		saveB.setBackground(Color.YELLOW);
		loadB.setBackground(Color.YELLOW);

		JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));

		JPanel left = new JPanel();

		JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_1.add(hakL);
		panel_1.add(hakT);
		JPanel panel_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_2.add(nameL);
		panel_2.add(nameT);
		JPanel panel_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_3.add(korL);
		panel_3.add(korT);
		JPanel panel_4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_4.add(engL);
		panel_4.add(engT);
		JPanel panel_5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_5.add(mathL);
		panel_5.add(mathT);

		left.add(panel_1);
		left.add(panel_2);
		left.add(panel_3);
		left.add(panel_4);
		left.add(panel_5);

		panel.add(left);
		panel.add(scroll);

		JPanel downP = new JPanel(new GridLayout(1, 6));
		downP.add(addB);
		downP.add(dispB);
		downP.add(searchB);
		downP.add(tot_descB);
		downP.add(saveB);
		downP.add(loadB);

		getContentPane().add("Center", panel);
		getContentPane().add("South", downP);

		setTitle("��������");
		setBounds(200, 100, 540, 240);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void event() {
		addB.addActionListener(this);
		dispB.addActionListener(this);
		searchB.addActionListener(this);
		tot_descB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addB) {// �Է�
			// ������ ������
			String hak = hakT.getText();
			String name = nameT.getText();
			int kor = Integer.parseInt(korT.getText());
			int eng = Integer.parseInt(engT.getText());
			int math = Integer.parseInt(mathT.getText());

			ScoreDTO dto = new ScoreDTO(hak, name, kor, eng, math);
			dto.calc();

			impl.input(dto);
			JOptionPane.showMessageDialog(this, "��ϿϷ�!!");

			hakT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");

		} else if (e.getSource() == dispB) {// ���
			impl.print(output);
		} else if (e.getSource() == searchB) {// �й��˻�
			impl.search(output);
		} else if (e.getSource() == tot_descB) {// �����˻�
			impl.tot_desc();
			impl.print(output);
		} else if (e.getSource() == saveB) {// ��������
			impl.save();
		} else if (e.getSource() == loadB) {// �����б�
			impl.load();
			impl.print(output);
		}

	}

}
