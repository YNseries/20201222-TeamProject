/*
 *    ���
 *     => ������ Ŭ������ ��� ��ɰ� �����͸� �޾Ƽ� Ȯ���ϴ� Ŭ������ ����� ��
 *     => ����� ����
 *        ========
 *        class A
 *        class B extends A
 *             ===       ===
 *           ����� ����   ����� ������ Ŭ����
 *     => �ڹٿ��� ����� ����: ���� ���. �׻� �ϳ��� ���� �� �ִ�
 *                        �� -> �� �� -> �� �� ��
 *     => ����: �ִ� �׷��� ���(����Ŭ����)
 *              �����ؼ� ���(���) 
 *     => ����
 *        extends
 *        
 *        class A
 *        class B extends A
 *        *** ����� �޴� ���(�⺻�� ��ӳ����� Ŭ������ ��� ���� �޾ƿ´�)
 *            ��, ���� ����(static����/static�޼ҵ�, �����ڴ� ��ӿ��� ����)
 *                      ===================== ��ӹ޴� Ŭ������ ��� ����
 *                          �������� ���� ����
 *                       private�� ����� �������µ�, ����� �Ұ���(private ��� protected ���°� ����)
 *     => �ߺ��� ������ �� 
 *     
 *     class A
 *     {
 *        int a=10;
 *        int b=20;
 *        public void display()
 *        {
 *        }
 *     }
 *     
 *     class B extends A
 *     {
 *        ======================= �ڵ����� �ʾƵ� �ڵ����� (������ �Ⱥ�������)���Ե�/���⼭ �ٲ㵵 �� �ڵ�� ���� �ȵ�(�������̵�)
 *        int a=100;
 *        int b=200;
 *        public void display()
 *        {
 *        }
 *        =======================
 *        public void bbb()
 *        {
 *        }
 *     }
 *     B ==> a,b,display(), bbb()
 *     
 *     Ŭ������ ũ�� �� => ����� ������ Ŭ������ ũ��(���)
 *     ����
 *      |
 *      ��� (���, ����)
 *     
 */
class SuperClass
{
	int a=10;
	int b=20;
	
}
public class SubClass {
	// int a=10;
	// int b=20;
	// ����Ŭ����
	SuperClass sc=new SuperClass();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass s=new SubClass();
		System.out.println(s.sc.a);
		System.out.println(s.sc.b);

	}

}
