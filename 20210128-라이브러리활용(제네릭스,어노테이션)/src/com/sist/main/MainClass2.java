package com.sist.main;
import java.util.*;
// ���׸��� => �÷��ǿ����� ��: ArrayList<>, Vector<>, LinkedList<>, Map<K,V>
//       => (���õ�)�����͸� �����ؼ� ��� ���� �� ���
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=
				new ArrayList<String>();
		// ����
		list.add("ȫ�浿");
		list.add("�̼���");
		
		// �� �б�
		String name1=list.get(0);
		String name2=list.get(1);
		
		System.out.println(name1);
		System.out.println(name2);
		
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		
		ArrayList list3=new ArrayList();
		list3.add(1);
		list3.add("Hello");
		list3.add('A');
		list3.add("Hello");
		list3.add('A');
		list3.add("Hello");
		list3.add('A');
		list3.add(1);
		list3.add(1);
		list3.add(1);   // 1000�� 
		
		//ArrayList<A> list5=new ArrayList<A>();
		
	}

}
