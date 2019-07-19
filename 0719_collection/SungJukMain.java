/*
성적관리 프로그램

1. 번호, 이름, 국어, 영어, 수학점수를 입력하여 총점과 평균을 구하시오
2. 각 기능에 따라 3개의 클래스로 나누어 작성하시오
     SungJukDTO.java
     SungJukAction.java	
     SungJukMain.java
3.평균은 소수이하 3째자리까지 출력
  소수이하 자리값이 0이면 출력하지 않는다
  92.000 → 92로 출력하시오
4. 번호는 중복되지않게 입력한다

menu()
*****************
   1. 입력
   2. 출력
   3. 검색
   4. 삭제
   5. 정렬
   6. 끝
*****************
   번호 : 8
1~6중에 선택하세요

insertArticle()
번호 입력 :
이름 입력 :
국어 입력 :
영어 입력 :
수학 입력 :

printArticle()
번호	이름	국어	영어	수학	총점	평균
15		홍길동	90		92		91		xxx		xx.xxx
30		또치	85		92		100		xxx		xx.xxx

searchArticle()
검색 할 이름 입력 : 코난
찾고자 하는 이름이 없습니다

검색 할 이름 입력 : 홍길동
번호	이름	국어	영어	수학	총점	평균
15		홍길동	90		92		91		xxx		xx.xxx
16		홍길동	89		45		78		xxx		xx.xxx

deleteArticle() - 똑같은 이름이 있으면 모두 삭제
삭제 할 이름 입력 : 홍길동
데이터를 삭제하였습니다

sortArticle()
1. 이름으로 오름차순
2. 총점으로 내림차순
3. 이전메뉴
 번호 입력 : 

*/

public class SungJukMain {

	public static void main(String[] args) {
		SungJukAction action = new SungJukAction();
		action.menu();
	}

}
