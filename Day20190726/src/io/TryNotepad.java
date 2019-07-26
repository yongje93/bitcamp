package io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener { // JFrame은 ContentPane 위에 붙여준다.
	private JTextArea area;
	private MenuPane menu;
	private File file;

	public TryNotepad() {
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		menu = new MenuPane();
		this.setJMenuBar(menu);

		getContentPane().add("Center", scroll);

		setBounds(300, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}// 생성자

	public void event() { // event만 잡는 함수
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(TryNotepad.this, "저장 하시겠습니까?", "메모장",
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					saveDialog();
					fileWrite();
				} else if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else if (result == JOptionPane.CANCEL_OPTION) {
					return;
				}
			}
		});
	}// 이벤트

	@Override // 오버라이드 구역은 thorws 안됨.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.getNewM()) {
			area.setText("");
		} else if (e.getSource() == menu.getOpenM()) {
			// 열기
			openDialog(); // 다이얼로그 열기
			fileRead(); // 파일 읽기 (호출)
		} else if (e.getSource() == menu.getSaveM()) {
			// 저장
			saveDialog();
			fileWrite();
		} else if (e.getSource() == menu.getExitM()) {
			System.exit(0);
		} else if (e.getSource() == menu.getCutM()) {
			area.cut();
		} else if (e.getSource() == menu.getCopyM()) {
			area.copy();
		} else if (e.getSource() == menu.getPasteM()) {
			area.paste();
		}
	}// 액션

	public void openDialog() {
		JFileChooser chooser = new JFileChooser();

		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(this, file);
		}
	}

	public void fileRead() { // 구현
		if (file == null)
			return;

		area.setText("");
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) { // 한줄씩 읽기. enter를 칠 때까지. enter 앞까지 읽어옴.
				area.append(line + "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveDialog() {
		JFileChooser chooser = new JFileChooser();

		int result = chooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(this, file);
		}
	}

	public void fileWrite() {
		if (file == null)
			return;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String data = area.getText();
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TryNotepad().event();
	}

}
