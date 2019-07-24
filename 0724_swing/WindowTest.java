import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class WindowTest extends JFrame {
	private JButton newB, exitB;
	private JTextArea area;

	public WindowTest(){
		newB = new JButton("���θ����");
		exitB = new JButton(new ImageIcon("exit.gif"));

		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		
		JPanel p = new JPanel();
		p.add(newB);
		p.add(exitB);
		
		Container c = this.getContentPane();
		c.add("North", p);
		c.add("Center", scroll);

		setBounds(100,80,300,400);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override 
			public void windowClosing(WindowEvent e) {
				//���� ���̾�α�
				int result = JOptionPane.showConfirmDialog(
									WindowTest.this,
									"���� ���� �ҷ�?",
									"����",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION) 
					System.exit(0);
			}
		});
		                    
	}

	public static void main(String[] args) {
		new WindowTest();
	}
}

