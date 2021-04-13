package com.sist.main;
/*
 *    LinkedList: ������ �ִ�, ������ �ߺ��� ����
 *    ==========
 *     =====
 *      ����
 *      ����
 *      �ּ�
 *     =====    =>
 *      ����
 *      ������
 *     =====
 *     
 *     => List�κ��� ���
 *        public class LinkedList implements List
 *     => class(����), interface(class)(����)
 *                    class�� Ȯ�� => ���� Ŭ����
 *     �߰�: add()
 *     �б�: get()
 *     ����: remove()
 *     ����: set()
 *     ����: size()
 */
import java.util.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list=new LinkedList();
		
		list.add("���");
		list.add("��");
		list.add("����");
		
		
		
		// ����
		System.out.println("======== ������ ���� =======");
		list.set(5, "��");
		for(int i=0;i<list.size();i++)
		{
			String s=(String)list.get(i);
			System.out.println(s);
		}
		
		// ��ü ����
		System.out.println("====== ������ ��ü ���� ======");
		list.clear();
		System.out.println("���� Ȯ��:"+list.size());
		
	}

}
