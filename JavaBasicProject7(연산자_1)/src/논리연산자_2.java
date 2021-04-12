/*
 *    || 연산자
 *    형식)
 *         (조건) || (조건)
 *         =====    =====  조건은 항상 true/false ==> 최종 결과값 : true/false
 *         조건 만들 때 : 사용할 수 있는 연산자 (부정연산자, 비교연산자)
 *                                         ! (boolean), ==, !=, <, >, <=, >=
 *         (조건) || (조건)
 *         ture     true   ===> true
 *         true     false  ===> true
 *         false    true   ===> true
 *         false    false  ===> false
 *         =====    =====
 *           1   ||   2
 *              ====
 *               3    ===> 결과값
 *         *** 효율적인 연산
 *             = 왼쪽편의 조건이 true일 경우에..
 *             
 *         *** 예매할 때 사용
 *         
 */
public class 논리연산자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=9;
		boolean bCheck=(a%2==0 || ++b==a);
		/*
		 *     a%2==0 ==> 10%2==0 true
		 *     //++b==a ==> 조건 검색을 하지 않았다
		 *     //두 개의 결과 || 연산처리 ==> true
		 */
		System.out.println("a%2==0 || ++b==a?"+bCheck);
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		bCheck=(a%2!=0 || ++b==a);
		/*
		 *    a%2!=0 => 10/2!=0 => false
		 *    ++b==a => 10==10  => true
		 *    false || true = true
		 */
		System.out.println("a%2!=0 || ++b==a?"+bCheck);
		System.out.println("a="+a);
		System.out.println("b="+b);

	}

}
