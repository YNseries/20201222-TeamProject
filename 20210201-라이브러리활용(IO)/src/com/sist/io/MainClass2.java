package com.sist.io;
// File ����
import java.io.*;
import java.text.SimpleDateFormat;
/*
 *     �ڹ����� ����
 *     =========
 *     
 *     package package��: �ݵ�� �� ���� ����� ����
 *     import : �������� ����� �� �ִ�
 *     public class className{
 *       ====================
 *         [����(�������, ��������)]
 *       ====================
 *         [������] => �ʿ����� �ʴ� ���(��Ʈ��ũ ����, ������ ��ġ, ����Ŭ ����)
 *                   default �����ڸ� ÷��(�����Ϸ��� ÷��)
 *       ====================
 *         [�޼ҵ�]
 *       ====================
 *         [main �޼ҵ�]
 *       ====================
 *       
 *     }
 */
// ���Ͽ� ���� ���� Ȯ��
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("c:\\javaDev\\daum_movie.txt");
		System.out.println("===== daum_movie.txt �� ���� =====");
		System.out.println("***1. ���� ũ��"+file.length()+"Bytes");
		// Byte   =>  KB  =>  MB
		// �� ����Ʈ �� /1024   /1024
		System.out.println("2. ���� ���Ͽ���"+file.isHidden());  // true ���� / false �ȼ���
		// �б�, ���� ���� ���� => true ����
		System.out.println("3. �б�����:"+file.canRead());
		System.out.println("4. ��������:"+file.canWrite());
		
		System.out.println("***5. ���ϸ�:"+file.getName());
		System.out.println("6. ��θ�:"+file.getParent());
		// 5,6 ���ÿ�
		System.out.println("***7. ���ϸ�+��θ�:"+file.getPath());
		
		System.out.println("8. ���Ͽ���:"+file.isFile());  // �����̸� true
		System.out.println("9. ������:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date(file.lastModified())));   // ��¿�
		/* 
		 *    Date date=new Date(file.lastModified(());
		 *    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 *    String day=sdf.format(date)
		 *    // ���� �� ���� �Ʒ� �� �ٷ� �ٲ� �� ����
		 *    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified(()))
		 */
		File creat_file=new File("c:\\javaDev\\naver_movie.txt");
		try
		{
			System.out.println("***10. ���ο� ���� ����:"+creat_file.createNewFile());
			System.out.println("***11. ���� ����:"+creat_file.delete());
		}catch(Exception ex) {}	
	}

}


















