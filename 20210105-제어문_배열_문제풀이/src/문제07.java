//	정수 입력을 받아서 60이상 합격 =>불합격  if~else
import java.util.Scanner;
public class 문제07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score;
		Scanner scan=new Scanner(System.in);
		System.out.println("점수 입력:");
		score=scan.nextInt();
		
		if(score>=60)
		{
			System.out.println("합격");
		}
		else
		{
			System.out.println("불합격");
		}
	}

}
