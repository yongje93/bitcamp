package kr.co.bit.obj3;

public class AirConExecuter {

	public static void main(String[] args) {
		AirCon airCon = new AirCon();
		airCon.company = "�Ｚ������";
		airCon.color = "���";
		airCon.price = 1000000;
		airCon.size = 7;
		airCon.temp = 0;
		System.out.println("���� " + airCon.company+"�� ���. ������ " + airCon.color+"�̰� "
				+ "������ "+airCon.price+"�̰� ����� "+airCon.size+"���̰� �µ��� "+airCon.temp+"�̴�.");
		airCon.powerOn();
		airCon.powerOff();
		airCon.tempUp();
		System.out.println(airCon.temp+"�� �ö���.");
		airCon.tempDown();
		System.out.println(airCon.temp+"�� ���ȴ�.");
		
	}

}
