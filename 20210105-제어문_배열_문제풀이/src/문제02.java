//  100~999 사이의 4의배수가 아닌 수의 갯수,합을 출력
public class 문제02 {
	
	public static void main(String[] args) {
		int count4=0;
		int sum=0;
		for(int i=100;i<=999;i++)
		{
			if(i%4!=0)
			{
				sum+=i;
				count4++;
			}	
		}
		System.out.println("갯수:"+count4);
		System.out.println("합:"+sum);
	}

}
