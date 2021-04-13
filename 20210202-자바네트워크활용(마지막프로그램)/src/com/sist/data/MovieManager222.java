package com.sist.data;
import java.io.*;
import java.util.*;
public class MovieManager222 {
	private static ArrayList<MovieVO> list=new ArrayList<MovieVO>();
	static
	{
		try
		{
			// 파일 읽기
			FileInputStream fis=new FileInputStream("c:\\download\\movie.txt");
			// 객체단위로 반경: 역직렬화
			ObjectInputStream oos=new ObjectInputStream(fis);
			// ArrayList에 값을 채워준다
			list=(ArrayList<MovieVO>)oos.readObject();  // 갖고 오는건 쉬움
			oos.close();
		}catch(Exception ex) {}
	}
	// 기능 => 메소드
	// 1. 전체 목록 출력 => 페이지 나누기 (모이면 Array)
	/*
	 *    윈도우창 => 사용자 요청 => 2페이지 보여달라 => MovieManager 처리 => 결과값을 윈도우로 보냄
	 *      웹(브라우저)도 같은 순서(코딩 형식)
	 */
	public ArrayList<MovieVO> movieListData(int page)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		int rowSize=20;
		int start=(page*rowSize)-rowSize;  // start 시작 위치(20개씩 나눴기 때문에 루프 돌릴 때 좋음)
		/*         start ~ rowSize
		 *    1 page  0  ~ 19
		 *    2 page 20  ~ 39
		 *    
		 *    11page 200 ~ 219 => 218
		 */
		int total=movieTotalPage();
		if(page==total)
		{
			rowSize=list.size()%20;     // 데이터 총 갯수%20 해야 함. 마지막 페이지를 제대로 하기 위함
			// 219%20
			// 11%20 ==> 11
		}
		for(int i=start;i<=start+rowSize;i++)
		{
			MovieVO vo=list.get(i);
			mList.add(vo);
		}
		return mList;
	}
	//  1-1. 총 페이지 구하기
	public int movieTotalPage()
	{
		return (int)(Math.ceil(list.size()/20.0));   // 219/20 = 11
		// ceil: 올림 메소드 => 소수점 이하가 1 이상이면 올림
		// random(), ceil()
	}
	// 2. 카테고리별 출력 => 페이지 나누기
	// 3. 검색: 제목별  => 페이지 나누기
	// 4. 검색: 장르별  => 페이지 나누기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieManager222 m=new MovieManager222();
		ArrayList<MovieVO> list=m.movieListData(11);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println("===================================");
		}
		/*for(MovieVO vo:list)
		{
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println(vo.getDirector());
			System.out.println(vo.getActor());
			System.out.println("===================================");
		}*/
		/*Scanner scan=new Scanner(System.in);
		String[] menu= {
				"1. 현재 상영 영화", 
				"2. 개봉 예정 영화", 
				"3. 박스오피스(주간)", 
				"4. 박스오피스(월간)", 
				"5. 박스오피스(연간)"
		};
		System.out.println("=========== 메뉴 ============");
		for(String s:menu)
		{
			System.out.println(s);
		}
		System.out.println("============================");
		System.out.print("메뉴를 선택하세요");
		int index=scan.nextInt();
		for(MovieVO vo:list)
		{
			if(vo.getCno()==index)
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getTitle());
				System.out.println(vo.getDirector());
				System.out.println(vo.getActor());
				System.out.println("============================");
			}
		}
		System.out.print("장르 입력:");
		String genre=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getGenre().contains(genre))     
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getTitle());
				System.out.println(vo.getDirector());
				System.out.println(vo.getActor());
				System.out.println("============================");
			}
		}
		System.out.print("영화 제목 입력:");
		String title=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getTitle().contains(title))     
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getTitle());
				System.out.println(vo.getDirector());
				System.out.println(vo.getActor());
				System.out.println("============================");
			}
		}
		System.out.print("1~219 번호를 선택:");
		int detail=scan.nextInt();
		MovieVO vo=list.get(detail-1);  // 영화번호는 1번부터 시작하고, 인덱스는 0부터 시작해서
		System.out.println(vo.getMno());
		System.out.println(vo.getTitle());
		System.out.println(vo.getDirector());
		System.out.println(vo.getActor());
		System.out.println(vo.getTime());
		System.out.println(vo.getGrade());
		System.out.println(vo.getRegdate());
		System.out.println(vo.getScore());*/
	}

}
