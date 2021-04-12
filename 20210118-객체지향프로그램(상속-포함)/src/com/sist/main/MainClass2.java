package com.sist.main;
// this() 메소드 => 자신의 생성자를 호출할 때 사용
class Member
{
	private int no;         // 0
	private String name;    // null
	private String sex;     // null
	
	public Member()
	{
		sex="남자";  // this.sex(지역변수, 매개변수에 존재하지 않는 경우, this를 생략할 수 있다)
		// 지역변수(매개변수) => 멤버변수 순으로 찾는다
	}
	public Member(int no, String name)
	{
		this();  // 자신의 생성자 호출이 가능하다
		this.no=no;
		this.name=name;
		// this(1,"")
	}
	public Member(int no,String name,String sex)
	{
		// this(1,"","")
		this.no=no;
		this.name=name;
		this.sex=sex;
	}
	public void print()
	{
		System.out.println("번호:"+no);
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1=new Member();
		m1.print();
		Member m2=new Member(1,"홍길동");
		m2.print();
		Member m3=new Member(1,"심청이","여자");
		m3.print();
		

	}

}
