package com.sist.main;
// 오버라이딩(재정의)
// 모든 클래스는 Object로부터 상속을 받는다
// 모든 클래스(데이터형)은 Object로 통합해서 사용이 가능
/*
 *      Object o=10;
 *      Object o=10.5;
 *      Object o="Hello";
 *      Object o=true;
 *      Object o=new A();
 *      ===> 자바에서 지원하는 라이브러리는 리턴형이 Object => 필요시마다 형변환을 시킨다
 */
public class MainClass3 {
	// Object가 가지고 있는 메소드를 재정의
	private String name,addr,tel;
	// 시작할 때 사용자로부터 값을 받아서 멤버변수에 초기화(값만 대입할 거니까 getter/setter 필요 없음)
	public MainClass3(String n, String a, String t)// 매개변수가 있는 생성자가 있기 때문에 디폴트 생성자는 추가되지 않는다.
	{
		this.name=n;
		addr=a;
		tel=t;
	}
	public String toString()
	{
		return "이름:"+name+",주소:"+addr+",전화:"+tel;
		// 모든 인스턴스 메소드는 모든 멤버변수, 메소드 호출이 가능
	}
	
	public void display()
	{
		System.out.println("Hello");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object m=new MainClass3("홍길동","서울","010-0000-0000"); // 시작으로 MainClass3대신 상위클래스 Object로 값을 받을 수 있다.
		// double d=10;
		MainClass3 m2=(MainClass3)m;
		// int a=(int)d;
		//상속
		m2.display();
		/* 
		 *    상위클래스로 객체주소를 받는 경우 => 오버라이딩 된 메소드만 호출이 가능
		 */
		String result=m2.toString();
		System.out.println(result);

	}


	/* @Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	} */

}
