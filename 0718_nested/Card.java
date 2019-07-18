import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Card {
	private Frame frame;	// default layout => BoardLayout 
	private CardLayout card;

	public void init() {
		frame = new Frame();
		card = new CardLayout();
		frame.setLayout(card);
			
		Panel[] panel = new Panel[5];
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE,Color.MAGENTA,Color.CYAN};
		String[] name = {"빨강","초록","파랑","보라","하늘"};
		for(int i = 0; i < panel.length; i++) {
			panel[i] = new Panel();
			panel[i].setBackground(color[i]);
			
			frame.add(panel[i], name[i]);	//패널에 이름 붙여서.
			//마우스 클릭
			panel[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e){
					//card.show(frame, "보라");
					//card.next(frame);
					card.show(frame, name[(int)(Math.random()*5)]);
				}
			});
		}
		
		frame.setBounds(100,80,200,200);
		frame.setVisible(true);

		//이벤트
		frame.addWindowListener(new WindowAdapter() { 
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		

		

	}

	public static void main(String[] args) {
		new Card().init();
	}
}
