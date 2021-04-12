/* 
 * 사용자로부터 세 개의 정수를 입력받은 다음에 곱과 합을 순서대로 진행해서 그 결과를 출력하는 
 * 프로그램을 작성해 보자. 예를 들어 사용자로부터 순서대로 입력받은 
 * 세 개의 정수가 1, 2, 3 이라면 1 * 2 + 3의 계산 결과를 출력하는 프로그램을 작성하시오. 
 */
import java.util.Scanner;
public class 문제13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("세개의 정수를 입력(10 20 30)?");
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int d=a*b+c;
		System.out.println("d="+d);
	}

}
