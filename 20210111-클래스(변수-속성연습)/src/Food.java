/*
 *    1) 보타이
 *    2) 주소  서울특별시 강동구 올림픽로60길 5 한스빌딩 1F
 *    3) 지번 서울시 강동구 성내동 111-55 한스빌딩 1F
 *    4) 전화번호	02-474-3520
	  5) 음식 종류	태국 음식
	  6) 가격대	만원-2만원
  	  7) 주차	주차공간없음
	  8) 영업시간	11:30 - 21:30
	  9) 쉬는시간	14:30 - 17:00
 	 10) 메뉴	  팟타이          10,000원
			  뿌팟퐁커리 (2마리) 18,000원
			  똠양꿍          12,000원
			  꾸웨이띠오   	 	9,000원
	 11) 평점 4.3
	 12) description 84751명
	 13) 맛있다 58
	 14) 괜찮다 10
	 15) 별로 9
	 16) 찜 1880	 
 */
/*
 *    클래스
 *      = 데이터형 클래스(멤버변수만 설정)
 *      = 액션 클래스(기능만 메소드 => 데이터베이스)
 *      = 혼합(변수+메소드)
 */
public class Food {
	String name;
	double score;
	String addr1;
	String addr2;
	String tel;
	String type;
	String price;
	String parking;
	String day1,day2;
	String[] menu;   // 현재 null값이기 때문에 크기설정 필요.
	int good;
	int soso;
	int bad;
	static String title="망고플레이트";
	// poster
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food food=new Food();   // static을 제외한 나머지 변수가 food에 저장됨
		// food 공간에 들어가 있는 변수들의 초기화: 쓰기
		food.name="보타이";
		food.score=4.3;
		food.addr1="서울특별시 강동구 올림픽로60길 5 한스빌딩 1F";
		food.addr2="서울시 강동구 성내동 111-55 한스빌딩 1F";
		food.tel="02-474-3520";
		food.type="태국 음식";
		food.price="만원-2만원";
		food.parking="주차공간없음";
		food.day1="11:30 - 21:30";
		food.day2="14:30 - 17:00";
		food.menu=new String[4];       // 배열이 있는 경우 반드시 크기 설정해 줘야함.
		food.menu[0]="팟타이 10,000원";
		food.menu[1]="뿌팟퐁커리(2마리) 18,000원";
		food.menu[2]="똠양꿍 12,000원";
		food.menu[3]="꾸웨이띠오 9,000원";
		food.good=58;
		food.soso=10;
		food.bad=9;
		// 변수는 데이터를 메모리에 저장 => 저장된 데이터를 읽기/변경
		System.out.println("========= 상세보기 =========");
		System.out.println(food.name+" "+food.score);
		System.out.println("주소:"+food.addr1);
		System.out.println("    지번:"+food.addr2);
		System.out.println("전화번호:"+food.tel);
		System.out.println("음식종류:"+food.type);
		System.out.println("가격대:"+food.price);
		System.out.println("주차:"+food.parking);
		System.out.println("영업시간:"+food.day1);
		System.out.println("쉬는시간:"+food.day2);
		System.out.print("메뉴:");
		for(String s:food.menu)
		{
			System.out.println(s);
		}
		System.out.print("전체("+(food.good+food.soso+food.bad)+")|");
		System.out.print("맛있다("+food.good+")|");
		System.out.print("괜찮다("+food.soso+")|");
		System.out.print("별로("+food.bad+")");
		System.out.println("\n데이터참조 업체:"+food.title);
	}

}
