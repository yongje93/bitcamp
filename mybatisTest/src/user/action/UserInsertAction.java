package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		// 데이터
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		// DB
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.wirte(userDTO);
		
		// 응답
		System.out.println("데이터를 저장하였습니다");	
	}

}
