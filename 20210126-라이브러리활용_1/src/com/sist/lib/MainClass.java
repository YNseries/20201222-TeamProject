package com.sist.lib;
/*
 *    java.util.*
 *    ===========
 *      목적: 웹(Spring(자바, 코틀린), 장고(파이썬))
 *          ===
 *          데이터베이스(오라클): 문자열, 숫자, 날짜
 *                          ====
 *                          String, int(Integer), double(Double), Date(Calendar)
 *      1. StringTokenizer: split(배열) => 빅데이터(분석)
 *         = hasMoreTokens(): boolean형식(자른 갯수를 모를 때)
 *         = nextTokens(): 실제 데이터를 가지고 온다: 리턴형 String
 *         = counterTokens(): 갯수: 리턴형 int
 *         = 데이터베이스, 네트워크
 *      2. Date: 시스템의 시간을 읽는다, 날짜제어: Calendar(달력: 일정표, 예매)
 *      3. 변환(java.text.*)
 *         SimpleDataFormat: 날짜를 변환해서 출력
 *                           년도: yyyy(yy)
 *                           월: MM(M) => 1,01 => M:12 MM:12(0=>8진법)
 *                           일: dd(d)
 *                           시간: HH(H)
 *                           분: mm(m)
 *                           초: ss(s)
 *         ChoiceFormat
 *         MassageFormat
 */
import java.util.*;
import java.text.*;  // 변환(Format)
class A
{
	int aa=10;
	public void display()
	{
		System.out.println("A:display Call...");
	}
}
// TO_CHAR('12345678','99,999,999') => 12,345,678
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 시스템의 시간 읽기
		Date date=new Date();
		// 2. 날짜를 변환
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");  // 출력할 땐 MM-dd가 좋지만, 제어를 위해서는 M-d가 나아
		String today=sdf.format(date);  // 오늘 갖고온 날짜를 위의 형식으로 표기해라
		// 3. 실행
		System.out.println(today);
		//4. 분리
		StringTokenizer st=new StringTokenizer(today,"-");
		String strYear=st.nextToken();
		String strMonth=st.nextToken();
		String strDay=st.nextToken();
		
		// strMonth="08";
		System.out.println("년도:"+strYear);
		System.out.println("월:"+strMonth);
		System.out.println("일:"+strDay);
		
		//5. 정수형으로 변환
		int year=Integer.parseInt(strYear);
		int month=Integer.parseInt(strMonth);
		int day=Integer.parseInt(strDay);
		System.out.println("========정수로 변환 후 출력========");
		System.out.println("년도:"+year);
		System.out.println("월:"+month);
		System.out.println("일:"+day);
		
		/*String today2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());  // 한번 쓰고 버릴 때
		System.out.println(today2);
		
		A a=new A();
		a.display();
		a.aa=100;
		
		new A().display();
		new A().aa=200;*/
	}

}
