import java.awt.*;
import javax.swing.*;

class JButtonEx extends JFrame {
	private Icon icon1 = new ImageIcon("image/apeach.jpg");
	private Icon icon2 = new ImageIcon("image/muzi.jpg");
	private Icon icon3 = new ImageIcon("image/ryan.jpg");
	private Icon icon4 = new ImageIcon("image/tube.jpg");
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();
	
	public JButtonEx() {
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2, 2));
		for(int i = 0; i < 4; i++) {
			jb[i] = new JRadioButton(i + 1 + "�� ��ư", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i+1 +"��° ��ư�̴�. ����...");
			jb[i].setMnemonic(i+49);
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
            jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);

		}
		pack();	// ������ ������Ʈ�� ũ�⿡ ���� ���ض�.
		setVisible(true);
	}
	public static void main(String[] args) {
		new JButtonEx();
	}
}
