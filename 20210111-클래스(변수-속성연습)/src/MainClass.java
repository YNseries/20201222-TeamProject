/*
 *    class의 구성 요소(변수+메소드)
 *    ==============
 *      = 변수
 *                    프로그래머가 직접 생성 => class{ 블록 안에 생성됨 } 
 *        ==============================================================
 *        = 멤버변수(인스턴스 변수): new를 사용시마다 따로 메모리가 만들어진다
 *        = 공통변수, 공유변수: JVM에서 자동으로 생성되는 변수(앞에 static이 붙어있음)
 *        ==============================================================
 *        
 *        = 지역변수: 메소드 안에서만 사용
 *                 for(int i=0~) ==> 메소드가 종료하면 자동으로 사라지는 변수
 *                 => 메모리 자체에서 관리 {}이 끝나면 자동으로 사라진다
 *      = 메소드: 멤버변수를 이용해서 기능을 설정
 *      = 생성자: 멤버변수에 대한 초기화를 담당
 *      
 *      ============================
 *      여러개의 데이터를 모아서 처리(클래스)
 *      저장하는 방법
 *        클래스명 변수명=new 클래스명();
 *      데이터를 읽어오는 방법
 *        변수명.변수  /  클래스명.변수
 *        ========     =========
 *        인스턴스변수     static 변수
 *      ============================
 *      예)
 *          Tv t;  ==> 데이터 channel
 *          ====t====
 *           ==> 전체를 모은 메모리 주소 100
 *          =========
 *          t=new Tv();
 *            =======100=======
 *            -----channel-----
 *                    0           ==> 100번째 안에 있는 channel 데이터를 달라.  t.channel
 *            -----------------
 *            =================   주소명(메모리 => 주소,번지) 0 ~
 *            
 *              		            =======200=======
 *          						-----channel-----
 *           						        0           
 *           						-----------------
 *            						================= 
 *            						new를 사용하게 되면 메모리가 따로 저장 => 제어는 본인의 주소에 있는 내용만 제어가 가능
 *            
 *            class A
 *            {
 *            	 int a=100;   // 전체 프로그램(메소드 전체에서 사용이 가능) => 전역변수
 *            	 void display()
 *            	 {
 *            		// b,a 사용가능
 *            	    int b=10;   // 지역변수
 *            		if(b==0)
 *            		{
 *            		   int c=100;   // 지역변수
 *            		   // b,a,c 사용가능
 *            		}   // c변수 사용 영역
 *            	 }   // b변수 사용 영역
 *            	 void display2(int d)
 *            	 {
 *            	    int e=10;
 *            
 *            		// d,e,a 사용가능   ==> 매개변수는 지역변수가 될 수 있다
 *            	 }
 *            	 void display3(inta)
 *            	 {
 *            	    int a=10;
 *            	    System.out.println("a="+this.a);    // 10
 *             							 // ===== 변수명이 동일 할 때(멤버변수, 지역변수) => 지역변수가 우선순위
 *             								때문에 현재 {}에 있는 변수를 갖고 와 달라고 this.을 붙여야 함.
 *            	 }
 *            }   // a변수는 사용
 *            
 */
// public으로 시작하는 클래스는 반드시 1개만 사용 
class Chef
{
	String chef_name;
	int rank;
	int mem_cont1,mem_cont2,mem_cont3,mem_cont7;
	// 27,771 => String => int => ,=> ""
}
class Recipe
{
	String title;
	String chef;
	String content;
	String info1,info2,info3;
	String[] data1;
	String[] data2;
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chef chef=new Chef();
		chef.rank=1;
		chef.chef_name="시크제이맘";
		chef.mem_cont1=1712;
		chef.mem_cont2=1027593;
		chef.mem_cont3=33561876;
		chef.mem_cont7=21771;
		
		Chef chef1=new Chef();
		chef1.rank=2;
		chef1.chef_name="조밍키♥";
		chef1.mem_cont1=249;
		chef1.mem_cont2=603334;
		chef1.mem_cont3=12912223;
		chef1.mem_cont7=15335;
		
		// 실행
		System.out.println("쉐프명:"+chef.chef_name);
		System.out.println("작품:"+chef.mem_cont1);
		System.out.println("클립:"+chef.mem_cont2);
		System.out.println("방문자:"+chef.mem_cont3);
		System.out.println("소식:"+chef.mem_cont7);
		System.out.println("==============================");
		System.out.println("쉐프명:"+chef1.chef_name);
		System.out.println("작품:"+chef1.mem_cont1);
		System.out.println("클립:"+chef1.mem_cont2);
		System.out.println("방문자:"+chef1.mem_cont3);
		System.out.println("소식:"+chef1.mem_cont7);
		System.out.println("==============================");
	}

}
