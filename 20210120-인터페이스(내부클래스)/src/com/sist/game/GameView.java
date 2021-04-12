package com.sist.game;
import javax.swing.*;
import java.awt.*;
/*
 *    / => //
 *    " => /"
 *    
 *    JFrame 
 *    JPanel
 *    JWindow
 *    JDialog
 */
public class GameView {
	Image back,avata;  // 인스턴스. 윈도우창 여러개 뜰 수 있기 때문에 따로따로 작동해야 해
	// 초기값 => 구현되어야 함: 초기화 블럭 or 생성자 => 보통 생성자 많이 씀
	int x=100, y=300;
	public GameView()
	{
		back=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\back.jpg");   // class명.static메소드.
		avata=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\player\\my_00.png");
	}
	public void setImage()
	{
		for(int i=0;i<9;i++)
		{
			avata=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\player\\my_0"+i+".png");
			
			try
			{
				Thread.sleep(100);
			}catch(Exception e) {}
			repaint();
		}
	}
		@Override
		public void paint(Graphics g) {
			g.drawImage(back,0,0,getWidth(),getHeight(),this);
			g.drawImage(avata,x,y,this);
		}
	public void start()
	{
		AvataMove a=new AvataMove();
		a.start();
	}
	
	// 윈도우 그림을 그린다  // 이너클래스 => 내가 필요한 것을 호출할 수 있는 장점. 그 외엔 등장 x
	class AvataMove extends Thread
	{
		public void run()
		{
			setImage();   // 총 쏘는 것까지의 이미지
			avata=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\player\\my_00.png");
			repaint();
		}
	}
	
}
