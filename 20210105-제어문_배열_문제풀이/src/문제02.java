//  100~999 ������ 4�ǹ���� �ƴ� ���� ����,���� ���
public class ����02 {
	
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
		System.out.println("����:"+count4);
		System.out.println("��:"+sum);
	}

}
