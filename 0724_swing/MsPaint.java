import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton drawB;
	private DrCanvas can;
	private ArrayList<ShapeDTO> list;

	public MsPaint(){
		x1L = new JLabel("x1");
		y1L = new JLabel("y1");
		x2L = new JLabel("x2");
		y2L = new JLabel("y2");
		z1L = new JLabel("z1");
		z2L = new JLabel("z2");

		x1T = new JTextField("0",4);
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("50",4);
		z2T = new JTextField("50",4);

		fill = new JCheckBox("채우기");

		line = new JRadioButton("선", true);
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형");
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");

		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		String[] color = {"빨강", "초록", "파랑", "보라", "하늘"};
		combo = new JComboBox<String>(color);

		drawB = new JButton("그리기");

		can = new DrCanvas(this);

		list = new ArrayList<ShapeDTO>();

		JPanel topP= new JPanel();
		topP.add(x1L); topP.add(x1T);
		topP.add(y1L); topP.add(y1T);
		topP.add(x2L); topP.add(x2T);
		topP.add(y2L); topP.add(y2T);
		topP.add(z1L); topP.add(z1T);
		topP.add(z2L); topP.add(z2T);
		topP.add(fill);

		JPanel bottomP = new JPanel();
		bottomP.add(line);
		bottomP.add(circle);
		bottomP.add(rect);
		bottomP.add(roundRect);
		bottomP.add(pen);
		bottomP.add(combo);
		bottomP.add(drawB);
		
		Container c = this.getContentPane();
		c.add("North", topP);
		c.add("South", bottomP);
		c.add("Center", can);
		
		setBounds(100, 80, 700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//이벤트
		drawB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				can.repaint();
			}
		});

		can.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				x1T.setText(e.getX()+"");
				y1T.setText(e.getY()+"");
			}

			@Override
			public void mouseReleased(MouseEvent e){
				ShapeDTO dto = new ShapeDTO();
				//좌표
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));

				dto.setFill(fill.isSelected());

				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected()) dto.setShape(Figure.ROUNDRECT);

				dto.setColor(combo.getSelectedIndex());

				list.add(dto);
				System.out.println("list의 개수 = "+list.size());
			}
		});
		
		can.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+"");

				can.repaint();

				//연필
				if(pen.isSelected()){
					ShapeDTO dto = new ShapeDTO();

					//좌표
					dto.setX1(Integer.parseInt(x1T.getText()));
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					dto.setZ1(Integer.parseInt(z1T.getText()));
					dto.setZ2(Integer.parseInt(z2T.getText()));

					dto.setFill(fill.isSelected());

					dto.setShape(Figure.PEN);

					dto.setColor(combo.getSelectedIndex());

					list.add(dto);

					x1T.setText(x2T.getText());
					y1T.setText(y2T.getText());

				}
			}
		});

	}//생성자

	public JTextField getX1T(){
		return x1T;
	}
	public JTextField getY1T(){
		return y1T;
	}
	public JTextField getX2T(){
		return x2T;
	}
	public JTextField getY2T(){
		return y2T;
	}
	public JTextField getZ1T(){
		return z1T;
	}
	public JTextField getZ2T(){
		return z2T;
	}
	public JComboBox getCombo(){
		return combo;
	}
	public JCheckBox getFill(){
		return fill;
	}
	public JRadioButton getLine(){
		return line;
	}
	public JRadioButton getCircle(){
		return circle;
	}
	public JRadioButton getRect(){
		return rect;
	}
	public JRadioButton getRoundRect(){
		return roundRect;
	}
	public ArrayList<ShapeDTO> getList(){
		return list;
	}

	public static void main(String[] args) {
		new MsPaint();
	}
}
