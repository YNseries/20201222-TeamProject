// 100~999���̿� 7�� ����� ������ ���� ���
public class ����01 {
	
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
		System.out.println("7�� ��� ����:"+count7);
		System.out.println("7�� ��� ��:"+sum);
	}

}
