// ������ �Է¹޾Ƽ� ���� ���, ����, �������� ����Ͻÿ�: �������ǹ�
import java.util.Scanner;
public class ����19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("���� �Է�:");
		// �Էµ� ���� �޾Ƽ� �޸� ����
		int a=scan.nextInt();
		
		if(a>0)
			System.out.println(a+"��(��) ���");
		else if(a<0)
			System.out.println(a+"��(��) ����");
		else
			System.out.println(a+"�� ����");

	}

}
