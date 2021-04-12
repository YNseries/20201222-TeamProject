package com.sist.main;
import com.sist.recipe.*;  // Ŭ������ 2�� �ֱ� ������ * ����.
/*
 *   �ڹ� �ҽ��� ����
 *   1. package�� => 1���� ��� ����
 *   2. �ʿ��� library import => ������ ��� ����
 *      ��Ű���� �ִ� Ŭ������ �о� �� ��
 *      import com.sist.main.*;
 *   3. class className{
 *         ==============
 *           ���� ����(�ν��Ͻ�����, Ŭ��������)
 *         ==============
 *           ������
 *         ==============
 *           ���(�޼ҵ�)
 *         ==============
 *           main�޼ҵ�()
 *           {
 *           }
 *         ==============
 *      }
 *   
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeManager rm=new RecipeManager();
		int no=rm.main_menu();
		String data=rm.sub_menu(no);
		System.out.println(data);
	}

}
