package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class ChatForm extends JPanel{
	JTextPane pane;
	JComboBox box;
	JTextField tf;
	JTable table;    // 테이블 모양
	DefaultTableModel model;   // 데이터 추가할 때
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
		
		String[] col= {"ID","대화명","성별"};
		String[][] row=new String[0][3];  // 한 줄에 데이터를 3개 입력
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js2=new JScrollPane(table);
		
		b1=new JButton("쪽지보내기");
		b2=new JButton("운세보기");   // 쓰레드(로또운세)
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,1,5,5));
		p.add(b1);
		p.add(b2);
		
		// 배치
		setLayout(null);
		
		// 사용자가 직접 채지
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
