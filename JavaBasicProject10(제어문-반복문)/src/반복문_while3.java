/*
 *    1. 시작 ==> 1,0
 *    2. 어디까지(루프횟수) => i<=100, i<100
 *    3. 반복문장? => 여러 문장이 될 수 있다
 *    4. 증가폭
 */
/*
 *    while 형식
 *    =========
 *    초기값 ==> 시작       =====> int i=1
 *    while(조건식)  ==> 끝 ====> i<=10
 *    {
 *        반복문장 => 시작~끝까지 지정된 갯수만큼 수행
 *        증가식 i++;
 *    }
 *    
 *    초기값 ==> 시작    ====> int i=10
 *    while(i>=1)
 *    {
 *        반복문장
 *        증감식 i--;  2개씩 => i+=2,   3개씩 => i+=3, ...
 *    }
 *    
 *    
 *    ===> while은 횟수가 없는 경우에 주로 사용
 *         while(true) => 보통 무한루프
 *         {
 *             종료 => break;
 *         }
 */
// 1~100까지 합, 짝수 합, 홀수 합
// 변수 3개 필요. sum(전체 합 누적), even(짝수합), odd(홀수합)
public class 반복문_while3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0, even=0, odd=0;
		int i=1; // 1부터 100까지 변경되는 변수
		while(i<=100)
		{
			// 전체합
			sum=sum+i;  // sum+=i;
			// 짝수합
			if(i%2==0)
				even=even+i;
			// 홀수합
			else
				odd=odd+i;
			i++;
		}
		// 결과값 출력
		System.out.println("1~100까지의 총합:"+sum);
		System.out.println("1~100까지 짝수의 합:"+even);
		System.out.println("1~100까지 홀수의 합:"+odd);

	}

}
