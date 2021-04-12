package com.sist.munje;
/*
 *     Grade 클래스를 작성해보자. 3 과목의 점수를 입력받아 Grade 객체를 생성하고 
 *     성적 평균을 출력하는 main()과 실행 예시는 다음과 같다.
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 "+me.average()); 
    // average()는 평균을 계산하여 리턴 }
수학, 과학, 영어 순으로 3개의 정수 입력 >> 90 88 96 평균은 91
 */
import java.util.Scanner;
class Grade
{
	private int math,science,english;
	public Grade(int math,int science,int english)
	{
		this.math=math;
		this.science=science;
		this.english=english;
	}
	public double average()
	{
		return (math+science+english)/3.0;
	}
}
public class 문제4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
		int math = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 "+me.average());

	}

}
