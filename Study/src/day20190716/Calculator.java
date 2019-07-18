package day20190716;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Calculator extends Frame {
	private Button[] btn;
	private Label upL, downL;

	public void init() {
		setTitle("계산기");

		btn = new Button[18];
		String[] numStr = {"BackSpace","C","7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"};
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new Button(numStr[i]);
		}
		
		upL = new Label();
		upL.setBackground(new Color(168, 168, 255));
		upL.setPreferredSize(new Dimension(270, 40));
		
		downL = new Label();
		downL.setBackground(new Color(168, 168, 255));
		downL.setPreferredSize(new Dimension(270, 40));
		
		Panel[] p = new Panel[8];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel();
		}

		p[0].setLayout(new GridLayout(7, 1, 0, 0));
		//------------------1줄 + 2줄
		p[1].add(upL);
		p[2].add(downL);
		
		p[3].setLayout(new GridLayout(1,2,5,0));
		p[4].setLayout(new GridLayout(1,4,5,0));
		p[5].setLayout(new GridLayout(1,4,5,0));
		p[6].setLayout(new GridLayout(1,4,5,0));
		p[7].setLayout(new GridLayout(1,4,5,0));
		
		
		//-------------------3줄
		p[3].add(btn[0]);
		p[3].add(btn[1]);
		//-----------------------4줄
		p[4].add(btn[2]);
		p[4].add(btn[3]);
		p[4].add(btn[4]);
		p[4].add(btn[5]);
		//------------------------5줄
		p[5].add(btn[6]);
		p[5].add(btn[7]);
		p[5].add(btn[8]);
		p[5].add(btn[9]);
		//------------------------6줄
		p[6].add(btn[10]);
		p[6].add(btn[11]);
		p[6].add(btn[12]);
		p[6].add(btn[13]);
		//-----------------------7줄
		p[7].add(btn[14]);
		p[7].add(btn[15]);
		p[7].add(btn[16]);
		p[7].add(btn[17]);
		//---------------------
		for(int i = 1; i <= 7; i++) {
			p[0].add(p[i]);
		}
		add(p[0]);

		setBounds(1000, 500, 300, 400);
		setVisible(true); // 프레임 보이게.
		setResizable(false); // 크기 변경 못하게.
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new Calculator().init();
	}
}
