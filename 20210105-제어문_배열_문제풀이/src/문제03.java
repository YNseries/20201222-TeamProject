// 1~30 ¦�� ��, Ȧ�� ��
public class ����03 {
	
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
		System.out.println("¦����:"+even);
		System.out.println("Ȧ����:"+odd);
	}

}
