package com.sist.main;
// page 375
/*
 *    �߻� Ŭ����
 *    1. ����
 *       ���������� Ÿ�� class className{}
 *       ======  ==(final|abstract)
 *    public|default
 *    
 *       public abstract class className
 *       {
 *          ================
 *            ����
 *             = �������(instance)
 *             = ���뺯��(static)
 *          ================
 *            �޼ҵ�
 *             ============= �Դ´� (��, ��, ����, ���...)
 *             = ������ �޼ҵ�
 *                ��ǻ�� / ��Ʈ�� / �ڵ��� ==> �Ŀ��� Ŭ��(�ʿ��ϸ� �������̵�)
 *                public ������ �޼ҵ�(�Ű�����..) => �����
 *                {
 *                   ������
 *                }
 *             = ����� �޼ҵ� ==> ������ �� �� ����
 *               ����� ���� => ������ �ٸ���
 *               public (abstract) ������ �޼ҵ�(�Ű�����);   // ����Ϸ�. ���پ� �� ���� = �̿ϼ�
 *                                                         => ����� �޾Ƽ� �ϼ�
 *          ================
 *          ================
 *       }
 *       Ư¡
 *       ===
 *       1) �ڽ��� �޸� �Ҵ��� �� �� ����(�̿ϼ��� Ŭ����) => new�� ����� �� ����
 *          abstract class A
 *          A a=new A();   // �ϼ��� �ȵ� ��ǰ�̱� ������ ���Ұ�
 *       2) ����� ���� Ŭ�������� �̿ϼ��� �޼ҵ带 �����ؼ� ���
 *       3) �߻� Ŭ������ ����
 *          ======== ����, ����, ������
 *       4) ���������� ������ �Ǵ� ��ɸ� ����
 *          �Խ���(�۾���, ����, ����, ���뺸��, ã��)
 *            = �ϹݰԽ���
 *            = ����� �Խ���
 *            = ������ �Խ���
 *            = ���� ���ϱ�
 *            = �ڷ��
 *    2. ���ó
 *       = �䱸���� �м�(��ŷ) => ������ ����
 *         �Ƿ� => �䱸���� �м� => �ʿ��� ������ ���� => UI => ���� => �׽���
 *               ==========    =============   ===   ===    ====
 *                  ��Ű����           DBA      �ۺ��� �����α׷��� �׽���
 *       = ����� ���� => �������°� ��������
 *         ======== ���α׷��� �°� �����ؼ� ���
 *         ======== �������� ���� Ŭ������ ��Ƽ� ó��(Ŭ������ ��Ƽ� �Ѱ��� �̸����� ����)
 *         ======== ǥ��ȭ�� �ȴ�(���̺귯��)
 */
// �߻�Ŭ������ ��� => ���� ��Ӹ� ����
abstract class Print{
	public abstract void list();
	public abstract void detail();
	// =========================== �� �ΰ��� public�� ������ �����ؼ� ����Ѵ�
	public void reserve() {
		System.out.println("������ �����մϴ�");   // �ʿ��� Ŭ���������� �����ؼ� ��� ����
	}
	public void end()
	{
		System.out.println("����Ʈ �̵�");
	}
}
class ��ȭ extends Print{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("��ȭ ������ ���");
	}
	
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("��ȭ ���� ������ ���");
	}
	/* public void reserve() {
		System.out.println("������ �����մϴ�");   // �ʿ��� Ŭ���������� �����ؼ� ��� ����
	} */
}

class ���� extends Print{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("������ ���̺� ���·� ���");
	}
	
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("���� ������ �޴��� ���");
	}
	/* public void reserve() {
		System.out.println("������ �����մϴ�");   // �ʿ��� Ŭ���������� �����ؼ� ��� ����
	} */
}
class �װ��� extends Print{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("������ ���� ���̺� ���·� ���");
	}
	
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("�ð��� ����Ѵ�");
		/*
		 *    class final System
		 *    {
		 *        static O
		 *        static 
		 *    }
		 */
	}
	
	public void reserve() {
		// TODO Auto-generated method stub
		System.out.println("�װ� �ð� ������ �մϴ�");  // �ʿ��� Ŭ���������� �����ؼ� ����� ����
	}
	/*
	 *     �޼ҵ�� {} => ����
	 */
}
public class �߻�Ŭ���� {
	/*
	 *    ���α׷� => ��Ƽ� �� ���� ����
	 *    �����Ͱ� ������ => �迭
	 *    Ŭ������ ������ => �߻�Ŭ���� or �������̽�
	 *    
	 *    ��ȭ int
	 *    ���� double
	 *    �װ��� String   // Ŭ���� �̸��� �ٸ��� �迭�� �ٸ�!�� ���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� �ٸ� Ŭ������ �����ؼ� ����� ����
		Print p=new ��ȭ();
		p.list();
		p.detail();
		p.reserve();
		
		p=new ����();
		p.list();
		p.detail();
		p.reserve();
		
		p=new �װ���();
		p.list();
		p.detail();
		p.reserve();
	}

}
