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

		redB = new Button("빨강");
		greenB = new Button("초록");
		blueB = new Button("파랑");
		
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

		//이벤트
		frame.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		
		//빨강 버튼
		redB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.RED);
			}
		});
		//초록 버튼
		greenB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.GREEN);
			}
		});
		//파랑 버튼
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
