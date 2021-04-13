package com.sist.anno;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("화면 선택:");
		String page=scan.next();
		MovieSystem ms=new MovieSystem();
		ms.movie(page);
		
		//@RequestMapping("홈")
		/*MovieManager m=new MovieManager();
		if(page.equals("홈"))
		{
			m.movieHome();
		}
		else if(page.equals("목록"))
		{
			m.movieList();
		}
		else if(page.equals("상세"))
		{
			m.movieDetail();
		}
		else if(page.equals("예매"))
		{
			m.movieReserve();
		}
		else if(page.equals("찾기"))
		{
			m.movieFind();
		}*/
		
	}

}
