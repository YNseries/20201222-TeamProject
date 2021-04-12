/*
 *    선택문 : 값 한 개rk 선택이 된 경우에 처리(다중조건문) => 게임 제작, 윈도우 제작
 *    1-10
 *    11-20
 *    21-30
 *    31-40
 *    41-50   ==> case 1:
 *    형식)  switch(정수,문자,문자열)
 *                정수 => 3
 *          switch(정수)
 *          {
 *             case 1:
 *                실행문장 1;
 *                문장 수행 후에 종료 : break;
 *             case 2:
 *                실행문장 2;
 *                문장 수행 후에 종료 : break;
 *             case 3:
 *                실행문장 3;
 *                문장 수행 후에 종료 : break;
 *             default:  ========> 생략가능
 *                실행문장 4;  //맨 마지막엔 break 안해도 됨
 *          }
 *          
  *          switch(문자)
 *          {  문자 = 'A'
 *             case 'A':
 *                실행문장 1;
 *                문장 수행 후에 종료 : break;
 *             case 'B':
 *                실행문장 2;
 *                문장 수행 후에 종료 : break;
 *             case 'C':
 *                실행문장 3;
 *                문장 수행 후에 종료 : break;
 *             default:  ========> 생략가능
 *                실행문장 4;  //맨 마지막엔 break 안해도 됨
 *          }
 *          switch(문자열)
 *          {
 *             case "로그인":
 *             case "회원가입":
 *             case "영화목록":    
 *             case "상세보기":
 *          }
 *          
 *          final int LOGIN=1
 *          
 *          case LOGIN:
 */
public class 선택문 {
	// 0.0 and less than 1.0 => 0.99
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no=(int)(Math.random()*5) + 1; //1~5
		//      ===  ===============  ===
		//       2          1          3 
		//            (0.0~4.99999)
		//      0~4  ===> +1   1~5
		// 3
		switch(no)
		{
		case 1: // if(i==1)
			System.out.println("1이 선택되었습니다");
			break; //위의 문장하고 switch를 종료
		case 2: // if(i==2)
			System.out.println("2가 선택되었습니다");
			break;
		case 3: // if(i==3)
			System.out.println("3이 선택되었습니다");
			break;
		case 4:
			System.out.println("4가 선택되었습니다");
			break;
		case 5:
			System.out.println("5가 선택되었습니다");
		}
		/*
		 * 	   10,9 => A, 8 => B, 7=>C, 6=>D default=>F
		 *     switch(score)
		 *     {
		 *        case 10: => if(score==10 || score==9)
		 *        case 9:
		 *           A            // 라벨이 10이거나 9이면 A
		 *           break;
		 *        case 8:
		 *           B
		 *           break;
		 *        case 7:
		 *           C
		 *           break;
		 *        case 6:
		 *           D
		 *           break;
		 *        default:
		 *           F
		 *     }
		 */
		         

	}

}
