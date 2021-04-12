/*
 *    상속
 *     => 기존의 클래스의 모든 기능과 데이터를 받아서 확장하는 클래스를 만드는 것
 *     => 상속의 형식
 *        ========
 *        class A
 *        class B extends A
 *             ===       ===
 *           상속을 받음   상속을 내리는 클래스
 *     => 자바에서 상속은 단점: 단일 상속. 항상 하나만 받을 수 있다
 *                        ○ -> ○ ■ -> ○ ■ △
 *     => 재사용: 있는 그래도 사용(포함클래스)
 *              변경해서 사용(상속) 
 *     => 사용법
 *        extends
 *        
 *        class A
 *        class B extends A
 *        *** 상속을 받는 경우(기본은 상속내리는 클래스의 모든 것을 받아온다)
 *            단, 예외 조건(static변수/static메소드, 생성자는 상속에서 제외)
 *                      ===================== 상속받는 클래스는 사용 가능
 *                          공통으로 쓰기 때문
 *                       private은 상속은 내려가는데, 사용은 불가능(private 대신 protected 쓰는게 좋음)
 *     => 중복을 제거할 때 
 *     
 *     class A
 *     {
 *        int a=10;
 *        int b=20;
 *        public void display()
 *        {
 *        }
 *     }
 *     
 *     class B extends A
 *     {
 *        ======================= 코딩하지 않아도 자동으로 (눈에는 안보이지만)포함됨/여기서 바꿔도 원 코드는 변경 안됨(오버라이딩)
 *        int a=100;
 *        int b=200;
 *        public void display()
 *        {
 *        }
 *        =======================
 *        public void bbb()
 *        {
 *        }
 *     }
 *     B ==> a,b,display(), bbb()
 *     
 *     클래스의 크기 비교 => 상속을 내리는 클래스가 크다(상속)
 *     동물
 *      |
 *      사람 (사람, 동물)
 *     
 */
class SuperClass
{
	int a=10;
	int b=20;
	
}
public class SubClass {
	// int a=10;
	// int b=20;
	// 포함클래스
	SuperClass sc=new SuperClass();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass s=new SubClass();
		System.out.println(s.sc.a);
		System.out.println(s.sc.b);

	}

}
