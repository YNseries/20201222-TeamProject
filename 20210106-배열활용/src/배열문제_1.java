// 양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라
// 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.

import java.util.Scanner;
public class 배열문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		
		for(int i:arr)
		{
			if(i%3==0)
			{
				System.out.print(i+" ");
			}
		} */
		
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*10)+1;
		}
		
		// sum
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n평균:"+sum/10.0);
		

	}

}
