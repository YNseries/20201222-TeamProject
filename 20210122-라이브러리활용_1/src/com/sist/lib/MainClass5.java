package com.sist.lib;
/*
 *    Object:
 *       1. 객체와 객체 비교     : equals
 *       2. 새로운 메모리 생성    : clone
 *       3. 문자열 변환 기능     : toString
 *       4. 클래스의 정보 읽기    : getClass
 *       5. 메모리에서 해제여부 확인: finalized
 *       
 *       ================ 객체 만든다(5가지 기능이 포함되어 있음)
 *       
 *       String => final (변경할 수 없어. 외우기만 하면 됨) 
 *       (*lang에 들어가는 클래스들 Object외엔 다 final. Method만 외우면 됨)
 */
import java.lang.reflect.Method;
class C
{
	public void display()
	{
		System.out.println("C:display() Call...");
	}
}
// class Class => getClass()
public class MainClass5 {
	
	public static void main(String[] args) {
		C c=new C();
		Class cc=c.getClass();
		Class cc1=C.class;    // 클래스 정보를 갖고옴
		//Class cc2=Class.forName("");
		/*
		 * try { Class clsName=Class.forName("com.sist.lib.C"); Object
		 * obj=clsName.newInstance(); Method[] m=clsName.getDeclaredMethods();
		 * m[0].invoke(obj,null); }catch(Exception ex) {}
		 */
		
	}

}
