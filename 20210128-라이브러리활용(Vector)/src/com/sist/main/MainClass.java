package com.sist.main;
/*
 *    java.lang
 *    =========
 *      Object => ��� Ŭ������ ��Ƽ� ����(��� ���������� ���� �� �ִ�)
 *                ����ȯ
 *                Object obj=new String();
 *                String str=(String)obj;
 *                => �ڹٿ��� �����ϴ� �޼ҵ� �߿� Ŭ������ ���������� ������ �ִ� ���
 *                   ��� �޼ҵ尡 Object�� �Ѿ��
 *                ArrayList���� �Ѿ�� �� ����� ���� �о� �´�(get����)
 *                         => public Object get(int index) => (String)list.get(0)
 *                                                            ======== 
 *                                    �̷��� ���������� ���̰ų� Ŭ���� ��ü�� ���������� �����ϰų�
 *      String => ��, �����, ������ => ���ڿ��� ����
 *      Wrapper => Integer, Double, Boolean => ���ڿ��� ��ȯ
 *                 parseInt() parseDouble() parseBoolean
 *      StringBuffer => ���Ͽ� ����� ���ڿ��� �� ��� => append
 *    java.util
 *    =========
 *      StringTokenizer: ���й��ڷ� ���ڿ��� �ڸ���
 *                       ================== ��ȭ, ����, ����, ���� => �̹����� �������� ��: �̹�����, �̹�����, ...
 *      Date: �ý����� ��¥ = ����Ŭ
 *      Calendar: �޷�(��¥ ����)
 *      SimpleDateFormat, MessageFormat(������ layout ���� �� ����), ChoiceFormat(���̴� �Ƚ�)
 *      ===============   =============                         ============ ��� (switch, if�� ó������)
 *         ��¥ ����          ����? ����? ����
 *      �ڷᱸ��
 *       List: ArrayList, Vector(��Ʈ��ũ), LinkedList, Stack
 *             ========= �����ͺ��̽�
 *       Set: HashSet, TreeSet
 *            ======= �ߺ����� �����͸� ����
 *       Map: HashMap, HashTable => session(�� ����/������ ����� ����)���� ���� ���, cookie, request, response
 *                                    id, "admin"                                   ?movieid=111111
 *                                    setAttribute("key","value")  // ���� ����ϴ� ����
 *                                    Map map=new HashMap()        // ������ ����
 *            =======                 map.put(key,value);          
 *              Spring, MyBatis ���̺귯���� ����
 *              ======  ======= <select id="movie">SQL����</select>
 *              <bean id="board" class="Board">: �������� Ŭ���� ������(����~�Ҹ���� ���)
 *      ==> ����ȯ�� ���� Collection => ���������� ����ȭ: ���׸��� <TYPE>
 *      ==> �޼ҵ� ����, Ŭ���� ã��(�ε���) => if ���: ������̼�
 */
// Vector: ��Ʈ��ũ(ip, port) => Socket => ����ȭ
/*
 *    java.util => import�� �ݵ�� ��� => import java.util.Vector, import java.util.*
 *                                     ====================== �� �̰ź��� �� �̷��� ���°� ����
 *    Vector: ����ȭ ���α׷� => ������ ����(10000���� ������ => 1500000) => Thread
 *    ======
 *     List => ������ �ִ�, �ߺ� ������ ������ ����
 *             ======== �ε��� ��ȣ
 *             �ڷᱸ��: CURD(����, ����, �б�, ����)   List �� �޼ҵ�,   Vector�� ������ �ִ� ���� (�� �� ����)
 *              = �б�(�����͸� ������ �´�)         => get(�ε��� ��ȣ), elementAt(�ε���)
 *              = ����                         => add(),         addElement()
 *              = ����                         => remove(),      removeElementAt()
 *              = ����                         => size()
 *              
 *              public interface List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              public class ArrayList implements List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              public class Vector implements List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              public class LinkedList implements List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              List list=new ArrayList();    // �񵿱���
 *              List list=new Vector();       // ������
 *              List list=new LinkedList();   // �ӵ�������
 *              ��� ���� �޼ҵ带 ����ϱ� ������ ��ȣ���� ���� ���� ����
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vec=new Vector();  // Vector(=�Ϲ� Ŭ����) ����
		// add() �� ���� ÷��, addAll() ������ ������ ���θ� �� ���� ÷��
		Collections.addAll(vec, "ȫ�浿","��û��","�����","�̼���","������"); // Collections�� �ֻ���Ŭ����
		Collections.sort(vec);
		//                      ================================== �� ������ ��� vec�� �־��. addAll()
		//vec.add("");   �̰� 5�� ���� �� = Collections.addAll();
		//System.out.println(vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.get(i);  // Object�� �����ϱ� ����ȯ �ؾ� ��
			System.out.println(name);
		}
		
		//Vector vec2=new Vector();
		ArrayList vec2=new ArrayList();
		vec2.addAll(vec);  // ���⼭ addAll�� �̹� ����� �� �� ����/������ ��   set�� �迭�� �ٸ��� ������ �ȵ�
		for(int i=0;i<vec2.size();i++)
		{
			String name=(String)vec2.get(i);
			System.out.println(name);
		}
	}

}
