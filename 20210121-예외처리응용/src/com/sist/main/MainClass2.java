package com.sist.main;
/*
 *    ���̺귯�� (API): ������ �� ����, Framework: ������ ����
 *    =============
 *       java.lang.*;   : import���� ������ ���� => �ڹٿ��� ���� �⺻��(����)���� ���Ǵ� Ŭ�����̱� ����
 *         = Object
 *         ***= String
 *         = StringBuffer / StringBuilder
 *         = Math
 *         ***= Wrapper(�⺻�� �������� => Ŭ���������� ����)
 *         = System
 *       java.util.*;
 *         = Date, Calendar
 *         = StringTokenizer
 *         = Scanner   // 1��
 *         ***= Collection   // �迭 ��ſ� ��.
 *                List, Set, Map
 *         = Arrays
 *       java.io.*;
 *       java.net.*;
 *       java.text.*;
 *       java.sql.*;
 *       ===============
 *       java.lang.*;
 *       =============================
 *       Object: ��� Ŭ������ ���� Ŭ����
 *       ���(�޼ҵ�): ** clone(): �޸� ����
 *                  finalized(): �Ҹ���    A() ~A()
 *                  toString(): ��ü�� ���ڿ��� ��ȯ => �ּ�
 *                  ** equals(): ��ü ��
 *                => ��� Ŭ������ �Ѱ��� ��Ƽ� ����(Object: ��� ���������� ��ȭ�� �� �ִ�)
 *       
 *       
 *       javax.http.servlet..*; => WEB
 *       
 *       org.springframework.*;
 */ 
/*
 *    ��ü ���� �ֱ�
 *    
 *    => ����(�޸� ����) ===> ��� Ȱ��(�޼ҵ� ȣ��) ===> �޸� ����
 *       new A()            a.display()           a=null;   ==> GC
 */
class A
{
	public A()
	{
		System.out.println("A��ü ����...");
	}
	public void display()
	{
		System.out.println("A��ü Ȱ��...");
	}
	@Override
	protected void finalize() throws Throwable {
		// ��ü�� �Ҹ�� �� �ڵ� ȣ��ȴ�
		System.out.println("A��ü �Ҹ�...");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();  // ������ �ּҸ� ���������
		return "Hello";  // Hello�� ����ϰ� �����
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		System.out.println(a.toString());   // �ּҰ� ���
		System.out.println(a);  // ��ü�� ����ϸ� �ڵ����� toString ȣ��(�ڿ� toString�� �پ������� ����)
		a.display();
		a=null;
		System.gc();   // ��Ƽ�̵�� => �Ҹ��� �޼ҵ带 ȣ���� �� �ַ� ���
		    // garbage collection. ������ ������ ������ �Ϻη� ���� �� ��� ��� �� �� ����
	}  

}
