package com.sist.main;
/*
 *    1. Ŭ���� �����: �����ϴ� ���α׷� ====> import(���̺귯�� �����=> .jar) => ���(������ ����)
 *         = ����
 *           = �޸𸮸� ���� ����(new ���) == �ν��Ͻ� ����
 *           = �޸𸮸� �� ���� ��� == static ����
 *         = �޼ҵ� => ������(������ �����) / �Ű�����(����ڷκ��� ���۹��� ��)
 *                   => �⺻���������� ��Ƽ� �� ���� ��������(= Ŭ����)���� �����
 *                   1) ������
 *                      ������� ���� void
 *                      �Ϲݵ�����(int, double, char, boolean, long..)
 *                      Ŭ������ �Ѿ ���� �ִ�: �󼼺���
 *                      �迭�� �Ѿ ����..  ���������̴ϱ�!: ��� ���
 *                   2) �Ű�����
 *                      �⺻��������
 *                      Ŭ����, �迭
 *           = ������(�׻� ���� �������������� ������ ����)
 *               ���׿�����(++, --, !, (type))
 *               ���׿�����
 *                 ���(+, -, *, /, %): ����ȯ
 *               �񱳿�����(==, !=, <, >, <=, >=)
 *               ��������(&&, ||)
 *                      ������ �Ⱓ�� ����(&&), ������(||)
 *               ���Կ�����(=, +=, -=)
 *           = ���
 *             ���ǹ�(�������ǹ� if, �������ǹ� if~else, if~else if~else if~else)
 *             �ݺ���(while, for)
 *             �ݺ����(break)
 *             
 *    2. �����߻��� �����ϴ� ���α׷�: ����ó��
 *       �̸� �����ؼ� => ����
 *       = ���� ���� => try~catch
 *         try: ���� ������ �� �ִ� ����
 *         catch: ���α׷����� �Ǽ�, ������� �Ǽ�(������� �߸��� �Է�), ������ �Ϸ�
 *         finally(������ ����) => ����Ŭ, ��Ʈ��ũ, ���� => (����: close)
 *         => �ڵ����� ������ ó���� �ִ� ���� �ƴ� (����)
 *         => catch�� ����Ǵ� ����ó���� ��(������ ����� ����) => ����ó�� Ŭ������ ����
 *         => �� �𸥴� catch(Exception e)
 *         => ���� �޼��� Ȯ��
 *            = getMessage(): ����Ŭ ����(null) => ���� �޼����� �������. ��� ���� �������� ��. ������ �ǹ����� ������...
 *            = printStactTrace()   ** ������ => ��ġ���� : �ٵ� �ǹ�����x ���� ��Ծ�
 *         => try~catch�� �׻� �ҽ� ��ü�� ������� ���� �ʴ´�(������ ����Ǵ� �κ�)
 *       = ���� ȸ�� => throws  // ���� �ϴ� ��
 *       = ���� ��ȯ => ���� �߻��� �ٸ� ���ܸ� �߻��ؼ� ȭ�� ����(throw)
 *    3. ���̺귯�� Ȱ��
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *    �ʱ�ȭ => ó���� �ʿ��� ������ ���� ����
 *    ������ => �׳� �θ� 0 => page=1���� �����ϰڴ� �����ؾ� ��. �����ϴ� ��ġ�� ���� = �ʱ�ȭ
 *    ===========================
 *    class Movie{
 *       int page=1;   // ����� �ʱ�ȭ
 *    }
 *    
 *    class Login
 *    {
 *       String id,pwd;
 *       => cookie�� �����ߴ� ����� �� ����
 *       {
 *          ����
 *       }
 *       Login()
 *       {
 *          ����
 *       }
 *    }
 */
