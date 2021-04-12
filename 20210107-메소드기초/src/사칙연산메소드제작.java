import java.util.Scanner;
/*
 *    연산처리하는 메소드를 만든다
 *    +
 *    -
 *    *
 *    /
 *    ===> 될 수 있으면 메소드는 세분화 하는게 좋다
 *    
 */
public class 사칙연산메소드제작 {

	// +
	static int plus(int a,int b)
	{
		return a+b;
	}
	// -
	static int minus(int a,int b)
	{
		return a-b;
	}
	// *
	static int multi(int a, int b)
	{
		return a*b;
	}
	// /
	static double div(int a,int b)     // 0이 들어왔을 때 오류가 나오기 때문에 string을 넣는게 맞을거야
	{
		return a/(double)b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 메소드 호출
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int a=scan.nextInt();   // nextInt에 마우스 올리면 int값임.
		System.out.print("두번째 정수 입력:");
		int b=scan.nextInt();
		System.out.print("연산자 입력(+,-,*,/):");
		String op=scan.next();   // next에 마우스 올려보면 string값인 것을 알 수 있음. 때문에 string으로 받는 것.
		
		int c=0;
		switch(op)
		{
			case "+":
				c=plus(a,b);    //함수명을 주고 a,b에 입력받으면 c로 결과값이 나오는
				System.out.printf("%d+%d=%d\n",a,b,c);
				break;
			case "-":
				c=minus(a,b);
				System.out.printf("%d-%d=%d\n",a,b,c);
				break;
			case "*":
				c=multi(a,b);
				System.out.printf("%d*%d=%d\n",a,b,c);
				break;
			case "/":
				if(b==0)
					System.out.println("0으로 나눌 수 없습니다");
				else   // 두 문장을 수행하기 때문에 {} 써야 함
				{
					double d=div(a,b);
					System.out.printf("%d/%d=%.2f\n",a,b,d);
				}
				break;
			default:
				System.out.println("잘못된 연산자입니다");
		}
	}

}
