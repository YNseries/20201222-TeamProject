// 100~999사이에 7의 배수의 갯수와 합을 출력
public class 문제01 {
	
	public static void main(String[] args) {
		int count7=0;
		int sum=0;
		for(int i=100;i<=999;i++)
		{
			if(i%7==0)
			{
				sum+=i;
				count7++;
			}
		}
		System.out.println("7의 배수 갯수:"+count7);
		System.out.println("7의 배수 합:"+sum);
	}

}
