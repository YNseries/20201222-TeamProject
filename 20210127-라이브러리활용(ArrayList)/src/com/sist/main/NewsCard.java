package com.sist.main;
import java.awt.*;
import javax.swing.*;

import com.sist.news.NewsVO;

import java.net.*;
// JPanel ==> HTML  ==> <div>
public class NewsCard extends JPanel{
    JLabel poster=new JLabel();
    JLabel title=new JLabel();
    JTextPane tp=new JTextPane();
    JLabel author=new JLabel();
    
    public NewsCard()
    {
    	setLayout(null);
    	poster.setBounds(10,5, 300, 150);  // 포스터 출력 위치, 가로, 세로사이즈
    	add(poster);
    	title.setBounds(315, 5, 900, 35);
    	add(title);
    	JScrollPane js=new JScrollPane(tp);
    	js.setBounds(315, 45, 900, 120);
    	add(js);
    	author.setBounds(315, 170, 900, 35);
    	add(author);
    }
    /*
     *    for(NewsVO vo:list)
     *    {
     *        NewsCard c=new NewsCard();
     *        c.newsPrint(vo);
     *    }
     */
    public void newsPrint(NewsVO vo)   // 페이지 내에 나올 카드 하나를 만들어서 for문을 돌리는 것
    {
    	try
    	{
    		URL url=new URL(vo.getPoster());
    		ImageIcon ii=new ImageIcon(url);
    		Image img=getImage(ii, poster.getWidth(), poster.getHeight());  // 포스터 사이즈에 따라 바뀌는 게 아닌, 위에 설정한 값에 맞춤
    		poster.setIcon(new ImageIcon(img));  // 이미지가 올라갈 때 쓰는 형식
    		title.setText(vo.getTitle());   // 문자열1
    		tp.setText(vo.getContent());    // 문자열2
    		author.setText(vo.getAuthor()); // 문자열3
    	}catch(Exception ex) {}
    }
    public static Image getImage(ImageIcon ii,int w,int h)  // 화면에 이미지를 딱 맞게 해 주는 코드
    {
    	Image dimg = ii.getImage().getScaledInstance(w, h,
    	        Image.SCALE_SMOOTH);
    	return dimg;
    } 
}








