import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;

class WindowTest extends Frame {
	public WindowTest() {
		//new Frame("��������������").setVisible(true);	// â ���� �ϳ��� �����.
		super("��������������"); //setTitle("��������������"); super�� �׻� ù°��
				
		setForeground(new Color(220, 220, 0));
		setBackground(new Color(205, 171, 214));
		//setBackground(Color.MAGENTA);	//������
		//this.setSize(300, 400); // ����, ����
		setBounds(1000, 200, 300, 400);
		setVisible(true);
	}

	public void paint(Graphics g) {	//����	
		g.drawString("���������", 100, 100);	
		g.drawLine(100, 150, 250, 200);	//��
		g.drawRect(100, 200, 80, 50);	//�簢�� drawRect(x, y, �ʺ�, ����)
		g.drawOval(125, 225, 100, 50);	//�� 
	}

	public static void main(String[] args) {
		WindowTest windowTest = new WindowTest();
	}
}

//POJO (Plain Old Java Object)
//� ������ ������ �Ǹ� JVM(�ü��)�� ȣ�� - Call Back �޼ҵ�. ex) main() // Run()  