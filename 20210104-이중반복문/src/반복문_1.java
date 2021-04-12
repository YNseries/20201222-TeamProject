/*
 *    윤년 작성 => 로마시대
 *    ======
 *    4년마다
 *    100년마다 제외
 *    400년마다 
 *    
 *    if((year$4==0 && year%100!=0)||(year%400==0))
 *    {
 *        
 *    }
 *    
 *     사용자로부터 두 개의 정수를 입력 받아서 뺄셈과 곱셈 연산의 결과를 출력하는 프로그램을 작성
 */
import java.util.Scanner;
public class 반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("두개의 정수를 입력하시오(10 10)?");
        int a=scan.nextInt();
        int b=scan.nextInt();
        System.out.printf("%d-%d=%d\n",a,b,a-b);
        System.out.printf("%d*%d=%d\n",a,b,a*b);

	}

}
