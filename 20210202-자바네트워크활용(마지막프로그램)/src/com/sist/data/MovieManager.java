package com.sist.data;
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
    		// ��ü������ ���� : ������ȭ 
    		ObjectInputStream oos=new ObjectInputStream(fis);
    		// ArrayList�� ���� ä���ش�
    		list=(ArrayList<MovieVO>)oos.readObject();
    		oos.close();
    	}catch(Exception ex){}
    }
    // ��� => �޼ҵ� 
    // 1. ��ü ��� ��� => ������ ������ 
    /*
     *   ������â => ����� ��û => 2������ �����޶� => MovieManageró�� => ����� => ������ 
     *     ��(������) 
     */
    public ArrayList<MovieVO> movieListData(int page)
    {
    	ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
    	int rowSize=20;
    	int start=(page*rowSize)-rowSize;
    	/*
    	 *    1page  0~19 (1~20)
    	 *    2page  20~39 (21~40)
    	 *    11page 200~219 => (201~219)
    	 */
    	int total=movieTotalPage();
    	//System.out.println(total);
    	if(page==total)
    	{
    		rowSize=list.size()%20;// �������Ѱ���%20 => 219%20 = 19 219 => 220
    		// 219%20
    		// 11%20 ==> 11
    	}
    	
    	for(int i=start;i<start+rowSize;i++)
    	{
    		MovieVO vo=list.get(i);
    		mList.add(vo);
    	}
    	return mList;
    }
    // 1-1. �������� ���ϱ�
    public int movieTotalPage()
    {
    	return (int)(Math.ceil(list.size()/20.0)); //219/20 => 11
    	// ceil => �ø� �޼ҵ� => �Ҽ������ϰ� 1�̻��̸� �ø�
    	// random() , ceil()
    }
    // 2. ī�װ��� ��� => ������ ������
    // 3. �˻� : ����  => ������ ������ 
    // 4. �˻� : �帣��  => ������ ������ => ����� �Ѵ��� ���� �ִ� ȭ��(�׸� 15)
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieManager m=new MovieManager();
		ArrayList<MovieVO> list=m.movieListData(11);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println("==================================================");
		}
        /*for(MovieVO vo:list)
        {
        	System.out.println(vo.getMno());
        	System.out.println(vo.getTitle());
        	System.out.println(vo.getDirector());
        	System.out.println(vo.getActor());
        	System.out.println("===================================================");
        }*/
		/*Scanner scan=new Scanner(System.in);
		String[] menu={
				"1. ���� �� ��ȭ",
				"2. ���� ���� ��ȭ",
				"3. �ڽ����ǽ�(�ְ�)",
				"4. �ڽ����ǽ�(����)",
				"5. �ڽ����ǽ�(����)"
		};
		System.out.println("========== �޴� ==========");
		for(String s:menu)
		{
			System.out.println(s);
		}
		System.out.println("=========================");
		System.out.print("�޴��� �����ϼ���?");
		int index=scan.nextInt();
		for(MovieVO vo:list)
		{
			if(vo.getCno()==index)
			{
				System.out.println(vo.getMno());
	        	System.out.println(vo.getTitle());
	        	System.out.println(vo.getDirector());
	        	System.out.println(vo.getActor());
	        	System.out.println("===================================================");
			}
		}
		System.out.print("�帣 �Է�:");
		String genre=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getGenre().contains(genre))
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getGenre());
	        	System.out.println(vo.getTitle());
	        	System.out.println(vo.getDirector());
	        	System.out.println(vo.getActor());
	        	System.out.println("===================================================");
			}
		}
		
		System.out.print("��ȭ ���� �Է�:");
		String title=scan.next();
		for(MovieVO vo:list)
		{
			if(vo.getTitle().contains(title))
			{
				System.out.println(vo.getMno());
				System.out.println(vo.getGenre());
	        	System.out.println(vo.getTitle());
	        	System.out.println(vo.getDirector());
	        	System.out.println(vo.getActor());
	        	System.out.println("===================================================");
			}
		}
		
		System.out.print("1~219 ��ȣ�� ����:");
		int detail=scan.nextInt();
		MovieVO vo=list.get(detail-1); // ArrayList => ���� 0
		System.out.println(vo.getMno());
		System.out.println(vo.getGenre());
    	System.out.println(vo.getTitle());
    	System.out.println(vo.getDirector());
    	System.out.println(vo.getActor());
    	System.out.println(vo.getTime());
    	System.out.println(vo.getGrade());
    	System.out.println(vo.getRegdate());
    	System.out.println(vo.getScore());*/
	}

}