/*
 *    프로그램
 *    =====
 *    필요한 데이터를 저장할 공간(변수)
 *    ===================== 값이 필요(초기값)
 *           초기값
 *             임의의 지정
 *             class A
 *             {
 *                int mx=400;my=500;
 *                                
 *                {
 *                   (초기값을)구현해서 사용(= {}블록이 있어야 가능)
 *                }
 *                생성자(){
 *                }
 *                void display(){
 *                }
 *             }
 *             ===================
 *             파일에 읽기(자동 로그인)
 *             데이터베이스(id,pwd)
 *             난수
 *             =================== 구현 => 메소드{}
 *             => 1. 생성자
 *             => 2. {}
 *    데이터를 활용
 *    사용자에게 보여줌
 *    
 *    저장되는 순서
 *    =========
 *    1. 명시적인 데이터    int a=10;
 *    2. 초기화 블럭      {a=100;}         => myBatis(데이터베이스 연결): XML, Annotation
 *            오라클 연결 => 게시판(300줄) / myBatis? => 20줄
 *    3. 생성자          생성자(){a=200;}
 *    
 *       10 => 100 => 200
 *       ================
 *       
 *       클래스에 선언되는 변수
 *       인스턴스변수  int a;
 *       
 *       class A
 *       {
 *       	int a;       // 0
 *       	{
 *       		a=100;   // 인스턴스 초기화 블럭
 *       	}
 *       }
 *       
 *       class A
 *       {
 *       	static int b;// 0
 *       
 *       	static
 *       	{
 *       		b=100;   // static 블럭
 *       	}
 *       }
 *       
 *       static, instance => 생성자
 *       
 *       클래스변수   static int a;
 *       
 *       JSP, MVC, Spring, MyBatis => Java기반 라이브러리
 *       ============================================ 표준화
 */
public class 초기화블럭 {
	int a=100;
	static int b=1000;
	int[] arr=new int[6];  // 선언
	////////////////////// 자동으로 호출
	{
		a=200;
		/*arr[0]=(int)(Math.random()*45)+1;      // 구현 {} 안에서만 가능
		arr[1]=(int)(Math.random()*45)+1;
		arr[2]=(int)(Math.random()*45)+1;
		arr[3]=(int)(Math.random()*45)+1;
		arr[4]=(int)(Math.random()*45)+1;
		arr[5]=(int)(Math.random()*45)+1; */
		for(int i=0;i<6;i++)
		{
			arr[i]=(int)(Math.random()*45)+1;
		}
	}
	static
	{
		b=2000;
	}
	//////////////////////
	/*
	 * 초기화블럭() { a=300; }
	 */
	// 초기화블럭(){}  생산자 만들어짐 // 위에 300을 대입한 생산자를 숨겼기 때문에

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		초기화블럭 aa=new 초기화블럭();
		System.out.println("aa.a="+aa.a);
		System.out.println("aa.b="+aa.b);
		for(int i:aa.arr)
		{
			System.out.print(i+" ");
		}
		
		/*
		 *  Scope => 변수 사용범위 지정
		 *  {
		 *  	{
		 *  		{
		 *  		
		 *  		}
		 *  	}
		 *  }
		 */

	}

}
