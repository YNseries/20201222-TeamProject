/*
 *    산술연산자
 *      / , %
 *      나눗셈(/)
 *        1. 0으로 나눌 수 없다     10/0 => error
 *        2. 정수/정수 = 정수
 *        	 5/2 = 2.5(x)   5/2=2  ==> 5/2.0=2.5
 *        	 double d=5/2.0  ==> 2.0
 *      % 나누고 나머지값 => 배수
 *        1. 주의점 : 결과값은 항상 왼쪽편의 부호를 따라간다
 *        	 5%2   ==> 1    1+4/2
 *           -5%2  ==> -1  -1-4/2
 *           5%-2  ==> 1    1+4/2
 *           -5%-2 ==> -1  -1-4/-2     -5*-2=10
 *           
 *        ==> 자동 형변환
 *        ==> 프로그래머가 변경 (강제 형변환)
 *           
 *           문자열 입력을 받아서 좌우대칭인지 여부를 출력
 *           1. 문자열이 짝수인 것을 우선 확인
 *           2. 중복인 것은 오류 처리
 *           ABBA
 */
// 최적화
// 에러를 예측(사용자가 무엇을 어떻게 누를지 모르기 때문에!) => 오류방지
public class 연산자_산술연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=123456;
		double d=123456.78;
		int k=(int)((d-i)*100);
					 // 0.78*100 ==> 78.0 ==> 78
		System.out.println("k="+k); // 77 (비트가 달랐기 때문에 8비트를 채워줘야 해서 78이 아닌 77임
		// d가 float이라면 비트가 같기 때문에 78 그대로 나옴
		
		int a=10;
		int b=3;
		System.out.println(a/(double)b); // 변수를 바꾸는 것이 아닌 형변환을 하는게 좋음.
		
		//a=10;
		//b=0;
		//System.out.println(a/b);
		
		int a1=5;
		int a2=2;
		int a3=-5;
		int a4=-2;
		System.out.println(a1%a2); // 5%2  = 1
		System.out.println(a1%a4); // 5%-2 = 1
		System.out.println(a3%a2); //-5%2  = -1
		System.out.println(a3%a4); //-5%-2 = -1

	}

}
