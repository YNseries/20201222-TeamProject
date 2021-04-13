package com.sist.server;
// 데이터를 관리(파일=오라클)
/*
 *     배열(객체 배열): 갯수(고정)
 *     => 가변형으로 : 컬렉션 클래스
 *     
 *     Collection
 *          |
 *     ------------
 *     |           |
 *    List        Set    Map     ==> 인터페이스
 *    기준점
 *      List: 순서(인덱스)가 존재, 데이터 중복
 *            => 구현한 클래스: ArrayList, Vector, LinkedList, Stack
 *                          =========
 *      Set: 순서(인덱스)가 없다, 데이터의 중복을 허용하지 않는다
 *           => HashSet(중복없이 데이터를 모아서 List에 저장할 때) ==> 오라클에서 DISTINCT로 쓰는게 편함
 *           
 *      Map: 순서(인덱스)가 없다, => key(중복 불가), value(중복 가능)가 동시에 저장
 *           => 라이브러리로 변경: session, cookie, request, response(웹 프로그램)
 *           => HashMap
 *      ====>
 *      프로그램 => 관련된 데이터끼리 모아서 관리 => 한 개의 이름으로 제어(간결하고, 사용하기 쉽다)
 *               int a=10; int b=20; int c=30;
 *               
 *               // 최댓값
 *               int max=0;
 *               if(max<a)
 *                  max=a;
 *               if(max<b)
 *                  max=b;
 *               if(max<c)
 *                  max=c;
 *               
 *               int[] arr={10,20,30};
 *               제어문 반복문 => 패턴(반복) => 데이터형을 통일
 *                                       =========== 제네릭스
 *               ArrayList, Vector...
 *               ===================== 모든 데이터형 Object <String>
 *               
 */
import java.util.*;
import java.io.*;
import java.util.Scanner;
/*
 *    변수: 데이터 한 개만 저장할 수 있는 공간
 *    배열, 클래스 
 *    클래스 여러개: 컬렉션
 */
