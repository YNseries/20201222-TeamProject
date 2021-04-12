// 사용자가 입력
/*
 *    1 => Home
 *    2 => Join
 *    3 => 영화목록
 *    4 => 영화추천
 *    5 => 영화예매
 *    6 => 프로그램 종료
 */
import java.util.Scanner;
public class 다중조건문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no;
		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴를 선택하세요(1.홈 2.회원가입 3.영화목록 4.영화추천 5.영화에매 6.종료):");
		no=scan.nextInt();
		//결과값을 보여준다
		if(no==1)
			System.out.println("영화 홈입니다");
		else if(no==2)
			System.out.println("회원가입 폽입니다");
		else if(no==3)
			System.out.println("영화목록을 출력합니다");
		else if(no==4)
			System.out.println("영화 추천을 합니다");
		else if(no==5)
			System.out.println("영화예매를 시작합니다");
		else
			System.exit(0); //프로그램 종료시 (0=> 정상종료, 1=>비정상 종료)
		

	}

}
