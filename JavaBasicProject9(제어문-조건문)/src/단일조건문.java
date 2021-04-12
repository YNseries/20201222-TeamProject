/*
 *    자바 조건문 (단일 조건문) : 독립적으로 실행 (조건이 true => 모든 문장을 수행한다)
 *    형식)
 *         if(조건 : 연산자(부정연산자, 비교연산자, 논리연산자))
 *               실행하는 문장 => 조건이 true일 경우에만 수행
 *         *** if(조건) => 여러개 문장ㅇ르 수행할 경우에는 {}안에 수행할 문장을 작성해야 함
 *             {
 *                 첫번째 문장
 *                 두번째 문장
 *                 --
 *                 --
 *                 --
 *              }
 *              ** 사용처 => web, mobile(메뉴, 버튼 클릭시), 게임(키보드 눌렀을 때)
 *                         ==== 자료수집 할 때
 *              
 *              예)
 *                   ==============
 *                   if(조건문)
 *                     실행문장 1
 *                   ==============
 *                     실행문장 2 => if와 관련이 없는 문장 (if=>true, false 상관없이 무조건 수행하는 문장)
 *                   
 *                   ==============
 *                   if(조건문)
 *                   {
 *                      실행문장 1
 *                      실행문장 2
 *                   }
 *                   ==============
 *                   실행문장 3 => 독립문장 (true/false 상관없이 무조건 수행하는 문장)
 *                      
 */
// 임의의 알파벳을 설정하고 => 대문자, 소문자 => 두 개의 조건문
// 사용자 입력
import java.util.Scanner;
public class 단일조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문자 한개를 저장하는 공간(변수) 필요
		char alpha; //초기값을 하지 않는 이유는 입력을 받으려고
		/*
		 *   변수의 초기값 
		 *   1. 명시적 초기화
		 *      char c='A';
		 *   2. 입력값을 받아서 초기화
		 *   3. 난수를 발생해서 초기화
		 */
		// 사용자의 입력값을 받아서 alpha 공간에 저장
		Scanner scan=new Scanner(System.in);
		// System.in => 키보드 입력값을 받는 경우
		System.out.println("알파벳을 입력:");
		//입력된 데이터를 저장
		// Scanner는 단점이 있다 => 문자 한 개를 받는 기능이 없다 => 문자열을 받아서 처리해야함
		String s=scan.next();
		//저장 (문자 한 개 저장)
		alpha=s.charAt(0); //맨 처음 글자를 char로 가지고 오는 기능(메소드)
		//출력
		System.out.println(alpha);
		///////////////////////////////// 평문 (순차적 구조)
		/// 1. 대문자 => A~Z => &&
		if(alpha>='A'&& alpha<='Z')
			 System.out.println(alpha+"는(은) 대문자입니다");
		/// 2. 소문자 => a~z => &&
		if(alpha>='a'&& alpha<='z')
			 System.out.println(alpha+"는(은) 소문자입니다");
		/// 3. 알파벳이 아닌 경우 => !  [^A-Za-z]
		if(!((alpha>='A'&& alpha<='Z')||(alpha>='a'&& alpha<='z')))
			System.out.println(alpha+"는(은) 알파벳이 아닙니다");

	}

}
