package com.sist.thread;
/*
 *    ������: �� ���� ���α׷� �ȿ��� �������� ����� ���ÿ� ����
 *          =========== ���μ���
 *          ������� �޼ҵ� ȣ��: ����, ä��(īī�� ��), ��(���� => ��� ���)
 *    1. ������ ������ ����
 *       1) Thread�� ���(Thread�� Ŭ����) => ��Ƽ������
 *          public class MyThread extends Thread {
 *          }
 *       2) Runnable ����(Runnable�� �������̽�) => �̱۾�����(������)
 *          ============ �̹� ����� �ִ� ��쿡 �ַ� ���
 *          public class MyThread implements Runnable
 *          {
 *              public void run()
 *              {
 *                  ������ ������ �ڵ�
 *              }
 *          }

 *    2. ������ �����ֱ�                      ====>  Blocked(�Ͻ�����)
 *       new  ====>  Runnable  ====>  Running
 *                                       ====>  Dead(�޸� ����)
 *       1) new
 *          Thread t=new Thread();
 *          => JVM(����ӽ�) ����
 *             = �̸��� �ο���(Thread-0����..)
 *               �̸� ������ ����: getName()
 *               �̸� ����: setName() 
 *             = �켱���� �ο�
 *               1 : MIN_PRIORITY
 *               10: MAX_PRIORITY
 *               5 : NORM_PRIORITY(����� ����_�߰�����)
 *               == ����: �۾� ���� �ӵ�
 *               = ������� �� ���� �ϸ� ������
 *                 ��) ���� / Ŭ���̾�Ʈ(�����κ��� ���䰪�� �޾Ƽ� ���)
 *                    Ŭ���̾�Ʈ
 *                      1) ������ ��û: ä�� ���ڿ��� ������ ��ü�� ����
 *                                   ����޼��� ���(�̱� ������)
 *                      2) ����: �����      
 *                              ����� �Ѿ�
 *                              �ƹ�Ÿ �Ѿ�
 *                              �ƹ�Ÿ
 *                 ==================================================
 *                 ���������� => C/S => ������ ���� => ���� ��ǻ�� => Empty(AS)
 *                                     GRID
 *                                   ========   ========
 *                                    Ŭ����        AI
 *                 ===================================================
 *       2) Runnable(������) => �ڿ�(CPU=>�޸𸮰���) ����
 *          start()
 *       3) Running(������ ����) => �����尡 ��� ������ ���� �ڵ�
 *          run(): �۾��ϴ� �޼ҵ常 �� ������ ��
 *       4) �����ϴ� ����: �Ͻ�����
 *          sleep()
 *       5) ����: ������ ����
 *          interrupt()
 *    3. ������� �����Ͱ� ���� => ���μ����� �����͸� �����ؼ� ���(����Ŭ����)
 *       class Game
 *       {
 *           Game�� ���õ� ������
 *           
 *           class ThreadEx extends Tread
 *           {
 *               
 *           }
 *       }
 */
class MyThread extends Thread
{
	// ���� 
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread()+":"+i);   // Thread[ȫ�浿,10,main]:10 ���� Thread ������ ���� ����
			try
			{
				Thread.sleep(1000);   // = 1/1000�ʾ� �Ͻ�����
			}catch(Exception ex) {}
		}
	}
}
/*
 *    ��� ���μ����� main()���� �����Ѵ�
 *               ======
 *               Thread ==> ��� ���μ���(��������)�� �� �� �̻��� �����带 ���� �ִ� 
 */
public class MainClass1 {

	public static void main(String[] args) {  // ���⼭ main�޼ҵ尡 Thread��
		// TODO Auto-generated method stub
		// Thread ����
		System.out.println(Thread.currentThread());
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		MyThread t3=new MyThread();
		MyThread t4=new MyThread();
		MyThread t5=new MyThread();
		
		t1.setName("ȫ�浿");
		t2.setName("��û��");
		t3.setName("�̼���");
		t4.setName("������");
		t5.setName("��������");
		
		// �켱���� 1(MIN) ~ 5(NORM):default ~ 10(MAX)
		//       ======                     =======
		//         GC                        main() => ������
		t1.setPriority(10);  // ������ ���� ������ Priority�� �־ ū ���� ����
		t2.setPriority(1);
		t3.setPriority(1);
		t4.setPriority(1);
		t5.setPriority(1);
		
		// ��� ����: start()
		t1.start();t2.start();t3.start();t4.start();t5.start();  // �����(�ѹ��� ����)
            // ; ������ ������ �����ϴ� ������, �� ������ �켱������ �������� �ƴ� �������� �ѹ��� �����

		// ���� ����: run() => start()�� �ɸ� �ڵ� ȣ���
		
	}

}
