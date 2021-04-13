package com.sist.main;
import java.util.*;
// 제네릭스 => 컬렉션에서만 씀: ArrayList<>, Vector<>, LinkedList<>, Map<K,V>
//       => (관련된)데이터를 통일해서 묶어서 저장 후 사용
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=
				new ArrayList<String>();
		// 저장
		list.add("홍길동");
		list.add("이순신");
		
		// 값 읽기
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
		list3.add(1);   // 1000개 
		
		//ArrayList<A> list5=new ArrayList<A>();
		
	}

}
