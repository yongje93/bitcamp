package kr.co.bit;

public class SearchService {
	private Member[] members;

	public SearchService() {
		members = new Member[5];
		members[0] = new Member("������", 180, 90, "���ѹα�");
		members[1] = new Member("������", 181, 91, "���ѹα�");
		members[2] = new Member("�ٴٴ�", 182, 92, "���ѹα�");
		members[3] = new Member("����", 183, 93, "���ѹα�");
		members[4] = new Member("������", 184, 94, "���ѹα�");
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
		System.out.println(member.getName() + "���� ã�� ���");
		System.out.println("�̸�: " + member.getName());
		System.out.println("����: " + member.getHeight());
		System.out.println("������: " + member.getWeight());
		System.out.println("����: " + member.getNation());
		
	}
}
