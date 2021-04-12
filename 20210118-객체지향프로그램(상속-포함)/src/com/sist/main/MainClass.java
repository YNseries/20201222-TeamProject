package com.sist.main;
/*
 *    객체지향 프로그램: 유지보수가 가능하게 만드는 프로그램
 *                  =====
 *                  1) 데이터 보호
 *                     => 멤버변수 private으로 은닉화
 *                     => 접속 => getter/setter
 *                     => 멤버변수는 감추고 메소드를 통해서 접근하는 방식
 *                        멤버변수: private
 *                        멤버메소드: public
 *                        생성자: 모든 클래스에서 접속이 가능 public
 *                        ** 상속이 있는 경우에는 멤버변수는 protected
 *                           === 사용이 가능(public, protected, default)
 *                           === 라이브러리를 변경
 *                  2) 기존의 클래스를 재사용: is-a(상속), has-a(포함): 웹에서 주로 사용
 *                       상속: 상속을 내리는 클래서(상위 클래스)의 모든 내용이 내려간다
 *                            예외) 생성자, static(사용이 가능하게 만들어 준다)
 *                            => 키워드: extends(확장)
 *                            기존의 클래스를 확장해서 새로운 클래스를 만들어서 사용
 *                       class A
 *                       {
 *                          내용(멤버변수, 멤버메소드)
 *                       }
 *                       class B
 *                       {
 *                          A가 가지고 있는 모든 내용을 받는다(소스코드에서 보이지 않는다) 중복을 제거
 *                                                    소스를 간결
 *                          추가, 변경해서 사용이 가능
 *                       }
 *                       포함: 기존 클래스의 기능을 그대로 사용
 *                       class A
 *                       {
 *                       }
 *                       class B
 *                       {
 *                          A a=new A();
 *                       }
 *                       
 *                       예)
 *                          윈도우, (버튼, 텍스트필드, 라디오버튼 ... )
 *                          ==== 윈도우 약간의 변경사항이 존재
 *                          ==== 자바에서 상속 단일 상속(가장 큰 것을 받아서 사용)
 *                          ==== 상속: 윈도우프로그램, 쓰레드
 *                               POJO(스프링 2.5이상): 독립클래스(컴포넌트) => 컨테이너
 *                  3) 변경, 추가(다형성)
 *                     ===  === 오버로딩
 *                     오버라이딩
 *                     
 *                     ==================================================
 *                                      오버로딩           오버라이딩
 *                     ==================================================
 *                       상속여부    자신의 클래스 안에서만         상속
 *                                                   (기존의 클래스 기능을 변경)
 *                     ==================================================
 *                       메소드명           동일               동일
 *                     ==================================================
 *                       매개변수       갯수나 데이터형이     매개변수가 동일
 *                                       다르다
 *                     ==================================================
 *                       리턴형           상관없다             동일
 *                                                    * 접속지정어의 확장이 가능
 *                                                      =======
 *                                                      private < default < protected < public
 *                                                      private: 자신의 클래스 안에서만 접근
 *                                                      default: private
 *                                                               같은 패키지 안에서만 접근이 가능
 *                                                      protected: default
 *                                                               다른 패키지에서 접근이 가능
 *                                                               단, 상속을 받은 경우에만
 *                                                      public: 모든 클래스에서 접근이 가능
 *                     ==================================================
 *    
 *    1. 캡슐화: 접근지정어, 2. 상속: 오버라이딩
 *    2. 자신의 클래스를 지정하는 키워드: this
 *       상위 클래스를 지정하는 키워드: super
 *       => 자신의 생성자 호출: this()
 *       => 상위 클래스의 생성자를 호출: super()
 *    3. 메소드 정의
 *       static: static 메소드, static 변수는 언제든지 사용이 가능
 *               instance를 호출시에는 반드시 객체를 생성하고 접근해야 함★
 *               class A
 *               {
 *                  private int x;
 *                  public static void display()
 *                  {
 *                     System.out.println("x="+x);   ==> 에러. 아직 저장이 안된 상태임.
 *                     
 *                     A a=new A();                  ==> 객체생성 후 가능
 *                     System.out.println("a.x="+a.x);
 *                  }
 *               }
 *       instance: 모든 데이터나 메소드 호출이 가능
 *       
 *          1) 자바의 클래스와 객체에 대한 설명 중 틀린 것은?
 *             
 *             1. 클래스 바깥에 전역 변수는 선언할 수 없다. : 자바에서 모든 소스는 메소드/변수 => 클래스 내에 존재
 *              
 *              class A
 *              {
 *                ======
 *                 변수
 *                ======
 *                 메소드
 *                ======
 *                 생성자
 *                ======
 *              }
 *             2. 클래스는 객체를 생성하기 위한 틀이다. : 클래스(설계도, 틀)
 *             3. 클래스의 멤버 변수를 필드라고 부르며, 클래스는 필드와 메소드로 이루어진다.
 *             *** 4. 필드는 클래스 내에서 private보다 public으로 선언하는 것이 바람직하다.
 *                    멤버변수는: private, 메소드/생성자: public
 *                    
 *          2) 생성자에 대한 설명 중 틀린 것은?
 *             
 *             1. 생성자가 작성되지 않으면, 컴파일러가 자동으로 기본 생성자를 추가해준다.
 *             2. 생성자의 이름은 클래스의 이름과 반드시 같아야 한다.
 *             3. this()는 생성자 내에서 다른 생성자를 호출하는 코드이다.
 *             *** 4. 생성자에서는 아무 값도 리턴하지 않기 떄문에 return문을 사용할 수 없다. (return)
 *             
 *                 모든 메소드의 종료시점: return(생성자에서도 return사용이 가능)
 */
