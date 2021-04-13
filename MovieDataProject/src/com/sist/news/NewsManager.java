package com.sist.news;
// http://newssearch.naver.com/search.naver?where=rss&query=영화
import java.util.*;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Unmarshaller;

import java.net.*;
/*
 *    XML, JSON, CSV => 읽어 온다
 *    기본 => 오라클
 *    
 *    XML: 스프링은 XML기반(어노테이션)
 */
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class NewsManager {
	public static void main(String[] args) {
		NewsManager m=new NewsManager();
		m.newsListData();
	}
	public List<Item> newsListData()
	{
		List<Item> list=new ArrayList<Item>();
		try
		{
			String fd="영화";
			String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
					+ URLEncoder.encode(fd,"UTF-8");
			/*JAXBContext jb=JAXBContext.newInstance(Rss.class);
			Unmarshaller un=jb.createUnmarshaller();
			Rss rss=(Rss)un.unmarshal(new URL(strUrl));*/
			/*
			 *    Unmarshaller(XML => 클래스화)
			 *    Marsharller (클래스 => XML)
			 */
			// 직접 파싱해서 작업
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(strUrl);
			//System.out.println(doc);
			Element root=doc.getDocumentElement();   // 전체 태그 (rss)
			System.out.println(root.getTagName());
			Element channel=(Element)root.getElementsByTagName("channel").item(0);
			System.out.println(channel.getTagName());  // channel
			
			NodeList nList=channel.getElementsByTagName("item");
			for(int i=2;i<50;i++)
			{
				nList=channel.getElementsByTagName("title");
				String title=nList.item(i).getFirstChild().getNodeValue();
				
				nList=channel.getElementsByTagName("description");
				String description=nList.item(i).getFirstChild().getNodeValue();
				
				nList=channel.getElementsByTagName("link");
				String link=nList.item(i).getFirstChild().getNodeValue();
				
				nList=channel.getElementsByTagName("author");
				String author=nList.item(i).getFirstChild().getNodeValue();
				//System.out.println(title);
				
				Item item=new Item();
				item.setTitle(title);
				item.setDescription(description);
				item.setLink(link);
				item.setAuthor(author);
				list.add(item);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
