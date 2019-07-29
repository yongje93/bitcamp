import javax.swing.JTextArea;

public interface Score {
	public void input(ScoreDTO dto); // 입력
	public void print(JTextArea output); // 출력
	public void search(JTextArea output); // 검색
	public void tot_desc();	//순위
	public void save();	// 저장
	public void load(); // 읽기
}
