/*
 *    1. �����ڰ� �Ѱ��� �����ϸ� �����Ϸ��� �����ڸ� ��������� �ʴ´�
 *    ��)
 *        class A
 *        {
 *           // �����Ϸ��� A(){}
 *        }
 *        class A
 *        {
 *           A(){} => ������(����Ʈ ������)
 *        }
 *        class A
 *        {
 *           A(int a){}
 *        }
 *        class A
 *        {
 *           A(int a,int b){} => A(){} (x)   A(10,20){} (O)
 *        }
 *        
 *        �޼ҵ�
 *        void display(int a){}  => display(int)�� �����
 *        void display(int b){}  => display(int)�� �����. ���� �޼ҵ�
 *        int display(int a,int b){} => display(int,int) => �ٸ� �޼ҵ�
 *        int display(String a){}    => display(String) => �ٸ� �޼ҵ�
 *        
 *        display() => �����߻�
 *        display(10) => �������� �־���� ȣ���
 *        
 *        
 *        ==> class A
 *        
 *            => A(){}            => new A()
 *            => A(int a){}       => new A(10)
 *            => A(int a,int b){} => new A(10,20)
 *            => A(String name){} => new A("Hong")
 *            => A(char a){}      => new A('A')
 *            
 *            => A(double d1, double d2, double d3)
 *               new A(10.5, 10.6, 10.7)
 *               new A('A',10,10.5F)
 */
public class ������ {
	// ������(){}  // �ϳ��� �����ϸ� ������ �߰����� ����
	// �ڿ����ε� : �ߺ��޼ҵ� ���� => ���� �޼ҵ�� ������ ����� ó��(������)
	// ���ο� ����� �߰�(new)
	// �����ڴ� �ʿ�ø��� ���� => ��������, ����Ŭ����, ����������
	int a=10;
	// a=100;  ���� �� ������ �ȵ�. ������
	{
		a=100;      // �ʱ�ȭ���. ��𿡼��� �� �� ����
	}
	������(int a){
		System.out.println("a="+a);
	}
	������(char a)
	{
		System.out.println("a="+a);
		{
			int b=10;  // ������ ����. Ŭ���� �ȿ� �� ���� �ʱ�ȭ���.
		}
	}
	������(double d1, double d2, double d3)
	{
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
	}
	
	public static void main(String[] args) {
		// ������ aa1=new ������();
		������ aa2=new ������(10);  // �������� �־���� ����
		// �Ű������� ���� �߰� => ���� ��, ���� ��
		������ aa3=new ������('A',10,10.5F);
		������ aa4=new ������('B');
		������ aa5=new ������(67);
		
		new ������('A');  // ������ ȣ���� �� ���� ���. �ּҸ� ������ �ʿ䰡 ���� ��
		// �ʱ�ȭ�� => �ڵ� ȣ���� ��
		int a=10;
		System.out.println("a="+a);
	}

}
