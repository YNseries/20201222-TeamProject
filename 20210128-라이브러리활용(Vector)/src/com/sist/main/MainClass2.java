package com.sist.main;
import java.util.*;
public class MainClass2 {
/*
 *    T => Type      ArrayList<Type>  = Integer, ...
 *    E => Element   Vector<Element>  = String, ...
 *    K => Key       Map<K, V>        = String, Integer
 *    V => Value     
 *    
 *    1, "", 10.6, new A(), .... 이런식으로 다양한 데이터형이 있는 것보단
 *    1,2,3,4,5,6
 *    
 *    1,1,1,2,3,1,5,1,6,7,8,9
 *    1,2,3,4,5,6 => 수열
 *    
 *    MovieVO, NewsVO, NewsVO, MovieVO, NewsVO, MovieVO => 프로그렘(데이터 모아서 관리)
 *                                                               =========
 *                                                               같은 것끼리 => 관련된 것
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
		// 추가 => Object
		// 영화 장르
		vec.add("액션");
		vec.add("드라마");
		vec.add("멜로");
		vec.add("코미디");
		vec.add("판타지");
		vec.add("SF");
		vec.add("애니메이션");
		vec.add("멜로");
		vec.add("코미디");
		vec.add("판타지");
		
		HashSet set=new HashSet();               // Set: 중복을 없앰
		for(int i=0;i<vec.size();i++)
		{
			String genre=(String)vec.get(i);
			set.add(genre);
		}
		System.out.println(set);
		
		/*System.out.println("======== 저장된 장르 ========");
		System.out.println("장르:"+vec.size());
		
		// 출력
		for(int i=0;i<vec.size();i++)
		{
			//String genre=(String)vec.elementAt(i);   
			String genre=(String)vec.get(i);             // elementAt 대신 get 써도 됨
			System.out.println(genre);
		}
		
		// 수정
		System.out.println("======== 데이터 수정 ========");
		vec.setElementAt("공포", 9);                       // vec.set(); 과 동일
		for(int i=0;i<vec.size();i++)
		{
			//String genre=(String)vec.elementAt(i);
			String genre=(String)vec.get(i);
			System.out.println(genre);
		}
		
		// 삭제
		System.out.println("======== 데이터 삭제 ========");
		vec.removeElementAt(8);
		for(int i=0;i<vec.size();i++)
		{
			//String genre=(String)vec.elementAt(i);
			String genre=(String)vec.get(i);
			System.out.println(genre);
		}
		
		System.out.println("======== 전체 삭제 ========");
		vec.removeAllElements();                            // vec.clear(); 와 동일
		System.out.println("갯수:"+vec.size()); */
	}

}
