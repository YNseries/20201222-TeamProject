package com.sist.server;
// ÀÓ½Ã ÆÄÀÏ(µ¥ÀÌÅÍ¸¦ °¡Á®¿À±â À§ÇÔ)
import java.util.*;  // µ¥ÀÌÅÍ ¼öÁý => ArrayList ÀúÀå

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;  // ÆÄÀÏ¿¡ ÀúÀå =>
/*
 *    ÀÚ¹Ù¿¡¼­ Á¦°øÇÏ´Â IO(Input, Output)
 *    Input : ÆÄÀÏ, ¸Þ¸ð¸®, ³×Æ®¿öÅ©¿¡¼­ µ¥ÀÌÅÍ ÀÐ±â
 *    Output: ÆÄÀÏ, ¸Þ¸ð¸®, ³×Æ®¿öÅ© µ¥ÀÌÅÍ Àü¼Û
 *                 ====
 *                 System.out
 *                 System.in
 *    ====================================
 *    InputStream, OutputStream => ¹ÙÀÌÆ® ½ºÆ®¸²(1byte¾¿ ÀÐ¾î¿Â´Ù) => Upload, Download¿¡¼­ ÇÊ¿ä
 *    Reader, Writer => ¹®ÀÚ ½ºÆ®¸²(2byte¾¿ ÀÐ¾î¿Â´Ù)
 *      *** ÇÑ±Û(ÇÑ ±ÛÀÚ´ç => 2byte)
 */
