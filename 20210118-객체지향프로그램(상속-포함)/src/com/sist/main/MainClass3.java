package com.sist.main;
// �������̵�(������)
// ��� Ŭ������ Object�κ��� ����� �޴´�
// ��� Ŭ����(��������)�� Object�� �����ؼ� ����� ����
/*
 *      Object o=10;
 *      Object o=10.5;
 *      Object o="Hello";
 *      Object o=true;
 *      Object o=new A();
 *      ===> �ڹٿ��� �����ϴ� ���̺귯���� �������� Object => �ʿ�ø��� ����ȯ�� ��Ų��
 */
public class MainClass3 {
	// Object�� ������ �ִ� �޼ҵ带 ������
	private String name,addr,tel;
	// ������ �� ����ڷκ��� ���� �޾Ƽ� ��������� �ʱ�ȭ(���� ������ �Ŵϱ� getter/setter �ʿ� ����)
	public MainClass3(String n, String a, String t)// �Ű������� �ִ� �����ڰ� �ֱ� ������ ����Ʈ �����ڴ� �߰����� �ʴ´�.
	{
		this.name=n;
		addr=a;
		tel=t;
	}
	public String toString()
	{
		return "�̸�:"+name+",�ּ�:"+addr+",��ȭ:"+tel;
		// ��� �ν��Ͻ� �޼ҵ�� ��� �������, �޼ҵ� ȣ���� ����
	}
	
	public void display()
	{
		System.out.println("Hello");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object m=new MainClass3("ȫ�浿","����","010-0000-0000"); // �������� MainClass3��� ����Ŭ���� Object�� ���� ���� �� �ִ�.
		// double d=10;
		MainClass3 m2=(MainClass3)m;
		// int a=(int)d;
		//���
		m2.display();
		/* 
		 *    ����Ŭ������ ��ü�ּҸ� �޴� ��� => �������̵� �� �޼ҵ常 ȣ���� ����
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
