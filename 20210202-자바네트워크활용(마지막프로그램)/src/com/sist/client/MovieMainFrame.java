package com.sist.client;
// 윈도우
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *    오라클: 데이터를 수집해서 저장하는 장소
 *    자바: 오라클 연결 => 데이터를 브라우저에 전송
 *    자바스크립트: 브라우저에서 이벤트 처리(버튼, 검색, 애니메이션 ...)
 *    HTML: 화면 출력
 *          \n => <br>
 *    CSS: 화면 디자인(색, 위치... Layout)
 *    
 *    ==> JSP(3월 중순?)
 */
public class MovieMainFrame extends JFrame implements ActionListener {
	
		JMenuItem home=new JMenuItem("홈");
		JMenuItem rmovie=new JMenuItem("현재상영영화");
		JMenuItem smovie=new JMenuItem("개봉예정영화");
		
		JMenuItem wbox=new JMenuItem("주간");
		JMenuItem mbox=new JMenuItem("월간");
		JMenuItem ybox=new JMenuItem("연간");
		
		JMenuItem chat=new JMenuItem("채팅");
		
		CardLayout card=new CardLayout();
		MovieHomeForm mhf=new MovieHomeForm();
		ChatForm cf=new ChatForm();
	
	public MovieMainFrame()
	{
		setLayout(card);
		JMenuBar bar=new JMenuBar();
		JMenu menu1=new JMenu("홈");
		menu1.add(home);
		
		JMenu menu2=new JMenu("영화");
		menu2.add(rmovie);
		menu2.add(smovie);
		
		JMenu menu3=new JMenu("박스오피스");
		menu3.add(wbox);
		menu3.add(mbox);
		menu3.add(ybox);
		
		JMenu menu4=new JMenu("네트워크");
		menu4.add(chat);
		
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		
		// 윈도우에 추가
		setJMenuBar(bar);
		
		// 화면 추가
		add("HOME",mhf);  // 먼저 볼 화면이 위로 올라와 있어야 함
		add("CHAT",cf);
		
		setSize(1024, 768);
		setVisible(true);
		
		home.addActionListener(this);
		chat.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		
		new MovieMainFrame();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home)
		{
			card.show(getContentPane(), "HOME");  // 추가된 화면의 이름과 일치되어야 함
		}
		if(e.getSource()==chat)
		{
			card.show(getContentPane(), "CHAT");
		}
	}

}
