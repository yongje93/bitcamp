package user.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		// 데이터
		System.out.print("찾고자 하는 아이디 입력 : ");
		String id = scan.next();
		
		// DB
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.search(id);
		
		// 응답
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다");
		} else {
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
			System.out.print("수정할 이름 입력 : ");
			String name = scan.next();
			System.out.print("수정할 비밀번호 입력 : ");
			String pwd = scan.next();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			map.put("pwd", pwd);
			map.put("id", id);
			
			userDAO.update(map);
			System.out.println("데이터를 수정하였습니다");
		}		
	}

}