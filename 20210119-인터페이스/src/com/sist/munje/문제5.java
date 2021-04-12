package com.sist.munje;
// 상속이 있는 경우에 생성자의 매개변수가 동일해야 함
class A {
	private int a;
	public A() {} // <= 이부분
	protected A(int i) { a = i; }
}
class B extends A {
	private int b;
	public B() { b = 0; }
}

public class 문제5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
