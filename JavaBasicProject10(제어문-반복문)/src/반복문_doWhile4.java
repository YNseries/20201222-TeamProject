// 1~10 => 1. 짝수만 출력, 2. 홀수만 출력

/*
 *     645   ==>   백단위 6
 *                 십단위 4
 *                 단단위 5    % 배수를 구할때만 사용되는 부호가 아님
 *                 
 *     int a=645
 *     int b=0, c=0, d=0;
 *     
 *     b=a/100   // 6
 *     c=(a%100)/10   // 4
 *        645%100 ==> 45/10 => 4
 *     d=645%10  // 5
 */
public class 반복문_doWhile4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("홀수 출력");
		int i=1;		
		do {
			System.out.println("i="+i);
			i+=2;  // 1..3..5..
		}while(i<=10);
		
		System.out.println("짝수 출력");
		i=1;
		do {
			if(i%2==0)
				System.out.println("i="+i);
			i++;
		}while(i<=10);
		
		System.out.println("홀수 출력2");
		i=1;
		do {
			if(i%2==1)
				System.out.println("i="+i);
			i++;
		}while(i<=10);

	}

}
