package com.sist.thread;
// 멀티쓰레드
import javax.swing.*;  // component(button...), container(윈도우)와 관련
import java.awt.*;     // color, image, layout
import java.awt.event.*;  // event(button click...) => 사건 => 정보수집
public class MainClass3 extends JFrame implements ActionListener{  // 제어를 위해
	                                 // ======================== 버튼처리
	JProgressBar[] bar=new JProgressBar[5];
	JButton b1,b2;
	
	BarThread[] bt=new BarThread[5];
	
	// 순위
	static int rank;  // rank 변수는 딱 하나 있어야 함 = static 쓰기 좋음
	
	// 초기화(객체 초기화(메모리할당) => 배치 => 윈도우크기 설정 => 윈도우 보여주기)
	public MainClass3()
	{
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(5, 1, 5,5));
		Color[] color={Color.cyan,Color.yellow,Color.pink,Color.orange,Color.magenta};
		for(int i=0;i<5;i++)
		{
			bar[i]=new JProgressBar();
			bar[i].setMinimum(0);
			bar[i].setMaximum(100);
			bar[i].setStringPainted(true);
			bar[i].setBackground(Color.white);
			bar[i].setForeground(color[i]);
			p.add(bar[i]);  // 배치
		}
		JPanel p2=new JPanel();
		p2.add(b1);p2.add(b2);
		
		// 윈도우 추가
		add("Center",p);
		add("South",p2);
		
		// 크기
		setSize(640, 350);
		setVisible(true);
		
		// 버튼 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass3();   // new => 새로운 윈도우!
	}
	// Progress Bar 동작 => 쓰레드(5개가 동작을 다르게 만든다)
	// 쓰레드가 프로그래스바를 공유 => 멤버클래스 이용
	class BarThread extends Thread  // 클래스 내의 클래스
	{
		// 프로그래스바 한 개만 작동하게 만든다
		int index;
		public BarThread(int index)
		{
			this.index=index;
		}
		// 동작을 구현
		public void run()
		{
			for(int i=0;i<=100;i++)
			{
				bar[index].setValue(i);
				int a=(int)(Math.random()*300);  // 일시정지하는 시간 random 발생
				try
				{
					Thread.sleep(a);
				}catch(Exception ex) {}
				
				if(i==100)
				{
					rank++;
					interrupt();   // 쓰레드 종료
				}
			}
			System.out.println((index+1)+"번째:"+rank+"등");
		}
	}
	// 클래스와 클래스끼리 데이터를 공유할 때 => (내부클래스/static)
	/*
	 *    내부 클래스
	 *    = 멤버 클래스: 데이터 공유(메모리 할당이 없는 상태에서) => 윈도우, 쓰레드, 네트워크(IP)
	 *                네트워크의 단점: 특히 서버(한 컴퓨터에서 두번 실행하면 오류 발생) 한 번만 실행하게 되어있음
	 *       public class A
	 *       {
	 *       	 윈도우
	 *           main()
	 *           {
	 *               A a=new A(); => 윈도우를 보여라
	 *           }
	 *           class MyThread extends Thread
	 *       	 {
	 *       
	 *       	 }
	 *       } 
	 *       
	 *    = 
	 *    = 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {   // 버튼처리
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			// 쓰레드 실행
			for(int i=0;i<5;i++)
			{
				bt[i]=new BarThread(i);
				bt[i].start();
			}
		}
		if(e.getSource()==b2)
		{
			// 쓰레드 종료
			System.exit(0);
		}
	}
	
}
