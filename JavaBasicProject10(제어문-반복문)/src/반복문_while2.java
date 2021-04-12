// 1~100까지의 합
// 1+2+3+4+...+100 ?
public class 반복문_while2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 변수 2개 필요 => 1~100 변경되는 변수(루프변수)
		int i=1;
		// 1~100까지 더한 값을 누적한 변수
		int sum=0; // + => 누적 (0), * => 1
		while(i<=100) // 100번을 반복한다
		{
			sum+=i; //sum=sum+i; 같은말
			/*
			 *    sum = sum +i
			 *    
			 *    i=1
			 *    sum=0+1 ==> sum=1
			 *    i=2
			 *    sum=1+2 ==> sum=3
			 *    i=3
			 *    sum=3+3 ==> sum=6
			 *    --
			 *    --
			 *    --
			 *    sum=()+100 ==> sum=?
			 */
			System.out.println("i="+i+",sum="+sum); //i가 몇일 때 sum이 몇인지 확인 가능
			i++;
			
		}
		System.out.println("1~100까지의 총합:"+sum);

	}

}
