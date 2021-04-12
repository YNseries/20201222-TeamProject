
public class 메소드활용_3 {
	// void => 결과값은 존재하지 않는다 (메소드에서 출력만 함)
	static void aMethod()
	{
		System.out.println("aMethod 호출 시작...");
		System.out.println("aMethod 기능 처리...");
		System.out.println("aMethod 종료...");
	}
	static void bMethod()
	{
		System.out.println("bMethod 호출 시작...");
		System.out.println("bMethod 기능 처리...");
		System.out.println("bMethod 종료...");
	}
	static void cMethod()
	{
		System.out.println("cMethod 호출 시작...");
		System.out.println("cMethod 기능 처리...");
		System.out.println("cMethod 종료...");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main 시작...");  //1 시작과 종료를 하는 method는 항상 main method임!!
		aMethod();  //
		aMethod();  //
		bMethod();
		cMethod();
		System.out.println("main 종료...");

	}

}
