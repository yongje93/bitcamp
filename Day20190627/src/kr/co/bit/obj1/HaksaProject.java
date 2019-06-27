package kr.co.bit.obj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connection conn = null;
		while (true) {
			try {
				// 1. 로드(적재) - 자바에게 데이터베이스 오라클을 사용한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. 연결 Connection DriverManager
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				if (conn == null) {
					System.out.println("데이터베이스 연결 실패");
				} else {
					System.out.println("데이터베이스 연결 성공");
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("학사관리");
			System.out.println("====메뉴====");
			System.out.println("1.등록\n2.찾기\n3.삭제\n4.전체출력");
			System.out.println("===========");
			System.out.println("0.종료");
			System.out.print("메뉴 선택--> ");

			int protocol = input.nextInt();
			if (protocol == 1) { // 등록
				HaksaFunction.register(protocol, input, conn);
				if (protocol == 4) { // 이전메뉴
					System.out.println("이전메뉴");
					continue;
				}
				
			} else if (protocol == 2) { // 찾기
				HaksaFunction.search(input, conn);

			} else if (protocol == 3) { // 삭제
				HaksaFunction.delete(input, conn);

			} else if (protocol == 4) { // 전체출력
				HaksaFunction.list(input, conn);

			} else if (protocol == 0) { // 종료
				System.out.println("종료");
				System.exit(0);
			}
		}
	}

}
