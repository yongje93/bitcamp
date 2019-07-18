import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class RGBTest {
	private Frame frame;
	private Button redB, greenB, blueB;
	private DrCanvas canvas;

	public RGBTest() {
		frame = new Frame();

		redB = new Button("����");
		greenB = new Button("�ʷ�");
		blueB = new Button("�Ķ�");
		
		canvas = new DrCanvas();
		//canvas.setBackground(new Color(255,255,0));

		Panel panel = new Panel();
		panel.add(redB);
		panel.add(greenB);
        panel.add(blueB);
        
		frame.add("North", panel);
		frame.add("Center", canvas);

		frame.setBounds(100,80,300,300);
		frame.setVisible(true);

		//�̺�Ʈ
		frame.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		
		//���� ��ư
		redB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.RED);
			}
		});
		//�ʷ� ��ư
		greenB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.GREEN);
			}
		});
		//�Ķ� ��ư
		blueB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.BLUE);
			}
		});

	}

	class DrCanvas extends Canvas {
		public DrCanvas() {
			this.setBackground(new Color(255,255,0));
		}
	}

	public static void main(String[] args) {
		new RGBTest();
	}
}
