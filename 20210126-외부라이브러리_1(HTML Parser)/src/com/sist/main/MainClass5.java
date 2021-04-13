package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// for(int i=1;i<=4,i++)
			{
				Document doc=Jsoup.connect("https://www.mangoplate.com/top_lists/1420_hotel_restaurant").get();
				Elements title=doc.select("h3");
				Elements addr=doc.select("p.etc");
				
				for(int i=0;i<title.size();i++)
				{
					System.out.println(title.get(i).text());
					System.out.println(addr.get(i).text());
					System.out.println("====================================================");
				}
			}
			
		}catch(Exception ex) {}

	}

}
