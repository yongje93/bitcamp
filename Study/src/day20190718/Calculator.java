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
import java.text.DecimalFormat;

class Calculator implements ActionListener {
	private Frame frame;
	private Button[] btn;
	private Label upL, downL;
	private StringBuffer upBuf, downBuf;
	private double result;		// 중간결과 / 최종결과
	private int op;	//연산자 구분

	public void init() {
		frame = new Frame();
		frame.setTitle("계산기");

		btn = new Button[18];
		String[] numStr = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", ".", "=", "C", "BackSpace" };
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(numStr[i]);
		}

		upBuf = new StringBuffer(); // upL
		downBuf = new StringBuffer("0"); // downL

		upL = new Label("", Label.RIGHT);
		upL.setFont(new Font("고딕체", Font.BOLD, 14));
		upL.setBackground(new Color(168, 168, 255));
		upL.setPreferredSize(new Dimension(270, 40));

		downL = new Label("0", Label.RIGHT);
		downL.setFont(new Font("고딕체", Font.BOLD, 26));
		downL.setBackground(new Color(168, 168, 255));
		downL.setPreferredSize(new Dimension(270, 40));

		Panel[] panel = new Panel[8];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new Panel();
		}

		panel[0].setLayout(new GridLayout(7, 1, 5, 5));
		panel[3].setLayout(new GridLayout(1, 2, 5, 5));
		panel[4].setLayout(new GridLayout(1, 4, 5, 5));
		panel[5].setLayout(new GridLayout(1, 4, 5, 5));
		panel[6].setLayout(new GridLayout(1, 4, 5, 5));
		panel[7].setLayout(new GridLayout(1, 4, 5, 5));

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
		// 숫자버튼
		if (e.getActionCommand() == "1" || e.getActionCommand() == "2" || e.getActionCommand() == "3" || 
			e.getActionCommand() == "4" || e.getActionCommand() == "5" || e.getActionCommand() == "6" || 
			e.getActionCommand() == "7" || e.getActionCommand() == "8" || e.getActionCommand() == "9" || e.getActionCommand() == "0") {

			if ((downBuf + "").equals("0")) {// 0 혼자만 입력 되어있을때 더이상 출력 못하게 탈출.
				downBuf.delete(0, downBuf.length()); // 0부터 1이전 지우기.
			}
			downBuf.append(e.getActionCommand());
			downL.setText(downBuf + "");

		} else if (e.getActionCommand() == "BackSpace") {
			if (downBuf.length() == 1) { // 1개
				downBuf.delete(0, 1);
				downBuf.append("0");
			} else {
				downBuf.delete(downBuf.length() - 1, downBuf.length());
			}
			downL.setText(downBuf + "");
		} else if (e.getActionCommand() == "C") {
			result = 0;
			upBuf.delete(0, upBuf.length());
			downBuf.delete(0, downBuf.length());
			downBuf.append("0");
	
			upL.setText("");
			downL.setText("0");
		} else if (e.getActionCommand() == ".") {
			if (downBuf.indexOf(".") == -1) downBuf.append(".");
			downL.setText(downBuf+"");
			
// 1. op를 비교 -> op에 있는 값이 +,-,*,/ 어떤것인지 물어본다.
// 2. 입력된 값을 result에 넣는다.	/op에 따라 계산
// 3. 연산자를 op에 넣는다.
		} else if (e.getActionCommand() == "+") {
			calc();
			op = 1;
			upBuf.append(downBuf.append("+"));
			downBuf.delete(0, downBuf.length());
			downBuf.append("0");
			
			upL.setText(upBuf+"");
		} else if (e.getActionCommand() == "-") {
			calc();
			op = 2;
			upBuf.append(downBuf.append("-"));
			downBuf.delete(0, downBuf.length());
			downBuf.append("0");
			
			upL.setText(upBuf+"");
		} else if (e.getActionCommand() == "*") {
			calc();
			op = 3;
			upBuf.append(downBuf.append("*"));
			downBuf.delete(0, downBuf.length());
			downBuf.append("0");
			
			upL.setText(upBuf+"");
		} else if (e.getActionCommand() == "/") {
			calc();
			op = 4;
			upBuf.append(downBuf.append("/"));
			downBuf.delete(0, downBuf.length());
			downBuf.append("0");
			
			upL.setText(upBuf+"");
		} else if (e.getActionCommand() == "=") {
			calc();
			downL.setText(new DecimalFormat("#.###").format(result)+"");
			upBuf.delete(0, upBuf.length());
			downBuf.delete(0, downBuf.length());
			downBuf.append("0");
			upL.setText(upBuf+"");
		}
	}

	public void calc() {
		if(op == 0) {
			result = Double.parseDouble(downBuf+"");
			System.out.println(result);
		} else if(op == 1) {	//더하기
			result += Double.parseDouble(downBuf+"");
			System.out.println(result);
		} else if(op == 2) {	//빼기
			result -= Double.parseDouble(downBuf+"");
			System.out.println(result);
		} else if(op == 3) {	//곱하기
			result *= Double.parseDouble(downBuf+"");
			System.out.println(result);
		} else if(op == 4) {	//나누기
			result /= Double.parseDouble(downBuf+"");
			System.out.println(result);
		}
	}	
	
	public static void main(String[] args) {
		new Calculator().init();
	}

}
