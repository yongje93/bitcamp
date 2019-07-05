package kr.co.bit.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberShipMain {
	private static String session;

	static {
		session = null;
	}

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> memberArray = new ArrayList<HashMap<String, String>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				System.out.println("R: 회원가입  L: 회원목록  S: ID찾기  D: 회원탈퇴  E: 회원수정  I: 로그인  O: 로그아웃");
				String protocol = br.readLine();
				if (protocol.equals("R") | protocol.equals("r")) { // 회원가입
					if (session != null) {
						System.out.println("로그인중입니다.");
						continue;
					}
					HashMap<String, String> memberHash = new HashMap<String, String>();

					System.out.print("아이디 입력: ");
					String id = br.readLine();
					System.out.print("패스워드 입력: ");
					String passwd = br.readLine();
					System.out.print("주소 입력: ");
					String address = br.readLine();
					System.out.print("전화번호 입력: ");
					String tel = br.readLine();

					memberHash.put("id", id);
					memberHash.put("passwd", passwd);
					memberHash.put("address", address);
					memberHash.put("tel", tel);
					memberArray.add(memberHash);

					System.out.println("회원등록 되었습니다.");

				} else if (protocol.equals("L") | protocol.equals("l")) { // 회원목록
					System.out.println("전체출력");
					System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						System.out.print(memberHash.get("id") + "\t" + memberHash.get("passwd") + "\t\t"
								+ memberHash.get("address") + "\t" + memberHash.get("tel") + "\n");
					}
				} else if (protocol.equals("S") | protocol.equals("s")) { // 회원찾기
					System.out.print("찾는 아이디 입력: ");
					String id = br.readLine();
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						if (memberHash.get("id").equals(id)) {
							System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
							System.out.print(memberHash.get("id") + "\t" + memberHash.get("passwd") + "\t\t"
									+ memberHash.get("address") + "\t" + memberHash.get("tel") + "\n");
						}
					}
				} else if (protocol.equals("I") | protocol.equals("i")) { // 로그인
					System.out.print("아이디 입력: ");
					String id = br.readLine();
					System.out.print("패스워드 입력: ");
					String passwd = br.readLine();
					if (memberArray.size() == 0) {
						System.out.println("회원이 한명도 없습니다.");
					} else {
						for (int i = 0; i < memberArray.size(); i++) {
							HashMap<String, String> memberHash = memberArray.get(i);

							if (memberHash.get("id").equals(id) && memberHash.get("passwd").equals(passwd)) {
								System.out.println("환영합니다. 로그인 되었습니다.");
								session = memberHash.get(id);
							} else if (!memberHash.get("id").equals(id) && memberHash.get("passwd").equals(passwd)) {
								System.out.println("아이디가 틀렸습니다.");
								return;

							} else if (memberHash.get("id").equals(id) && !memberHash.get("passwd").equals(passwd)) {
								System.out.println("패스워드가 틀렸습니다.");
								return;

							} else if (!memberHash.get("id").equals(id) && !memberHash.get("passwd").equals(passwd)) {
								System.out.println("아이디,패스워드 둘 다 틀렸습니다.");
								return;
							}

						}
					}
				} else if (protocol.equals("O") | protocol.equals("o")) { // 로그아웃
					if (session == null) {
						System.out.println("로그인하세요.");
						continue;
					}
					System.out.println("로그아웃 되었습니다.");
					session = null;

				} else if (protocol.equals("D") | protocol.equals("d")) { // 회원탈퇴
					if (session == null) {
						System.out.println("로그인하세요.");
						continue;
					}
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						if (memberHash.get("id").equals(session)) {
							memberArray.remove(i);
						}
					}
					session = null;
					System.out.println("회원탈퇴 되었습니다.");
				} else if (protocol.equals("E") | protocol.equals("e")) { // 회원수정
					if (session == null) {
						System.out.println("로그인하세요.");
						continue;
					}
					for (int i = 0; i < memberArray.size(); i++) {
						HashMap<String, String> memberHash = memberArray.get(i);
						if (memberHash.get("id").equals(session)) {
							System.out.print(memberHash.get("id") + "\t" + memberHash.get("passwd") + "\t\t"
									+ memberHash.get("address") + "\t" + memberHash.get("tel") + "\n");

							System.out.print("아이디 입력: ");
							String id = br.readLine();
							System.out.print("패스워드 입력: ");
							String passwd = br.readLine();
							System.out.print("주소 입력: ");
							String address = br.readLine();
							System.out.print("전화번호 입력: ");
							String tel = br.readLine();

							memberHash.put("id", id);
							memberHash.put("passwd", passwd);
							memberHash.put("address", address);
							memberHash.put("tel", tel);
							memberArray.set(i, memberHash);

							session = memberHash.get("id");
							System.out.println("회원수정 하였습니다.");
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
