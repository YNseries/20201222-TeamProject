package com.sist.munje;
/*
 * 다음 코드를 객체 지향 프로그래밍 관점에서 바람직한 코드로 수정하라.
                 ================= 캡슐화, 상속, 다형성
변수: private  /  메소드: public(getter/setter): 캡슐화 방식

class Power {private int kick;  private int punch;
   public void setKick(int kick)
   {
       this.kick=kick;
   }
   public int getKick()
   {
       return kick;
   {}public class Example {public static void main (String args[]) 
   { Power robot = new Power();
		robot.setKick = 10;
		robot.setPunch= 20;
	}
}
 */
// page 348 캡슐화
/*
 *   변수에 대한 초기화
 *   1) 메소드를 이용하는 방식 => getter, setter
 *   2)
 *   3) 초기화블록: 다른 클래스에서 값을 입력받지 못한다
 */
class Power{
	private int kick;
	private int punch;
	public void setKick(int kick)
	{
		this.kick=kick;
		
	}
	public int getKick()
	{
		return kick;
	}
	public void getPunch()
	{
		
	}
	public void setPunch(int punch) {
		this.punch=punch;
	}
}
/*
 *    객체 지향(데이터 보호)
 *    1. 변수 => private
 *    2. 변수를 이용할 때 => 메소드,생성자(public)
 */
public class 문제1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power p1=new Power(10,20);
		Power p2=new Power();
		p2.setKick(10);
		p2.setPunch(20;)

	}

}
