package com.sist.main;
/*
 *    예외처리
 *      => 직접처리 => 복구(try~catch)
 *         try{실행문장} => 에러발생 => catch{복구}
 *         => Exception(전체 예외처리), Throwable(전체 예외+에러)
 *            예외: 수정이 가능한 에러
 *            에러: 수정이 불가능한 에러
 *            ===================
 *            1. 컴파일 에러(javac): 에러가 발생하는게 문법상 문제. 찾기 쉬움
 *               = 변수명이 틀리거나, 메소드를 호출했는데 대소문자가 틀렸거나
 *            2. 실행시 에러(java)
 *               = 웹, 네트워크 에러잡기 어려워 => 모든 것이 문자열로 이뤄짐
 *               String sql="SELECT * FROM 테이블명";  // 테이블(파일)명을 주지 않아서 오라클에서는 오류남
 *               FileReader fr= new FileReader("c:\\");   // 파일명을 주지 않아서 실행 과정에서 오류남. but 컴파일 상에선 오류 아님
 *      
 *      *****=> 간접처리 => 자바 시스템(JVM)에 에러발생을 알려주고 떠맡긴다
 *                   throws => 메소드 뒤에서 선언
 *                   => 라이브러리에서 주로 프로그래머에게 떠맡긴다 (pass)
 *      => 임의발생: 사용자 정의 예외를 만들어서 호출할 때 주로 사용(웹에선 거의 본 적 없음)
 *                
 *                1) 메소드 호출
 *                   메소드명(값)
 *                2) 생성자 호출
 *                   new 생성자()
 *                3) 예외처리 호출
 *                   throw new 예외처리명()
 */
import java.io.*;
public class MainClass {
	public void aaa()
	{
	
	}
	public void bbb()
	{
	
	}
	public void ccc()
	{
	
	}
	public void ddd()
	{
	
	}
	public void eee()
	{
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass m=new MainClass();
		m.aaa();
		m.bbb();
		//Thread.sleep(100);

	}

}
