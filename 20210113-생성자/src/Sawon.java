import java.util.Scanner;
public class Sawon {
	String name;   // null
	String sex;    // null
	String dept;   // null
	String loc;    // null
	long pay;      // 0L
	// Sawon(){}   // �����ڸ� �߰����� �ʴ´�(�ؿ� �����Ʊ� ������ ���� �Ⱥ������� ������)
	Sawon(){
		System.out.println("��������� ���� �ʱ�ȭ ���");
		System.out.println("�̸�:"+name);  // ������ ���⿡�� this.�� �ٿ��� ������, ���� �̸��� ���ٸ� �浿�� ���� ���� ������ ������.
		System.out.println("����:"+sex);
		System.out.println("�μ���:"+dept);
		System.out.println("�ٹ���:"+loc);
		System.out.println("����:"+pay);
	}
	Sawon(String name,String sex,String dept,String loc,long pay){  // ���=��������
		/*
		 *    ������ ������ ��
		 *    �������
		 *      = �ν��Ͻ� ����
		 *      = static : ���뺯��(Ŭ��������)
		 *    ��������
		 *      = �޼ҵ� �ȿ� ����� ����
		 *      = �Ű�����
		 *      
		 *    =====> �켱����(���������� �켱����)
		 *           1. ��������, �Ű������� ã�´�
		 *           2. ����������� ã�´�
		 */
		this.name=name;    // �������(�Ķ�)=��������(���)  �̸��� ���� �� this.�� ������� �տ� �ٿ� ��ǻ�Ͱ� �����ϰ� �Ѵ�
		this.sex=sex;
		this.dept=dept;
		this.loc=loc;
		this.pay=pay; 
		// ���нÿ��� �ݵ�� this�� ���
		System.out.println("this="+this);
		
		// Ŭ���� �ȿ� ����� ��� �޼ҵ�(����:static)���� this�� ����� �� �ִ�
		// ��� �޼ҵ� �ȿ� �����ڰ� ���ԵǾ� ����
		// �����ڴ� ����ڰ� �Է��� �����͸� �޾Ƽ� ��������� �ʱⰪ�� ����
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����ڰ� �Է�
		/* Sawon sa=new Sawon();
		Scanner scan=new Scanner(System.in);
		System.out.print("�̸� �Է�:");
		sa.name=scan.next();
		System.out.print("���� �Է�:");
		sa.sex=scan.next();
		System.out.print("�μ��� �Է�:");
		sa.dept=scan.next();
		System.out.print("�ٹ��� �Է�:");
		sa.loc=scan.next();
		System.out.print("���� �Է�:");
		sa.pay=scan.nextInt();
		// ���
		System.out.println("�̸�:"+sa.name);
		System.out.println("����:"+sa.sex);
		System.out.println("�μ���:"+sa.dept);
		System.out.println("�ٹ���:"+sa.loc);
		System.out.println("����:"+sa.pay);
		*/
		Scanner scan=new Scanner(System.in);
		System.out.print("�̸� �Է�:");
		String name=scan.next();
		System.out.print("���� �Է�:");
		String sex=scan.next();
		System.out.print("�μ��� �Է�:");
		String dept=scan.next();
		System.out.print("�ٹ��� �Է�:");
		String loc=scan.next();
		System.out.print("���� �Է�:");
		long pay=scan.nextInt();
		// Ŭ������ ����
		Sawon sa=new Sawon(name,sex,dept,loc,pay);
		
		/*
		 *    JVM
		 *    �޸𸮿� ����
		 *    Sawon sa=new Sawon()
		 *          == �޸𸮸� ���� �޸� �ּҸ� sa�� ����
		 *                 =======
		 *                 sa�� �������ִ� ������ ���� �ʱⰪ�� ����
		 *    this=sa;
		 */
		System.out.println("sa="+sa);
		// ���
		System.out.println("�̸�:"+sa.name);
		System.out.println("����:"+sa.sex);
		System.out.println("�μ���:"+sa.dept);
		System.out.println("�ٹ���:"+sa.loc);
		System.out.println("����:"+sa.pay);
		/*
		 *     Sawon sa;
		 *     sa=new Sawon();  => ������ ����. 
		 *     sa=new Sawon(name,sex,dept,loc,pay);
		 *     ====sa====
		 *        100
		 *     ==========
		 *             100==============
		 *                  ===name===  sa(100).name
		 *                     �̼���
		 *                  ==========
		 *                  
		 *                  ====sex===
		 *                      ����
		 *                  ==========
		 *                  
		 *                  ===dept===
		 *                     ���ߺ�
		 *                  ==========
		 *                  
		 *                  ====loc===
		 *                      �λ�
		 *                  ==========
		 *                  
		 *                  ====pay===
		 *                     4500
		 *                  ==========
		 *                ==============
		 */

	}

}
