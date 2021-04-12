/*
 *    1. static => instance메소드(변수) 호출
 *       => 다른 클래스에서 불러서 사용
 *    2. insance메소드 => static
 *       => 다른 클래스에서 불러서 사용
 *    
 *    class A
 *    {
 *    	int a;
 *    	static int b;
 *    
 *    	public void disp1()
 *    	{
 *    		기능 처리
 *    	}
 *    	public static void disp2()
 *    	{
 *    		기능 처리
 *    	}
 *    
 *    	// main
 *      public static void main(String[] args)
 *      {
 *         // 1. static 메소드 호출, static 변수 호출
 *         System.out.println(b);  // 같은 클래스 내에 있는 경우. 그냥 가져다 쓸 수 있음
 *         disp2();
 *      }
 *    }
 */
class A
{
	static int b=100;
	int c=200;  // instance 변수
	public void disp()
	{
		System.out.println("A:disp() Call...");
	}
	public static void display()
	{
		System.out.println("A:display() Call");
	}
}
public class 객체지향프로그램 {
	static int a=10;
	public static void disp()
	{
		System.out.println("disp:Call...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a="+a);
		disp();        // 같은 클래스 안이라서 객체지향프로그램. 생략 가능 & 붙여도 상관없음
		A.display();   // 앞에 A. 붙이지 않으면 못씀. 다른 클래스에 있기 때문에
		System.out.println("b="+A.b);
		// instance 항상 메모리에 저장하는 공간을 만들고 => 저장 후에 사용
		//              ===================== 동적 메모리 할당(new)
		A a=new A();
		a.disp();
		System.out.println("a.c="+a.c);

	}

}
