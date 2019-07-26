package day20190724;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

class DrCanvas extends Canvas {
	private MsPaint mp;
	private Image bufferImage;	//update에서 사용
	private Graphics bufferG;	//update에서 사용
	//펜관련
	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();
	
	public DrCanvas(MsPaint mp) {
		this.mp = mp;
		setBackground(new Color(255, 200, 255));
	}

	@Override
	public void update(Graphics g) { // 메모리에 그림 그려줌(화면에 안보임)
		Dimension d = this.getSize();	// Canvas의 이미지
		
		if(bufferG == null) {
			bufferImage = this.createImage(d.width, d.height);
			bufferG = bufferImage.getGraphics();
		}
		
		bufferG.setColor(this.getBackground());
		bufferG.fillRect(0, 0, d.width, d.height);	//화이트칠 하는 효과.
		
		// ArrayList에 담아놓은 도형 다시 그려주기.
		for(int i = 0; i <mp.getList().size(); i++) {
			int x1 = mp.getList().get(i).getX1();
			int y1 = mp.getList().get(i).getY1();
			int x2 = mp.getList().get(i).getX2();
			int y2 = mp.getList().get(i).getY2();
			int z1 = mp.getList().get(i).getZ1();
			int z2 = mp.getList().get(i).getZ2();
			// 색
			if((mp.getList().get(i).getColor()) == 0) {
				bufferG.setColor(Color.RED);
			} else if((mp.getList().get(i).getColor()) == 1) {
				bufferG.setColor(Color.GREEN);
			} else if((mp.getList().get(i).getColor()) == 2) {
				bufferG.setColor(Color.BLUE);
			} else if((mp.getList().get(i).getColor()) == 3) {
				bufferG.setColor(Color.MAGENTA);
			} else if((mp.getList().get(i).getColor()) == 4) {
				bufferG.setColor(Color.CYAN);
			}
			//도형
			if(mp.getList().get(i).getFill()) {
				if (mp.getList().get(i).getShape() == 0) { // 선
					bufferG.drawLine(x1, y1, x2, y2);
				} else if (mp.getList().get(i).getShape() == 1) { // 원
					bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (mp.getList().get(i).getShape() == 2) { // 사각형
					bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (mp.getList().get(i).getShape() == 3) { // 둥근사각형
					bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				}
			} else {
				if (mp.getList().get(i).getShape() == 0) { // 선
					bufferG.drawLine(x1, y1, x2, y2);
				} else if (mp.getList().get(i).getShape() == 1) { // 원
					bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (mp.getList().get(i).getShape() == 2) { // 사각형
					bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
				} else if (mp.getList().get(i).getShape() == 3) { // 둥근사각형
					bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				}
			}
		}
		
		///////////////////////////////////////////////////////////////내가 직접 그리는 애들
		// 좌표 - 6개
		int x1 = Integer.parseInt(mp.getX1T().getText());
		int y1 = Integer.parseInt(mp.getY1T().getText());
		int x2 = Integer.parseInt(mp.getX2T().getText());
		int y2 = Integer.parseInt(mp.getY2T().getText());
		int z1 = Integer.parseInt(mp.getZ1T().getText());
		int z2 = Integer.parseInt(mp.getZ2T().getText());

		// 색
		switch (mp.getCombo().getSelectedIndex()) {
		case 0:	bufferG.setColor(Color.RED); break;
		case 1:	bufferG.setColor(Color.GREEN); break;
		case 2:	bufferG.setColor(Color.BLUE);	break;
		case 3: bufferG.setColor(Color.MAGENTA); break;
		case 4:	bufferG.setColor(Color.CYAN); break;
		}
		
		// 도형
		if (mp.getFill().isSelected()) { // 채우기 선택O
			if (mp.getLine().isSelected()) { // 선
				bufferG.drawLine(x1, y1, x2, y2);
			} else if (mp.getCircle().isSelected()) { // 원
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRect().isSelected()) { // 사각형
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRoundRect().isSelected()) { // 둥근사각형
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			}
		} else { // 체크박스 선택X
			if (mp.getLine().isSelected()) { // 선
				bufferG.drawLine(x1, y1, x2, y2);
			} else if (mp.getCircle().isSelected()) { // 원
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRect().isSelected()) { // 사각형
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			} else if (mp.getRoundRect().isSelected()) { // 둥근사각형
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
			}
		}

		// 펜
		if (mp.getPen().isSelected()) {
			x.add(x2);
			y.add(y2);
			for (int i = 1; i < x.size(); i++) {				
				bufferG.drawLine(x.get(i-1), y.get(i-1), x.get(i), y.get(i));
			}
		}

		paint(g);	// paint로 Image 넘겨주기.
	}

	@Override
	public void paint(Graphics g) { // 화면에 그림 그려줌 
		g.drawImage(bufferImage, 0, 0, this);
	}
}