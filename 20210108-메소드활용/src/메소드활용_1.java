
public class �޼ҵ�Ȱ��_1 {
	static void star(int a)    // ��¸��� ����. ������x �Ű�����x
	{
		for(int i=0;i<a;i++)
		{
			System.out.println("***** *****");
		}
	}
	static void star()
	{
		System.out.println("***** *****");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");
		System.out.println("***** *****");   // �̷��� ����ϰ� �����Ÿ�, for���� ����
		
		System.out.println("===== for =====");  // �ٵ� for���� �߰��߰��� �� �� ����
		for(int i=0;i<10;i++)
		{
			System.out.println("***** *****");
		}
		
		System.out.println("===== method =====");  // ��� �� �� ����? => �޼ҵ� ó��
		star(10);
		
		System.out.println("===== method ====="); 
		star();star();star();star();star();
		star();star();star();star();star();

	}

}
