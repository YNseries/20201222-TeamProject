package com.sist.main;
/*
 *    LinkedList: 순서가 있다, 데이터 중복이 가능
 *    ==========
 *     =====
 *      다음
 *      연결
 *      주소
 *     =====    =>
 *      실제
 *      데이터
 *     =====
 *     
 *     => List로부터 상속
 *        public class LinkedList implements List
 *     => class(단일), interface(class)(다중)
 *                    class를 확장 => 상위 클래스
 *     추가: add()
 *     읽기: get()
 *     삭제: remove()
 *     수정: set()
 *     갯수: size()
 */
import java.util.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list=new LinkedList();
		
		list.add("사과");
		list.add("배");
		list.add("포도");
		
		
		
		// 수정
		System.out.println("======== 데이터 수정 =======");
		list.set(5, "귤");
		for(int i=0;i<list.size();i++)
		{
			String s=(String)list.get(i);
			System.out.println(s);
		}
		
		// 전체 삭제
		System.out.println("====== 데이터 전체 삭제 ======");
		list.clear();
		System.out.println("갯수 확인:"+list.size());
		
	}

}
