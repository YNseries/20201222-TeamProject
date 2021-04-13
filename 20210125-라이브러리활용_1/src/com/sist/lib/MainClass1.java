package com.sist.lib;
/*
 *    java.lang.* => ���α׷����� ����� �� �ִ� Ŭ������ ����
 *    ===========
 *    1) Ư¡
 *       = import�� ������ �� �ִ�
 *    2) �ڹٿ��� �����ϴ� Ŭ����
 *       = Object
 *         = toString() ���ڿ� ��ȯ(��ü) => ��ü�� �ּҰ� ���
 *         = equals() ��ü�� ��ü�� ��
 *         = finalize() �Ҹ���(�޸� ���� �ڵ� ȣ��) => System.gc()
 *         = clone() ����
 *           = ����: ���ο� �޸𸮸� ����� �ش�
 *           = ����: �ּҰ� ����(�������� �� ���� �޸𸮸� ����)
 *                  ������, ��Ʈ��ũ����, ����Ŭ���� ����
 *             =================== �������� Ŭ�������� �� ���� �ּҷ� �����ϴ� ���(�̱���)
 *             ==> ����(��Ʈ��ũ), �����ͺ��̽�: ���������� �̿��ؼ� �� ���� ��ü�� ��� Ŭ������ ����
 *             ==> ����Ʈ���� ����: �̱���, ���丮 ���� => ������ �ַ� �̿�(������)
 *       = Spring: ���ڿ��� ���õ� Ŭ����
 *         = �Ϲ�Ŭ����(�⺻��)
 *         = Ŭ������(���=�޼ҵ�)
 *         = �޼ҵ忡�� �Ű������� �̿��ؼ� ������ �����ϴ� ���
 *           �Ű����� �̿��
 *           1) Call By Value(�Ϲ� �����Ͱ�) => �޸𸮰� ���� ���� => �⺻ ��������, String
 *           2) Call By Reference => �迭, Ŭ������ ��쿡 �ַ� ���(�ּҸ� �Ѱܼ� �ּ� ��ü�� �����Ͱ��� ����)
 *         = �ֿ���(�޼ҵ�)
 *           1) equals(): ���� ����� ���ڿ��� �� ==> ����: public boolean equals(String str)
 *              ��) 
 *                 String id="";
 *                 String id2="";
 *                 id.equals(id2)  => id�� id2�� ���� true(����)/false(�ٸ���)
 *              = �α���(ID,Password ��)
 *              = ID �ߺ�üũ
 *           2) substring(): ���ڿ��� �ڸ� ��
 *              = �����ε�: �������� �޼ҵ尡 ������� �ִ�
 *              ����:
 *                   public String substring(int s): ������ ��ġ�κ��� ��ü�� �о� �� ��(������ ��ġ~��)
 *                   public String substring(int s,int e): ���ڿ� �߰����� �ڸ���(������ ��ġ~e-1����)
 *                          # ������ ���ڴ� ���ܵȴ�
 *              = �ڹ��� ���ڿ��� ���۹�ȣ�� 0���̴�
 *           3) ã��: �տ��� ã�� = indexOf()
 *                   �ڿ��� ã�� = lastIndexOf()
 *                   ===========> public int indexOf(ã�� ����, ã�� ���ڿ�)
 *           4) ���ڿ��� ã��
 *              startsWith(): ���� ���ڿ��� ���� ���
 *              endsWith(): ������ ���ڿ��� ���� ���
 *              contains(): ���ڿ� �߿� ã�� ���ڿ��� ���Ե� ���
 *              
 *           5) ������ ����: length()
 *           6) ���ڿ� ��ȯ(��� ���������� ���ڿ��� ��ȯ): valueOf() => �����ϰ� static �������� �Ǿ�����
 *           7) ���ڿ� �и�: split => public String[] split(String regex)
 *           
 *       = StringBuffer/StringBuilder
 *         StringBuffer = StringBuilder : ������ ����(��Ʈ��ũ���� ������ �����͸� �о ����: StringBuilder)
 *         ============
 *           = append() => ���ڿ� ����
 *           = toString() => ����� ���ڿ��� �о���� ���
 *       = Wrapper: �Ϲ� �����͸� �����ϱ� ���� ����� �� Ŭ����
 *         =======
 *           Byte(byte)
 *           Boolean(boolean)
 *           Long(long)
 *           Double(double)
 *           Float(float)
 *           Integer(int)
 *           ==> ����ڽ� / ��ڽ�
 *               Integer i=new Integer(1);
 *               int a=10;
 *               int b=i;   // ����ڽ�
 *               ============================== Integer Ŭ������ �Ϲ� �����Ͱ��� ����� �� �ִ�
 *               Integer b=i; // ��ڽ�
 *       = Math(��� �޼ҵ尡 static): �������� ����
 *         = random(): 0.0~0.99 ������ ������ �߻� => public static double random();
 *         = ceil(): �ø� �޼ҵ� => (������ ����� ����Ѵٸ�, ������ ������ �ʿ�)�� ������ ���� �� ���
 *                   ** ����¡ ���
 *       = Scanner: Ű���� �Է°��� �޴� ���(���� �̿��ϸ� ����x)
 *    java.util.* => �ݵ�� import�� ����ؼ� Ŭ������ �о�;� ��
 *       ***= ��¥
 *       = ���ڿ� �и�
 *       ***= �÷��� Ŭ����: �迭 ��� ���
 *    java.io.*
 *    java.net.*
 *    ===================================================
 *    java.sql.* : Oracle ����(����Ŭ���� ������ �б�)
 *    javax.http.servlet.* : Web���� ���
 */
import java.io.*;  // ���Ͽ��� ������ �б�
public class MainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String �̿�
		String data="";  // movie.txt ���Ͽ��� �����͸� �о �����ϴ� ����
		// ���� �б�
		/*
		 *    IO, SQL, NetWork => CheckException = �ݵ�� ����ó���� �Ѵ�
		 */
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");  // ���� ���� ���� ���� �� ���
			// FileInputStream(1byte), FileReader(2byte): �ѱ� ���� ����
			int i=0;  // �ѱ��ھ� �о�´� => ���� ��ȣ�� �д´�  A = 65
			// char => 0~65535 => ��Ƽ����Ʈ(UniCode) => ASC�� UniCode�� ����(UTF-8)
			//System.out.println((int)'ȫ');
			/*
			 *    ���
			 *      while: �ݺ� Ƚ���� ���� ��쿡 �ַ� ���
			 *      for: �ݺ� Ƚ���� ������ ���
			 */
			while ((i=fr.read())!=-1)  // ������ ���� ��(-1)���� �� ���ھ� �о����(-1:EOF)
			{
				data+=String.valueOf((char)i);
				// valueOf ==> static �޼ҵ�. ��� ���������� ���ڿ��� ��ȯ
				// ����ó���� ���� �������������� ����. ������ ����ȯ�� �Ǵ� ��
				// ���ڿ�+int => ���ڿ�+(int=>���ڿ�)
			}
			// ���� �ݱ�
			fr.close();
			// ���� �����͸� ����Ѵ�
			System.out.println("=============== ��ȭ ���� ===============");
			System.out.println(data);
		}catch(Exception ex) {}
	}

}
