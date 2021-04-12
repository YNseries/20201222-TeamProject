package com.sist.lib;
// equals => 객체가 가지고 있는 값만 비교
// == 주소값을 비교(배열, 클래스), 일반데이터는 값을 비교
/*
 *     int a=(int)(Math.random()*100)+1 => 1~100 난수발생     이렇게 일일이 하는 것보다
 *                 ============= 을 double형에서 int형으로 바꿔두면 편하겠지
 *     라이브러리 언제나 외우는 것 아님. 사용자의 편의에 맞게 수정/사용할 수 있어야 함  
 */
class B
{
	String name;
	// String addr;  // 이렇게 있으면 name/addr 중 뭘 비교할지 아무도 모름!
	public B(String name)  // name을 비교해라 라고 되어있어, equals를 재정의해야 주소값이 아닌 네임값을 비교하게 됨.
	{
		this.name=name;
	}
	/* @Override  // 이 재정의 된 비교 지워버리면 equals는 원래대로 주소를 비교함
	public boolean equals(Object obj) {
		//return super.equals(obj);      // 원래 equals의 역할
		if(obj instanceof B)             // 비교할 때는 반드시 equals 재정의해서 써야 함
			return name.equals(((B)obj).name);
		else
			return false;
	} */
	
}
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b1=new B("홍길동");
		B b2=new B("홍길동");  // new 하면 새로 생기는 것. 
		B b3=b1;
		
		if(b1.equals(b2))  // 여기서 equals는 값(네임값)을 비교하는것이 아닌 주소(객체)를 비교하는 것
		// 아예 if(b1.name.equlas(b2.name))이라고 명시하면서 네임값을 비교하게 할 수도 있음
			System.out.println("b1과 b2는 주소값이 같다");
		else
			System.out.println("b1과 b2는 주소값이 다르다");
		
		if(b1==b3)
			System.out.println("b1과 b3는 주소값이 같다");
		else
			System.out.println("b1과 b3는 주소값이 다르다");

	}

}
