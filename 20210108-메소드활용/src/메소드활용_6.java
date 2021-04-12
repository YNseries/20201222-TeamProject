
public class 메소드활용_6 {
	static int a=10;   // 전역변수. 모든 클래스에서 사용 가능. 이렇게 해야 매개변수가 없어도 됨
	static void print1()
	{
		
		System.out.println("a="+a);
		print2();
	}
	static void print2()
	{
		System.out.println("a="+a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print1();
	}

}
