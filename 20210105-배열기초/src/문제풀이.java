
public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1번
		/* int count=0, a7=0;
		for(int i=100;i<=999;i++)
		{
			if(i%7==0)
			{
				count++;
				a7+=i;
			}
		}
		System.out.println(count);
		System.out.println(a7); */
		
		// 2번
		/* int count=0,a4=0;
		for(int i=100;i<=999;i++)
		{
			if(i%4!=0)
			{
				count++;
				a4+=i;
			}
		}
		System.out.println(count);
		System.out.println(a4); */
		
		// 3번
		/* int even=0,odd=0;
		for(int i=1;i<=30;i++)
		{
			if(i%2==0)
			{
				even+=i;
			}
			else
			{
				odd+=i;
			}
		}
		System.out.println(even);
		System.out.println(odd); */
		
		// 4번
		/* for(int i=1;i<=100;i++)
		{
			if(i%3==0 && i%5==0)
			{
				System.out.print(i+" ");
			}
		} */
		
		// 5번
		/* int a7=0,a9=0;
		for(int i=1;i<=1000;i++)
		{
			if(i%7==0)
				a7+=i;
			if(i%9==0)
				a9+=i;
		}
		System.out.println(a7);
		System.out.println(a9);
		System.out.println(a7+a9); */
		
		// 6번
		/* for(int i=10;i<=99;i++)
		{
			int a=i/10;
			int b=i%10;
			if(a==b)
			{
				System.out.print(i+" ");
			} */
		
		// 7번
		/* int score=(int)(Math.random()*101); //0~100
		if(score>=60)
			System.out.println("합격");
		else
			System.out.println("불합격"); */
				
		// 8번
		/* int[] num= {94, 85, 95, 88, 90};
		int max=num[0];
		int min=num[0];
		for(int i=0;i<num.length;i++)
		{
			if(max<num[i])
				max=num[i];
			if(min>num[i])
				min=num[i];
		}
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min); */
		
		// 9번
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*10)+1;
		}
		int sum=0;
		// double avg=0.0;
		for(int i:arr)
		{
			sum+=i;
		}
		// arr에 저장된 데이터 출력
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n평균:"+(sum/10.0));

	}

}
