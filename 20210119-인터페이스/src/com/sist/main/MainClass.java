package com.sist.main;
/*
 *    JDK 1.0
 *    JDK 1.2 => 윈도우(swing)
 *    JDK 1.5 => 제네릭, printf
 *    (1.6,1.7)
 *    =========== SUN
 *    JDK 1.8                           () -> {}
 *     |  오라클(C형식) => interface 변경, 람다식(함수포인터), 윈도우(JavaFX)
 *        ========== 윈도우(오라클: ERP) SAP(MS)
 *    인터페이스(interface)
 *    1) 추상 클래스의 일종 => 추상클래스의 단점을 보완
 *       # 자바의 클래스는 무조건 단일 상속만 가능
 *       # 인터페이스도 클래스다(다중 상속이 가능)
 *    2) 형식
 *       접근지정어 interface 인터페이스명{
 *          ================
 *            변수(멤버변수(X)): 상수형 변수
 *          ================
 *            추상메소드(선언된 메소드)
 *          ================
 *            구현된 메소드(JDK 1.8 이상)
 *            default
 *          ================
 *            static
 *          ================
 *       }
 *       =======
 *       public|default
 *    3) 추상클래스와 동일 => 공통적인 속성을 모아서 저장 => 구현해서 사용
 *       ** 서로 다른 클래스를 연결할 때 사용
 *       ** 표준화가 가능하다
 *     
 *     *** 인터페이스의 모든 변수와 모든 메소드는 public만 사용이 가능
 *     public interface Common
 *     {
 *        ***** int a;   // 상수형 변수이기 때문에 => int a=10; 값을 넣어줘야 함
 *                          => public static final int a;
 *                             =================== 생략됨
 *        void display();   // public abstract void display();
 *                             =============== 생략됨
 *        public void display();  // 이렇게 적어도 됨. abstract 생략
 *        ===============
 *        default void aaa(){}  // default public void aaa(){}
 *                                         ======
 *        static void bbb(){}   // static public void bbb(){}
 *                                        ====== 
 *     }
 *     
 *     public interface Common
 *     {
 *         (public abstract) void display();
 *     }
 *     # class A => class B : class B extends A
 *     # interface A => class B : class B implements A
 *     public class A implements Common
 *     {
 *         public void display(){}   // public 없이 쓰면 default이기 때문에 오류남.
 *     }
 *     
 *     오버라이딩: 접근지정어가 확대는 가능, 축소는 불가능
 *     
 *     상속
 *       class A
 *       class B    ==> 클래스 A가 클래스 B에 상속을 내림
 *                      class B extends A
 *       interface A
 *       class B    ==> 인터페이스 A가 클래스 B에 상속      => 같은 형식으로 상속받으면 extends
 *                      class B implements A        => 다른 형식으로 상속받으면 implements
 *       interface A
 *       interface B => 인터페이스 A가 인터페이스 B에 상속
 *                      interface B extends A
 *       ======================================== 오류(인터페이스는 클래스로부터 상속받을 수 없다)
 *       class A
 *       interface B => 클래스 A가 인터페이스 B에 상속
 *                      interface B extends A    (XXXXXX 존재하지 않는 형식)
 *       
 *       interface A
 *       interface B extends A
 *       class C implements B     => 단일상속
 *       
 *       interface A
 *       interface B
 *       class C implements A,B   => 다중상속
 *       
 *       interface A
 *       interface B
 *       class C
 *       class D extends C implements A,B
 *               ========= ==============
 *            클래스 상속 받고, 인터페이스 상속 받는 순서
 */
interface Common{
	/*public static final*/ int x=10;
	/* public abstract */ void display();
	default void aaa() {
		
	}
	static void bbb() {
		
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
