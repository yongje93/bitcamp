import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MsPaint extends JFrame {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect;
	private JComboBox<String> combo;
	private JButton drawB;
	private DrCanvas can;
	
	public MsPaint() {
		x1L = new JLabel("X1");
		x2L = new JLabel("X2");
		y1L = new JLabel("Y1");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");
		
		x1T = new JTextField("0",4);
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("50",4);
		z2T = new JTextField("50",4);
		
		fill = new JCheckBox("채우기");
		
		line = new JRadioButton("선", true);	//항상 선택 되어있음.
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형");
		roundRect = new JRadioButton("둥근사각형");
		
		ButtonGroup group = new ButtonGroup();
		group.add(line); 
		group.add(circle); 
		group.add(rect); 
		group.add(roundRect);
		
		String[] color = {"빨강", "초록", "파랑", "보라", "하늘"};
		combo = new JComboBox<String>(color);
		
		drawB = new JButton("그리기");
		
		can = new DrCanvas(this);
		
		//North
		JPanel topP = new JPanel();
		topP.add(x1L); topP.add(x1T);  
		topP.add(y1L); topP.add(y1T);
		topP.add(x2L); topP.add(x2T);
		topP.add(y2L); topP.add(y2T);
		topP.add(z1L); topP.add(z1T);
		topP.add(z2L); topP.add(z2T);
		topP.add(fill);
		
		//South
		JPanel bottomP = new JPanel();
		bottomP.add(line);
		bottomP.add(circle); 
		bottomP.add(rect); 
		bottomP.add(roundRect); 
		bottomP.add(combo); 
		bottomP.add(drawB);
		
		Container c = this.getContentPane();
		c.add("North", topP);
		c.add("South", bottomP);
		c.add("Center", can);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 80, 700, 500);
		setVisible(true);
		
		// 그리기 버튼
		drawB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.repaint();
			}
		});
		// 마우스 눌렀을때 x1, y1 좌표
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX() + "");
				y1T.setText(e.getY() + "");
			}
		});

		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");
				can.repaint();
			}
		});
		
	}
	
	public JTextField getX1T() { return x1T; }
	public JTextField getY1T() { return y1T; }
	public JTextField getX2T() { return x2T; }
	public JTextField getY2T() { return y2T; }
	public JTextField getZ1T() { return z1T; }
	public JTextField getZ2T() { return z2T; }
	public JComboBox<String> getCombo() { return combo; }
	public JCheckBox getFill() { return fill; }
	public JRadioButton getLine() {	return line; }
	public JRadioButton getCircle() { return circle; }
	public JRadioButton getRect() {	return rect; }
	public JRadioButton getRoundRect() { return roundRect; }

	public static void main(String[] args) {
		new MsPaint();
	}
}