public class MovieHtmlParser {
	// »ó¿µ => °³ºÀ¿¹Á¤ => ÁÖ°£ => ¿ù°£ => ¿¬°£ ==> µû·Î ±Ü¾î¿Ã °ÅÁö¸¸, ÀúÀåÀº ÇÑ °³ÀÇ ÆÄÀÏ¿¡ ÀúÀå
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
			      System.out.prinln("0À¸·Î ³ª´­ ¼ö ¾ø´Ù")
			  }
			  int c=a/b;  => Á¾·á
			  
			  ¿À·ù ¹ß»ý => if ¿¹»ó => try
		 */
		StringBuffer sb=new StringBuffer();  // ¸Þ¼Òµå ÀüÃ¼¿¡¼­ »ç¿ëÇÒ ¼ö ÀÖ°Ô try ¹Û¿¡ ÀÖ¾î¾ß ÇÔ
		// for¹® ¾È¿¡ try¿¡¼­ ¿À·ù°¡ ¹ß»ýÇÏ¸é => Á¦¿ÜÇÏ°í ´Ù½Ã for¹®À» ¼öÇà
		// web»çÀÌÆ® => ¸ðµç Á¤º¸¸¦ Ãâ·ÂÇÏÁö ¾Ê´Â´Ù
		try
		{
			int mno=168;   // ¿µÈ­ °íÀ¯ ¹øÈ£
			int cno=5;   // Ä«Å×°í¸® ¹øÈ£
			//for(int i=1;i<=7;i++)
			{
				Document doc=Jsoup.connect("https://movie.daum.net/boxoffice/yearly").get();
			//  ======= ¹®¼­ ÀúÀå             ¸Ç µÚ¿¡ .get() ÀØÀ¸¸é ¾ÈµÊ
				// doc ¸ñ·Ï
				Elements link=doc.select("div.wrap_desc a.desc_movie");  
				for(int j=0;j<link.size();j++)
				{
					try
					{
					System.out.println(link.get(j).attr("href"));
					// doc2 »ó¼¼º¸±â
					Document doc2=Jsoup.connect("https://movie.daum.net"+link.get(j).attr("href")).get();
					// <span class="txt_name">¼Ò¿ï(2020)</span>
					Element title=doc2.selectFirst("span.txt_name");  // ÇÏ³ª¸¸ °®°í¿Ã ¶§ selectFirst
					System.out.println(title.text());
					Element score=doc2.selectFirst("div.info_origin a");
					String s=score.text();
					// s.indexOf("Á¡") => 1+2
					s=s.substring(s.indexOf("Á¡")+3);  // ÆòÁ¡ 07 . 8¿¡¼­ ¾Õ¿¡ 3 ±ÛÀÚ Á¦¿Ü
					System.out.println(s.replace(" ",""));  // replace·Î °ø¹é¹®ÀÚ¸¦ ¾ø¾Ú
					String ss=s.replace(" ","");
					// trim()Àº ÁÂ¿ì °ø¹é¸¸ Áö¿ï ¼ö ÀÖÀ½ => Áß°£¿¡ ÀÖ´Â °ø¹éÀº replace »ç¿ëÇØ¾ß Á¦°Å °¡´É
					Element genre=doc2.selectFirst("dd.txt_main");
					System.out.println(genre.text());
					
					Element etc=doc2.select("dl.list_movie").get(1);
					s=etc.text();
					s=s.substring(s.indexOf("¶ó")+2);  // °³ºÀ | ¿µÈ­½Ã°£/Å¸ÀÔ/³ª¶ó Á¦°Å
					String regdate=s.substring(0,s.indexOf(",")-5);  // , ¾Õ¿¡¼­ 5°³±îÁö Á¦°Å
					System.out.println(regdate.replaceAll("[°¡-ÆR]", ""). /*ÇÑ±Û ÀüÃ¼ Á¦°Å*/
							replace("(","").replace(")", ""));  /*()°ýÈ£ Á¦°Å*/    // ¼³Á¤ÇÑ ³»¿ëÀ» Ãâ·Â¸¸ ÇÑ °Í
					regdate=regdate.replaceAll("[°¡-ÆR]", "").
							replace("(","").replace(")", "");   // regdate¸¦ ¼³Á¤ÇØ¼­ µ¥ÀÌÅÍ¿¡ ÀúÀå
					String time=s.substring(0,s.indexOf(","));  // ,±îÁö ÀÚ¸§
					time=time.substring(time.lastIndexOf(" ")+1);  // »ó¿µ½Ã°£ ¾Õ °ø¹éºÎÅÍ ÀÚ¸£°í °ø¹é ´ÙÀ½ºÎÅÍ Ãâ·Â
					// substring(int begin) => ÇØ´ç À§Ä¡
					// substring(int begin, int end) => end-1
					System.out.println(time);
					String grade=s.substring(s.lastIndexOf(",")+2);  // ,ºÎÅÍ 2°³ Á¦°Å
					System.out.println(grade);
					// °³ºÀ | ¿µÈ­½Ã°£/Å¸ÀÔ/³ª¶ó 1999.11.20 °³ºÀ 2020.12.23 (Àç°³ºÀ) 116ºÐ, ÀüÃ¼°ü¶÷°¡
					// °³ºÀ | ¿µÈ­½Ã°£/Å¸ÀÔ/³ª¶ó 2021.01.07 °³ºÀ 105ºÐ, 15¼¼ÀÌ»ó°ü¶÷°¡
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
							+story.text()+"\r\n";   // ¿µÈ­ ÇÏ³ª¿¡ ´ëÇÑ Á¤º¸
					sb.append(msg); // ¿µÈ­ ÇÏ³ªÀÇ Á¤º¸¸¦ ÀúÀå
					mno++;
					}catch(Exception ex) {}  // for¹® ¾È¿¡¼­ try-catchÇÏ¸é Á¦¿ÜÇÏ°í ÁøÇàµÊ
					
					/*
					 *    <div class="aaa">
					 *       <a href="http://~">link</a>
					 *    </div>
					 *    
					 *    »óÈ²¿¡ µû¶ó ÇÊ¿äÇÑ ºÎºÐÀÌ ´Þ¶ó
					 *    HTMLÀº µ¥ÀÌÅÍ ÀúÀåÇÏ´Â °ø°£ÀÌ 1. ÅÂ±×, 2. ¼Ó¼º(attribute)
					 *    <span>aaa</span> ==> select("span") = aaa ==> °®°í¿À·Á¸é text()½á¾ß ÇÔ
					 *    <a href="http://~">link</a> ==> ("a") ==> text() ¾²¸é: link
					 *                                              attr("href") ¾²¸é: http:/~
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
					 *    <a> => link ÁÖ¼Ò
					 *    <img src="">
					 *    class => È­¸é µðÀÚÀÎ¿ë. CSSÇÒ ¶§
					 */
					
				}
			}
			FileWriter fw=new FileWriter("c:\\javaDev\\daum_movie.txt",true); 
			                            // true¸¦ ³Ö¾î ÀÌÈÄ¿¡ »ý±æ ¸ñ·ÏÀ» ÀÌÀü ¸ñ·Ï ÀÌÈÄ¿¡ ºÙ¿©³ÖÀ» ¼ö ÀÖ°Ô ÇÑ´Ù.
			fw.write(sb.toString());
			fw.close();
		}catch(Exception ex) {
			// ¿¡·¯ ¸Þ¼¼Áö Ãâ·Â ÇØ ÁÖ´Â°Ô ÁÁÀ½
			ex.printStackTrace();  // ¿©±â¿¡¼­ º¹±¸ÇØ¼­ ´Ù½Ã Ã³¸®ÇÔ
		}
		/*
		 *   ¿¹¿ÜÃ³¸®
		 *     CheckException: IO(°æ·Î), ³×Æ®¿öÅ©(¼­¹öIP), Thread(ºñµ¿±âÈ­ => Ãæµ¹), Web(URL => site)
		 *                     SQL(sql¹®Àå)
		 *                     => »çÀü¿¡ ¿À·ù¸¦ ¹æÁöÇÏ´Â ÇÁ·Î±×·¥
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieHtmlParser m=new MovieHtmlParser();
		m.movieAllData();
	}

}
