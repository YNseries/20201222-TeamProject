package com.sist.server;
// �����͸� ����(����=����Ŭ)
/*
 *     �迭(��ü �迭): ����(����)
 *     => ���������� : �÷��� Ŭ����
 *     
 *     Collection
 *          |
 *     ------------
 *     |           |
 *    List        Set    Map     ==> �������̽�
 *    ������
 *      List: ����(�ε���)�� ����, ������ �ߺ�
 *            => ������ Ŭ����: ArrayList, Vector, LinkedList, Stack
 *                          =========
 *      Set: ����(�ε���)�� ����, �������� �ߺ��� ������� �ʴ´�
 *           => HashSet(�ߺ����� �����͸� ��Ƽ� List�� ������ ��) ==> ����Ŭ���� DISTINCT�� ���°� ����
 *           
 *      Map: ����(�ε���)�� ����, => key(�ߺ� �Ұ�), value(�ߺ� ����)�� ���ÿ� ����
 *           => ���̺귯���� ����: session, cookie, request, response(�� ���α׷�)
 *           => HashMap
 *      ====>
 *      ���α׷� => ���õ� �����ͳ��� ��Ƽ� ���� => �� ���� �̸����� ����(�����ϰ�, ����ϱ� ����)
 *               int a=10; int b=20; int c=30;
 *               
 *               // �ִ�
 *               int max=0;
 *               if(max<a)
 *                  max=a;
 *               if(max<b)
 *                  max=b;
 *               if(max<c)
 *                  max=c;
 *               
 *               int[] arr={10,20,30};
 *               ��� �ݺ��� => ����(�ݺ�) => ���������� ����
 *                                       =========== ���׸���
 *               ArrayList, Vector...
 *               ===================== ��� �������� Object <String>
 *               
 */
import java.util.*;
import java.io.*;
import java.util.Scanner;
/*
 *    ����: ������ �� ���� ������ �� �ִ� ����
 *    �迭, Ŭ���� 
 *    Ŭ���� ������: �÷���
 */