/*
 *    생성자: 여러개를 만들 수 있다(사용자로부터 멤버변수의 초기값을 받아서 사용)
 *          => 오버로딩을 지원한다
 *          => 초기화를 담당한다
 *          => 리턴형이 없다(return은 사용이 가능)
 *          => 클래스명과 동일(대소문자 구분)
 *          => 존재하지 않는 경우에 컴파일러가 자동으로 디폴트생성자(매개변수가 없는 생성자) 추가
 *          예) 네트워크 데이터베이스에서 주로 사용(시작과 동시에 연결)
 *             *** 모든 클래스의 시작은 생성자(가장 먼저 호출이 된다)
 *             *** 객체 생성시에 호출된다
 *             *** 생성자를 호출시에는 반드시 new 생성자명();
 *          class A
 *          {
 *              public A(){}
 *              public A(int a){}
 *              ***** public A(int b){} => 오류 ==> A(int)
 *              ***** public void A(int a){} ==> 생성자가 아니다
 *              public A(int a,int b){} => A(int,int)
 *              public A(String name){}
 *          }
 *          
 *          ***
 *          클래스
 *          ====
 *            1. 일반 클래스
 *               public class MainClass
 *            2. 추상 클래스(설계) ===================> 보완(인터페이스)
 *               public abstract class MainClass
 *            3. 종단 클래스
 *               public final class MainClass: 확장이 불가능한 클래스
 *               =====> String, Math, System
 *            4. 내부 클래스
 *               class A
 *               {
 *                  class B => 쓰레드, 네트워크
 *                  {
 *                  }
 *               }
 *               
 *               class A
 *               {
 *                  B b=new B(){
 *                     public void display(){}   // 익명의 클래스
 *                  }
 *               }
 *               class B
 *               {
 *                  public void display(){}
 *               }
 */
// 기존의 클래스 상속 => this() : 자신의 생성자 호출이 가능
/*
 *    상속
 *    ===
 *      상속을 내리는 클래스(슈퍼클래스) => 서브클래스를 제어할 수 없다
 *      상속을 받는 클래스(서브 클래스) => 슈퍼클래스의 데이터나 메소드 호출이 가능
 */
import javax.swing.*;
/*
 *     1. 상위 클래스를 제어할 때: super,super()
 *     2. 자신 클래스를 제어할 때: this, this()
 *                         =======
 *                         객체가 생성이 될 때 존재(자신의 객체)
 *                         MainClass m=new MainClass();
 *                         this=m; ==> 컴파일러가 생성된 클래스 객체의 주소를 기억
 *     
 *     다음 클래스에는 컴파일 오류가 있다. 오류 부분을 지적하고 오류를 수정할 수 있는 방법을 모두 제시하라.
 *     그리고 그 중 객체지향프로그래밍에 가장 적합한 방법을 설명하라.
 *     => 생성자, 쎄터
 *        private? 메소드!
 *     
		class Person {
		    private int age;
		    public Person(int age)
		    {
		       this.age=age;
		    }
		    public void setAge(int age)
		    {
		       this.age=age;
		    }
		    public void display(int age)
		    {
		        this.age=age;
		    }
		    
		    // 생성자나 메소드는 private을 사용하게 되면 다른 클래스와 통신 할 수 없다 : public 
		    // 객체지향 프로그램 
		       객체와 객체의 통신을 통해서 연결 
		                 ============
		                 메세지 => 메소드 : 모바일 (서비스)
		       Tv   ====   사람
		            메세지
		            결과값 받기 ======> 메소드 호출 
		}
		public class Example {
		    public static void main (String args[]) {
		        Person aPerson = new Person(17);
		        //aPerson.age = 17;
		        aPerson.setAge(17);
		        aPerson.display(17);
		    }
		}
 */
public class MainClass extends JFrame {
	public MainClass()
	{
		super("Hello");    // JFrame의 생성자 함수 => 상위클래스(상속을 내리는 클래스)의 생성자를 호출. 항상 첫번쨰 줄에 와야 함 
		setSize(640,480);  // 윈도우 크기
		setVisible(true);  // 윈도우 보여주기
	}
	public MainClass(int width,int height)  // 윈도우 크기를 계속 바꾸고 싶으면 이렇게 하지만 잘 안써
	{
		// this();  // 생성자를 호출할 떄 반드시 첫번째 줄에 코딩
		setSize(width,height);  // 윈도우 크기
		setVisible(true);  // 윈도우 보여주기
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성자만 호출
		new MainClass(800,600);

	}

}
/*
 *  public static Image getImage(ImageIcon ii,int w,int h)
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    }
 */
