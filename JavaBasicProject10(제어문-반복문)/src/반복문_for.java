/*
 *    for
 *    1. 사용처=> 반복 횟수가 지정된 경우에 주로 사용
 *    2. while, do~while(1차)과 달리 for문은 2차까지 해야함
 *    3. for문의 형식
 *       3-1. 일반 for    false => 종료
 *                 ①  →  ②  ←  ④
 *            for(초기값;조건식;증가식)
 *            {          ↓ true
 *                       ③     ↗
 *                    반복수행문장
 *            }
 *            
 *            실행과정
 *              초기값 => 조건식(조건검색)              ↖ (조건식으로 이동)
 *                       = true  : => 반복수행문장 => 초기값을 변경(증가/감식)
 *                       = false : for문을 종료 
 *       
 *       3-2. 향상된 for(JDK1.5이상) => web에서 주로 사용(forEach구문)
 *            =========
 *            1. 배열(다음장), 2. 컬렉션(2권)이 있어야 사용 가능 
 *           
 */
public class 반복문_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 홀수면 ☆, 짝수면 ★
		for(int i=1; i<=10; i++) {
			// 별을 10개 출력
			/* if(i%2==1)
				System.out.print("☆"); // i가 홀수일 경우
			else
				System.out.print("★"); // i가 짝수일 경우 */
		
			if(i%3==0)
				System.out.print("☆");
			else
				System.out.print("★");
		}

	}

}
