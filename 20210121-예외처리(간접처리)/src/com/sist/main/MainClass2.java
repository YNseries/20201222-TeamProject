package com.sist.main;
/*
 *    ���� ȸ��: �ý��ۿ��� ó�� => throws
 *    ����)
 *         ���������� ������ �޼ҵ��(�Ű�����..) throws�� ����Ǵ� ���� ���..
 *         
 *         ��)
 *             public void display() throws NumberFormatException, NullPoint Exception,
 *                                   ClassCastException,Exception
 *                                   ============================ ������ ����
 *             => display() ȣ��ÿ�
 *                  = ȸ��
 *                  public void main() throws NumberFormatException, NullPoint Exception,
 *                                     ClassCastException,Exception
 *                  {
 *                      display;
 *                  }
 *                  
 *                  public void main() throws Exception
 *                  {
 *                      display();
 *                  }
 *                  
 *                  public void main() throws Throwable
 *                  {
 *                      display();
 *                  }
 *                  = ���� => try-catch�Ἥ ���ƿ��� �ؾ� ��. Ȥ�� ���� ����ó���� ���
 *                  public void main()
 *                  {
 *                     try
 *                     {
 *                        display()
 *                     }catch(Exception ex){}
 *                  }
 */
// ���̺귯�� => throws�� try-catch �������
import java.io.*;
public class MainClass2 {
	public void display() throws Exception,NumberFormatException,ArithmeticException,ArrayIndexOutOfBoundsException
	                          //            ========================================================================
	                          // ���⿡ Exception�� ����, �� �����ϱ� ������ �ڿ��� �� ���൵ ��.
	{
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MainClass2 m=new MainClass2();
		FileReader fr=new FileReader("c:\\javaDev\\movie.json"); // ������ ���ڸ��� ����ó�� ������ Ȯ��
	}

}
