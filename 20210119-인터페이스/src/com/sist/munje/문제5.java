package com.sist.munje;
// ����� �ִ� ��쿡 �������� �Ű������� �����ؾ� ��
class A {
	private int a;
	public A() {} // <= �̺κ�
	protected A(int i) { a = i; }
}
class B extends A {
	private int b;
	public B() { b = 0; }
}

public class ����5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
