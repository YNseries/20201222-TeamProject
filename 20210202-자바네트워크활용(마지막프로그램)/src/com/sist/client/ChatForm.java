package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class ChatForm extends JPanel{
	JTextPane pane;
	JComboBox box;
	JTextField tf;
	JTable table;    // ���̺� ���
	DefaultTableModel model;   // ������ �߰��� ��
	JButton b1,b2;
	public ChatForm()
	{
		pane=new JTextPane();
		JScrollPane js=new JScrollPane(pane);
		box=new JComboBox();
		box.addItem("black");
		box.addItem("cyan");
		box.addItem("green");
		box.addItem("yellow");
		box.addItem("blue");
		tf=new JTextField();
		
		String[] col= {"ID","��ȭ��","����"};
		String[][] row=new String[0][3];  // �� �ٿ� �����͸� 3�� �Է�
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js2=new JScrollPane(table);
		
		b1=new JButton("����������");
		b2=new JButton("�����");   // ������(�ζǿ)
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,1,5,5));
		p.add(b1);
		p.add(b2);
		
		// ��ġ
		setLayout(null);
		
		// ����ڰ� ���� ä��
		js.setBounds(15, 20, 650, 550);
		tf.setBounds(15, 575, 550, 30);
		box.setBounds(570, 575, 95, 30);
		
		js.setBounds(670, 20, 330, 500);
		
		p.setBounds(670, 525, 330, 80);
		add(js);
		add(tf);add(box);
		add(js2);
		add(p);
	}
}
