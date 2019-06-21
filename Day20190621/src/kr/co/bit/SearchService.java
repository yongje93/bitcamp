package kr.co.bit;

public class SearchService {
	private Member[] members;

	public SearchService() {
		members = new Member[5];
		members[0] = new Member("가가가", 180, 90, "대한민국");
		members[1] = new Member("나나나", 181, 91, "대한민국");
		members[2] = new Member("다다다", 182, 92, "대한민국");
		members[3] = new Member("라라라", 183, 93, "대한민국");
		members[4] = new Member("마마마", 184, 94, "대한민국");
	}

	boolean searchMember(String name) {
		boolean searchResult = false;
		for (int i = 0; i < members.length; i++) {
			if(members[i].getName().equals(name)) {
				printInfo(members[i]);
				searchResult = true;
			}
		}
		return searchResult;
	}

	private void printInfo(Member member) {
		System.out.println(member.getName() + "으로 찾은 결과");
		System.out.println("이름: " + member.getName());
		System.out.println("신장: " + member.getHeight());
		System.out.println("몸무게: " + member.getWeight());
		System.out.println("국가: " + member.getNation());
		
	}
}
