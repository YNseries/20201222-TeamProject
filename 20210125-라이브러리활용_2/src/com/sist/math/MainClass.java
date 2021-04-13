package com.sist.math;
// Math
/*
 *     ceil(): 올림 메소드 ===> public ststic double ceil(double d)
 *     
 *     int count=38;
 *     int total=count/10;  => total=3
 *     if(total%10>0)
 *        total++;          => total=4
 *     
 *     int count=38;                   ==== 10으로 갖고오면 정수로 나오기 때문에 10.0 넣어야함
 *     int total=(int)(Math.ceil(count/10.0))    => total=4
 *     
 *     ==> SELECT CEIL(COUNT(*)/10.0) FROM movie => SQL(검색)
 *     
 *     
 *     random() => 컴퓨터에서 임의이ㅡ 수를 가지고 온다(난수) ==> public static double random()
 *     ========
 *        0.0 ~ 0.90 사이의 실수를 발생
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ceil
		int count=47;
		int total=(int)(Math.ceil(count/10.0));   // total=4
		//                        ========== 우선계산 위치. 10으로 나누면 4.0 ==> (10.0으로 나눠야 4.7 나옴) (1이상)
		System.out.println(total);
		
		// random()
		int data=(int)(Math.random()*100)+1;  // 0.0~99.0 => 0~99 => 1~100
		// 연산자 우선순위 ===> () (type) => 
		System.out.println(data);
	}

}
