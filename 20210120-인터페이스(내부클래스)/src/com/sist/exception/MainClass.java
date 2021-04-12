package com.sist.exception;
/*
 *    ����
 *     1. ����: �ҽ��󿡼� ������ �� ���� ����: �޸� ����, �ü�� ����...
 *     2. ����: �ҽ��󿡼� ������ �� �ִ� ����: ������� �Է��� �߸��� ���, ���ϸ��� Ʋ����
 *        ===========================================================
 *        ���� ȸ��: ����ó�� throws
 *        ���� ó��: ���� ó�� try~catch
 *                 ���� �߻� throw
 *                 ����� ���� ����ó��
 *     ==============================================================
 *     ����ó�� ����: ������ ���� �����ϰ� ���� ���Ḧ �� �� �ְ� ����� ����
 *                �̸� ������ ������ �� �ְ� ����
 *                ����: ���α׷����� �Ǽ�, ����� �Է�
 *                    ======================
 *     A.java ==========> A.class(0,1) ==========> �� �پ� 
 *     ���üҽ�     javac                    java           
 *     (���α׷���)
 *              ========                  ======
 *              
 *              1. ������ ����: �ݵ�� ����ó��
 *              2. ����� ����: ����ó���� ������ �� �ִ�(�ʿ�� ����ó���� �� �� �ִ�)
 *              
 *            ===============================================
 *              Check Exception       NON-Check Exception
 *            ===============================================
 *              ������ �ÿ� Ȯ��           ����ÿ� Ȯ��(����ó���� ��� �ȴ�)
 *              
 *                           ����ó�� ������
 *                         ===============
 *                         
 *                             Object
 *                                |
 *                            Throwable  (������ �����ϱ� ������ �� �ִ� ����� ����)
 *                                |
 *                   -----------------------------
 *                   |                           |
 *                 Error                     Exception
 *                           Check               |              NON-Check
 *                              --------------------------------------
 *                              |                                    |
 *                        IOException(����)                           |
 *                        InterruptedException(������)                 |
 *                        URLMalformedException(��Ʈ��ũ)               |
 *                        ClassNotException                          |
 *                        SQLException(�����ͺ��̽�)                     |
 *                                                            RuntimeException   
 *                                                                   |
 *                                                       ArrayIndexOfBoundsException
 *                                                       NumberFormatException
 *                                                       ArithmeticException
 *                                                       NullPointerException
 *                                                       ClassCastExeption
 *     ����ó��
 *       = ���� ����(���� ó��)
 *         try
 *         {
 *            ���� ���� ����
 *         }catch(){
 *            ������� => �����߻��� �ϸ� ����
 *         }
 *       = ���� ȸ��(���� ���ѱ��: �ڹٽý��ۿ�) => ���� �� throws
 *       = ���� ��ȯ(������ �߻��� ���� �������� �ٸ� ���ܸ� �߻���Ŵ) => throw(����� ���� ����)
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * A a=new A(); B b=new B(); b=(B)a; A aa=null; System.out.println(aa.a);
		 */
		/*int[] arr=new int[2];
		arr[0]=10;
		arr[2]=0;*/
		//int a=10/0;
		// Integer.parseInt(" 10")   NumberFormatException
		/* int a=10;
		int b=0;
		int result=a/b;   // ���⼭ ����� => ������ ����
		System.out.println("���α׷� ����!!"); */
		try
		{
			int a=10;
			int b=0;  // ���� ����
			int result=a/b;  // ���� �߻� => catch�� �̵�
			System.out.println("result="+result);
		}catch(Exception e) {
			System.out.println("���α׷� ����!!");  // {} ���� �ҽ��� �̵�
		}
			System.out.println("���α׷� ����");
	}

}
