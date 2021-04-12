package com.sist.main;
/*
 *    1. 기본 데이터형: 자바에서 지원하는 메모리 크기
 *       정수: int, long
 *       실수: double
 *       문자: char
 *       논리: boolean
 *       문자열: String
 *       ============== 외에는 프로그래머가 직접 만들어서 사용 => class(사용자 정의 데이터형)
 *                      클래스: 1) 변수(다른 데이터형) 2) 메소드를 저장
 *                      ==== 관련된 데이터 + 관련된 메소드(하나로 모아서 관리)
 *       영화   Movie => Movie[]
 *       뮤직   Music
 *       게시판  Board
 *       회원   Member
 *       상품   Product
 *       ==============
 *       int a=10;
 *       A a=new A();   // 주소를 저장하고 값을 쓸 수 있게 함.
 *          = 메모리의 주소(접근 .)
 *    2. 다른 클래스에서 데이터에 접근해서 사용을 할 수 없게 만든다(데이터를 은닉화 private) => 메소드를 통해 접근
 *          => 캡슐화(다른 클래스에서 이용 => 변질) => getter/setter
 *    3. 중복제거, 재사용
 *       1) 중복제거: 소스를 간결하게 함
 *          = 반복문
 *          = 메소드
 *          = 상속 => 기능 추가(변경시에 전체 상속받은 모든 클래스를 변경. 상속받은 클래스에서 변경하면 오류) 
 *                => 때문에 인터페이스(스프링 기반)를 선호
 *          class A
 *          {
 *             a(){}
 *             b(){}
 *             c(){}
 *          }
 *          class B extends A
 *          {
 *             a(){}
 *             b(){}
 *             c(){}
 *             d(){}   // 상속받는 클래스에 추가하면 x
 *          }
 *          
 *          A aa=new B();   => aa.a(), aa.b(), aa.c() 까지 가능하지만 aa.d()는 작동안됨. 오류남
 *          B bb=new B();
 *    
 */

public class 자바정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
