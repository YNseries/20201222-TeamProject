package com.sist.util;
/*
 *    java.lang.*
 *    ===========
 *      Object, String, StringBuffer, Wrapper, Math
 *      => final 클래스(상속을 받아서 오버라이딩이 불가능)
 *    java.util.*
 *      = 문자열 분리: StringTokenizer(split 대체해서 사용)
 *      = 날짜 관리: Date, Calendar
 *      = 난수 관리: Random => nextInt(10)
 *      = 자료 구조: Collection
 *                =========== List, Set, Map(interface) => 웹 핵심
 *    java.sql.* : 오라클 연동
 *      = Connection: 연결
 *      = Statement: SQL문장 전송
 *      = ResultSet: 결과값을 읽어온다
 *    java.io.*
 *    java.net.*
 *      = URL
 *      = URLEncoder
 *    =================================================
 *    웹: javax~ (Servlet => JSP => Struts => Spring)
 *               =======    ====             ======= Maven
 *        Request, Response, Session, Cookie => Network
 */
import java.util.*;   // * 은 모든 클래스
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();  // 일반클래스
		//int data=r.nextInt(100)+1;   // int 범위, 항상 양수가 들어가야 함. 숫자를 넣지 않으면, int범위 내의 모든 수가 나옴(음수포함)
		// 0~99 + 1 => 1~100 발생
		//System.out.println(data);
		int[] arr=new int[100];
		for(int i=0;i<100;i++)
		{
			arr[i]=r.nextInt(10);
		}
		
		// 출력
		for(int i=0;i<100;i++)
		{
			if(i%10==0 && i!=0)
			{
				System.out.println();
			}
			System.out.print(arr[i]);
		}
	}

}
