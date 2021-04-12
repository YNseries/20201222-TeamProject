package com.sist.string;
/*
 *    ***trim(): 좌우에 있는 모든! 공백을 제거
 *            예) "Hello Java ".trim()  ==>  "Hello Java"
 *            사용) 검색어, 로그인처리, 아이디중복, 게시판 비밀번호
 *    리턴형: String
 *    매개변수: 없음
 *    원형: public String trim()
 *    
 *    ***valueOf(): 모든 데이터형을 문자열로 변환할 때 사용 = 오버로딩
 *               100 => "100"
 *               true => "true"
 *    리턴형: String    
 *    매개변수: valueOf(char c)
 *           valueOf(int i)
 *           valueOf(long l)
 *           valueOf(float f)
 *           valueOf(double d)
 *           valueOf(boolean b)
 *           valueOf(Object o)
 *    원형: public static String valueOf(데이터형)
 *               ========
 *    100 => int a=100;
 *           String s=(String)a;  (X)
 *           a.toString()  (X)
 *           String.valueOf(a);
 *    String s="Hello Java";
 *    String s1="Oracle";
 *    substring(0,3)
 *    
 *    Web, Window => String
 */
public class MainClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="           Hello Java ";
		System.out.println(msg);
		System.out.println(msg.length());  // 공백도 문자!
		
		String msg2=msg.trim();  // 하나의 공백만 지우는 게 아님
		System.out.println(msg2);
		System.out.println(msg2.length());  // 10
		
		int a=100;
		int b=200;
		String s=String.valueOf(a);  // s="100"
		String s1=String.valueOf(b); // s1="200"
		String s2=String.valueOf(true); // s2="true"
		String s3=String.valueOf(10.5); // s3=10.5
		

	}

}
