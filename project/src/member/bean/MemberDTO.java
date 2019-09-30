package member.bean;

import lombok.Data;

@Data
public class MemberDTO {
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String tel;
	private String birthday;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String savedmoney;
}
