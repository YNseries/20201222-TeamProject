// 가위 바위 보 게임
/*
 *   사용자 입력 : 0(가위), 1(바위), 2(보)
 *   컴퓨터 입력 : 난수(0,1,2)
 *   ===============================
 *   결과 : 중첩 if
 *   if()
 *   {
 *     if()
 *     {
 *     }
 *   }
 *   
 *   컴퓨터 ==> 알고리즘
 *     가위
 *       사용자
 *         가위
 *         바위
 *         보
 *     바위
 *       사용자
 *         가위
 *         바위
 *         보
 *     보
 *       사용자
 *         가위
 *         바위
 *         보
 */
import java.util.Scanner; //입력받는 경우에 사용하는 클래스 Scanner(문법 배울 때만 사용)
public class 단일조건문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자가 입력한 값을 받는다 (0,1,2)
		int user; // 사용자 입력값을 저장하는 공간
		// 사용자가 입력을 할 수 있게 처리
		Scanner scan=new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) 입력:");
		user=scan.nextInt();
		// 확인 => 사용자가 뭘 냈는지
		if(user==0) //
			System.out.println("사용자:가위");
		if(user==1) //
			System.out.println("사용자:바위");
		if(user==2) //
			System.out.println("사용자:보");
		
		///// 컴퓨터 (난수)
		int com=(int)(Math.random()*3); //0,1,2
		/*
		 *    Math.random() ==> 0.0~0.99
		 *    Math.random()*3 ==> 0.0~2.9xx
		 *    (int)0.0~2.9xx ==> 0~2
		 */
		if(com==0)
			System.out.println("컴퓨터:가위");
		if(com==1)
			System.out.println("컴퓨터:바위");
		if(com==2)
			System.out.println("컴퓨터:보");		
		
		/// 결과값을 출력
		System.out.println("******결과******");
		/*
		 *                            com-user
		 *      컴퓨터 (가위 0)
		 *         사용자 (가위 0)          0  비김
		 *              (바위 1)          -1 사용자
		 *              (보 2)           -2  컴퓨터
		 *       컴퓨터 (바위 1)
		 *         사용자 (가위 0)          1  컴퓨터
		 *              (바위 1)          0  비김
		 *              (보 2)           -1  사용자
		 *       컴퓨터 (보 2)
		 *         사용자 (가위 0)          2  사용자
		 *              (바위 1)          1  컴퓨터
		 *              (보 2)           0  비김
		 *              
		 *              ==> 사용자가 이길 확률?
		 *       
		 */
		/* //   가위       가위
		if(com==0 && user==0)
			System.out.println("비겼다!!");
		//   가위       바위
		if(com==0 && user==1)
			System.out.println("사용자 Win!!");
		//   가위       보
		if(com==0 && user==2)
			System.out.println("컴퓨터 Win!!");
		
		//   바위       가위
		if(com==1 && user==0)
			System.out.println("컴퓨터 Win!!");
		//   바위       바위
		if(com==1 && user==1)
			System.out.println("비겼다!!");
		//   바위       보
		if(com==1 && user==2)
			System.out.println("사용자 Win!!");
		
		//   보       가위
		if(com==2 && user==0)
			System.out.println("사용자 Win!!");
		//   보       바위
		if(com==2 && user==1)
			System.out.println("컴퓨터 Win!!");
		//   보       보
		if(com==2 && user==2)
			System.out.println("비겼다!!"); */
		/*
		 *   ==> 사용자가 Win ==> -1,2
		 *       컴퓨터가 Win ==> -2,1
		 */
		
		int res=com-user;
		if(res==-1 || res==2)
			System.out.println("사용자 Win!!");
		if(res==-2 || res==1)
			System.out.println("컴퓨터 Win!!");
		if(res==0)
			System.out.println("비겼다!!");

	}

}
