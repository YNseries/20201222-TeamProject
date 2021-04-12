/*
 *    1. 입력
 *    2. 처리  ==> 세부적으로 (여러개) => 다른 클래스(재사용)에서 사용할 수 있도록
 *    3. 출력
 *    
 *    ==== 메소드
 *    1. 매개변수 : 사용자가 입력값
 *    2. 결과값(리턴형)
 *    
 *    		매개변수를 봐야 전역변수로 넣을지 지역변수로 넣을지를 알 수 있음
 *   	 	int year=input("년도");
			int month=input("월");
			
			System.out.println(year+"년도 "+month+"월");
			
			// 요일 출력
			weekPrint();
			
			int week=weekData(year,month);
			
			// 출력
			datePrint(month, week);
			
			===> 클래스
			     = 변수 => 지역, 전역
			     = 메소드
 */
import java.util.Scanner;
public class 달력만들기_메소드 {
	static int input(String msg)   // 년도/월 두번 쓰려고
	{
		Scanner scan=new Scanner(System.in);  // System.in => 키워드 입력값을 읽어오는 기능
		System.out.print(msg+"입력:");
		return scan.nextInt();
	}
	// 요일 출력
	static void weekPrint()
	{
		String[] strWeek={"일","월","화","수","목","금","토"};
		for(String week:strWeek)
		{
			System.out.print(week+"\t");   // 이 위치의 week과 아래위치의 week은 다름. 지역변수
		}
		System.out.println();   // 다음줄에 출력
	}
	static boolean isYear(int year)
	{
		boolean bCheck=false;
		
		if((year%4==0 && year%100!=0)||(year%400==0))
			bCheck=true;   // 이 문장을 수행 안하면 무조건 false
		
		return bCheck;
	}
	// 요일구하기 (처리)
	static int weekData(int year,int month)
	{
		// 1. 전년도까지의 합
			int total=(year-1)*365+(year-1)/4          // 전년도까지니까 올해를 제외하고 윤년 계산 추가
					              -(year-1)/100
					              +(year-1)/400;
			// 2. 전 달까지의 합
			/*
			 *    case 2:      // 2월달이면
			 *       total+=31    // 31일이 추가되어야    
			 *    case 3:
			 *       total+=31+28
			 *     case 4:
			 *       total+=31+28+31      // => 일일이 하는 것보단 배열을 이용하는 것이 좋지!
			 */
			int[] lastday= {31,28,31,30,31,30,
					        31,31,30,31,30,31};
			/*
			 * if((year%4==0 && year%100!=0)||(year%400==0)) // ****윤년조건**** 2월 =>29
			 * lastday[1]=29; else lastday[1]=28;
			 */
			if(isYear(year))
				lastday[1]=29;
			else
				lastday[1]=28;
			for(int i=0;i<month-1;i++)  // 전 달, 기준점이 사용자가 입력한 값이기 때문에 
			{
			total+=lastday[i];
			}                           // 이게 전 달까지의 합 끝
			
			// 3. +1
			total++;    // 각 달의 1일자 확인
			int week=total%7;     // 요일
			
			return week;
	}
	// 출력
	static int getLastDay(int month) 
	{
		int[] lastday= {31,28,31,30,31,30,
		        31,31,30,31,30,31};
		return lastday[month-1];
	}
	static void datePrint(int month, int week)
	{
		for(int i=1;i<=getLastDay(month);i++)
		{
			if(i==1)
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");     // 공백(tab)
				}
			}
			System.out.printf("%2d\t",i);       // %2d: 한 칸 띄어쓰기?
			week++;                             // 토요일까지 숫자가 입력되고 밑으로 내려가는 코드 필요함
			if(week>6)   // 토요일보다 커지면
			{
				week=0;  // 0, 일요일로 가도록
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=input("년도");
		int month=input("월");
		
		System.out.println(year+"년도 "+month+"월");
		
		// 요일 출력
		weekPrint();
		
		int week=weekData(year,month);
		
		// 출력
		datePrint(month, week);
	
	}

}
