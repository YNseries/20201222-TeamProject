/*
 *    class�� ���� ���(����+�޼ҵ�)
 *    ==============
 *      = ����
 *                    ���α׷��Ӱ� ���� ���� => class{ ��� �ȿ� ������ } 
 *        ==============================================================
 *        = �������(�ν��Ͻ� ����): new�� ���ø��� ���� �޸𸮰� ���������
 *        = ���뺯��, ��������: JVM���� �ڵ����� �����Ǵ� ����(�տ� static�� �پ�����)
 *        ==============================================================
 *        
 *        = ��������: �޼ҵ� �ȿ����� ���
 *                 for(int i=0~) ==> �޼ҵ尡 �����ϸ� �ڵ����� ������� ����
 *                 => �޸� ��ü���� ���� {}�� ������ �ڵ����� �������
 *      = �޼ҵ�: ��������� �̿��ؼ� ����� ����
 *      = ������: ��������� ���� �ʱ�ȭ�� ���
 *      
 *      ============================
 *      �������� �����͸� ��Ƽ� ó��(Ŭ����)
 *      �����ϴ� ���
 *        Ŭ������ ������=new Ŭ������();
 *      �����͸� �о���� ���
 *        ������.����  /  Ŭ������.����
 *        ========     =========
 *        �ν��Ͻ�����     static ����
 *      ============================
 *      ��)
 *          Tv t;  ==> ������ channel
 *          ====t====
 *           ==> ��ü�� ���� �޸� �ּ� 100
 *          =========
 *          t=new Tv();
 *            =======100=======
 *            -----channel-----
 *                    0           ==> 100��° �ȿ� �ִ� channel �����͸� �޶�.  t.channel
 *            -----------------
 *            =================   �ּҸ�(�޸� => �ּ�,����) 0 ~
 *            
 *              		            =======200=======
 *          						-----channel-----
 *           						        0           
 *           						-----------------
 *            						================= 
 *            						new�� ����ϰ� �Ǹ� �޸𸮰� ���� ���� => ����� ������ �ּҿ� �ִ� ���븸 ��� ����
 *            
 *            class A
 *            {
 *            	 int a=100;   // ��ü ���α׷�(�޼ҵ� ��ü���� ����� ����) => ��������
 *            	 void display()
 *            	 {
 *            		// b,a ��밡��
 *            	    int b=10;   // ��������
 *            		if(b==0)
 *            		{
 *            		   int c=100;   // ��������
 *            		   // b,a,c ��밡��
 *            		}   // c���� ��� ����
 *            	 }   // b���� ��� ����
 *            	 void display2(int d)
 *            	 {
 *            	    int e=10;
 *            
 *            		// d,e,a ��밡��   ==> �Ű������� ���������� �� �� �ִ�
 *            	 }
 *            	 void display3(inta)
 *            	 {
 *            	    int a=10;
 *            	    System.out.println("a="+this.a);    // 10
 *             							 // ===== �������� ���� �� ��(�������, ��������) => ���������� �켱����
 *             								������ ���� {}�� �ִ� ������ ���� �� �޶�� this.�� �ٿ��� ��.
 *            	 }
 *            }   // a������ ���
 *            
 */
// public���� �����ϴ� Ŭ������ �ݵ�� 1���� ��� 
class Chef
{
	String chef_name;
	int rank;
	int mem_cont1,mem_cont2,mem_cont3,mem_cont7;
	// 27,771 => String => int => ,=> ""
}
class Recipe
{
	String title;
	String chef;
	String content;
	String info1,info2,info3;
	String[] data1;
	String[] data2;
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chef chef=new Chef();
		chef.rank=1;
		chef.chef_name="��ũ���̸�";
		chef.mem_cont1=1712;
		chef.mem_cont2=1027593;
		chef.mem_cont3=33561876;
		chef.mem_cont7=21771;
		
		Chef chef1=new Chef();
		chef1.rank=2;
		chef1.chef_name="����Ű��";
		chef1.mem_cont1=249;
		chef1.mem_cont2=603334;
		chef1.mem_cont3=12912223;
		chef1.mem_cont7=15335;
		
		// ����
		System.out.println("������:"+chef.chef_name);
		System.out.println("��ǰ:"+chef.mem_cont1);
		System.out.println("Ŭ��:"+chef.mem_cont2);
		System.out.println("�湮��:"+chef.mem_cont3);
		System.out.println("�ҽ�:"+chef.mem_cont7);
		System.out.println("==============================");
		System.out.println("������:"+chef1.chef_name);
		System.out.println("��ǰ:"+chef1.mem_cont1);
		System.out.println("Ŭ��:"+chef1.mem_cont2);
		System.out.println("�湮��:"+chef1.mem_cont3);
		System.out.println("�ҽ�:"+chef1.mem_cont7);
		System.out.println("==============================");
	}

}
