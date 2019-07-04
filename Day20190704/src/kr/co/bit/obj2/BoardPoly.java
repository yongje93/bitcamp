package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class BoardPoly {

	public void boardSQL(BoardInterface board) {
		board.boardSQL();
	}

	public void boardClose(BoardInterface board) {
		board.boardClose();
	}

	public void boardProcess(BoardInterface board) throws IOException, SQLException {
		board.boardProcess();
	}

}
