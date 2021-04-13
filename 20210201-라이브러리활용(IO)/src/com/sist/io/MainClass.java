package com.sist.io;
/*
 *    IO => �����(�޸�, ����, ��Ʈ��ũ)
 *    ===
 *      File ����: ���ε�, �ٿ�ε� => ��õ ���α׷�, AI
 *      1) File
 *      2) byte ������ �б�, ���� => ~InputStream, ~OutputStream => 1����Ʈ��
 *      3) char ������ �б�, ���� => ~Reader, ~Writer => 2����Ʈ��(�ѱ�)
 *      4) ��ü ������ �б�, ���� => ObjectInputStream, ObjectOutputStream
 *    ** �ڹٿ��� ������� ��Ʈ�� => �����͸� �̵��ϴ� ���(�ܹ���) => �����(���α׷� �� ���� ���ÿ� ó��)
 *                                                     ========================== ������(�޼ҵ� �������� ���ÿ� ����)
 *       ��� �޼ҵ�� ����ȭ ���α׷��� ���� ����
 *       class A
 *       {
 *           public void aaa(){}
 *           public void bbb(){}
 *       }
 *       
 *       A a=new A();
 *       a.aaa();   ==> return(������)
 *       a.bbb();   ==> return(������ ����)      aaa() bbb() aaa() bbb() �̷��� ������ ���� ���� => ������(���ôٹ��� ���� ����)
 *       ============================================================ IO������ ������� �Ұ�
 *          = ����Ʈ ��Ʈ��(1byte): �̹�������, ZIP... (���ε�, �ٿ�ε�)
 *            InputStrimg       OutputStream  ==> interface
 *                 |                  |
 *               read               write  => ������ ó���� �Ŀ��� �ݵ�� �ݱ�(close())
 *                                            ================================ finally
 *            ***** IO�� CheckException: �ݵ�� ����ó���Ѵ� => finally
 *            = ������ Ŭ����
 *              FileInputStream        FileOutputStream
 *              BufferedInputStream    BufferdOutputStream
 *              ObjectInputStream      ObjectOutputStream
 *            
 *          = ���� ��Ʈ��(�ѱ��� �ִ� ���) => 2byte
 *            Reader       Writer ===> interface
 *            = ������ Ŭ����
 *              FileReader        FileWriter
 *              BufferedReader    BufferedWriter
 *            
 *          = File (Ŭ������)
 *            = file =======> ���ϸ����
 *              File file=new File("c:\\javaDev\\daum_movie.txt")
 *            = directory ==> ���������
 *              File dir=new File("c:\\javaDev")
 *            = ���̺귯��
 *              directory ����
 *                = listFiles(): ���� �ȿ� �ִ� ���ϰ� ����..
 *                = delete(): ���� ����
 *                = mkdir(): ���� ����
 *              file ����
 *                = ������: lastModified(long) => ��¥������ ����
 *                                              ====    ===
 *                                              Date    SimpleDateFormat
 *                = ���ϸ� �б� => getName(), getPath(), getParent()
 *                         getName(): ���ϸ� ������ �´�
 *                         getPath(): ��θ���� ���ϸ���� �б�
 *                         getParent(): ��θ� ���� ����
 *                = �������Ͽ���: isHidden()
 *                  �б⾲�⿩��: canRead(), canWrite()
 *                  
 */
import java.io.*;   // ���� ���� => ����°� ���õ� ��� Ŭ������ ����(�޸������, ���������, ��Ʈ��ũ�����)
// URL => IO�� �̿��ؼ� ����� => ��ü ������ ������ ��Ƽ� ó��(Buffered~~)
// File
/*
 *   1. File ��ü ����
 *      File file=new File("c:\\������\\���ϸ�");(********** ��ȣ)   // length ũ�� �ݵ�� Ȯ��
 *      
 *      File dir=new File("c:\\������");
 *      File file=new File(dir,"���ϸ�");
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����(directory) �б�
		// 1. ���� �����
		File dir=new File("c:\\download");
		if(!dir.exists())  // ������ �ִ��� ���� Ȯ��
		{
			// �������� �ʴ� ���, ������ �����
			dir.mkdir();
		}
		// ���� �ȿ� �� �ִ� ������ ����
		File[] files=dir.listFiles();   // Ž���⸦ ����� ���
		for(File f:files)
		{
			if(f.isFile())        // ������ ���
			{
				System.out.println(f.getName());
			}
			if(f.isDirectory())   // ������ ���
			{
				System.out.println(f.getName()+" DIR");
			}
			
			// ���� ����
			dir.delete();   // ���� �ȿ� �����̳� ������ �ִ� ��쿡�� ������ �� ����
			for(File f1:files)
			{
				if(f1.isFile())
				{
					f1.delete();   // ���� ����
				}
				if(f1.isDirectory()) {
					File dir2=new File("c:\\download\\"+f1.getName());
					File[] files2=dir2.listFiles();
					for(File ff:files2)
					{
						ff.delete();   // ������ ���� �� ���� ����
					}
					dir2.delete();
				}
			}
			dir.delete();   // ���� ����
		}
	}

}
