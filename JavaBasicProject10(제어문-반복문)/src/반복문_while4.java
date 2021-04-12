// while : 반복횟수가 없는 경우에 주로 사용
// Up-Down 게임
/*
 *     게임 : 난수 (1~100 사이의 난수 발생)
 *           ======================== 맞추는 게임
 *           힌트 : up, down
 *           난수 : 70
 *           사용자 입력 : 80 ==> DOWN
 *           사용자 입력 : 65 ==> UP
 *     
 *     게임 제작
 *     =======
 *     1. 난수 발생 => 메모리에 저장
 *     2. 사용자가 입력
 *     3. 난수와 사용자 입력값 비교
 *     4. 힌트
 *     5. 종료여부 확인 => true ==> 게임 종료
 *                      false ==> 2번으로 이동
 */
// 사용자 입력값을 받기
import java.util.Scanner;
public class 반복문_while4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 1~100 사이의 숫자 한 개를 저장 (임의의 숫자 = 난수)
		int com=(int)(Math.random()*100)+1;
		/*
		 *    1. (Math.random()*100) ==> 0.0~0.99 ==> 0.0~99.0
		 *    2. (int) 0.0~99.0 ==> int ==> 0~99
		 *    3. +1 ==> 1~100
		 */
		// 사용자 입력 => 정답 맞출때까지
		Scanner scan=new Scanner(System.in);
		while(true)  // 무한루프
		{
			// 1. 사용자 입력값을 받는다
			System.out.print("1~100 사이의 정수 입려:");
			//    사용자 입력값 저장
			int user=scan.nextInt();
			// 2. 난수와 입력 비교
			
			// 3. 힌트
			// 4. 종료
			if(com>user)
			{
				System.out.println("입력값보다 큰 값을 입력하세요");  // UP
			}
			else if(com<user)
			{
				System.out.println("입력값보다 작은 값을 입력하세요");  // DOWN
			}
			else
			{
				//com==user
				System.out.println("Game Over!!");
				//프로그램 종료
				System.exit(0);  // 정상 종료한다. 이건 함부로 쓰면 안됨. 밑에서 종료가 불가능한 사태가 벌어짐
				// break;  // 위와 똑같음. 원래는 break 써야하지만 안배워서 위와 같이 종료함
			}
			
		}
		// System.out.println("프로그램 종료");

	}

}
