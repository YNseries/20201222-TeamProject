package com.sist.main;
/*
 *    라이브러리 (API): 변경할 수 없다, Framework: 변경이 가능
 *    =============
 *       java.lang.*;   : import에서 생략이 가능 => 자바에서 가장 기본적(자주)으로 사용되는 클래스이기 때문
 *         = Object
 *         ***= String
 *         = StringBuffer / StringBuilder
 *         = Math
 *         ***= Wrapper(기본형 데이터형 => 클래스형으로 변경)
 *         = System
 *       java.util.*;
 *         = Date, Calendar
 *         = StringTokenizer
 *         = Scanner   // 1권
 *         ***= Collection   // 배열 대신에 씀.
 *                List, Set, Map
 *         = Arrays
 *       java.io.*;
 *       java.net.*;
 *       java.text.*;
 *       java.sql.*;
 *       ===============
 *       java.lang.*;
 *       =============================
 *       Object: 모든 클래스의 조상 클래스
 *       기능(메소드): ** clone(): 메모리 복제
 *                  finalized(): 소멸자    A() ~A()
 *                  toString(): 객체를 문자열로 변환 => 주소
 *                  ** equals(): 객체 비교
 *                => 모든 클래스를 한개로 모아서 관리(Object: 모든 데이터형을 소화할 수 있다)
 *       
 *       
 *       javax.http.servlet..*; => WEB
 *       
 *       org.springframework.*;
 */ 
/*
 *    객체 생명 주기
 *    
 *    => 생성(메모리 저장) ===> 기능 활용(메소드 호출) ===> 메모리 해제
 *       new A()            a.display()           a=null;   ==> GC
 */
class A
{
	public A()
	{
		System.out.println("A객체 생성...");
	}
	public void display()
	{
		System.out.println("A객체 활용...");
	}
	@Override
	protected void finalize() throws Throwable {
		// 객체가 소멸될 때 자동 호출된다
		System.out.println("A객체 소멸...");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();  // 원래는 주소를 출력하지만
		return "Hello";  // Hello를 출력하게 만들면
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		System.out.println(a.toString());   // 주소값 출력
		System.out.println(a);  // 객체를 출력하면 자동으로 toString 호출(뒤에 toString이 붙어있지만 생략)
		a.display();
		a=null;
		System.gc();   // 멀티미디어 => 소멸자 메소드를 호출할 때 주로 사용
		    // garbage collection. 반응이 느리기 때문에 일부러 빨리 해 줘야 결과 볼 수 있음
	}  

}
