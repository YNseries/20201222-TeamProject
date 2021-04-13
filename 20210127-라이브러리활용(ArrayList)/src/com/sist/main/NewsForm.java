package com.sist.main;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.sist.news.*;  // 다른 폴더에 newsListData가 있기 때문에 import 해 줘야 함

public class NewsForm extends JPanel implements ActionListener{
   JButton b1,b2;
   JLabel la;
   int curpage=1;
   int totalpage=0;
   JPanel p=new JPanel();
   NewsManager mgr=new NewsManager();
   public NewsForm()
   {
	   setLayout(new BorderLayout());
	   
	   
   	   //p.setLayout(null);
   	   JScrollPane pp=new JScrollPane();
   	   Dimension size = new Dimension();
   	   size.setSize(1000, 1000);
   	   p.setPreferredSize(size);
   	   pp.setViewportView(p);
	   
	   p.setLayout(new GridLayout(5, 1));
	   
	   ArrayList list=mgr.newsListData(curpage);  // 1page에 나와있는
	   for(int i=0;i<list.size();i++)
	   {
		   NewsVO vo=(NewsVO)list.get(i);
		   NewsCard nc=new NewsCard();
		   nc.newsPrint(vo);   // vo에 들어가는 이미지가 다 달라짐
		   p.add(nc);
	   }
	   
	   add("Center",pp);
	   b1=new JButton("이전");
	   b2=new JButton("다음");
	   totalpage=mgr.newsTotalPage();
	   la=new JLabel(curpage+" page / "+totalpage+" pages");
	   JPanel ppp=new JPanel();
	   ppp.add(b1); ppp.add(la); ppp.add(b2);
	   add("South",ppp);
	   
	   b1.addActionListener(this);
	   b2.addActionListener(this);
	   
   }
	@Override
	public void actionPerformed(ActionEvent e) {   // 버튼 눌렀을 때 처리하는 곳
		// TODO Auto-generated method stub
		if(e.getSource()==b1)   // 누름 버튼이 b1(이전)이면,
		{
			if(curpage>1)
			{
				curpage--;      // 페이지 감소
				p.removeAll();  // 지우고
				ArrayList list=mgr.newsListData(curpage);  // 새로운 페이지 출력
				   for(int i=0;i<list.size();i++)
				   {
					   NewsVO vo=(NewsVO)list.get(i);
					   NewsCard nc=new NewsCard();
					   nc.newsPrint(vo);   // vo에 들어가는 이미지가 다 달라짐
					   p.add(nc);
				   }
				   p.validate();  // 다시 패널에 출력하라
				   la.setText(curpage+" page / "+totalpage+" pages");
			}
		}
		if(e.getSource()==b2)   // 누름 버튼이 b2(다음)면,
		{
			if(curpage<totalpage)
			{
				curpage++;      // 페이지 증가
				p.removeAll();  // 지우고
				ArrayList list=mgr.newsListData(curpage);  // 새로운 페이지 출력
				   for(int i=0;i<list.size();i++)
				   {
					   NewsVO vo=(NewsVO)list.get(i);
					   NewsCard nc=new NewsCard();
					   nc.newsPrint(vo);   // vo에 들어가는 이미지가 다 달라짐
					   p.add(nc);
				   }
				   p.validate();  // 다시 패널에 출력하라
				   la.setText(curpage+" page / "+totalpage+" pages");  // 페이지 증가할 때 표시되는 페이지도 증가
			}
		}

	}
	
}
