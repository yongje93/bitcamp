package user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		String columnName = null;
		String value = null;
		
		System.out.println();
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.print("번호입력 : ");
		menu = scan.nextInt();
		
		if(menu == 1) {
			System.out.print("검색할 이름 입력 : ");
			value = scan.next();
			columnName = "name";
		} else if (menu == 2) {
			System.out.print("검색할 아이디 입력 : ");
			value = scan.next();
			columnName = "id";
		} else {
			System.out.println("1~2까지 가능합니다.");
			return;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", value);
		map.put("columnName", columnName);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		if(list == null) {
			System.out.println("찾는 아이디 또는 이름이 없습니다");
		} else {
			for (UserDTO userDTO : list) {
				System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			}
		}
	}

}
