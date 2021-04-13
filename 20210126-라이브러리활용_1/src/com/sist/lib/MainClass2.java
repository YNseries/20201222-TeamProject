package com.sist.lib;
// ChoiceFormat
import java.util.*;  // Scanner
import java.text.*;  // ChoiceFormat
/*
 *    public void display()
 *    {
 *        int a=10;
 *        if(a==10)
 *        {
 *            int b=20;
 *            
 *            {           === scope
 *            	  {
 *                    int c=30;
 *                    {
 *                        int d=30;
 *                    }
 *                    // a,b,c,d => d는 메모리에서 사라진다
 *                }
 *                // a,b,c => c는 메모리에서 사라진다
 *            }
 *            // a,b => b 사라짐
 *        }
 *        // a => a 사라짐
 *    }
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int[] score=new int[10];
		Random r=new Random();
		int i=0;
		for(i=0;i<score.length;i++) 
		{
			score[i]=r.nextInt(50)+51;  // 0~49 => 51~100
		}
		
		// 학점 구하기
		char[] hakjum=new char[10];
		for(i=0;i<score.length;i++)
		{
			switch(score[i]/10)
			{
			case 10:
			case 9:
				hakjum[i]='A';
				break;
			case 8:
				hakjum[i]='B';
				break;
			case 7:
				hakjum[i]='C';
				break;
			case 6:
				hakjum[i]='D';
				break;
			default:
				hakjum[i]='F';
			}
		}
		// 확인
		/*for(int i:score)   // for-each 구문은 반드시 받아야하는 데이터형을 줘야 함
		{
			System.out.print(i+" ");
		}*/
		for(i=0;i<score.length;i++)
		{
			System.out.println(score[i]+":"+hakjum[i]);
			
		}
	}

}
