package com.sist.string;
/*
 * 	  서제스트를 만들 경우: 검색기
 *      구글: 
 *    startsWith: 시작하는 문자열이 같은 경우 true
 *    리턴형: boolean
 *    매개변수: 시작하는 문자열 String
 *    원형: public boolean startsWith(String str)
 *    endsWith: 끝나는 문자열 같은 경우 true
 *    리턴형: boolean
 *    매개변수: 끝 문자열 String
 *    원형: public boolean endsWith(String str)
 *    
 *    contains: 문자열에 포함된 경우: true
 */
import java.util.Scanner;
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] menu= {
			"자바와 오라클",
			"자바프로그래밍",
			"혼자 배우는 자바",
			"자바 200제",
			"오라클과 Ajax",
			"JQuery and 자바",
			"HTML5 & CSS3",
			"자바와 파이썬 융합",
			"스프링5와 제이썬",
			"자바 기초"
		};
		Scanner scan=new Scanner(System.in);
		//System.out.print("검색어 입력:");
		//String find_data=scan.next();
		String find_data="  자바";  // 공백이 들어가면 위험. 찾을 수 없음. 때문에 밑에서 .trim() 넣어줘야 함
		
		// 검색어가 포함된 데이터 보여주기
		for(String s:menu)
		{												  // 오라클에서의 형식 ↓
			if(s.startsWith(find_data.trim()))   // 자바로 시작하는  => LIKE '자바%' 자바로 시작하는 모든 문자열
			//if(s.endsWith(find_data))     // 자바로 끝나는   => LIKE '%자바'
			//if(s.contains(find_data))       // '자바'가 포함된 => LIKE '%자바%'
			{
				System.out.println(s);
				try
				{
					Thread.sleep(300);   // 0.3초
				}catch(Exception ex) {}
			}
		}

	}

}
