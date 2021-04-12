/*
 *      1~100까지 총합, 3의 배수 합, 5의 배수 합, 7의 배수 합을 출력
 *      1-2+3-4+5-6+7-8+9-10 합
 */
public class 반복문_doWhile3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		// 변수 4개 필요
		int sum=0, thi=0, fif=0, sev=0;
		do
		{
			sum+=i;
			if(i%3==0)
				thi+=i;
			if(i%5==0)      // else(다중조건문x) 붙이면 안됨! -> 중복되는 경우가 있을 때 제외되기 때문에 
				fif+=i;
			if(i%7==0)
				sev+=i;
			i++;
		}while(i<=100);
		System.out.println("1~100까지 총합:"+sum);
		System.out.println("1~100까지 3의배수 합:"+thi);
		System.out.println("1~100까지 5의배수 합:"+fif);
		System.out.println("1~100까지 7의배수 합:"+sev);
		
		//   여기까진 else 빼곤 맞았음 ㅠ
		
		// 1-2+3-4+5-6+7-8+9-10 합  => 수열
		i=1;
		sum=0;
		do {
				if(i%2==0)
					sum-=i;
				else
					sum+=i;
				i++;
		}while(i<=10);
		System.out.println("합:"+sum);
		
		// =============================== 아래와 같이 짜도 됨
		i=1;
		sum=0;
		do
		{
			sum = (sum + i) * -1;
			i++;
		}while(i<=10);
		System.out.println("합:"+sum);
	}

}
