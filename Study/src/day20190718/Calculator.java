package day20190718;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Calculator implements ActionListener {
	private Frame frame;
	private Button[] btn;
	private Label upL, downL;

	public void init() {
		frame = new Frame();
		frame.setTitle("계산기");

		btn = new Button[18];
		// String[] numStr = { "BackSpace", "C", "7", "8", "9", "/", "4", "5", "6", "*",
		// "1", "2", "3", "-", ".", "0", "=", "+" };
		String[] numStr = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", ".", "=", "C",
				"BackSpace" };
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(numStr[i]);
		}

		upL = new Label();
		upL.setAlignment(Label.RIGHT);
		upL.setBackground(new Color(168, 168, 255));
		upL.setPreferredSize(new Dimension(270, 40));

		downL = new Label();
		downL.setAlignment(Label.RIGHT);	
		downL.setBackground(new Color(168, 168, 255));
		downL.setPreferredSize(new Dimension(270, 40));
		downL.setText("0");
		
		Panel[] panel = new Panel[8];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new Panel();
		}

		panel[0].setLayout(new GridLayout(7, 1, 0, 0));
		panel[3].setLayout(new GridLayout(1, 2, 5, 0));
		panel[4].setLayout(new GridLayout(1, 4, 5, 0));
		panel[5].setLayout(new GridLayout(1, 4, 5, 0));
		panel[6].setLayout(new GridLayout(1, 4, 5, 0));
		panel[7].setLayout(new GridLayout(1, 4, 5, 0));

		panel[1].add(upL);
		panel[2].add(downL);
		panel[3].add(btn[17]); // 17번 backspace
		panel[3].add(btn[16]); // 16번 C

		panel[4].add(btn[7]);
		panel[4].add(btn[8]);
		panel[4].add(btn[9]);
		panel[4].add(btn[13]); // 13번 나누기

		panel[5].add(btn[4]);
		panel[5].add(btn[5]);
		panel[5].add(btn[6]);
		panel[5].add(btn[12]); // 12번 곱하기

		panel[6].add(btn[1]);
		panel[6].add(btn[2]);
		panel[6].add(btn[3]);
		panel[6].add(btn[11]); // 11번 빼기

		panel[7].add(btn[14]); // 14번 .
		panel[7].add(btn[0]);
		panel[7].add(btn[15]); // 15번 =
		panel[7].add(btn[10]); // 10번 +

//		for (int i = 2; i <= 5; i++) {
//			panel[4].add(btn[i]);
//		}
//		for (int i = 6; i <= 9; i++) {
//			panel[5].add(btn[i]);
//		}
//		for (int i = 10; i <= 13; i++) {
//			panel[6].add(btn[i]);
//		}
//		for (int i = 14; i <= 17; i++) {
//			panel[7].add(btn[i]);
//		}

		for (int i = 1; i <= 7; i++) {
			panel[0].add(panel[i]);
		}

		frame.add(panel[0]);
		frame.setBounds(1000, 500, 300, 400);
		frame.setVisible(true); // 프레임 보이게.
		frame.setResizable(false); // 크기 변경 못하게.

		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);
		}

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	// 10번 + 11번 - 12번 * 13번 / 14번 . 15번 = 16번 C 17번 backspace
	@Override
	public void actionPerformed(ActionEvent e) {
		String temp;
		for (int i = 0; i < btn.length; i++) {
			if (e.getSource() == btn[i]) {
				if(i < 10) { //0 부터 9까지
					temp = downL.getText();
					if(temp.equals("0")) {
						downL.setText(""+i);
					} else downL.setText(temp + i);
				} else {
					switch(i) {
						case 10: //더하기
							temp = downL.getText();
							downL.setText(temp + "+"); 
							break;
						case 11: //빼기
							temp = downL.getText();
							downL.setText(temp + "-"); 
							break;
						case 12: //곱하기
							temp = downL.getText();
							downL.setText(temp + "*");
							break;
						case 13: //나누기
							temp = downL.getText();
							downL.setText(temp + "/");
							break;
						case 14: //소수점
							temp = downL.getText();
							downL.setText(temp + "."); 
							break;
						case 15: // =
							
							break;
						case 16: // 초기화
							downL.setText("0");
							break;
						case 17: // backspace
							temp = downL.getText();
							if(temp.length() != 0) {
								downL.setText(temp.substring(0,temp.length()-1));
							}
							break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Calculator().init();
	}

}
