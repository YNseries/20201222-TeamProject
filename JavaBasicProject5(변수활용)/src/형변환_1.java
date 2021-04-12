/*
 *   형변환 : 변수의 데이터를 다른 데이터형으로 변환
 *   1. 가장 많이 변경
 *   	Web, 윈도우 프로그램, 모바일 프로그램
 *   	문자열 => 정수형으로 변경
 *   	===================
 *   1-1 문자 => 정수, 정수 => 문자로 변환
 *   	 정수 => 실수, 실수 => 정수로 변환
 *   1-2
 *   	 1. 자동 형변환 (UpCasting)    ====> 작은 데이터형이 큰 데이터형으로 변경
 *   		int a='A'
 *   			  === int 변경
 *   		long a=100
 *   			   ===
 *   				int => long (100L)
 *   		double d=100
 *   				 ===
 *   				 int ==> double (100.0)
 *   		데이터형의 크기 (숫자(정수, 실수), 문자)
 *   		==========================================
 *   		byte < Short < int < long < float < double
 *   				char
 *   		==========================================
 *   		double d='A'
 *   				 === char ==> double (65.0)
 *   	 2. 강제 형변환 (DownCasting)  ====> 큰 데이터형을 작은 데이터형으로 변경
 */
public class 형변환_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a='A'; // 'A' => (int변경) 65
		System.out.println("a="+a);
		double d='A'; // 'A' => (double 변경) 65.0
		System.out.println("d="+d);
		double d1=100; // 100 => (int 변경) 100.0
		System.out.println("d1="+d1);
		// 작은 데이터형 값을 첨부 => 큰 데이터형으로 변환(무조건은 x)
		//int a=100 char c='a'
		
		// int a=10.5;
		// 큰것을 작은것으로(ex. 실수를 정수로) 바꾸는건 자동으로 안됨. 오류남. 그래서 강제로 해야함
		int a1=(int)10.5; // 실수 => 정수 (소수점은 인식하지 않는다) => a1=10 (반올림 x)
		System.out.println("a1="+a1);
		// 강제 형변환 ==> (데이터형)값  보통 실수->정수.
		// int a2=Integer.parseInt("100");
		/*
		 * 	 숫자와 관련된 내용만 가능
		 *   int => char	(char)65   =>  'A'	
		 *   char => int	(int)'A'   =>  65
		 *   double => int	(int)10.5  =>  10
		 *   int => double  (double)10 =>  10.0
		 *   
		 *   형변환 : 큰 데이터형에 작은 데이터형을 대압하는 경우에는 자동변환
		 *   		   double d='A';
		 *   		작은 데이터형에 큰 데이터형을 대입시에는 반드시 데이터형을 설정 (데이터 타입을 바꾸는 것이기 때문에)
		 *   		   int a1=(int)10.5;
		 */

		// 형변환 주의점 ==> 오버플로우
		byte b1=(byte)250; //범위를 벗어남 (127)
		/*
		 *   0~9
		 *   01234567890123456789
		 */
		System.out.println("b1="+b1);
		/*   
		 *   1 0101 1110
		 *   => byte => 0000 0000
		 *   			0101 1110		
		 */
		
	}

}
