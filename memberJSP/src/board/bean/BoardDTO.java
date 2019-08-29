package board.bean;

import lombok.Data;

@Data
public class BoardDTO {
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
}
