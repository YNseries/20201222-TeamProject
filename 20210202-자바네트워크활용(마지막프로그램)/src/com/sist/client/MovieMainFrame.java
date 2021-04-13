package com.sist.client;
// ������
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *    ����Ŭ: �����͸� �����ؼ� �����ϴ� ���
 *    �ڹ�: ����Ŭ ���� => �����͸� �������� ����
 *    �ڹٽ�ũ��Ʈ: ���������� �̺�Ʈ ó��(��ư, �˻�, �ִϸ��̼� ...)
 *    HTML: ȭ�� ���
 *          \n => <br>
 *    CSS: ȭ�� ������(��, ��ġ... Layout)
 *    
 *    ==> JSP(3�� �߼�?)
 */
public class MovieMainFrame extends JFrame implements ActionListener {
	
		JMenuItem home=new JMenuItem("Ȩ");
		JMenuItem rmovie=new JMenuItem("����󿵿�ȭ");
		JMenuItem smovie=new JMenuItem("����������ȭ");
		
		JMenuItem wbox=new JMenuItem("�ְ�");
		JMenuItem mbox=new JMenuItem("����");
		JMenuItem ybox=new JMenuItem("����");
		
		JMenuItem chat=new JMenuItem("ä��");
		
		CardLayout card=new CardLayout();
		MovieHomeForm mhf=new MovieHomeForm();
		ChatForm cf=new ChatForm();
	
	public MovieMainFrame()
	{
		setLayout(card);
		JMenuBar bar=new JMenuBar();
		JMenu menu1=new JMenu("Ȩ");
		menu1.add(home);
		
		JMenu menu2=new JMenu("��ȭ");
		menu2.add(rmovie);
		menu2.add(smovie);
		
		JMenu menu3=new JMenu("�ڽ����ǽ�");
		menu3.add(wbox);
		menu3.add(mbox);
		menu3.add(ybox);
		
		JMenu menu4=new JMenu("��Ʈ��ũ");
		menu4.add(chat);
		
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		
		// �����쿡 �߰�
		setJMenuBar(bar);
		
		// ȭ�� �߰�
		add("HOME",mhf);  // ���� �� ȭ���� ���� �ö�� �־�� ��
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
			card.show(getContentPane(), "HOME");  // �߰��� ȭ���� �̸��� ��ġ�Ǿ�� ��
		}
		if(e.getSource()==chat)
		{
			card.show(getContentPane(), "CHAT");
		}
	}

}
