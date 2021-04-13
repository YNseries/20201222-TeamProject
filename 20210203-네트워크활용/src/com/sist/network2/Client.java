package com.sist.network2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// ��Ʈ��ũ ����
import java.net.*;  // Socket => ����(Server)
import java.io.*;  // ������ ������(OutputStream), �����κ��� �ޱ�(BufferedReader)
public class Client extends JFrame implements ActionListener,Runnable{
	JTextField tf; // ä�� �Է�
	JTextArea ta;  // ä�� ���
	JButton b1,b2; // ����, ����
	
	// ��Ʈ��ũ ���� Ŭ����
	Socket s;
	OutputStream out;
	BufferedReader in;
	String name;
	JScrollBar bar;
	/*
	 *    1. ������ ����: ���ӹ�ư
	 *    2. ä�� ���ڿ��� ������: JTextField => Enter�ÿ� ������ ����
	 *    3. �����κ��� ä�ù��ڿ��� �޾Ƽ� ��� => �ǽð�(������) => ���� ����
	 *       ============== Output, Input
	 *                      ======  =====
	 *                        �۽�     ����  ==> �۽�/����(������� �� �� ����)
	 */
	// �ʱ�ȭ
	public Client()
	{
		tf=new JTextField(20);
		tf.setEnabled(false); // ���� ���� ���� �� �� �� �ְ� �Ϸ��� ��Ȱ��ȭ
		b1=new JButton("����");
		b2=new JButton("����");
		ta=new JTextArea();  // ��ũ���� ���� ���� ������ �����
		ta.setEditable(false);  // ���� �� �ִ� ������ �� �� �� �ִ� �� ��Ȱ��ȭ
		JScrollPane js=new JScrollPane(ta);  // Vertical, Horizontal
		bar=js.getVerticalScrollBar();
		// ��ġ
		add("Center",js);
		JPanel p=new JPanel();
		p.add(tf);p.add(b1);p.add(b2);
		add("South",p);
		
		// ������ ũ��
		setSize(400,450);
		setVisible(true);
		
		// ��ư�� ������ actionPerformed�� ȣ��(eventó��: ���)
		b1.addActionListener(this);
		// Client�� ������ �ִ� actionPerformed(ActionEvent e) ȣ��
		// ====== Client�� �ڽ�: this
		b2.addActionListener(this);
		tf.addActionListener(this);
		/*
		 *   ActionListener => actionPerformed(ActionEvent e)
		 *   ==============
		 *     button ����(JButton, JRadioButton)
		 *     textField => Enter
		 *     menuItem
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������
		new Client();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			System.exit(0);  // ���α׷� ����
		}
		else if(e.getSource()==b1)  // ����
		{
			name=JOptionPane.showInputDialog("��ȭ�� �Է�:");  // [ȫ�浿] Hi
			// ����
			try
			{
				s=new Socket("localhost",3355);
				// �����κ��� �о���� ��ġ Ȯ�� => in
				in=new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
				// ������ ���� ������ ��ġ Ȯ�� => out
				out=s.getOutputStream();
			}catch(Exception ex) {ex.printStackTrace();}
			
			// ������ �Ǹ� => ����� �����ض�
			new Thread(this).start();
			tf.setEnabled(true);  // ������ �Ǹ�, Ȱ��ȭ
			tf.requestFocus();  // Ŀ�� ������
			b1.setEnabled(false);  // ���ӹ�ư ��Ȱ��ȭ
		}
		else if(e.getSource()==tf)  // ���ڸ� �Է��ϰ� Enter������ => �Է��� ���� �о ������ ����
		{
			try
			{
				// �Էµ� ���ڿ��� �о� �´�
				String msg=tf.getText();
				if(msg.length()<1)
					return;
				// ������ ����
				out.write(("["+name+"] "+msg+"\n").getBytes());
				tf.setText("");
			}catch(Exception ex) {ex.printStackTrace();}
		}
	}
	// �����κ��� ������ �����͸� (�ǽð�����)�о JTextArea�� ����ϴ� ����
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				String msg=in.readLine();
				ta.append(msg+"\n");
				bar.setValue(bar.getMaximum());
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}

}
