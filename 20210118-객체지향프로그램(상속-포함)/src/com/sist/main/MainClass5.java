package com.sist.main;
/*
 *    제어자(page 344)
 *    ==============
 *    접근지정어 public, protected, default, private
 *    클래스
 *    ====
 *      클래스: public, default
 *      멤버변수: public, protected, default, private
 *      =======================================================
 *      메소드: public(가급적 사용), protected, default, private
 *      생성자: public, protected, default, private
 *      =======================================================
 *      메소드 / 생성자는 다른 클래스와 연결하는 부분 => 될 수 있으면 public 쓰는게 좋음
 *      
 *    final, static, abstract, synchronized 
 *    =====================================
 *    final => 상속을 할 수 없는 클래스, 상수
 *    static: 공통적인
 *    abstract: 추상적인 => 구현하지 않고 사용
 *    synchronized: 동기화, 비동기화
 *                  ====
 *                  메소드는 기본적으로 동기화 되어있음
 *    class A
 *    {
 *        public void aaa() {}
 *        public void bbb() {}
 *        public void ccc() {}
 *        public void ddd() {}
 *        public void eee() {}
 *    }
 *    class B
 *    {
 *        public static void main(String[] args)
 *        {
 *            A a=new A();
 *            a.aaa();
 *            a.bbb();
 *            a.ccc();
 *            a.ddd();
 *            a.eee();
 *        }
 *    }
 *    
 *    =============================
 *    
 *    =============================
 *       eee()
 *    =============================
 *       ddd()
 *    =============================
 *       ccc()
 *    =============================
 *       bbb()
 *    =============================
 *       aaa()   => 종료. 하나가 완전히 종료해야 다음 것을 호출 
 *    =============================
 *       Call Stack(메소드가 호출되는 영역)
 *       
 *       ===========  ===========  ===========  ===========  ===========  
 *          aaa()        bbb()        ccc()        ddd()        eee()    ==> 동시에 5개를 호출. 쓰레드
 *       ===========  ===========  ===========  ===========  ===========  
 * 
 *       사용방법(page 353)
 *       클래스
 *       접근지정어 옵션   class  className
 *                [final, abstract]
 *       [public, default]
 *       
 *       public final class String
 *       public abstract class String
 *       final class String
 *       abstract class String
 *       =============================
 *       
 *       메소드
 *       접근지정어 옵션 리턴형 메소드명()
 *       ====== === [final|abstract|static]
 *       [public|private|default|protected]
 *       
 *       멤버변수
 *       접근지정어 옵션 데이터형 변수명
 *       ======  == [final|static]
 *       [public|private|default|protected]
 */
class Student
{
	private int hakbun;
	public String name;
	protected String sex;
	int kor;                      // 멤버변수는 접근지정어 4개 동시에 사용 가능
	
	public void aaa() {}
	private void bbb() {}
	void ccc() {}
	protected void ddd() {}       // 메소드도 네개 다 사용 가능. 다만 public 사용 권장
	
	public Student() {}
	private Student(int a) {}
	Student(int a, int b){}
	protected Student(int a, int b, int c) {}
}
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
