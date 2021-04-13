package com.sist.main;
import java.util.*;
import java.text.*;
/*class A
{
	private static A a=null;
	public static A getInstance()
	{
		if(a==null)
			a=new A();   // a가 null 이면 생성
		return a;        // 아니면 그냥 씀
	}
}*/
/*
 *    year/day는 상관없이 그대로 집어넣으면 된다
 *    month => 1~12로 저장 됨. 때문에 저장할 때 month-1 해야함
 *    week => DAY_OF_WEEK ==> 1~7 -1 배열(0부터 시작하니까) 돌아갈 때 편함
 *    
 *    getActualMaximum(): 각 달의 마지막 날짜를 읽어온다
 *    set(): 날짜 설정
 *    get(): 설정된 날짜 읽어온다
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();  // 싱글턴(static)
		/*
		 * A a=A.getInstance(); System.out.println("a="+a); A b=A.getInstance();
		 * System.out.println("b="+b); // 여러개를 생성해도 같은 주소값을 쓰는 것 = 싱글턴 
		 * A c=A.getInstance(); System.out.println("c="+c);
		 */
		/* Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		
		cal.set(Calendar.YEAR, year);  // 설정
		cal.set(Calendar.MONTH, month-1);  // (0~11) 1월-0, 2월-1, 3월-2, ...
		cal.set(Calendar.DATE, day);
		
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;  // 1~7 -1  => 0~6
		int lastday=cal.getActualMaximum(Calendar.DATE);   // 마지막 날짜 갖고와
		System.out.println(lastday);
		String[] strWeek= {"일","월","화","수","목","금","토"};
		//int week=cal.get(Calendar.DAY_OF_WEEK);
		//String[] strWeek= {"","일","월","화","수","목","금","토"}; 이렇게 0을 없애기 위한 공백을 넣어줘도 됨
		
		String msg=String.format("%d년도 %d월 %d일 %s요일입니다", cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),strWeek[week]);  // 설정한 값 갖고오기
		//              ================= 저장된 값이 1이 줄어든 상태이기 때문에 +1 해줘야 함
		System.out.println(msg); */
		
		Date date=new Date();  // 시스템의 날짜(시간) ==> 오라클 저장시에 사용
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  // 원하는 형식으로 바꿈
		System.out.println(sdf.format(date));
	}

}