public class MainClass extends JFrame implements ActionListener{
	// JFrame: ������ => MainClass�� �������� ��� ����� ����� �� �ִ�(���)
	// ActionListener => Menu, Button, TextField(Enter)
	// ���� Ŭ����
	JTextField tf;  // �Է�â(�� �ٸ� �Է��� �� �Է�) => ���� ID, Password
	JTextArea ta;   // �Է�â(���� �� �Է�)
	JButton bu1,bu2;          // ========== �������� �ѹ��� �����ϴ� ����  
	// class �ȿ��� ����: �⺻��������, �迭, Ŭ����
	//                 ======== �� ���� ����
	// ���Ӱ��� ����
	int[] com={5,8,3};
	int[] user=new int[3];
	int s,b;  // ������� => �ʱ�ȭ�� �ȵ� ���¿����� 0������ �ʱ�ȭ
	public MainClass()  // ��������� ���� �ʱ�ȭ�� ���
	{
		tf=new JTextField(10);   // Ŭ������ �ʱ�ȭ => new
		tf.setEditable(false);   // �Է��ϴ� �� ��Ȱ��ȭ => ������ ������ �����ϰ� �ϱ� ����
		ta=new JTextArea();
		JScrollPane js=new JScrollPane(ta);  // ��ũ�ѹ� ScrollPane -> ���� ���� �� �� ����
		ta.setEnabled(false);  // ��Ȱ��ȭ => ��Ʈ�� ������ִ� ����
		bu1=new JButton("����");
		bu2=new JButton("����");
		// �����쿡 ��ġ
		JPanel p=new JPanel();
		p.add(tf);p.add(bu1);p.add(bu2);
		
		add("Center",js);
		add("South",p);

		// ������ ũ�� ����
		setSize(350, 500);
		setVisible(true);
		
		tf.addActionListener(this);  // ���ڸ� �Է��ϰ� enter�� ġ�� actionPerformed�� ȣ���ϵ��� ����
		bu1.addActionListener(this);
		bu2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass m=new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bu2)   // bu2 ��ư�� �����ٸ�, 
		{
			System.exit(0);   // ���α׷� ����
		}
		else if(e.getSource()==bu1)  // bu1 ��ư�� ������ 
		{
			JOptionPane.showMessageDialog(this, "������ �����մϴ�!!");   // ���� �޼��� �ȳ�
			bu1.setEnabled(false);  // ��Ȱ��ȭ
			tf.setEnabled(true);   // Ȱ��ȭ
			tf.requestFocus();      // focus Ŀ���� �����̰� ��
		}
		else if(e.getSource()==tf)
		{
			// �Է��� ���� ������ �´�(���� �� �׻� String���� �޾ƾ���. ������ ���� 80%�� String���� ���� ��)
			String strNum=tf.getText();  // �Է��� �� ������ �� �� ����
			if(strNum.length()<1)
			{
				String msg="���ڸ� ������ �Է��ϼ���";
				ta.append(msg+"\n");
			}
			
			// ���ڿ� => ������ȯ
			try
			{
				int num=Integer.parseInt(strNum);  // javac  =>  java
				// �� �길 ���� �������ͼ� try-catch �����
				/*
				 *    CheckException     UnCheckException
				 *    ==============     ================
				 *    ������ �� �˻�         ����ÿ� �˻�
				 *    = �ݵ�� ����ó��       = �ʿ信 ���� ����ó��
				 *    IO (�����)  ***
				 *    URL (��Ʈ��ũ)
				 *    SQL (�����ͺ��̽�)  ***  ����ó�� �ݵ�� ���� �־�� ��
				 *    Thread (������)
				 *    Ŭ���� ����
				 *    "123" " 123" ������ ����. ����!
				 *          " 123".trim() �ϸ� ���� ���� ����
				 */
			}catch(NumberFormatException ex)   // �ݵ�� ����ϴ� ���� �ƴ�. RuntimeException: ���� ����
			{
				String msg="������ �Է��� �����մϴ�!!";
				ta.append(msg+"\n");
				tf.setText("");
				tf.requestFocus();
				// ó������ �ٽ� ���ư��� (���󺹱� => catch���� �Է�)
				return;
			}
		}
	}

}
