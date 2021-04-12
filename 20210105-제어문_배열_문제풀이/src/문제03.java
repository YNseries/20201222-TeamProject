// 1~30 Â¦¼ö ÇÕ, È¦¼ö ÇÕ
public class ¹®Á¦03 {
	
	public static void main(String[] args) {
		int even=0;
		int odd=0;
		for(int i=0;i<=30;i++)
		{
			if(i%2==0)
			{
				even+=i;
			}
			else if(i%2!=0)
			{
				odd+=i;
			}
		}
		System.out.println("Â¦¼öÇÕ:"+even);
		System.out.println("È¦¼öÇÕ:"+odd);
	}

}
