
public class 메소드활용_1 {
	static void star(int a)    // 출력만을 위함. 리턴형x 매개변수x
	{
		for(int i=0;i<a;i++)
		{
			System.out.println("***** *****");
		}
	}
	static void star()
	{
		System.out.println("***** *****");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");   // 이렇게 출력하고 끝낼거면, for문이 좋음
		
		System.out.println("===== for =====");  // 근데 for문은 중간중간에 들어갈 수 없음
		for(int i=0;i<10;i++)
		{
			System.out.println("***** *****");
		}
		
		System.out.println("===== method =====");  // 계속 쓸 것 같다? => 메소드 처리
		star(10);
		
		System.out.println("===== method ====="); 
		star();star();star();star();star();
		star();star();star();star();star();

	}

}
