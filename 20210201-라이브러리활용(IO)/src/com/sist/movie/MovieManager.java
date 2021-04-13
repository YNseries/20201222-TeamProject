package com.sist.movie;
import java.io.*;
import java.util.*;
public class MovieManager {
	private static ArrayList<MovieVO> list=new ArrayList<MovieVO>();
	static
	{
		try
		{
			// ���� �б�
			FileInputStream fis=new FileInputStream("c:\\download\\movie.txt");
			// ��ü������ �ݰ�: ������ȭ
			ObjectInputStream oos=new ObjectInputStream(fis);
			// ArrayList�� ���� ä���ش�
			list=(ArrayList<MovieVO>)oos.readObject();  // ���� ���°� ����
			oos.close();
		}catch(Exception ex) {}
	}
	// ��� => �޼ҵ�
	// 1. ��ü ��� ��� => ������ ������
	// 2. ī�װ��� ��� => ������ ������
	// 3. �˻�: ����  => ������ ������
	// 4. �˻�: �帣��  => ������ ������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(MovieVO vo:list)
		{
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println(vo.getDirector());
			System.out.println(vo.getActor());
			System.out.println("===================================");
		}*/
		Scanner scan=new Scanner(System.in);
		String[] menu= {
				"1. ���� �� ��ȭ", 
				"2. ���� ���� ��ȭ", 
				"3. �ڽ����ǽ�(�ְ�)", 
				"4. �ڽ����ǽ�(����)", 
				"5. �ڽ����ǽ�(����)"
		};
		System.out.println("=========== �޴� ============");
		for(String s:menu)
		{
			System.out.println(s);
		}
		System.out.println("============================");
		System.out.print("�޴��� �����ϼ���");
		int index=scan.nextInt();
		for(MovieVO vo:list)
		{
			if(vo.getCno()==index)
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getTitle());
				System.out.println(vo.getDirector());
				System.out.println(vo.getActor());
				System.out.println("============================");
			}
		}
		System.out.print("�帣 �Է�:");
		String genre=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getGenre().contains(genre))     
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getTitle());
				System.out.println(vo.getDirector());
				System.out.println(vo.getActor());
				System.out.println("============================");
			}
		}
		System.out.print("��ȭ ���� �Է�:");
		String title=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getTitle().contains(title))     
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getTitle());
				System.out.println(vo.getDirector());
				System.out.println(vo.getActor());
				System.out.println("============================");
			}
		}
		System.out.print("1~219 ��ȣ�� ����:");
		int detail=scan.nextInt();
		MovieVO vo=list.get(detail-1);  // ��ȭ��ȣ�� 1������ �����ϰ�, �ε����� 0���� �����ؼ�
		System.out.println(vo.getMno());
		System.out.println(vo.getTitle());
		System.out.println(vo.getDirector());
		System.out.println(vo.getActor());
		System.out.println(vo.getTime());
		System.out.println(vo.getGrade());
		System.out.println(vo.getRegdate());
		System.out.println(vo.getScore());
	}

}
