package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board {

	public Register() {
		super();
	}

	public void setNo() throws IOException {
		System.out.print("게시글번호입력: ");
		no = Integer.parseInt(br.readLine());
	}

	public void setTitleContent() throws IOException {
		System.out.print("제목|내용입력: ");
		titleContent = br.readLine();
	}

	public void boardSqlRegister() {
		sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, AUTHOR, DAY, READCOUNT) VALUES(?,?,?,?,?,?)";
	}

	public void boardSqlExecute() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "신용제");
		pstmt.setString(5, "20190703");
		pstmt.setInt(6, 0);
		cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("등록 실패");
		} else {
			System.out.println(cnt + "건의 게시글이 등록되었습니다.");
		}
	}
		
	public void registerProcess() throws IOException, SQLException {
		setNo();
		setTitleContent();
		titleContentPorcess();
		boardSqlRegister();
		boardSqlExecute();
		closeAll();
	}

}
