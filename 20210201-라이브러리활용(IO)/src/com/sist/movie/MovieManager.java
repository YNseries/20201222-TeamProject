package com.sist.movie;
import java.io.*;
import java.util.*;
public class MovieManager {
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
	// 1. 전체 목록 출력 => 페이지 나누기
	// 2. 카테고리별 출력 => 페이지 나누기
	// 3. 검색: 제목별  => 페이지 나누기
	// 4. 검색: 장르별  => 페이지 나누기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(MovieVO vo:list)
		{
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println(vo.getDirector());
			System.out.println(vo.getActor());
			System.out.println("===================================");
		}*/
		Scanner scan=new Scanner(System.in);
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
		System.out.println(vo.getScore());
	}

}
