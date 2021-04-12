/*
 *    숫자를 비교해서 정답 => true, 오답 => false
 *    6==9 => false
 *    6==6 => true
 *    =============== 비교연산자의 결과값은 항상 true/false
 *    비교연산자의 종류
 *    ===============
 *    == 같다
 *    != 같지 않다
 *    < 작다
 *    > 크다
 *    <= 작거나 같다
 *    >= 크거나 같다
 *    
 *    ==
 *     10==10 true
 *     10!=10 false
 *     10<11 true
 *     10>11 false
 *     10<=10 true (10==10 || 10<10)
 *                   true     false
 *     10>=10 true (10==10 || 10>10)
 *                   true     false  ==> ||는 둘 중에 한개만 true => true
 *                   
 *      => 원하는 데이터만 출력을 하고 싶은 경우
 *    
 */
public class 비교연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수 두개 저장 => 비교해서 처리
		int a=10;
		int b=11;
		System.out.println("a==b?"+(a==b)); //a와 b값이 같은가? => false
		System.out.println("a!=b?"+(a!=b)); //a와 b값이 같지 않다? => true
		System.out.println("a<b?"+(a<b)); // true
		System.out.println("a>b?"+(a>b)); // false
		System.out.println("a<=b?"+(a<=b)); // true
		System.out.println("a>=b?"+(a>=b)); // false
		// 제어문 ==> 조건문, 반복문(조건)에서 주로 사용
		// 총알이 비행기 안에 들어 갔는지 여부(게임)
		
		String dap=a%2==0?"짝수":"홀수"; // 2로 나눠서 0이 나오면 짝수, 아니면 홀수
		System.out.println(dap);

	}

}
