/*	 
 *   정리
 *     기본형 데이터
 *     ==========================================================
 *     	  	  1byte		2byte		4byte		8byte
 *     ==========================================================
 *     정수	   byte		short		int			long
 *     							   default
 *     							   System.out.println(100)
 *     												 ===== 컴퓨터에서는 int로 인식
 *     							   => int와 long 구분 ==> l(L) 예) long데이터를 출력 100L
 *     ==========================================================
 *     실수	 						float		double
 *     											default
 *     											System.out.println(100.5)
 *     															  ======= 컴퓨터는 double로 인식
 *     								=> float과 double 구분 ==> f(F)
 *     								예) 10.5F,  10.5
 *     ==========================================================
 *     문자				 char
 *     					문자 1개만 저장 가능 ==> ''
 *     ==========================================================
 *     논리	   boolean	항상 저장시에 true/false만 저장이 가능
 *     ==========================================================
 */
public class 변수_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 변수 설정
		// 정수(4byte)를 100으로 저장
		int x = 100; // 초기값
		System.out.println("x="+x); // 문자열 결합 "Hello" +"Java" => "HelloJava" 붙여쓰라는 얘기
		// 왼쪽으로 5만큼 이동
		x = 95;
		System.out.println("x="+x); // x=95
		x = 90;
		// 변수의 값을 변경 (가공=> 캐릭터가 이동 => x,y)
		// 변경된 값을 출력
		System.out.println("x="+x); // x= 90
		
		char c='A';
		// 'A'를 저장 => 'A'를 'B'로 바꾼다
		c= 'B'; // c라는 메모리 공간에는 최종 값이 저장된다
		System.out.println("c="+c);
		// 변수는 반드시 초기값을 대입해야 한다.
		// 4byte 정수를 3개를 만들고 100, 200, 300을 저장
		//int a = 100;
		//int b = 200;
		//int d = 300;
		int a=100, b=200, d=300;
		/*	 
		 * 	 1. 선언(변수설정)
		 * 		= 선언과 동시에 초기값을 대입
		 * 		  int a=100;  // default 
		 * 		= 선언을 하고 나중에 초기값을 대입
		 * 		  int=a;	//입력값을 받거나 외부에서 데이터를 갖고올 때, 난수발생
		 * 		  a=100;
		 */
		int k;
		k=500;
		// 설정된 데이터를 출력
		System.out.println("a="+a+",b="+b+",d="+d+",k="+k);
		
		// 실수
		float f=10.9f; // float f=(float)10.9; => 형 변환
		// UP Casting (데이터형 커진다), DOWN Casting (데이터형 작아진다)
		// 프로그램이 어려워진다 (같은 결과 => 개발자마다 소스코딩이 다르다)
		double q=10.9;
		
		// 기억
		double w=100;
		// 100 => 자동으로 100.0
		int u = 'A'; // u='A'(X) u=65 // A가 정수일 수가 없으니 그에 맞는 숫자로 바뀐 것.
		System.out.println("u="+u);
		System.out.println("w="+w);
		// 값을 저장시에는 왼쪽에 있는 데이터형이 저장하는 값보다 항상 크거나 같아야 한다
		/*
		 * 		데이터형의 크기
		 * 		===========
		 * 		byte < short, char < int < long < float < boolean
		 * 		정수보다는 실수가 크다
		 * 		= 메모리 크기로 설정하느느 것이 아니라 숫자를 표현할 수 있는 갯수
		 * 		  1
		 * 		  1.00000
		 * 		  1.0000000000000
		 */
		System.out.println("byte의 최소값:"+Byte.MIN_VALUE);
		System.out.println("byte의 최대값:"+Byte.MAX_VALUE);
		
		System.out.println("int의 최소값:"+Integer.MIN_VALUE);
		System.out.println("int의 최대값:"+Integer.MAX_VALUE);
		
		System.out.println("long의 최소값:"+Long.MIN_VALUE);
		System.out.println("long의 최대값:"+Long.MAX_VALUE);
	}

}
