//  ���ڿ� => String => char[]
/*
 *    String : ��������, Ŭ����(���ڿ��� ������ �� �ִ� ��� = �޼ҵ�)
 *    ���ڿ����� ���� �� ���� ������ �� ��  => charAt(0)
 *       ABCDEFG
 *       0123456
 *    ���ڿ��� ���� Ȯ��  length()
 *    ���ڿ� ��       equals �ڡڡ�            => Login (id,pw)ó���� ��
 *    ���ڿ� ���Ե� �ܾ�  contains()
 *    =============
 *    �����ϴ� ���ڿ�    startsWith()
 *    ������ ���ڿ�     endsWith()
 *    ============= ������Ʈ(�ڵ��ϼ���/ã��)     => �˻��� ���� ��
 *    ���ڿ� �ڸ���     substring() �ڡڡ�       => A.java  (. �ڿ��� ����Ͷ�)��°� �� ��
 *                                           02)111-1111 (02 ���� ����Ͷ� �� ��)
 *    ���ڿ� => �빮��, �ҹ��� 
 *            ====  ====
 *   toUpperCase(), toLowerCase()
 */
import java.util.Scanner;
public class �迭Ȱ��_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ������ ���� ������ ���� (length())
		String data="Hello Java!!";  // ���� ������ ���� ����
		System.out.println("������ ����:"+data.length());
		// 2. �빮�ڷ� ��ȯ (toUpperCase())
		System.out.println("�빮�� ��ȯ:"+data.toUpperCase());  // �빮�ڴ� �״�� ����. ���ĺ��� �ٲ�
		// char c='a'  ==>  (c-32)='A'  a=97 <a�� A ������ ���� 32> A=65
		// 3. �ҹ��ڷ� ��ȯ (toLowerCase())
		System.out.println("�ҹ��� ��ȯ:"+data.toLowerCase());  
		// 4. charAt(index) => ���ڿ��� ��ȣ 0������ ����
		/*
		 *   Hello Java!!
		 *   01234567891011
		 *   
		 *   J ==> charAt(6)  // ��ü ���� �� �ϳ��� ����� ��
		 */
		System.out.println("���� �� �� �б�:"+data.charAt(8));
		// 5. contains() => ���ڿ� �߿� Ư�����ڰ� ������ �ǳ� => true/false
		System.out.println("���Կ���:"+data.contains("Java"));  // ��ҹ��� ���� Ȯ���� �ؾ���.
		                     // ����Ŭ������ ========= LIKE
		Scanner scan=new Scanner(System.in);
		String[] find_data= {"�ڹٶ�",
				             "�ڹ�",
				             "�ڹٶ� ĭ����",
				             "�ڹٶ� �ڹ�",
				             "�ڹ���",                  // ���� �پ��� ������ ������ ����
				             "�ڹ� �ٿ�ε�",
				             "�ڹٶ� ��",
				             "�ڹٶ� �빮",
				             "�ڹٶ� Ŀư",
				             "�ڹ� ��ũ��Ʈ",
				             "�ڹ��� ��� �Ǿ��޿� ����",    // ���� �پ��� ������ x
				             "�ڹٶ� �ڹ�",
				             "�ڹٳ���",
				             "�ڹٽ�ũ��Ʈ ���� �ذ�",
				             "�ڹ� ����"};
		System.out.print("�˻��� �Է�:");
		String fd=scan.next();  // �˻�� �޴´�
		for(String s:find_data) // �ڵ� �ϼ���(�˻���)
		{
			// if(s.startsWith(fd))  // ù ���� �ܾ�
			if(s.endsWith(fd))       // ������ �ܾ�
			{
				System.out.println(s);
			}
		}
	}

}
