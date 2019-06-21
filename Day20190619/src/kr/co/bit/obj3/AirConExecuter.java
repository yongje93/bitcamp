package kr.co.bit.obj3;

public class AirConExecuter {

	public static void main(String[] args) {
		AirCon airCon = new AirCon();
		airCon.company = "삼성에어콘";
		airCon.color = "흰색";
		airCon.price = 1000000;
		airCon.size = 7;
		airCon.temp = 0;
		System.out.println("내가 " + airCon.company+"을 샀다. 색깔은 " + airCon.color+"이고 "
				+ "가격은 "+airCon.price+"이고 평수는 "+airCon.size+"평이고 온도는 "+airCon.temp+"이다.");
		airCon.powerOn();
		airCon.powerOff();
		airCon.tempUp();
		System.out.println(airCon.temp+"도 올랐다.");
		airCon.tempDown();
		System.out.println(airCon.temp+"도 내렸다.");
		
	}

}
