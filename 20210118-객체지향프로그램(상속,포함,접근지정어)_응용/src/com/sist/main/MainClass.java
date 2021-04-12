package com.sist.main;
// 다른 패키지에 있는 클래스 읽기 => 자바에서 제공하는 라이브러리, 사용자정의
import com.sist.manager.*;
/*
 *     public String[] aaa() {}
 *     
 *     => String[] a=aaa();
 *     
 *     int[] a={10,20,30}
 *     int[] b=a;
 *     
 *     int a=10;
 *     int b=a;
 *     
 *     A a=new A();
 *     A b=a;
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieManager m=new MovieManager();
		MovieVO[] movie=m.movieAllData();
		// 출력
		System.out.println("=========== 영화 목록 ==========");
		for(MovieVO vo:movie)
		{
			//System.out.println("순위:"+vo.getMno());
        	System.out.println("영화명:"+vo.getTitle());
        	System.out.println("감독명:"+vo.getDirector());
        	System.out.println("출연:"+vo.getActor());
        	System.out.println("등급:"+vo.getGrade());
        	System.out.println("줄거리:"+vo.getStory());
        	System.out.println("===========================================");
		}

	}

}
