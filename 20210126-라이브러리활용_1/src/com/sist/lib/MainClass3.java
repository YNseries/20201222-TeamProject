package com.sist.lib;
import java.text.*;
import java.util.Random;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 예매율 => rating에 따라 달라 => 왓챠  => 화장품
		double[] limits= {50,60,70,80,90};       // 이 두개가 ChoiceFormat의 패턴
		String[] grades= {"F","D","C","B","A"};  // 이 두개가 ChoiceFormat의 패턴
		
		int[] score=new int[10];
		Random r=new Random();
		for(int i=0;i<score.length;i++) 
		{
			score[i]=r.nextInt(50)+51;  // 0~49 => 51~100
		}
		
		ChoiceFormat format=new ChoiceFormat(limits,grades);
		for(int i=0;i<score.length;i++)
		{
			System.out.println(score[i]+":"+format.format(score[i]));
		}

	}

}
