/*
 *    조건문
 *    1. 형식
 *       1-1 단일 조건문
 *           형식) if(조건문)
 *                {
 *                    조건문이 true면 수행하는 문장을 작성한다
 *                    (여러개의 문장 사용시에 {}한다)
 *                }
 *                => 조건문 false => 점프 (원하는 문장만 수행이 가능하게 만드는 기능)
 *                => enter 누르면 : 총알을 발사
 *                => esc 누르면 : 게임 종료
 *                => 독립실행 (단일 if가 여러개 있는 경우에는 따로 수행하기 때문에 여러개 동시에 수행할 수 있다)
 *       1-2 선택 조건문 : true일때 false일때 나눠서 수행할 수 있게 만든다
 *           형식)
 *                if(조건문)
 *                {
 *                    조건문이 true일 때 처리하는 문장
 *                }
 *                else
 *                {
 *                    조건문이 false일때 처리하는 문장
 *                }
 *                => ID가 중복이 된 경우, ID가 중복이 안된 경우
 *                => 로그인이 된 상태, 로그인이 안된 상태
 *                => 값이 입력된 경우, 값이 입력이 안된 경우
 *       1-3 다중조건문 : 조건이 여러개중에 한 개의 조건만 수행이 가능하게 만드는 경우에 사용
 *           => 메뉴,버튼
 *           형식)
 *               if(조건문)
 *               {
 *                   true : 문장을 실행하고 종료 ↗
 *                 ↘ false : 다음 조건문으로 이동
 *                   
 *               }
 *               else if(조건문)
 *               {
 *                   true : 문장을 실행하고 종료 ↗
 *                 ↘ false : 다음 조건문으로 이동
 *               }
 *               else if(조건문)
 *               {
 *                   true : 문장을 실행하고 종료 ↗
 *                 ↘ false : 다음 조건문으로 이동
 *               }
 *               else
 *               {
 *                   해당되는 조건이 없는 경우에 수행문장 (생략이 가능하다)
 *               }
 *       1-4 중첩 조건문 : 부메뉴 (주메뉴 => 부메뉴) ==> 이중 if
 *           형식)
 *                 if(조건문) => 조건(true)
 *                 {
 *                    if(조건문) => 조건(true)
 *                    {
 *                       실행문장
 *                    }
 *                 }
 *                 ===> 단일조건문 : if(조건문 && 조건문)
 *               
 *    2. 조건식 만드는 방법
 *         if(조건식) => 부정연산자(!), 비교연산자(==,!=,<,>,<=,>=), 논리연산자(&&,||)
 *           => == 같다
 *           => && : 기간, 범위가 포함이 된 경우
 *           => || : 기간, 범위가 포함이 안된 경우
 *           
 *           3자리 정수를 입력 (100~999) => num
 *           if(num<100 || num>999) => 오류
 *           if(num>=100 && num<=999) => 정상 수행 //반복문 사용
 *           
 *    3. 사용처
 *       3-1. 오류 처리 (잘못 입력이 된 경우) => 비정상 종료가 없는 프로그램
 *            ======
 *            사용자 입력, 프로그램 실수
 *                      ========== 씨티은행 (2주간 폐쇄)
 *                      "10,00" 이거 찾는데 2주 걸림. 
 *                      
 *       3-2. 점프 - 원하는 부분만 출력하고 싶은 경우에 주로 사용
 */
public class 조건문정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
