/*
 *    �����Ϸ��� �ڵ����� ÷��
 *    1. import java.lang.*;
 *              =========== String, System, Math.... �� �ڵ����� ÷��
 *    2. �޼ҵ� => void�� �� compiler�� �ڵ����� return ÷��
 *    3. ��� Ŭ������ �����ڸ� ������ �ִ�
 *       ���� ��쿡 ����Ʈ �����ڸ� ÷��
 *    4. ��� Ŭ���� ����(�ڹ��� ��� Ŭ������ Object ����� �޴´�)
 *       class A extends Object
 *               ==============
 *    5. ��� Ŭ������ ����ó���� ������ �ִ�: ������ �� �ִ� �κ�..
 *    �ڹ�
 *    ����Ŭ
 *    HTML / CSS => ������(bootstrap) => JavaScript (JQuery, Ajax)
 *    JSP
 *    Spring => XML, Anntation => MyBatis
 *    ���̽�
 */
// Super => a,display(),Object
class Super
{
	protected int a=10;  // a�� private�� �� ������ ��� �Ұ����ϱ� ������ protected�� �־���� �� / protected �����
	// ����� �ƴ϶� => �������� ����� �� �ְ� �Ѵ�
	public static int c=20;
	public void display()
	{
		System.out.println("Super:display() Call...");
	}
	public void display1()
	{
		System.out.println("Sub:display1() Call..");
	}
	public void display2()
	{
		System.out.println("Sub:display2() Call..");
	}
	// ����
	public Super()
	{
		System.out.println("Super: �������Լ�()...");
	}
}
// Sub => display(), Object
class Sub extends Super
{
	/* 
	 * 	protected int a=10;
	 * 	public void display()
	 * 	{
	 * 		System.out.println("Super:display() Call...")
	 * 	}
	 * 	public void display1()
		{
			System.out.println("Sub:display1() Call..");
		}
		public void display2()
		{
			System.out.println("Sub:display2() Call..");
		}
	 */
	private int b=10;  // private ���� �׸�
	public Sub()  // public �ʷϻ�
	{
		System.out.println("Sub: ������ () Call...");
	}
	// �������̵�: ��� �Ŀ� ����
	/*
	 *    �������̵�(������): �޼ҵ��� ���� ���� ===> ������ ����: ���, �޼ҵ��, ������, �Ű�����
	 *      1) ����� �޴´� 
	 *      2) �޼ҵ���� ����
	 *      3) �Ű������� ����
	 *      4) �������� ����
	 *      5) Ȯ���� ����, ��Ҵ� �Ұ��� �ڡڡ� : ���������� / �� �𸣰����� public ���� ��
	 *         private < default < protected < public
	 *                   =======
	 */
	public void display()
	{
		System.out.println("Sub:display() Call..");
	}
	public void display2()
	{
		System.out.println("Sub:display2() Call..");
	}

}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s=new Sub();
		Sub sub=new Sub();
		sub.display();
		// sub.a=100;
		System.out.println("sub.a="+sub.a);  // �Ѱܹ��� �� Ȯ��
		sub.a=100;
		System.out.println("sub.a="+sub.a);  //
		sub.display1();
		sub.display2();
		s.display();

	}

}