public class MovieManager {
	private static ArrayList<MovieVO> list=new ArrayList<MovieVO>();  // 데이터의 제한이 없음
	// MovieVO[]과 비슷함 단, 데이터 저장공간의 제한이 있음 => 고정
	// 프로그램이 시작 => 데이터를 저장 => 초기화 블럭(파일 => 메모리)
	static
	{
		try
		{
			// 파일읽기
			// | 별로 분리 => VO에 담는다
			// VO => list
			FileReader fr=new FileReader("c:\\javaDev\\daum_movie.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1)  // 지금은 한 글자씩 읽어오는데 IO 배우면 한 줄씩 읽어올거야
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			//System.out.println(sb.toString());
			// 영화별로 분리
			String[] movie_data=sb.toString().split("\n");
			/*
			 *   215|
			 *   5|
			 *   밤쉘: 세상을 바꾼 폭탄선언(2019)|
			 *   8.0|
			 *   드라마|
			 *   2020.07.08 |
			 *   109분|
			 *   15세이상관람가|
			 *   제이 로치|
			 *   샤를리즈 테론|
			 *   //img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net
			 *   	%2Fmovie%2F0a3e3e96d51a738c0e45c314899ce6e4793443ea|
			 *   182,026|
			 *   판단은 날카롭게, 외침은 당당하게, 행동은 과감하게! 대선후보 토론회에서 트럼프와 설전을 벌인 
			 *   	폭스뉴스의 간판 앵커 메긴 켈리(샤를리즈 테론)는 트럼프의 계속되는 트위터 공격으로 화제의 중심에 선다. 
			 *   	한편, 동료 앵커인 그레천 칼슨(니콜 키드먼)은 ‘언론 권력의 제왕’이라 불리는 폭스뉴스 회장을 고소하고 
			 *   	이에 메긴은 물론, 야심 있는 폭스의 뉴페이스 케일라 포스피실(마고 로비) 역시 충격을 감추지 못하는데… 
			 *   	최대 권력을 날려버릴 폭탄선언 이제 이들의 통쾌하고 짜릿한 역전극이 시작된다!
			 */
			for(String s:movie_data)
			{
				//System.out.println(s);   // 이제 | 별로 분리해서 VO에 첨부 => 하나씩 ArrayList에 첨부
				StringTokenizer st=new StringTokenizer(s,"|");
				// String[] data=s.split("\\|");   split는 정규식(regex) 형식으로 자른다는 단점이 있음
				//                          = 이미 사용중이기 때문에 \\를 붙여 갖고와야 함
				MovieVO vo=new MovieVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setCno(Integer.parseInt(st.nextToken()));
				/*
				 *     class A
				 *     
				 *     A a=10;                 이렇게는 불가능함. 10이 아닌 주소가 들어가야 해
				 *     A a=(int)new A();       역시 불가능
				 *     
				 *     다만, Wrapper 클래스/Object는 가능하게 되어있음
				 *     Integer i=10;
				 *     Object o=10;
				 *     
				 *     나머진 new를 통해서 갖고와야 함
				 */
				vo.setTitle(st.nextToken());
				vo.setScore(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setTime(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setPoster("http:"+st.nextToken());
				vo.setShowUser(st.nextToken());
				vo.setStory(st.nextToken());
				
				list.add(vo);   // ArrayList에 저장!
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// 전체 목록 출력
	public ArrayList<MovieVO> movieListData(int page)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		int j=10;                   // 10개씩 나눠서 저장
		int pagecnt=(page*10)-10;   // 시작 위치
		// 0~218  (1~219)  == 219
		int totalpage=movieListTotalPage();
		if(page==totalpage)    // 맨 마지막 페이지도 출력하기 위해서 설정
		{
			if(list.size()%10>0)   // 이 조건이 반드시 걸려야 함. 마지막 페이지까지 딱 맞을 수도 있기 때문에 
			{                      // 맞지 않는 가정 하에 진행하기 위함
				j=list.size()%10;    // 219%10 ==> 9
			}
		}
		// for문 => 상상 0번부터 시작해서 돌림
		for(int i=pagecnt;i<pagecnt+j;i++)
		{
			MovieVO vo=list.get(i);
			mList.add(vo);
		}
		return mList;
	}
	
	// 카테고리별 출력(페이지 나누기)
	public ArrayList<MovieVO> movieCategoryData(int page,int cno)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		return mList;
	}
	
	// 상세 보기(영화 정보 하나만 필요)
	public MovieVO movieDetailData(int no)
	{
		MovieVO vo=list.get(no-1);   // 영화는 1부터 시작했지만, 인덱스 번호는 0부터 시작했기 때문에 -1 해 줘야 매칭됨
		// vo: 영화 한 개에 대한 모든 정보를 가지고 있다
		return vo;
	}
	
	// 찾기
	public ArrayList<MovieVO> movieFindData(String title)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		for(MovieVO vo:list)
		{
			// 포함
			// SELECT * FROM movie WHERE title LIKE '%소%'   : 소 가 포함된 타이틀을 달라
			if(vo.getTitle().contains(title))
			{
				mList.add(vo);
			}
		}
		return mList;
	}
	// 총 페이지
	public int movieListTotalPage()
	{
		int total=(int)(Math.ceil(list.size()/10.0));
		return total;
	}
	public int movieCategoryTotalpage(int cno)
	{
		// SELECT CEIL(COUNT(*)/10.0) FROM movie WHERE cno=1  이렇게 오라클에서 써도 해도 됨
		int total=0;
		int count=0;
		for(MovieVO vo:list)
		{
			if(vo.getCno()==cno)
			{
				count++;
			}
		}
		total=(int)(Math.ceil(count/10.0));
		return total;
	}
	public static void main(String[] args) {
		MovieManager m=new MovieManager();   // m => 영화 관련된 기능 다 갖고 있음
		/*String[] category={"","현재상영영화","개봉예정영화","박스오피스(주간)","박스오피스(월간)","박스오피스(연간)"};
		System.out.println("총페이지:"+m.movieListTotalPage());
		for(int i=1;i<=5;i++)
		{
			System.out.println(category[i]+":"+m.movieCategoryTotalpage(i));
		}*/
		
		/*for(MovieVO vo:list)
		{
			System.out.println(vo.getNo()+"|"+vo.getTitle());
		}*/
		Scanner scan=new Scanner(System.in);
		//검색하기
		/*System.out.print("검색어 입력:");
		String find_data=scan.next();
		ArrayList<MovieVO> list=m.movieFindData(find_data);
		System.out.println("검색된 결과:"+list.size());
		for(MovieVO vo:list)
		{
			System.out.println(vo.getNo()+":"+vo.getTitle());
		}*/
		
		/*System.out.print("상세 볼 영화번호 입력(1~219):");
		int no=scan.nextInt();
		MovieVO vo=m.movieDetailData(no);
		System.out.println("번호:"+vo.getNo());
		System.out.println("제목:"+vo.getTitle());
		System.out.println("감독:"+vo.getDirector());
		System.out.println("출연:"+vo.getActor());
		System.out.println("장르:"+vo.getGenre());
		System.out.println("등급:"+vo.getGrade());
		System.out.println("평점:"+vo.getScore());
		System.out.println("시간:"+vo.getTime());
		System.out.println("줄거리:"+vo.getStory());*/
		
		System.out.print("페이지 입력:");
		int page=scan.nextInt();
		ArrayList<MovieVO> list=m.movieListData(page);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getNo()+":"+vo.getTitle());
		}
	}
}
