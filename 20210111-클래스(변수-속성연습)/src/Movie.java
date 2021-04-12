/*
 *    1) 래시 컴 홈(2020)  2) 상영중
	  3) Lassie Come Home, Lassie: Eine Abenteurliche Reise    평점 4) 09 . 5
	  5) 어드벤처/드라마/가족
	  6) 독일
	  7) 2021.01.07 개봉
 	  8) 96분, 9) 전체관람가
	  10) 감독 하노 올더디센   11) 주연 세바스찬 베젤, 안나 마리아 뮈헤, 니코 마리츠카
	  12) 예매 4위   13) 누적관객936명
	  
	  14) 전 세계 베스트셀러 [돌아온 래시] 원작  
	  영화 역사상 가장 유명한 명견 ‘래시’가 전하는 2021년 새해 첫 감동! 
	  서로의 가장 소중한 친구인 12살 소년 플로와 천재견 래시.
	  아버지가 실직해 작은 집으로 이사하자 플로는 더 이상 반려견을 키울 수 없게 되고,
	  래시는 다른 사람의 저택에 맡겨진다.
	  =============================================================
	  15) Category
	  16) 영화마다 고유번호 movieId=137528
	  17) 포스트
 */
public class Movie {
	String titleKr;
	boolean isShow;  // boolean => 항상 변수 앞에 is가 붙어있음: is~   / set~ 은 void
	String titleEng;
	double score;
	String genre;
	String nation;
	String regdate;
	int time;
	String grade;
	String director;
	String[] actor;   // 배우가 여러명 들어가기 때문에
	int reserve;
	int totalAudience;
	String story;     // 제한이 없다
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 메모리에 저장 => 데이터 읽기(변수: 쓰기(값 저장), 읽기(저장된 값 갖고오기))
		Movie m1=new Movie();  // m1 => 메모리 주소(객체)
		// 저장할 메모리 공간을 만들 때 => new를 사용한다
		//////////////////////////////// 쓰기(메모리 저장)//////////////////////////////////////
		m1.titleKr="래시 컴 홈(2020)";    // .은 저장할 메모리에 접근
		m1.titleEng="Lassie Come Home, Lassie: Eine Abenteurliche Reise";
		m1.isShow=true;
		m1.score=9.5;
		m1.genre="어드벤처/드라마/가족";
		m1.nation="독일";
		m1.regdate="2021.01.07";
		m1.time=96;
		m1.grade="전체";
		m1.director="하노 올더디센";
		m1.reserve=4;
		m1.totalAudience=936;
		m1.story="영화 역사상 가장 유명한 명견 ‘래시’가 전하는 2021년 새해 첫 감동! \r\n"
				+ "	  서로의 가장 소중한 친구인 12살 소년 플로와 천재견 래시.\r\n"
				+ "	  아버지가 실직해 작은 집으로 이사하자 플로는 더 이상 반려견을 키울 수 없게 되고,\r\n"
				+ "	  래시는 다른 사람의 저택에 맡겨진다.";
		String actor="세바스찬 베젤, 안나 마리아 뮈헤, 니코 마리츠카";
		m1.actor=actor.split(",");  // split는 문자열을 있는 갯수만큼 분리할 수 있음 => String[]
		//////////////////////////////// 읽기 //////////////////////////////////////
		System.out.println("영화명(한글)"+m1.titleKr);
		System.out.println(m1.isShow==true?"상영중":"개봉예정");
		System.out.println("영화명(영문):"+m1.titleEng);
		System.out.println("감독:"+m1.director);
		System.out.print("출연:");
		String s="";
		for(String name:m1.actor)
		{
			s+=name+",";
		}
		// s="세바스찬 베젤, 안나 마리아 뮈헤, 니코 마리츠카,"
		s=s.substring(0,s.lastIndexOf(","));    // 맨 마지막에 있는 ,를 찾아서 제거
		System.out.println(s);
		System.out.println("장르:"+m1.genre);
		System.out.println("등급:"+m1.grade+"관람가");
		System.out.println("국가:"+m1.nation);
		System.out.println("상영시간:"+m1.time+"분");
		System.out.println("예매일:"+m1.reserve+"위");
		System.out.println("누적인원:"+m1.totalAudience+"명");
		System.out.println(m1.story);
	}

}
