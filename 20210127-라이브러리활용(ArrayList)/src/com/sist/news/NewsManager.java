package com.sist.news;
import java.util.*;
import java.io.*;
public class NewsManager {   // NewsVO�� NewsManager�� ��𿡼� ����ϴ��� �ٲ��� ����.
	private static ArrayList newsList=new ArrayList();
	// �����͸� ����(static) 
	static
	{
		try
		{
			// ���� �б�
			FileReader fr=new FileReader("c:\\javaDev\\daum_news.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			// System.out.println(sb);  // sb | sb.toString() => �� �� �Ȱ���. �ϳ��� toString()�� ������ ��(����� ����)
			// �и� => ������ ������ ����
			String data=sb.toString();  // �׳� sb���� ���� ��
			String[] news_data=data.split("\n");
			//NewsVO vo=new NewsVO();  // ���⿡ ���� �޸� �ּ� �Ѱ����� ������ �͸� ����. �ȿ� ���� �ּҰ� ���� �����
			// aaa||bbb|ccc ����    aaa| |bbb|ccc ����ó��
			for(String news:news_data)
			{
				StringTokenizer st=new StringTokenizer(news,"|");
				NewsVO vo=new NewsVO();  // ������ �޸� �ּ� ����� ���ؼ� ���� for�� ������� ��
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setContent(st.nextToken());
				vo.setAuthor(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setLink(st.nextToken());
				newsList.add(vo);
			}  // vo(stack�� ����Ǿ� ����)�� �� ���� ������ ��������� 
			   // �̸� ������ �ּ�_������(heap)�� �������� => �̰� �����ϱ� �� �ؼ��ϴ°� GC
		}catch(Exception ex) {}  
		                  // {}�ȿ� ������ ��� ���ؼ� ex.printStackTrace(); �� �־���� ��		
	}
	
	// ��� ���
	public ArrayList newsListData(int page)   // �ڡڡ� ������ �ڡڡ�
	{
		ArrayList list=new ArrayList();
		int j=0;  // 10���� �����ִ� ���� => j<10
		int pagecnt=(page*5)-5;  // ���� ��ġ�� ����ִ� ����(�ε��� ������ �̿�)
		/*                == �����ְ� ���� ����
		 *    1page: 1~5
		 *    2page: 6~10
		 *    3page: 11~15
		 */
		for(int i=0;i<newsList.size();i++)  // �̷��� ������ ��)300���� �� �Ź� 300���� ���ư��� ������ ����.
		{    // i=�ε�����ȣ                      �׷��� ����Ŭ���� �����ִ°� ����
			if(j>4) break;
			if(j<5 && i>=pagecnt)   // i(�ε���)�� ���� ��ġ ����
			{
				NewsVO vo=(NewsVO)newsList.get(i);
				list.add(vo);
				j++;  // j=5�� �Ǹ� ����
			}
		}
		return list;
	}
	
	// �� ������
	public int newsTotalPage()
	{             // ========= ����ص�    random�� ���� ������ ��
		return (int)(Math.ceil(newsList.size()/5.0));
		// 203/20.0 ==> 10.15 ==> ceil(10.15) ==> 11     ceil: �ø��Լ�
	}
	
	public static void main(String[] args) {
		NewsManager m= new NewsManager();
		/*String msg="aaa||bbb|ccc|||ddd";
		StringTokenizer st=new StringTokenizer(msg,'|');
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());*/
		/*
		 * for(int i=0;i<newsList.size();i++) { NewsVO vo=(NewsVO)newsList.get(i);
		 * System.out.println(vo.getTitle()); }
		 */
		ArrayList list=m.newsListData(30);
		for(int i=0;i<list.size();i++)
		{
			NewsVO vo=(NewsVO)list.get(i);   // Object �ްԵǸ� getter/setter �̿� �Ұ�
			// Object obj=list.get(i)
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		System.out.println("�� ������:"+m.newsTotalPage());  
		/*
		 *    class A
		 *    {
		 *        public String toString(){}
		 *        public void display(){}
		 *    }
		 *    
		 *    Object obj=new A();  ==> Object�� ������ �ִ� �޼ҵ� �߿� AŬ������ �������̵� �� �͸� ȣ��
		 *    
		 *    obj.toString();
		 *    obj.display()  (X)
		 *    
		 *    A a=(A)obj;   // �� ��ȯ ��Ű�鼭 �����;� ��
		 *    a.toString();
		 *    a.display();
		 */
		// String s="Hello";  // "" ��ü�� �ּ�
		// char[] s=new char[]{'H'	...} �̷��� ��ȯ�Ǳ� ����
		// int[] arr={10, 20, 30, ... }
		
	}
}
