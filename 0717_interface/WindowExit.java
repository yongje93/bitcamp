import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowExit implements WindowListener { // ������â�� ������ ���.

	public void windowActivated(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		System.exit(0);	//���α׷� ��������  0�̸� �������� 1�̸� ����������
	} //â�ݱ�
	public void windowClosed(WindowEvent e) { }	// â������ ó��
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }

}
