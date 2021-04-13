package com.sist.movie;
import java.io.*;
import java.util.*;
/*
 *    ��ü���� ���α׷�(��������)
 *     = �����ͺ�ȣ: �����ʹ� ���߰�(����ȭ:private) �޼ҵ�(public)�� �̿��ؼ� �����Ϳ� ���� => ĸ��ȭ ���
 *     = ����
 *       1) ���(�����ϰų� �߰��ؼ� ���) => extends => is-a
            class A
            {
                �� �� ��
            }
            class B extends A
            {
               // �� �� ��  �ߺ�����, �߰� ����
                ��
            }
            => ����: ���� Ŭ������ �޸� �Ҵ� => �Ҵ�� �޸𸮸� ����Ŭ������ ��������� �� => �ӵ��� ����
            => ������(�������̵�): �������̵� ��� �޼ҵ��� ������ �� �˰� �־�� �Ѵ�
            => ����� ����(static: ������ ����, ������, private: ����� ���������� ����� ���� ����)
            => ����� �ȵǴ� Ŭ����: ����Ŭ����(final class)
                               java.lang.* (String, System, Math, StringBuffer, Wrapper)
 *       2) ����(�������� �ʰ� ���) => has-a
 *          class A
            {
            }
            class B extends A
            {
               A a=new A();   // A�� ���� �Ұ�
            }
 *     = ����, �߰� �����ϰ� �����
 *       ����: �������̵�
 *       �߰�: �����ε�
 *       =============================================
 *                  �������̵�      �����ε�
 *       =============================================
 *       ��ӿ���       O           X(���� Ŭ���� ���� ����)
 *       �޼ҵ��      ����          ����
 *       �Ű�����      ����          �ٸ���(��������, ����)
 *       ������       ����          �������
 *       ����������    ����, ũ��      �������
 *       =============================================
 *       ���������� ũ��
 *       private < default < protected <public
 *       
 *       class className{
 *          �Ϲ� ����: �� ���� ������ �� �ִ� ����
 *          �迭: ������ ���� => ���� ��������
 *          Ŭ����: ������ ���� => �ٸ� ��������
 *          ===============================����
 *           +
 *          �޼ҵ�
 *       }
 */
class NewsVO
{
	// ������� => �ڵ� �ʱ�ȭ
	private int no; // 0
	private String title; // null => ��� Ŭ������ null ������ �ʱ�ȭ
	private String content;
	private String poster;
	private String author;
	private String link;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
class MovieSystem
{
	// ��ȭ ���� �����͸� ����(��ȭ �� ���� ���� ��� ������ ������ �ִ� ���� �����ϱ� ����)
	// ��� user�� �����͸� ����(�����͸� �� ���� ����Ѵ�) => �ڹ�(static), ����, ����Ŭ
	private static NewsVO[] news=new NewsVO[300];  // ����
	// Ŭ���� ���� => ����(���, �����б� => �Ұ���)
	// ArrayList<NewsVO> news=new ArrayList<NewsVO>();	
	// �����б�, ����Ŭ �б�
	/*
	 *    ������� => �ʱ�ȭ
	 *    = ������: �ν��Ͻ� ����
	 *    = �ʱ�ȭ ��: static => �ڵ����� ó��
	 */
	static
	{
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\daum_news.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			//System.out.println(sb);   // sb.toString()
			
			// �迭�� ����
			String[] data=sb.toString().split("\n");
			i=0;
			for(String s:data)
			{
				StringTokenizer st= new StringTokenizer(s,"^");
				news[i]=new NewsVO();  // �޸� �Ҵ�!
				news[i].setNo(Integer.parseInt(st.nextToken()));
				news[i].setTitle(st.nextToken());
				news[i].setContent(st.nextToken());
				news[i].setAuthor(st.nextToken());
				news[i].setPoster(st.nextToken());
				news[i].setLink(st.nextToken());
				i++;
			}
		}catch(Exception ex) {}
	}
	public NewsVO[] newsAllData()
	{
		return news;
	}
}
public class MovieMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieSystem ms=new MovieSystem();
		NewsVO[] news=ms.newsAllData();
		for(NewsVO vo:news)
		{
			System.out.println(vo.getNo()+":"+vo.getTitle());
		}
		//ArrayList list=new ArrayList();
		//ArrayList<String> list=new ArrayList<String>();  // ���׸���<> �ȳְ� ����ó�� �ᵵ ��
		/*
		 *    class Box<T>  // ���⼭ T�� �ӽ� ��������
		 *    {
		 *       T t;
		 *       public void setT(T t)
		 *       {
		 *          this.t=t;
		 *       }
		 *       public T getT()
		 *       {
		 *          return t;
		 *       }
		 *    }
		 *    
		 *    Box<String>
		 */
		
	}

}
