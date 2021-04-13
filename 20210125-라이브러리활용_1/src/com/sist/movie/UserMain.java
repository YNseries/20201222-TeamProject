package com.sist.movie;
import java.util.Scanner;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 영화정보를 볼 페이지를 입력
		int totalpage=MovieManager.movieTotalPage();
		
		int page=1;
		// 페이지가 정상으로 입력되었는지 오류 체크
		while(true)
		{
			System.out.println("영화 목록을 볼 페이지 지정(1~"+totalpage+"):");
			String s=scan.next();  // 입력될 페이지
			page=Integer.parseInt(s);   // 문자열을 정수형으로 변경 => 문자열 변경 => String.valueOf()
			if(page<1 || page>totalpage)
			{
				System.out.println("존재하지 않는 페이지입니다!!");
				continue;
			}
			break;			
		}
		System.out.println("=========현재 보고있는 페이지는 "+page+"페이지 입니다=========");
		MovieVO[] movie=MovieManager.movieListData(page);
		for(MovieVO vo:movie)
		{
			if(vo==null) break;  // 오류처리
			System.out.println("영화번호:"+vo.getMno());
			System.out.println("영화명:"+vo.getTitle());
			//System.out.println("장르:"+vo.getGenre());
			//System.out.println("감독:"+vo.getDirector());
			//System.out.println("출연:"+vo.getActor());
			//System.out.println("등급:"+vo.getGrade());
			//System.out.println("개봉일:"+vo.getRegdate());
			System.out.println("====================================================");
		}
		System.out.print("상세히 볼 영화 번호를 입력:");
		int detail_no=scan.nextInt();
		MovieVO vo=MovieManager.movieDetailData(detail_no);
		System.out.println("=================="+vo.getTitle()+" 상세보기=================");
		System.out.println("영화번호:"+vo.getMno());
		System.out.println("영화명:"+vo.getTitle());
		System.out.println("장르:"+vo.getGenre());
		System.out.println("감독:"+vo.getDirector());
		System.out.println("출연:"+vo.getActor());
		System.out.println("등급:"+vo.getGrade());
		System.out.println("개봉일:"+vo.getRegdate());
		System.out.println("==========================================================");
		System.out.print("출연자 이름을 입력:");
		String name=scan.next();
		String[] title=MovieManager.movieFindData(name.trim());
		for(String t:title)
		{
			System.out.println(t);
		}
		System.out.println("==========================================================");
		System.out.print("영화명 입력:");
		String str=scan.next();
		title=MovieManager.findTitleData(str.trim());   // trim()은 좌우의 공백문자 제거
		for(String t:title)
		{
			System.out.println(t);
			try
			{
				Thread.sleep(100);   // Check Exception => 잠시 멈춤 
			}catch(Exception ex) {}
		}
	}

}
