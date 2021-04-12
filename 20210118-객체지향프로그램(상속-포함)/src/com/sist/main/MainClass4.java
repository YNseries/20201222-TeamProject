package com.sist.main;
class Sawon
{
	private int sabun;
	private String name;
	private String dept;
	/*
	 *    Object(메소드: clone, equals, finalize(), hashCode, toString)
	 *       |
	 *    Sawon
	 */
	// 생성자
	public Sawon(int sabun,String name, String dept)
	{
		this.sabun=sabun;
		this.name=name;
		this.dept=dept;
	}
	// 재정의
	public String toString()
	{
		return "사번:"+sabun+",이름:"+name+",부서:"+dept;
	}
}
/*
 *    Object
 *       |
 *    Human => clone,equals,finalize(),hashCode,toStirng
 *    
 *    Object
 *       |
 *     게시판
 *    
 *     게시판       게시판        게시판       게시판  => 상위클래스로 모든 클래스를 제어할 수 있다
 *       |         |            |          |      =======의 메소드를 반드시 재정의(오버라이딩) 해야 호출 가능
 *     댓글게시판   갤러리게시판    답변형게시판     자료실
 *     (댓글추가)	 (이미지추가)    (답변)    (업로드/다운로드) 
 */ 
class Human
{
	private String name;
	private String sex;
	public Human(String name, String sex)
	{
		this.name=name;
		this.sex=sex;
	}
	/*
	 *    상속 => 메소드를 정의를 변경 (오버라이딩)
	 *    ==================================
	 *    
	 *    class A extends Object
	 *    {
	 *    }
	 *    class B extends A  => A,Object
	 */
	public String toString()
	{
		return "이름:"+name+",성별:"+sex;
	}
	/*
	 * public void toString(int a) {
	 * 
	 * }
	 */
}
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Sawon s=new Sawon(1,"홍길동","개발부");
		String res=s.toString();
		System.out.println(res);
		Human h=new Human("심청이","여자");
		res=h.toString();
		System.out.println(res); */
		Object o=new Sawon(1,"홍길동","개발부");
		String res=o.toString();
		System.out.println(res);
		
		o=new Human("심청이","여자");
		res=o.toString();
		System.out.println(res);
	}

}
