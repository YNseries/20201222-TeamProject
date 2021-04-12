// 정수 1개를 입력받아서 => 3,5,7의 배수 여부를 확인 => 단일 조건문 3개
import java.util.Scanner;
public class 단일조건문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력받은 정수를 저장할 메모리 공간 : 변수
		int num;
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 한개를 입력:");
		//입력이 된 상태 ==> 입력하고 enter
		num=scan.nextInt();
		// 조건 => 3의 배수
		// 조건에 맞는 모든 문장을 수행 => 단일조건문 여러개를 사용한다 (중복적으로 수행이 가능)
		if(num%3==0)
			System.out.println(num+"는(은) 3의 배수입니다");
		if (num%5==0)
			System.out.println(num+"는(은) 5의 배수입니다");
		if (num%7==0)
			System.out.println(num+"는(은) 7의 배수입니다");
		

	}

}
