package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ScoreImpl implements Score{
	private ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

	@Override
	public void input(ScoreDTO dto) {
		list.add(dto);
		// System.out.println(list.size());
	}

	@Override
	public void print(JTextArea output) {
		output.setText("");
		for (ScoreDTO dto : list) {
			output.append(dto.toString() + "\n");
		}
	}

	@Override
	public void search(JTextArea output) {
		int sw = 0;
		String hak = JOptionPane.showInputDialog(null, "학번 입력");
		if(hak == null || hak.equals("")) return;
		output.setText("");
		for(ScoreDTO dto : list) {
			if(dto.getHak().equals(hak)) {
				//System.out.println(dto);
				sw = 1;
				output.append(dto.toString() + "\n");
			}
		}
		if(sw == 0) {
			JOptionPane.showMessageDialog(null, "찾고자 하는 학번이 없습니다!!");
		}
	}
	
	@Override
	public void tot_desc() {
		Comparator com = new Comparator<ScoreDTO>() {

			@Override
			public int compare(ScoreDTO s1, ScoreDTO s2) {
				return (s1.getTot() < s2.getTot()) ? 1 : -1; //내림차순
			}
		}; 
		
		Collections.sort(list, com);
		//Collections.sort(list);
	}
	
	@Override
	public void save() {
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int result = chooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		int count = list.size();
		try {
			if (file == null) return;
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeInt(count);	//파일에 맨처음에 리스트의 개수가 몇개인지 넣어주기.
			for (ScoreDTO dto : list) {
				oos.writeObject(dto);
				oos.flush();
			}
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load() {
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		try {
			if (file == null) return;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			int count = ois.readInt();	// 파일 맨처음에 있는 리스트의 개수 읽어오기.
			ScoreDTO dto = null;
			list.clear();
			for(int i = 0; i < count; i ++) {	// 파일의 맨처음에 있는 리스트의 개수만큼 추가해라.
				dto = (ScoreDTO)ois.readObject();
				list.add(dto);
			}
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
