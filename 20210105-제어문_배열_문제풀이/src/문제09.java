// 	������ 10�� �����ϴ� �迭�� ����� 1���� 10���� ������ ������ �����ϰ� �����Ͽ� 
//  �迭�� �����϶�. �׸��� �迭�� �� ���ڵ�� ����� ����϶�.

public class ����09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*10)+1;
			System.out.print(arr[i]+" ");
		}
		int sum=0;                               // ***** ��
		for(int i:arr)
		{
			sum+=i;
		}                                        // ***** ��
		System.out.println();
		System.out.println("���:"+(sum/10.0));

	}

}
