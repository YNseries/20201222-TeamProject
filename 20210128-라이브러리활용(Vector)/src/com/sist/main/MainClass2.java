package com.sist.main;
import java.util.*;
public class MainClass2 {
/*
 *    T => Type      ArrayList<Type>  = Integer, ...
 *    E => Element   Vector<Element>  = String, ...
 *    K => Key       Map<K, V>        = String, Integer
 *    V => Value     
 *    
 *    1, "", 10.6, new A(), .... �̷������� �پ��� ���������� �ִ� �ͺ���
 *    1,2,3,4,5,6
 *    
 *    1,1,1,2,3,1,5,1,6,7,8,9
 *    1,2,3,4,5,6 => ����
 *    
 *    MovieVO, NewsVO, NewsVO, MovieVO, NewsVO, MovieVO => ���α׷�(������ ��Ƽ� ����)
 *                                                               =========
 *                                                               ���� �ͳ��� => ���õ� ��
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *    CURD
		 *    C => Create => add()
		 *    U => Update => set()
		 *    R => Read   => get()
		 *    D => Delete => remove()
		 */
		Vector vec=new Vector();
		// �߰� => Object
		// ��ȭ �帣
		vec.add("�׼�");
		vec.add("���");
		vec.add("���");
		vec.add("�ڹ̵�");
		vec.add("��Ÿ��");
		vec.add("SF");
		vec.add("�ִϸ��̼�");
		vec.add("���");
		vec.add("�ڹ̵�");
		vec.add("��Ÿ��");
		
		HashSet set=new HashSet();               // Set: �ߺ��� ����
		for(int i=0;i<vec.size();i++)
		{
			String genre=(String)vec.get(i);
			set.add(genre);
		}
		System.out.println(set);
		
		/*System.out.println("======== ����� �帣 ========");
		System.out.println("�帣:"+vec.size());
		
		// ���
		for(int i=0;i<vec.size();i++)
		{
			//String genre=(String)vec.elementAt(i);   
			String genre=(String)vec.get(i);             // elementAt ��� get �ᵵ ��
			System.out.println(genre);
		}
		
		// ����
		System.out.println("======== ������ ���� ========");
		vec.setElementAt("����", 9);                       // vec.set(); �� ����
		for(int i=0;i<vec.size();i++)
		{
			//String genre=(String)vec.elementAt(i);
			String genre=(String)vec.get(i);
			System.out.println(genre);
		}
		
		// ����
		System.out.println("======== ������ ���� ========");
		vec.removeElementAt(8);
		for(int i=0;i<vec.size();i++)
		{
			//String genre=(String)vec.elementAt(i);
			String genre=(String)vec.get(i);
			System.out.println(genre);
		}
		
		System.out.println("======== ��ü ���� ========");
		vec.removeAllElements();                            // vec.clear(); �� ����
		System.out.println("����:"+vec.size()); */
	}

}
