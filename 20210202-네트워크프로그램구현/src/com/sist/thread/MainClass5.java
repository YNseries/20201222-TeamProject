package com.sist.thread;
/*
 *    ���� Ŭ����
 *    = ��� Ŭ����
 *      class A(������)
 *      {
 *         class B(������)
 *         {
 *            A�� ������ �ִ� ��� ������, �޼ҵ� Ȱ��
 *            A�� �޸� �Ҵ����� �ʰ� ���
 *         }
 *      }
 *    = �͸��� Ŭ����: ��� ���� �������̵��� ����
 */
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Runnable r=new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("run Call...");
			}
		};
		Thread t=new Thread(r);
		t.start();*/
		
		// ���ٽ�
		Runnable r=()->{
			System.out.println("run Call...");
		};
		Thread t=new Thread(r);
		t.start();
		/*
		 *    function aaa(){
		 *    }
		 *    
		 *    var aaa=funcions() {}
		 *    
		 *    var aaa=()=>{
		 *    };
		 */
	}

}
