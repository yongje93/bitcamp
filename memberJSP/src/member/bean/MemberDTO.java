package member.bean;

import lombok.Data;

@Data	//@Setter	//@Getter
public class MemberDTO {
	//@Setter 하면 바로 아래만 Setter 생김
	private String name;
	private String id;
	private String password;
	private String gender;
	private String email1;
	private String email2;
	private String tel1;
	private String tel2;
	private String tel3;
	private String zipcode;
	private String addr1;
	private String addr2;
}
