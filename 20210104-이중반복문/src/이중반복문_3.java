/*
 *      *
 *      **
 *      ***
 *      ****
 *      --
 *      --
 *      n번째 출력 (사용자가 입력한 정수)
 *      i    j     ===>  i=j  ==>  j=i
 *      줄수  별표
 *      1    1
 *      2    2
 *      3    3
 *      =
 *      =
 *      n    n
 */
// 입력한 갯수만큼 출력한다
import java.util.Scanner;
public class 이중반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		// 입력된 정수를 받아서 저장
		int n=scan.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("☆");
			}
			System.out.println();
		}

	}

}
