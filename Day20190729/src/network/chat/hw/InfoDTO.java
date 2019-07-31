package network.chat.hw;

import java.io.Serializable;

enum Info {
	JOIN, EXIT, SEND
}

public class InfoDTO implements Serializable {
	private String nickName;
	private String message;
	private Info command;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Info getCommand() {
		return command;
	}

	public void setCommand(Info command) {
		this.command = command;
	}
}

//데이터는 String이 아니라 InfoDTO 넘겨주고 받고
//BufferedReader, PrintWriter 사용X
//ObjectInputStream, ObjectOutputStream 사용하세요
