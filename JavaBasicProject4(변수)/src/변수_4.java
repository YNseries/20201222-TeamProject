// Scanner : 키보드 입력값을 받아서 메모리에 저장
// BufferedReader : 반드시 예외처리 먼저 해 줘야 함
// Scanner를 사용하기 위해서는 반드시 클래스를 불러와야 함
// 이미 만들어진 클래스를 읽어올 때 사용 : import
import java.util.Scanner;

import javax.swing.JOptionPane;
/*
 *    import : Java
 *    include : C
 *    using : C#
 *    Kotlin : import (Java)
 */
public class 변수_4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner를 사용하는 방법
		Scanner scan=new Scanner (System.in); // Scanner 선언을 해야함
		// new => 메모리 할당, System.in => 키보드 입력값
		// System.out.print("정수 입력:");
		// 키보드로 입력한 정수를 저장한다
		// int input = scan.nextInt();
		// System.out.println("키보드 입력값:"+input);
		int kor,eng,math;
		System.out.print("국어 점수 입력:");
		kor=scan.nextInt();
		System.out.print("영어 점수 입력:");
		eng=scan.nextInt();
		System.out.print("수학 점수 입력:");
		math=scan.nextInt();
		
		// 결과값을 출력 (가공) => 연산자
		System.out.println("총점:"+(kor+eng+math));
		System.out.printf("평균:%.2f",(kor+eng+math)/3.0);
		// 사용자로부터 입력값을 받아서 처리. Scanner
		// 초기값 => 임의로 지정 int kor=80, 입력값을 받아서 사용 Scanner, 난수 
		// JOptionPane.showInputDialog("정수입력");
		
		/*   1. 출력
		 * 
		 * 		= System.out.println => \n 포함 (다음줄로 넘기는 것) (기본)
		 * 		= System.out.print => \n 미포함
		 * 		= System.out.printf => 서식이 필요할 때 (소수점처리 등..)
		 * 
		 * 	 2. 입력
		 * 
		 * 		Scanner => 키보드 입력값을 받는 경우에 주로 사용
		 * 		// Scanner => 클래스
		 *  	= import java.util.Scanner
		 *  	= Scanner를 저장
		 *  	  *** 클래스를 저장할 시에는 반드시 new를 사용해서 저장
		 *  	Scanner scan=new Scanner(system.in)
		 *  	= 입력이 되면
		 *  	  **scan.nextInt() => 정수를 입력했을 때
		 *  	  **scan.next()    => 문자열을 입력했을 때
		 *  	  scan.nextDouble()  => 실수를 입력했을 때
		 *  	  scan.nextBoolean() => true/false
		 */
		
	}

}
