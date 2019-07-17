import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowExit implements WindowListener { // 윈도우창을 닫을때 사용.

	public void windowActivated(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		System.exit(0);	//프로그램 강제종료  0이면 정상종료 1이면 비정상종료
	} //창닫기
	public void windowClosed(WindowEvent e) { }	// 창닫은뒤 처리
	public void windowDeactivated(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowOpened(WindowEvent e) { }

}
