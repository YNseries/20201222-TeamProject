package com.sist.main;
import com.sist.recipe.*;  // 클래스가 2개 있기 때문에 * 쓴것.
/*
 *   자바 소스의 구조
 *   1. package명 => 1개만 사용 가능
 *   2. 필요한 library import => 여러개 사용 가능
 *      패키지에 있는 클래스를 읽어 올 때
 *      import com.sist.main.*;
 *   3. class className{
 *         ==============
 *           변수 설정(인스턴스변수, 클래스변수)
 *         ==============
 *           생성자
 *         ==============
 *           기능(메소드)
 *         ==============
 *           main메소드()
 *           {
 *           }
 *         ==============
 *      }
 *   
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeManager rm=new RecipeManager();
		int no=rm.main_menu();
		String data=rm.sub_menu(no);
		System.out.println(data);
	}

}
