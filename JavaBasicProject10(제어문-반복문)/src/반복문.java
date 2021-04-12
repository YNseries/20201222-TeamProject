/*
 *    자바에서 지원하는 반복문
 *    => 같은 소스가 여러번 코딩이 된 경우에 사용 기술
 *    1. while : 반복 횟수를 지정하지 않는 경우 (데이터베이스(오라클)) => 선 검색 후 실행 혹은 빠져나감
 *       게시물, 레시피목록, 영화목록 등 ==> web
 *    2. do~while : 한 번 이상을 반복하는 경우에 사용
 *                 ============== 조건검색 (나중에 하기 때문)
 *    3. for : 반복 횟수가 지정된 경우
 *       ===
 *       
 *       1) 동작하는 순서 : while, for => 선 조건검색, do~while => 후 조건검색
 *       2) 형식 :
 *            2-1 while
 *                초기값 int i=1;          ================== 1
 *                while(조건문) => i<=10   ================== 2
 *                {
 *                   반복문장 System.out.println("i="+i); ==== 3
 *                   증가식 i++;     ===================== 4 ======> 2번으로 이동
 *                }
 *                1 (초기값) => 2 (초기값에 대한 조건검색) => 3 반복문장 수행 === 4 증가식
 *                         => 증가된 값에 대한 조건 검색 => 3 반복문장 수행 === 4 증가식
 *                            ====================
 *                            true : 3 => 4
 *                            false : 종료
 *       3) 사용처
 */
public class 반복문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=====반복문을 사용하지 않는 경우====="); //일정한 패턴이 있어야 반복문 사용 가능
		System.out.println("i=1");
		System.out.println("i=2");
		System.out.println("i=3");
		System.out.println("i=4");
		System.out.println("i=6");
		System.out.println("i=7");
		System.out.println("i=10");
		System.out.println("i=5");
		System.out.println("i=8");
		System.out.println("i=9");
		System.out.println("====반복문을 사용할 때====");
		int i=1;
		while(i<=10)
		{
			System.out.println("i="+i);
			i++;
		}
	}

}
