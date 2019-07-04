package kr.co.bit;

import java.io.Serializable;

public class User implements Serializable {
	private String id;
	private String passwd;
	private String dong;
	private int age;
	private String name;

	public User() {
		super();
	}

	public User(String id, String passwd, String dong, int age, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.dong = dong;
		this.age = age;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [아이디=" + id + ", 비밀번호=" + passwd + ", 동=" + dong + ", 나이=" + age + ", 이름=" + name + "]";
	}

	

}
