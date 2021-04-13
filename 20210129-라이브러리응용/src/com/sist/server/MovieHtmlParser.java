package com.sist.server;
// �ӽ� ����(�����͸� �������� ����)
import java.util.*;  // ������ ���� => ArrayList ����

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;  // ���Ͽ� ���� =>
/*
 *    �ڹٿ��� �����ϴ� IO(Input, Output)
 *    Input : ����, �޸�, ��Ʈ��ũ���� ������ �б�
 *    Output: ����, �޸�, ��Ʈ��ũ ������ ����
 *                 ====
 *                 System.out
 *                 System.in
 *    ====================================
 *    InputStream, OutputStream => ����Ʈ ��Ʈ��(1byte�� �о�´�) => Upload, Download���� �ʿ�
 *    Reader, Writer => ���� ��Ʈ��(2byte�� �о�´�)
 *      *** �ѱ�(�� ���ڴ� => 2byte)
 */
public class MovieHtmlParser {
	// �� => �������� => �ְ� => ���� => ���� ==> ���� �ܾ�� ������, ������ �� ���� ���Ͽ� ����
	public void movieAllData()
	{
		/*
		 *    <div class="wrap_desc">
									<a href="/moviedb/main?movieId=135111"
			  
			  String s="Hello Java";
			  String ss=s.substring(0,5); => Hello
			  
			  s="Hello Java";
			  
			  int a=10;
			  int b=0;
			  if(b==0)
			  {
			      System.out.prinln("0���� ���� �� ����")
			  }
			  int c=a/b;  => ����
			  
			  ���� �߻� => if ���� => try
		 */
		StringBuffer sb=new StringBuffer();  // �޼ҵ� ��ü���� ����� �� �ְ� try �ۿ� �־�� ��
		// for�� �ȿ� try���� ������ �߻��ϸ� => �����ϰ� �ٽ� for���� ����
		// web����Ʈ => ��� ������ ������� �ʴ´�
		try
		{
			int mno=168;   // ��ȭ ���� ��ȣ
			int cno=5;   // ī�װ� ��ȣ
			//for(int i=1;i<=7;i++)
			{
				Document doc=Jsoup.connect("https://movie.daum.net/boxoffice/yearly").get();
			//  ======= ���� ����             �� �ڿ� .get() ������ �ȵ�
				// doc ���
				Elements link=doc.select("div.wrap_desc a.desc_movie");  
				for(int j=0;j<link.size();j++)
				{
					try
					{
					System.out.println(link.get(j).attr("href"));
					// doc2 �󼼺���
					Document doc2=Jsoup.connect("https://movie.daum.net"+link.get(j).attr("href")).get();
					// <span class="txt_name">�ҿ�(2020)</span>
					Element title=doc2.selectFirst("span.txt_name");  // �ϳ��� ����� �� selectFirst
					System.out.println(title.text());
					Element score=doc2.selectFirst("div.info_origin a");
					String s=score.text();
					// s.indexOf("��") => 1+2
					s=s.substring(s.indexOf("��")+3);  // ���� 07 . 8���� �տ� 3 ���� ����
					System.out.println(s.replace(" ",""));  // replace�� ���鹮�ڸ� ����
					String ss=s.replace(" ","");
					// trim()�� �¿� ���鸸 ���� �� ���� => �߰��� �ִ� ������ replace ����ؾ� ���� ����
					Element genre=doc2.selectFirst("dd.txt_main");
					System.out.println(genre.text());
					
					Element etc=doc2.select("dl.list_movie").get(1);
					s=etc.text();
					s=s.substring(s.indexOf("��")+2);  // ���� | ��ȭ�ð�/Ÿ��/���� ����
					String regdate=s.substring(0,s.indexOf(",")-5);  // , �տ��� 5������ ����
					System.out.println(regdate.replaceAll("[��-�R]", ""). /*�ѱ� ��ü ����*/
							replace("(","").replace(")", ""));  /*()��ȣ ����*/    // ������ ������ ��¸� �� ��
					regdate=regdate.replaceAll("[��-�R]", "").
							replace("(","").replace(")", "");   // regdate�� �����ؼ� �����Ϳ� ����
					String time=s.substring(0,s.indexOf(","));  // ,���� �ڸ�
					time=time.substring(time.lastIndexOf(" ")+1);  // �󿵽ð� �� ������� �ڸ��� ���� �������� ���
					// substring(int begin) => �ش� ��ġ
					// substring(int begin, int end) => end-1
					System.out.println(time);
					String grade=s.substring(s.lastIndexOf(",")+2);  // ,���� 2�� ����
					System.out.println(grade);
					// ���� | ��ȭ�ð�/Ÿ��/���� 1999.11.20 ���� 2020.12.23 (�簳��) 116��, ��ü������
					// ���� | ��ȭ�ð�/Ÿ��/���� 2021.01.07 ���� 105��, 15���̻������
					Element director=doc2.select("a.link_person").get(0);
					System.out.println(director.text());
					Element actor=doc2.select("a.link_person").get(1);
					System.out.println(actor.text());
					
					Element story=doc2.selectFirst("div.desc_movie p");
					System.out.println(story.text());
					
					Element poster=doc2.selectFirst("span.thumb_img img");
					System.out.println(poster.attr("src"));
					
					Element showUser=doc2.selectFirst("em.emph_g");
					System.out.println(showUser.text());
					
					String msg=mno+"|"+cno+"|"
							+title.text()+"|"
							+ss+"|"
							+genre.text()+"|"
							+regdate+"|"
							+time+"|"
							+grade+"|"
							+director.text()+"|"
							+actor.text()+"|"
							+poster.attr("src")+"|"
							+showUser.text()+"|"
							+story.text()+"\r\n";   // ��ȭ �ϳ��� ���� ����
					sb.append(msg); // ��ȭ �ϳ��� ������ ����
					mno++;
					}catch(Exception ex) {}  // for�� �ȿ��� try-catch�ϸ� �����ϰ� �����
					
					/*
					 *    <div class="aaa">
					 *       <a href="http://~">link</a>
					 *    </div>
					 *    
					 *    ��Ȳ�� ���� �ʿ��� �κ��� �޶�
					 *    HTML�� ������ �����ϴ� ������ 1. �±�, 2. �Ӽ�(attribute)
					 *    <span>aaa</span> ==> select("span") = aaa ==> ��������� text()��� ��
					 *    <a href="http://~">link</a> ==> ("a") ==> text() ����: link
					 *                                              attr("href") ����: http:/~
					 *    <div class="aaa">   ==> select("div.bbb span")
					 *       <span>aaa</span>
					 *    </div>
					 *    <div class="bbb">
					 *       <span>bbb</span>
					 *    </div>
					 *    <div class="ccc">
					 *       <span>ccc</span>
					 *    </div>
					 *    
					 *    <a> => link �ּ�
					 *    <img src="">
					 *    class => ȭ�� �����ο�. CSS�� ��
					 */
					
				}
			}
			FileWriter fw=new FileWriter("c:\\javaDev\\daum_movie.txt",true); 
			                            // true�� �־� ���Ŀ� ���� ����� ���� ��� ���Ŀ� �ٿ����� �� �ְ� �Ѵ�.
			fw.write(sb.toString());
			fw.close();
		}catch(Exception ex) {
			// ���� �޼��� ��� �� �ִ°� ����
			ex.printStackTrace();  // ���⿡�� �����ؼ� �ٽ� ó����
		}
		/*
		 *   ����ó��
		 *     CheckException: IO(���), ��Ʈ��ũ(����IP), Thread(�񵿱�ȭ => �浹), Web(URL => site)
		 *                     SQL(sql����)
		 *                     => ������ ������ �����ϴ� ���α׷�
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieHtmlParser m=new MovieHtmlParser();
		m.movieAllData();
	}

}
