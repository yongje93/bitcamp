import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class DrCanvas extends Canvas {
	private MsPaint mp;
	private Image bufferImage;
	private Graphics bufferG;

	public DrCanvas(MsPaint mp)	{
		this.mp = mp;
		setBackground(new Color(255,200,255));
	}
	
	@Override
	public void update(Graphics g){
		int x1, y1, x2, y2, z1, z2;
		Dimension d = this.getSize();

		if(bufferG==null){
			bufferImage = this.createImage(d.width, d.height);
			bufferG = bufferImage.getGraphics();
		}

		bufferG.setColor(this.getBackground());
		bufferG.fillRect(0,0,d.width,d.height);
		
		//ArrayList에 담아놓은 도형을 다시 그려주기
		for(ShapeDTO dto : mp.getList()){
			//좌표
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();

			//색
			switch(dto.getColor()){
				case 0 : bufferG.setColor(Color.RED); break;
				case 1 : bufferG.setColor(Color.GREEN); break;
				case 2 : bufferG.setColor(Color.BLUE); break;
				case 3 : bufferG.setColor(Color.MAGENTA); break;
				case 4 : bufferG.setColor(Color.CYAN); break;
			}

			//도형
			if(dto.getFill()){
				if(dto.getShape()==Figure.LINE) 
					bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape()==Figure.CIRCLE) 
					bufferG.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape()==Figure.RECT) 
					bufferG.fillRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape()==Figure.ROUNDRECT) 
					bufferG.fillRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				else if(dto.getShape()==Figure.PEN)
					bufferG.drawLine(x1, y1, x2, y2);
			
			}else{
				if(dto.getShape()==Figure.LINE) 
					bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape()==Figure.CIRCLE) 
					bufferG.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape()==Figure.RECT) 
					bufferG.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape()==Figure.ROUNDRECT) 
					bufferG.drawRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				else if(dto.getShape()==Figure.PEN)
					bufferG.drawLine(x1, y1, x2, y2);
			}

		}//for


		/////////////////////////////////////////////////////
		//좌표 - 6개
		x1 = Integer.parseInt(mp.getX1T().getText());
		y1 = Integer.parseInt(mp.getY1T().getText());
		x2 = Integer.parseInt(mp.getX2T().getText());
		y2 = Integer.parseInt(mp.getY2T().getText());
		z1 = Integer.parseInt(mp.getZ1T().getText());
		z2 = Integer.parseInt(mp.getZ2T().getText());

		//색
		switch(mp.getCombo().getSelectedIndex()){
			case 0 : bufferG.setColor(Color.RED); break;
			case 1 : bufferG.setColor(Color.GREEN); break;
			case 2 : bufferG.setColor(Color.BLUE); break;
			case 3 : bufferG.setColor(Color.MAGENTA); break;
			case 4 : bufferG.setColor(Color.CYAN); break;
		}

		//도형
		if(mp.getFill().isSelected()){
			if(mp.getLine().isSelected()) 
				bufferG.drawLine(x1, y1, x2, y2);
			else if(mp.getCircle().isSelected()) 
				bufferG.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(mp.getRect().isSelected()) 
				bufferG.fillRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(mp.getRoundRect().isSelected()) 
				bufferG.fillRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		
		}else{
			if(mp.getLine().isSelected()) 
				bufferG.drawLine(x1, y1, x2, y2);
			else if(mp.getCircle().isSelected()) 
				bufferG.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(mp.getRect().isSelected()) 
				bufferG.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(mp.getRoundRect().isSelected()) 
				bufferG.drawRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
		}

		paint(g);
	}


	@Override
	public void paint(Graphics g){
		g.drawImage(bufferImage,0,0,this);
	}
}
