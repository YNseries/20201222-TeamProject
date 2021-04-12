package com.sist.lib;
/*
 *    toString(): 객체를 문자열로 변환
 *                (String) => 형변환
 */
// new A();  ==> a
class A // (extends Object)가 자동으로 생성/생략되어 있음
{
	int a=100;
	// toString, clone, equals
	/*static int b=30;
	public A() {
		// this. => 멤버에만 존재. static엔 X(static은 본인것이 아닌 공통으로 사용되기 때문)
	}*/
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 원래는 이건데 return super.toString();
		return "Hello~~";  // toString() 역할 대신 그 위치에 Hello~~가 출력됨
	}

	
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		A b=new A();
		System.out.println("a="+a);  // 보이진 않지만, toString()을 자동호출
		System.out.println("a="+a.toString());
		
		System.out.println("b="+b);
		System.out.println("b="+b.toString());
	}

}
