package com.sist.thread;
// �̱۾�����
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainClass2 extends JFrame implements Runnable{ // implements => �����ؾ� �ϴ� �޼ҵ� ���;� ��
	/*JProgressBar bar1=new JProgressBar();
	JProgressBar bar2=new JProgressBar();
	JProgressBar bar3=new JProgressBar();
	JProgressBar bar4=new JProgressBar();
	JProgressBar bar5=new JProgressBar();*/
	JProgressBar[] bar=new JProgressBar[5];
	
	JButton b1,b2;
	// �ʱ�ȭ => ������(�ʱ�ȭ ��) => ������ static�� ��
	public MainClass2()
	{
		b1=new JButton("����");
		b2=new JButton("����");
		// progressBar: �������� �ʿ�
		Color[] color={Color.yellow,Color.pink,Color.cyan,Color.orange,Color.green};
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(5, 1, 5,5));  // ����5 ����1 ����5,5
		for(int i=0;i<5;i++)
		{
			bar[i]=new JProgressBar();
			bar[i].setMaximum(100);
			bar[i].setMinimum(0);   // �޼ҵ� ���� = ����
			bar[i].setBackground(Color.white);
			bar[i].setForeground(color[i]);
			bar[i].setStringPainted(true);  // 0%
			p.add(bar[i]);
		}
		
		JPanel p1=new JPanel();
		p1.add(b1);
		p1.add(b2);
		
		add("Center",p);
		add("South",p1);
		
		// ������ ũ�� ����
		setSize(450,300);
		setVisible(true);
		new Thread(this).start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass2();
	}
	public void go()
	{
		try
		{
			int a=(int)(Math.random()*101);   // 0~100
			for(int i=0;i<=a;i++)
			{
				bar[0].setValue(i);
				Thread.sleep(50);
			}
			a=(int)(Math.random()*101);   // 0~100
			for(int i=0;i<=a;i++)
			{
				bar[1].setValue(i);
				Thread.sleep(50);
			}
			a=(int)(Math.random()*101);   // 0~100
			for(int i=0;i<=a;i++)
			{
				bar[2].setValue(i);
				Thread.sleep(50);
			}
			a=(int)(Math.random()*101);   // 0~100
			for(int i=0;i<=a;i++)
			{
				bar[3].setValue(i);
				Thread.sleep(50);
			}
			a=(int)(Math.random()*101);   // 0~100
			for(int i=0;i<=a;i++)
			{
				bar[4].setValue(i);
				Thread.sleep(50);
			}
		}catch(Exception ex) {}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		go();
	}

}
