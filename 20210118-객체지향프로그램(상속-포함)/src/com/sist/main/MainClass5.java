package com.sist.main;
/*
 *    ������(page 344)
 *    ==============
 *    ���������� public, protected, default, private
 *    Ŭ����
 *    ====
 *      Ŭ����: public, default
 *      �������: public, protected, default, private
 *      =======================================================
 *      �޼ҵ�: public(������ ���), protected, default, private
 *      ������: public, protected, default, private
 *      =======================================================
 *      �޼ҵ� / �����ڴ� �ٸ� Ŭ������ �����ϴ� �κ� => �� �� ������ public ���°� ����
 *      
 *    final, static, abstract, synchronized 
 *    =====================================
 *    final => ����� �� �� ���� Ŭ����, ���
 *    static: ��������
 *    abstract: �߻����� => �������� �ʰ� ���
 *    synchronized: ����ȭ, �񵿱�ȭ
 *                  ====
 *                  �޼ҵ�� �⺻������ ����ȭ �Ǿ�����
 *    class A
 *    {
 *        public void aaa() {}
 *        public void bbb() {}
 *        public void ccc() {}
 *        public void ddd() {}
 *        public void eee() {}
 *    }
 *    class B
 *    {
 *        public static void main(String[] args)
 *        {
 *            A a=new A();
 *            a.aaa();
 *            a.bbb();
 *            a.ccc();
 *            a.ddd();
 *            a.eee();
 *        }
 *    }
 *    
 *    =============================
 *    
 *    =============================
 *       eee()
 *    =============================
 *       ddd()
 *    =============================
 *       ccc()
 *    =============================
 *       bbb()
 *    =============================
 *       aaa()   => ����. �ϳ��� ������ �����ؾ� ���� ���� ȣ�� 
 *    =============================
 *       Call Stack(�޼ҵ尡 ȣ��Ǵ� ����)
 *       
 *       ===========  ===========  ===========  ===========  ===========  
 *          aaa()        bbb()        ccc()        ddd()        eee()    ==> ���ÿ� 5���� ȣ��. ������
 *       ===========  ===========  ===========  ===========  ===========  
 * 
 *       �����(page 353)
 *       Ŭ����
 *       ���������� �ɼ�   class  className
 *                [final, abstract]
 *       [public, default]
 *       
 *       public final class String
 *       public abstract class String
 *       final class String
 *       abstract class String
 *       =============================
 *       
 *       �޼ҵ�
 *       ���������� �ɼ� ������ �޼ҵ��()
 *       ====== === [final|abstract|static]
 *       [public|private|default|protected]
 *       
 *       �������
 *       ���������� �ɼ� �������� ������
 *       ======  == [final|static]
 *       [public|private|default|protected]
 */
class Student
{
	private int hakbun;
	public String name;
	protected String sex;
	int kor;                      // ��������� ���������� 4�� ���ÿ� ��� ����
	
	public void aaa() {}
	private void bbb() {}
	void ccc() {}
	protected void ddd() {}       // �޼ҵ嵵 �װ� �� ��� ����. �ٸ� public ��� ����
	
	public Student() {}
	private Student(int a) {}
	Student(int a, int b){}
	protected Student(int a, int b, int c) {}
}
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
