package com.sist.main;
/*
 *    �÷��� Ŭ����(Collection): �����͸� �����ϴ� ǥ��ȭ�� Ŭ����
 *    =====================
 *      = CURD(Create, Update, Read, Delete)
 *      = ������ �б� / ���� / �߰� / ����
 *      = ǥ��ȭ
 *      = (�迭�� ����������) �÷��� => ����
 *    1. ����
 *       List: ������ �ִ�(�ε��� ��ȣ�� �ϰ������� ����) = �����ϱ� ����, �����͸� �ߺ������� ���� ���� => DataBase(����Ŭ)���� ���� ���� ���
 *       Set: ������ ����(�ε��� ���� X) = ������ ã�� �����, ������ ������ �ߺ��� ������� X => ��� �󵵰� ����
 *       Map: ������ ����, Ű, �� => Ű�� �ߺ� ��� X, �����ʹ� �ߺ� ��� (O)
 *       ===
 *       �� �����׷�: session, cookie, request, response
 *       
 *       List: �������̽�(�̿ϼ��� Ŭ����) => �����ϰ� �ִ� Ŭ������ �̿��Ѵ�(ǥ��ȭ, ���� �ٸ� Ŭ������ �����ؼ� ��� ����)
 *         ������ Ŭ����
 *         =========
 *         �迭�� ��ü�ؼ� ��� => ���̻� �迭�� ���������� ������� ����
 *         ===============================================
 *         1) ArrayList: �񵿱�ȭ(�����ͺ��̽� ������ �� ���� ��) ***
 *         2) Vector: ����ȭ(��Ʈ��ũ ���α׷�) => �ӵ��� ����
 *         3) LinkedList: C��� ȣȯ => �ӵ��� ����
 *         ===============================================
 *           ���������� ���(�ڷᱸ��) �ڡڡ�              ����Ŭ����
 *           1. ������ ����(�߰�)�� ��: add()       => INSERT
 *           2. ������ ����        : remove()    => DELETE
 *           3. ������ ����        : set()       => UPDATE
 *           4. ������ �б�(�������) : get()       => SELECT        JOIN, SUBQUERY���� �� ��������ž�
 *           5. ����� ������ ����   : size()
 *         ===============================================
 *         4) Stack: LIFO, Queue: FIFO
 *            ===========  ===========
 *            ������         ��Ʈ��ũ, �ü��
 *       
 *       
 *       ArrayList
 *       =========
 *       1. �����ϴ� ���
 *          ArrayList list=new ArrayList();
 *          =========          ===========
 *          Vector             Vector()       => �̷��� Ŭ������ �ٲ㵵 ��(�޼ҵ�)���� ������� ����
 *          LinkedList         LinkedList()      �����ϰ� �۵���. �̷��� �������̽��� ��ӹ����� ǥ��ȭ �Ǿ��־� ����ϱ� ���� 
 *       2. ������ ���� ���
 *          = �� �ڿ� �߰� list.add(������);
 *                              ====== Object  => (����) public void add(Object obj)
 *          = ���ϴ� ��ġ�� �߰� list.add(int index,Object obj)
 *                                  ==========
 *                                  1
 *                                  2    <= 1, 3, 2 �߰��� ����� ���� ����(���� ����)
 *       3. ������ �б� 
 *          list.get(int index): 0���� ����       => (����) public Object get(int index)
 *          ��) list.get(1): 2��°�� �� ��       => int no=(int)list.get(i)  // �ʹݿ� �� ����ȯ �����ִ� �� ����
 *       4. ������ ���� Ȯ��
 *          list.size()                        => (����) public int size()
 *       5. ������ ���� 
 *          list.set(int index,Object obj)     => (����) public Object set(int index,Object obj)
 *                        0 1
 *                        1 1
 *                        2 1 => 2 5 : list.set(2,5)
 *                        3 1
 *                        4 1
 *                        5 2
 *       6. ������ ����(�� ��, ��ü)
 *          list.remove(int index)             => (����) public boolean remove(int index)
 *          list.removeAll(), list.clear()  // ��ü ����, ���������
 */
import java.util.*;  // Collection Ŭ���� ��� �� ����
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �̸��� ����(������) = �ʹݿ� ��� ��: String[] names=new String[10];
		// ������ �޸� ���� ����
		ArrayList nameList=new ArrayList();  // Ŭ������ �޸� ���� ����  // ������� ��� ==> ����(Object)
		//Vector nameList=new Vector();
		//LinkedList nameList=new LinkedList();
		//Stack nameList=new Stack();
		// ����
		nameList.add("ȫ�浿");  // 0  => Object o= "ȫ�浿"; Object o=new Object() => Object
		nameList.add("��û��");  // 1          Object o=new String(""); => String
		nameList.add("�̼���");  // 2
		nameList.add("������");  // 3
		nameList.add("�ڹ���");  // 4
		// ArrayList ����: ��� ���� ����. �ٸ� Object�� ���� ���������� �پ������� ������ �� ��ȯ ��Ű�鼭 for�� ������ �����
		// ������ ���� �������� ������ ���¿��� �ϴ°� ���� => ���Ͻ�Ű�� ���: ���׸���<>
		
		/*
		 *   public void display(double d)
		 *   {
		 *         65.0
		 *   }
		 *   display('A'); 
		 *           === char
		 *   double d='A';   => 65.0
		 *            === char
		 *   public void add(Object o)
		 *   {
		 *   }
		 *   
		 *   add("aaa")
		 */
		Object o="AAAA";  // "�ּ�" new
		Object o1=new Object();
		System.out.println(o);
		System.out.println(o1);
		
		System.out.println("========= ArrayList�� ����� ������ ========");
		// Object nema=new String();
		/*for(Object name:nameList)  // �Ű������� ���� ���������� �޶����ϱ� Object�� �޾Ƽ� Object �����
		{
			System.out.println((String)name);  // Ȥ�� name.toString | name�� �ᵵ ��
		}
		System.out.println("���� ����� �̸�:"+nameList.size());
		                                   //     ======== �� ����� ���� */
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		// ���ϴ� ��ġ�� �����͸� ���(�������� ����)
		System.out.println("============== �߰� =============");
		nameList.add(2, "��������");
		/*
		 *  ȫ�浿  0
			��û��  1
			          <-  2, "��������"
			�̼���  2 -> 3
			������  3 -> 4
			�ڹ���  4 -> 5
			=> �̷��� �߰��� �߰����� �� ����: ���� ���ڵ��� �ϳ��� �߰��Ǹ鼭 �ӵ��� ������
			   ������ �� �� ������ �� �ڿ� �߰��ϴ°� ����
		 */
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		
		System.out.println("============== ���� =============");
		nameList.set(3,"������");
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		
		System.out.println("============== ���� =============");
		nameList.remove(2); // (�������� ����)
		/*
		 *  ȫ�浿  0
			��û��  1
			�������� 2 => ����
			������  3 -> 2
			������  4 -> 3
			�ڹ���  5 -> 4
		 */
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		
		System.out.println("=========== ��ü ���� ============");
		nameList.clear();
		System.out.println("����� �̸�:"+nameList.size());
	}

}
