package day20190718;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
		downL.setFont(new Font("", Font.BOLD, 20));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String getString = downL.getText();
		StringBuffer set = new StringBuffer(getString);
		
		for (int i = 0; i < btn.length; i++) {
			if (e.getSource() == btn[i]) {
				if (i < 10) { // 0 부터 9까지
					if (getString.equals("0")) {
						downL.setText("" + i);
					} else {
						downL.setText(set.append(i).toString());
					}
				} else {
					switch (i) {
					case 10: // 더하기
						if (getString.indexOf("+") < 0) {
							downL.setText(set.append("+").toString());
							upL.setText(set.toString());
						}
						break;
					case 11: // 빼기
						if (getString.indexOf("-") < 0) {
							downL.setText(set.append("-").toString());
							upL.setText(set.toString());
						}
						break;
					case 12: // 곱하기
						if (getString.indexOf("*") < 0) {
							downL.setText(set.append("*").toString());
							upL.setText(set.toString());
						}
						break;
					case 13: // 나누기
						if (getString.indexOf("/") < 0) {
							downL.setText(set.append("/").toString());
							upL.setText(set.toString());
						}
						break;
					case 14: // 소수점
						if (getString.indexOf(".") < 0) { // 소수점 연속으로 입력 안되게.
							downL.setText(set.append(".").toString());
						}
						break;
					case 15: // =

						break;
					case 16: // 초기화
						downL.setText("0");
						upL.setText("");
						break;
					case 17: // backspace
						if (getString.length() != 0) {
							downL.setText(set.deleteCharAt(getString.length() - 1).toString());
						}
						if (getString.length() == 1) {
							downL.setText("0");
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
