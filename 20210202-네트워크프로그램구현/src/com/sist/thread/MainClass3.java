package com.sist.thread;
// ��Ƽ������
import javax.swing.*;  // component(button...), container(������)�� ����
import java.awt.*;     // color, image, layout
import java.awt.event.*;  // event(button click...) => ��� => ��������
public class MainClass3 extends JFrame implements ActionListener{  // ��� ����
	                                 // ======================== ��ưó��
	JProgressBar[] bar=new JProgressBar[5];
	JButton b1,b2;
	
	BarThread[] bt=new BarThread[5];
	
	// ����
	static int rank;  // rank ������ �� �ϳ� �־�� �� = static ���� ����
	
	// �ʱ�ȭ(��ü �ʱ�ȭ(�޸��Ҵ�) => ��ġ => ������ũ�� ���� => ������ �����ֱ�)
	public MainClass3()
	{
		b1=new JButton("����");
		b2=new JButton("����");
		
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
			p.add(bar[i]);  // ��ġ
		}
		JPanel p2=new JPanel();
		p2.add(b1);p2.add(b2);
		
		// ������ �߰�
		add("Center",p);
		add("South",p2);
		
		// ũ��
		setSize(640, 350);
		setVisible(true);
		
		// ��ư ���
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass3();   // new => ���ο� ������!
	}
	// Progress Bar ���� => ������(5���� ������ �ٸ��� �����)
	// �����尡 ���α׷����ٸ� ���� => ���Ŭ���� �̿�
	class BarThread extends Thread  // Ŭ���� ���� Ŭ����
	{
		// ���α׷����� �� ���� �۵��ϰ� �����
		int index;
		public BarThread(int index)
		{
			this.index=index;
		}
		// ������ ����
		public void run()
		{
			for(int i=0;i<=100;i++)
			{
				bar[index].setValue(i);
				int a=(int)(Math.random()*300);  // �Ͻ������ϴ� �ð� random �߻�
				try
				{
					Thread.sleep(a);
				}catch(Exception ex) {}
				
				if(i==100)
				{
					rank++;
					interrupt();   // ������ ����
				}
			}
			System.out.println((index+1)+"��°:"+rank+"��");
		}
	}
	// Ŭ������ Ŭ�������� �����͸� ������ �� => (����Ŭ����/static)
	/*
	 *    ���� Ŭ����
	 *    = ��� Ŭ����: ������ ����(�޸� �Ҵ��� ���� ���¿���) => ������, ������, ��Ʈ��ũ(IP)
	 *                ��Ʈ��ũ�� ����: Ư�� ����(�� ��ǻ�Ϳ��� �ι� �����ϸ� ���� �߻�) �� ���� �����ϰ� �Ǿ�����
	 *       public class A
	 *       {
	 *       	 ������
	 *           main()
	 *           {
	 *               A a=new A(); => �����츦 ������
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
	public void actionPerformed(ActionEvent e) {   // ��ưó��
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			// ������ ����
			for(int i=0;i<5;i++)
			{
				bt[i]=new BarThread(i);
				bt[i].start();
			}
		}
		if(e.getSource()==b2)
		{
			// ������ ����
			System.exit(0);
		}
	}
	
}
