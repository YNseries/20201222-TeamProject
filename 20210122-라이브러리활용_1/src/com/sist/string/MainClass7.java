package com.sist.string;
/*
 * 	  ������Ʈ�� ���� ���: �˻���
 *      ����: 
 *    startsWith: �����ϴ� ���ڿ��� ���� ��� true
 *    ������: boolean
 *    �Ű�����: �����ϴ� ���ڿ� String
 *    ����: public boolean startsWith(String str)
 *    endsWith: ������ ���ڿ� ���� ��� true
 *    ������: boolean
 *    �Ű�����: �� ���ڿ� String
 *    ����: public boolean endsWith(String str)
 *    
 *    contains: ���ڿ��� ���Ե� ���: true
 */
import java.util.Scanner;
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] menu= {
			"�ڹٿ� ����Ŭ",
			"�ڹ����α׷���",
			"ȥ�� ���� �ڹ�",
			"�ڹ� 200��",
			"����Ŭ�� Ajax",
			"JQuery and �ڹ�",
			"HTML5 & CSS3",
			"�ڹٿ� ���̽� ����",
			"������5�� ���̽�",
			"�ڹ� ����"
		};
		Scanner scan=new Scanner(System.in);
		//System.out.print("�˻��� �Է�:");
		//String find_data=scan.next();
		String find_data="  �ڹ�";  // ������ ���� ����. ã�� �� ����. ������ �ؿ��� .trim() �־���� ��
		
		// �˻�� ���Ե� ������ �����ֱ�
		for(String s:menu)
		{												  // ����Ŭ������ ���� ��
			if(s.startsWith(find_data.trim()))   // �ڹٷ� �����ϴ�  => LIKE '�ڹ�%' �ڹٷ� �����ϴ� ��� ���ڿ�
			//if(s.endsWith(find_data))     // �ڹٷ� ������   => LIKE '%�ڹ�'
			//if(s.contains(find_data))       // '�ڹ�'�� ���Ե� => LIKE '%�ڹ�%'
			{
				System.out.println(s);
				try
				{
					Thread.sleep(300);   // 0.3��
				}catch(Exception ex) {}
			}
		}

	}

}
