package com.sist.anno;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("ȭ�� ����:");
		String page=scan.next();
		MovieSystem ms=new MovieSystem();
		ms.movie(page);
		
		//@RequestMapping("Ȩ")
		/*MovieManager m=new MovieManager();
		if(page.equals("Ȩ"))
		{
			m.movieHome();
		}
		else if(page.equals("���"))
		{
			m.movieList();
		}
		else if(page.equals("��"))
		{
			m.movieDetail();
		}
		else if(page.equals("����"))
		{
			m.movieReserve();
		}
		else if(page.equals("ã��"))
		{
			m.movieFind();
		}*/
		
	}

}
