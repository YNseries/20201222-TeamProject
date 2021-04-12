/*
 *    자바에 지원하는 제어문
 *    = 조건문 : 원하는 명령만 수행할 수 있게 만든다, 에러예상
 *             = 단일 조건문 (true) => 독립문장
 *             ===================================
 *               if(조건문)
 *                 실행문장 ==> 조건문이 true일 때 수행
 *             ===================================
 *             = 선택 조건문 (true, false) => 삼항연산자
 *               if(조건문)
 *                 실행문장 ==> 조건문이 true일때 수행
 *               else
 *                 실행문장 ==> 조건문이 false일때 처리문장
 *             ===================================
 *             = 다중 조건문 => 한개의 문장
 *               if(조건문)
 *                 실행문장 ==> 1) 조건문이 true일때 수행 => 종료
 *                            2) false 다음 조건문으로 이동
 *               else if(조건문)
 *                 실행문장 ==> 1) true 실행문장을 수행 => 종료
 *                            2) false 다음 조건문으로 이동
 *               else if(조건문)
 *                 실행문장 ==> 1) true 실행문장을 수행 => 종료
 *                            2) false 다음 조건문으로 이동
 *               else
 *                 실행문장 ==> 해당 조건이 없는 경우에 수행하는 문장
 *                 
 *        ============> *** 조건에 해당하는 문장이 여러개 있는 경우
 *            int a=10;
 *            if(a%2==0) => true
 *              System.out.println("짝수");  => 수행 ==> if문 소속문장
 *              
 *              System.out.println("a="+a); => 수행 ==> if와 관련이 없는 문장
 *            
 *            ==> 짝수, a=10
 *            int a=10;
 *            if(a%2==1) => false
 *              System.out.println("짝수");  => 수행(x) ==> if문 소속문장
 *              System.out.println("a="+a); => 수행(o) ==> if와 관련이 없는 문장
 *              
 *            ===> 자바에서 지원하는 모든 제어문은 한개의 문장만 제어할 수 있다
 *                 여러개 문장을 제어 할때는 {}로 감싼다
 *            int a=10;
 *            if(a%2==1){
 *              System.out.println("짝수");
 *              System.out.println("a="+a);
 *            }
 *               
 *    = 선택문 : 원하는 명령 한 개를 처리한다
 *              switch(정수/문자/문자열) => 다른 언어는 사용할 수 없다(실수) => 다중 조건문
 *              {
 *                 case "LOGIN":
 *                    login처리
 *                 case "JOIN":
 *                    회원가입
 *                 case "RESERVE":
 *                    예매처리
 *              }
 *    = 반복문 : 중복 코드를 제거
 *       = while : 반복횟수가 지정이 안된경우 (Web) => 오라클
 *       = do ~ while : : 반드시 한번 이상 수행할 때
 *       = for : 반복 횟수가 지정이 되면
 *    = 반복제어문 : 반목분을 중단, 특정부분 제외할 경우
 *       = break => 반복문을 종료
 *       = continue => 특정부분을 제외
 */
public class 제어문기초 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
