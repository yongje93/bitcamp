/* 가위 바위 보 게임.
	1: 가위 
	2: 바위
	3: 보
	컴퓨터가 1~3의 난수를 발생한다. 
	졌다 이겼다 비겼다.
	
	[실행결과]
	가위, 바위, 보(1~3) : 1 (System.in.read() 사용)
	컴퓨터 : 바위, 나 : 가위
	졌다
	0 '0' 48 차이
*/
class Game {
	public static String getName(int i) {
		if(i == 1) return "가위";
		else if(i == 2)	return "바위";
		else if(i == 3) return "보";
		else return "";
	}

	public static void gameProcess(String com_result, String user_result) {
		if(com_result.equals(user_result)) {
			System.out.println("비겼다.");
		}
		if("가위".equals(com_result)) {
			if("바위".equals(user_result)) {
				System.out.println("이겼다.");
			} else {
				System.out.println("졌다.");
			}
		} else if ("바위".equals(com_result)) {
			if("보".equals(user_result)) {
				System.out.println("이겼다.");
			} else {
				System.out.println("졌다.");
			}
		} else if ("보".equals(com_result)) {
			if("가위".equals(user_result)) {
				System.out.println("이겼다.");
			} else {
				System.out.println("졌다.");
			}
		}
	}
	
	public static void main(String[] args) throws java.io.IOException {
		int com, user;
		com = (int)(Math.random()*3) + 1;		
		System.out.println(com);
		System.out.print("가위, 바위, 보 (1~3) : ");	//1,2,3->49,50,51
		user = System.in.read()-48; // System.in.read-'0';
		
		String com_result = getName(com);
		String user_result = getName(user);
		System.out.println("컴퓨터 : " + com_result +", 나 : " + user_result);
		
		gameProcess(com_result, user_result);
/*
		if(com == 1) {	//가위
			if(user == 1) { //가위
				System.out.println("컴퓨터 : 가위, 나 : 가위");
				System.out.println("비겼다.");
			} else if(user == 2) { //바위
				System.out.println("컴퓨터 : 가위, 나 : 바위");
				System.out.println("이겼다.");
			} else if(user == 3) { //보
				System.out.println("컴퓨터 : 가위, 나 : 보");
				System.out.println("졌다.");
			}
		} else if (com == 2) {	//바위
			if(user == 1) { //가위
				System.out.println("컴퓨터 : 바위, 나 : 가위");
				System.out.println("졌다.");
			} else if(user == 2) { //바위
				System.out.println("컴퓨터 : 바위, 나 : 바위");
				System.out.println("비겼다.");
			} else if(user == 3) { //보
				System.out.println("컴퓨터 : 바위, 나 : 보");
				System.out.println("이겼다.");
			}
		} else if (com == 3) {	//보
			if(user == 1) { //가위
				System.out.println("컴퓨터 : 보, 나 : 가위");
				System.out.println("이겼다.");
			} else if(user == 2) { //바위
				System.out.println("컴퓨터 : 보, 나 : 바위");
				System.out.println("졌다.");
			} else if(user == 3) { //보
				System.out.println("컴퓨터 : 보, 나 : 보");
				System.out.println("비겼다.");
			}
		}
		*/
	}
}
