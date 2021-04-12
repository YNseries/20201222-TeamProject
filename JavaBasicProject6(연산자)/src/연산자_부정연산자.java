/*
 *   부정연산자 (단항연산자)
 *   연산자 기호 : !
 *   사용하는 데이터형이 항상 boolean
 *     true => false
 *     false => true
 *     
 *     ==> 결과값이 boolean으로 나오면 => 조건문 (if())
 *     
 *     != ==
 */
import java.util.Scanner; //키보드로 입력값을 받는 경우 사용
public class 연산자_부정연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner 선언
		/*
		 *   변수 선언
		 *   데이터형 변수명 = 값
		 *   int i=10;
		 *   
		 *   클래스 선언
		 *   클래스명 변수명(객체) = new 생성자()
		 *   				        ====   클래스 명과 동일
		 */
		Scanner scan=new Scanner(System.in);  //SYstem.in => 키보드값을 읽어올 때
		System.out.println("true/false입력:");
		boolean bCheck=scan.nextBoolean();
		System.out.println("bCheck="+bCheck);
		// 변경
		System.out.println("변경후 :"+!bCheck);
		

	}

}
