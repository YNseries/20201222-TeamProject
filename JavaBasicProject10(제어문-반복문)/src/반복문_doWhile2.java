// 프로그램은 정답이 없다: 요구사항대로 출력만 해 주면 됨
// 1~100 출력 총합, 짝수합, 홀수합 => do~while문으로
public class 반복문_doWhile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 초기값 => 1
		int i=1;
		// 1~100 합을 누적할 수 있는 변수, 짝수합 변수, 홀수합 변수
		int sum=0, even=0, odd=0;
		do
		{
			// 총합
			sum+=i;
			//짝수합
			if(i%2==0)
				even+=i;
			else
				odd+=i; // 홀수값만 누적
			i++;  // i=1~ i=100  101이면 종
		}while(i<=100);
		// 가공된 데이터를 출력
		System.out.println("1~100까지 총합:"+sum);
		System.out.println("1~100까지 짝수합:"+even);
		System.out.println("1~100까지 홀수합:"+odd);

	}

}
