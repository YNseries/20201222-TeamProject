


// 1~10���� ���� �� �ߺ����� �ʰ�
public class �迭Ȱ��_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		// ������ �����ϴ� ����
		int su=0;
		// �ߺ����θ� Ȯ���ϴ� ����
		boolean bCheck=false;
		
		for(int i=0;i<arr.length;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				// ���� �߻� �� �� => �ߺ����� Ȯ�� / �ߺ��� ������ ����
				su=(int)(Math.random()*10)+1;
				bCheck=false;   // ���������� ���� �ۿ� �ؾ� ��. for���� else if �������ϱ�
				for(int j=0;j<i;j++)
				{
					if(arr[j]==su)
					{
						bCheck=true;
						break;  // continue ==> �ڽ��� �ݺ����� ����
					}
				}
			}
			arr[i]=su;   // �ߺ����� ���� �����͸� �����
		}
		// ���
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

	}

}
