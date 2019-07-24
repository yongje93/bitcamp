import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class DrCanvas extends Canvas {
	private MsPaint mp;

	public DrCanvas(MsPaint mp) {
		this.mp = mp;
		setBackground(new Color(255, 200, 255));

	}

	@Override
	public void paint(Graphics g) { // call back �޼ҵ�. ȭ�鿡 �ѷ����� ���ÿ� paint �θ�.
		// ��ǥ - 6��
		int x1 = Integer.parseInt(mp.getX1T().getText());
		int y1 = Integer.parseInt(mp.getY1T().getText());
		int x2 = Integer.parseInt(mp.getX2T().getText());
		int y2 = Integer.parseInt(mp.getY2T().getText());
		int z1 = Integer.parseInt(mp.getZ1T().getText());
		int z2 = Integer.parseInt(mp.getZ2T().getText());

		// ��
		switch (mp.getCombo().getSelectedIndex()) {
			case 0:	setForeground(Color.RED); break;
			case 1: setForeground(Color.GREEN); break;
			case 2:	setForeground(Color.BLUE); break;
			case 3:	setForeground(Color.MAGENTA); break;
			case 4:	setForeground(Color.CYAN); break;
		}

		// ����
		if (mp.getFill().isSelected()) { // üũ�ڽ� ����O
			if (mp.getLine().isSelected()) { // �� ����
				g.drawLine(x1, y1, x2, y2);
			} else if (mp.getCircle().isSelected()) { // �� ����
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRect().isSelected()) { // �簢�� ����
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRoundRect().isSelected()) { // �ձٻ簢�� ����
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			}
		} else { // üũ�ڽ� ����X
			if (mp.getLine().isSelected()) { // �� ����
				g.drawLine(x1, y1, x2, y2);
			} else if (mp.getCircle().isSelected()) { // �� ����
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRect().isSelected()) { // �簢�� ����
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRoundRect().isSelected()) { // �ձٻ簢�� ����
				g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			}
		}
	}
}
