package com.sist.util;
// StringTokenizer => java.util.*
/*
 *    단어별로 문자열을 분리하는 역할(빅데이터)
 *    = hasMoreTokens()   갯수 명확하게 모를 때
 *    = countTokens()     갯수를 알 수 있음
 *    = nextToken()       하나씩 갖고 올 때
 */
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String colors="red|yellow|blue|green|black|white";
		StringTokenizer st=new StringTokenizer(colors,"|"); // 변수 colors 중에 뭘 자를건지 결정
		System.out.println(st.countTokens());
		/*while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}*/
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());  // 위의 생략된 두 줄과 같은 출력
	}

}
