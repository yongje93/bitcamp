package chat;

import java.io.Serializable;

enum Info {
	JOIN, EXIT, SEND
}

public class InfoDTO implements Serializable {	// 객체 직렬화 적용
	public static final long serialVersionUID = 1L; // 직렬화 버전 맞추기
	private String nickName; // 닉네임
	private String message; // 메세지
	private Info command; // 상태
	// setter
	public void setNickName(String nickName) {this.nickName = nickName;}
	public void setMessage(String message) {this.message = message;}
	public void setCommand(Info command) {this.command = command;}
	// getter
	public String getNickName() {return nickName;}
	public String getMessage() {return message;}
	public Info getCommand() {return command;}

}
