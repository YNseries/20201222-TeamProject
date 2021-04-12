/*
 *    중첩 => if 안에 if가 첨부 (이중if)
 *    형식)
 *        if(조건문) 조건문 true
 *        {
 *           if(조건문) true
 *           {
 *              실행문장
 *           }
 *        }
 *        
 *        ==> if(조건문 && 조건문)
 */
// 3개 정수를 받아 평균, 총점, 학점( >=98 A+  94<= A-)
import java.util.Scanner;
public class 중첩조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 저장하는 데이터 => 메모리 공간(변수)
		int kor,eng,math,total,avg;
		char score=' ',option=' '; //'' 사이 붙이면 안됨 // +,-,0  A+ A- A0
		// 초기값
		Scanner scan=new Scanner(System.in);
		//국어, 영어, 수학
		System.out.println("국어점수 영어점수 수학점수 입력(90 90 90):");
		kor=scan.nextInt();
		eng=scan.nextInt();
		math=scan.nextInt();
		
		//총점
		total=kor+eng+math;
		//평균
		avg=total/3;
		//학점
		if(avg>=90)
		{
			score='A';
			if(avg>=98)
			{
				option='+';
			}
			else if(avg<94)
			{
				option='-';
			}
			else
			{
				option='0';
			}
		}
		else if(avg>=80)
		{
			score='B';
			if(avg>=88)
			{
				option='+';
			}
			else if(avg<84)
			{
				option='-';
			}
			else
			{
				option='0';
			}
		}
		else if(avg>=70)
		{
			score='C';
			if(avg>=78)
			{
				option='+';
			}
			else if(avg<74)
			{
				option='-';
			}
			else
			{
				option='0';
			}			
			
		}
		else if(avg>=60)
		{
			score='D';
			if(avg>=68)
			{
				option='+';
			}
			else if(avg<64)
			{
				option='-';
			}
			else
			{
				option='0';
			}
		}
		else
		{
			score='F';
		}
		//출력
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
		System.out.println("총점:"+total);
		System.out.println("평균:"+avg);
		System.out.printf("학점:%c%c\n",score,option);
		

	}

}
