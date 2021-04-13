package com.sist.main;

import java.util.HashMap;

// ���õ� Ŭ������ ��� �� ���� �̸����� ����
interface I
{
	public void display();
}
class A implements I
{
	public void display() {
		System.out.println("A:display Call...");
	}
}
class B implements I
{
	public void display() {
		System.out.println("B:display Call...");
	}
}
class C implements I
{
	public void display() {
		System.out.println("C:display Call...");
	}
}
class Container
{
	HashMap map=new HashMap();
	public Container()
	{
		// Ŭ���� ����
		map.put("a", new A());    // �޸� �Ҵ� �� �� �ϰ� ��� �ҷ��� �� ����(���� ����) �޸� ����
		map.put("b", new B());
		map.put("c", new C());
	}
	public I getBean(String key)
	{
		return(I)map.get(key);
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container con=new Container();
		I i=con.getBean("a");
		System.out.println("i="+i);
		i.display();
		
		i=con.getBean("b");
		System.out.println("i="+i);
		i.display();
		
		i=con.getBean("c");
		System.out.println("i="+i);
		i.display();
		
		i=con.getBean("a");
		System.out.println("i="+i);
		i.display();

	}

}
