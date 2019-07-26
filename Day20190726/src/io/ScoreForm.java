package io;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ScoreForm extends JFrame {
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JTextArea output;
	private JButton addB, dispB, searchB, tot_descB, saveB, loadB; // tot_desc 총점으로 내림차순

	public ScoreForm() {
		hakL = new JLabel("학번  ", JLabel.RIGHT);
		nameL = new JLabel("이름  ", JLabel.RIGHT);
		korL = new JLabel("국어  ", JLabel.RIGHT);
		engL = new JLabel("영어  ", JLabel.RIGHT);
		mathL = new JLabel("수학  ", JLabel.RIGHT);

		hakT = new JTextField(11);
		nameT = new JTextField(11);
		korT = new JTextField(11);
		engT = new JTextField(11);
		mathT = new JTextField(11);
				
		output = new JTextArea(200, 200);
		
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		output.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		//output.setBorder(border);
		
		addB = new JButton("입력");
		dispB = new JButton("출력");
		searchB = new JButton("학번검색");
		tot_descB = new JButton("순위");
		saveB = new JButton("파일저장");
		loadB = new JButton("파일읽기");

		addB.setBackground(Color.YELLOW);
		dispB.setBackground(Color.YELLOW);
		searchB.setBackground(Color.YELLOW);
		tot_descB.setBackground(Color.YELLOW);
		saveB.setBackground(Color.YELLOW);
		loadB.setBackground(Color.YELLOW);
		
		JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));

		JPanel left = new JPanel();

		JPanel panel_1 = new JPanel(new GridLayout(1, 2));
		panel_1.add(hakL);
		panel_1.add(hakT);
		JPanel panel_2 = new JPanel(new GridLayout(1, 2));
		panel_2.add(nameL);
		panel_2.add(nameT);
		JPanel panel_3 = new JPanel(new GridLayout(1, 2));
		panel_3.add(korL);
		panel_3.add(korT);
		JPanel panel_4 = new JPanel(new GridLayout(1, 2));
		panel_4.add(engL);
		panel_4.add(engT);
		JPanel panel_5 = new JPanel(new GridLayout(1, 2));
		panel_5.add(mathL);
		panel_5.add(mathT);

		left.add(panel_1);
		left.add(panel_2);
		left.add(panel_3);
		left.add(panel_4);
		left.add(panel_5);

		panel.add(left);
		panel.add(output);

		JPanel downP = new JPanel(new GridLayout(1, 6));
		downP.add(addB);
		downP.add(dispB);
		downP.add(searchB);
		downP.add(tot_descB);
		downP.add(saveB);
		downP.add(loadB);

		getContentPane().add("Center", panel);

		getContentPane().add("South", downP);

		setTitle("성적관리");
		setBounds(200, 100, 550, 230);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
