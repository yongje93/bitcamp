import javax.swing.JTextArea;

public interface Score {
	public void input(ScoreDTO dto); // �Է�
	public void print(JTextArea output); // ���
	public void search(JTextArea output); // �˻�
	public void tot_desc();	//����
	public void save();	// ����
	public void load(); // �б�
}
