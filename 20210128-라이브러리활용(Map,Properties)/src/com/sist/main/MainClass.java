package com.sist.main;
/*
 *    Map, Properties
 *    ===============
 *    Map => �� ������ ������ �� ����(key, value): Ŭ������ ������ ��, SQL���� ������ ��
 *    
 *    java.util.*
 *    Map => interface
 *    === HashMap
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map=new HashMap();
		map.put("id", "admin");
		map.put("pwd", "1234");
		map.put("name", "ȫ�浿");
		map.put("sex", "����");  // Ű(�ߺ��� �� ����), ��(�ߺ��� �� �ִ�)
		map.put("sex", "����");
		
		// �� �о����
		System.out.println("ID:"+map.get("id"));
		System.out.println("Password:"+map.get("pwd"));   // key �̸��� ������ �ȵ�
		System.out.println("Name:"+map.get("name"));
		System.out.println("Sex:"+map.get("sex"));
	}

}
