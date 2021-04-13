package com.sist.main;
/*
 *    Map, Properties
 *    ===============
 *    Map => 두 가지를 저장할 수 있음(key, value): 클래스를 저장할 때, SQL문장 저장할 때
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
		map.put("name", "홍길동");
		map.put("sex", "남자");  // 키(중복할 수 없다), 값(중복할 수 있다)
		map.put("sex", "여자");
		
		// 값 읽어오기
		System.out.println("ID:"+map.get("id"));
		System.out.println("Password:"+map.get("pwd"));   // key 이름을 잊으면 안됨
		System.out.println("Name:"+map.get("name"));
		System.out.println("Sex:"+map.get("sex"));
	}

}