public class MovieManager {
	private static ArrayList<MovieVO> list=new ArrayList<MovieVO>();  // �������� ������ ����
	// MovieVO[]�� ����� ��, ������ ��������� ������ ���� => ����
	// ���α׷��� ���� => �����͸� ���� => �ʱ�ȭ ��(���� => �޸�)
	static
	{
		try
		{
			// �����б�
			// | ���� �и� => VO�� ��´�
			// VO => list
			FileReader fr=new FileReader("c:\\javaDev\\daum_movie.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1)  // ������ �� ���ھ� �о���µ� IO ���� �� �پ� �о�ðž�
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			//System.out.println(sb.toString());
			// ��ȭ���� �и�
			String[] movie_data=sb.toString().split("\n");
			/*
			 *   215|
			 *   5|
			 *   �㽩: ������ �ٲ� ��ź����(2019)|
			 *   8.0|
			 *   ���|
			 *   2020.07.08 |
			 *   109��|
			 *   15���̻������|
			 *   ���� ��ġ|
			 *   �������� �׷�|
			 *   //img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net
			 *   	%2Fmovie%2F0a3e3e96d51a738c0e45c314899ce6e4793443ea|
			 *   182,026|
			 *   �Ǵ��� ��ī�Ӱ�, ��ħ�� ����ϰ�, �ൿ�� �����ϰ�! �뼱�ĺ� ���ȸ���� Ʈ������ ������ ���� 
			 *   	���������� ���� ��Ŀ �ޱ� �̸�(�������� �׷�)�� Ʈ������ ��ӵǴ� Ʈ���� �������� ȭ���� �߽ɿ� ����. 
			 *   	����, ���� ��Ŀ�� �׷�õ Į��(���� Ű���)�� ����� �Ƿ��� ���ա��̶� �Ҹ��� �������� ȸ���� ����ϰ� 
			 *   	�̿� �ޱ��� ����, �߽� �ִ� ������ �����̽� ���϶� �����ǽ�(���� �κ�) ���� ����� ������ ���ϴµ��� 
			 *   	�ִ� �Ƿ��� �������� ��ź���� ���� �̵��� �����ϰ� ¥���� �������� ���۵ȴ�!
			 */
			for(String s:movie_data)
			{
				//System.out.println(s);   // ���� | ���� �и��ؼ� VO�� ÷�� => �ϳ��� ArrayList�� ÷��
				StringTokenizer st=new StringTokenizer(s,"|");
				// String[] data=s.split("\\|");   split�� ���Խ�(regex) �������� �ڸ��ٴ� ������ ����
				//                          = �̹� ������̱� ������ \\�� �ٿ� ����;� ��
				MovieVO vo=new MovieVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setCno(Integer.parseInt(st.nextToken()));
				/*
				 *     class A
				 *     
				 *     A a=10;                 �̷��Դ� �Ұ�����. 10�� �ƴ� �ּҰ� ���� ��
				 *     A a=(int)new A();       ���� �Ұ���
				 *     
				 *     �ٸ�, Wrapper Ŭ����/Object�� �����ϰ� �Ǿ�����
				 *     Integer i=10;
				 *     Object o=10;
				 *     
				 *     ������ new�� ���ؼ� ����;� ��
				 */
				vo.setTitle(st.nextToken());
				vo.setScore(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setTime(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setPoster("http:"+st.nextToken());
				vo.setShowUser(st.nextToken());
				vo.setStory(st.nextToken());
				
				list.add(vo);   // ArrayList�� ����!
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// ��ü ��� ���
	public ArrayList<MovieVO> movieListData(int page)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		int j=10;                   // 10���� ������ ����
		int pagecnt=(page*10)-10;   // ���� ��ġ
		// 0~218  (1~219)  == 219
		int totalpage=movieListTotalPage();
		if(page==totalpage)    // �� ������ �������� ����ϱ� ���ؼ� ����
		{
			if(list.size()%10>0)   // �� ������ �ݵ�� �ɷ��� ��. ������ ���������� �� ���� ���� �ֱ� ������ 
			{                      // ���� �ʴ� ���� �Ͽ� �����ϱ� ����
				j=list.size()%10;    // 219%10 ==> 9
			}
		}
		// for�� => ��� 0������ �����ؼ� ����
		for(int i=pagecnt;i<pagecnt+j;i++)
		{
			MovieVO vo=list.get(i);
			mList.add(vo);
		}
		return mList;
	}
	
	// ī�װ��� ���(������ ������)
	public ArrayList<MovieVO> movieCategoryData(int page,int cno)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		return mList;
	}
	
	// �� ����(��ȭ ���� �ϳ��� �ʿ�)
	public MovieVO movieDetailData(int no)
	{
		MovieVO vo=list.get(no-1);   // ��ȭ�� 1���� ����������, �ε��� ��ȣ�� 0���� �����߱� ������ -1 �� ��� ��Ī��
		// vo: ��ȭ �� ���� ���� ��� ������ ������ �ִ�
		return vo;
	}
	
	// ã��
	public ArrayList<MovieVO> movieFindData(String title)
	{
		ArrayList<MovieVO> mList=new ArrayList<MovieVO>();
		for(MovieVO vo:list)
		{
			// ����
			// SELECT * FROM movie WHERE title LIKE '%��%'   : �� �� ���Ե� Ÿ��Ʋ�� �޶�
			if(vo.getTitle().contains(title))
			{
				mList.add(vo);
			}
		}
		return mList;
	}
	// �� ������
	public int movieListTotalPage()
	{
		int total=(int)(Math.ceil(list.size()/10.0));
		return total;
	}
	public int movieCategoryTotalpage(int cno)
	{
		// SELECT CEIL(COUNT(*)/10.0) FROM movie WHERE cno=1  �̷��� ����Ŭ���� �ᵵ �ص� ��
		int total=0;
		int count=0;
		for(MovieVO vo:list)
		{
			if(vo.getCno()==cno)
			{
				count++;
			}
		}
		total=(int)(Math.ceil(count/10.0));
		return total;
	}
	public static void main(String[] args) {
		MovieManager m=new MovieManager();   // m => ��ȭ ���õ� ��� �� ���� ����
		/*String[] category={"","����󿵿�ȭ","����������ȭ","�ڽ����ǽ�(�ְ�)","�ڽ����ǽ�(����)","�ڽ����ǽ�(����)"};
		System.out.println("��������:"+m.movieListTotalPage());
		for(int i=1;i<=5;i++)
		{
			System.out.println(category[i]+":"+m.movieCategoryTotalpage(i));
		}*/
		
		/*for(MovieVO vo:list)
		{
			System.out.println(vo.getNo()+"|"+vo.getTitle());
		}*/
		Scanner scan=new Scanner(System.in);
		//�˻��ϱ�
		/*System.out.print("�˻��� �Է�:");
		String find_data=scan.next();
		ArrayList<MovieVO> list=m.movieFindData(find_data);
		System.out.println("�˻��� ���:"+list.size());
		for(MovieVO vo:list)
		{
			System.out.println(vo.getNo()+":"+vo.getTitle());
		}*/
		
		/*System.out.print("�� �� ��ȭ��ȣ �Է�(1~219):");
		int no=scan.nextInt();
		MovieVO vo=m.movieDetailData(no);
		System.out.println("��ȣ:"+vo.getNo());
		System.out.println("����:"+vo.getTitle());
		System.out.println("����:"+vo.getDirector());
		System.out.println("�⿬:"+vo.getActor());
		System.out.println("�帣:"+vo.getGenre());
		System.out.println("���:"+vo.getGrade());
		System.out.println("����:"+vo.getScore());
		System.out.println("�ð�:"+vo.getTime());
		System.out.println("�ٰŸ�:"+vo.getStory());*/
		
		System.out.print("������ �Է�:");
		int page=scan.nextInt();
		ArrayList<MovieVO> list=m.movieListData(page);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getNo()+":"+vo.getTitle());
		}
	}
}
