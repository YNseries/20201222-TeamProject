// 정수를 입력받아서 수가 양수, 음수, 제로인지 출력하시오: 다중조건문
import java.util.Scanner;
public class 문제19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		// 입력된 값을 받아서 메모리 저장
		int a=scan.nextInt();
		
		if(a>0)
			System.out.println(a+"는(은) 양수");
		else if(a<0)
			System.out.println(a+"는(은) 음수");
		else
			System.out.println(a+"은 제로");

	}

}
