package com.sist.main;
import java.util.*;
class Diary
{
	public void myDate()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		
		// 전년도까지 구하기
		int total=(year-1)*365
				  +(year-1)/4
				  -(year-1)/100
				  +(year=1)/400;
		int[] lastDay= {31,28,31,30,31,30,
						31,31,30,31,30,31};
		if((year%4==0 && year%100!=0)||(year%400==0))
			lastDay[1]=29;
		else
			lastDay[1]=28;
		// 전달까지 구하기
		for(int i=0;i<month-1;i++)
		{
			total+=lastDay[i];
		}
		// +day
		total+=day;
		// %7
		int week=total%7;
		String[] strWeek= {"일","월","화","수","목","금","토"};
		System.out.printf("%d년도 %d월 %d일은 %s요일입니다\n",year,month,day,strWeek[week]);
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diary d=new Diary();
		d.myDate();
	}

}
