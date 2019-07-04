package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public interface BoardInterface {
	public void boardSQL();

	public void boardClose();

	public void boardProcess() throws IOException, SQLException;

}
