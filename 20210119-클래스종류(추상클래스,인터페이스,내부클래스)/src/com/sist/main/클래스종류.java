package com.sist.main;
/*
 *    Ŭ������ ����
 *    1) �Ϲ� Ŭ����
 *       ���������� class className{
 *          ===============
 *            ����(����,����)
 *          ===============
 *            �޼ҵ� (���)
 *          ===============
 *            ������
 *          ===============
 *       }
 *    2) �߻�Ŭ����(���ϻ��): �̿ϼ� Ŭ����(�޼ҵ常 ����) => �������� ����� �ִ� ���
 *       ���������� abstract class className{
 *          ===============
 *            ����(����,����)
 *          ===============
 *            ������ �޼ҵ�
 *          ===============
 *            ����� �޼ҵ� => �ݵ�� ��ӹ��� Ŭ������ �����ؼ� ���
 *            ��) �Դ´�(), �ȴ´�() ...
 *               ��ư Ŭ��, ���콺 Ŭ��
 *            �������̵�: ���α׷��� �°� �����ؼ� ���
 *          ===============
 *            ������
 *          ===============
 *       }
 *    ***3) �߻�Ŭ������ ���� => �������̽�(���߻��)
 *       ��, �ڵ���, �����
 *       class transformer implements ��,�ڵ���,�����
 *       ���������� interface interface��{
 *          ===============
 *           ����: ����� ����
 *          ===============
 *           ����� �޼ҵ�
 *          ===============
 *           ������ �޼ҵ� => JDK 1.8 �̻�
 *             default
 *             static
 *          ===============
 *       }
 *    4) ���� Ŭ����: ���������α׷�, ������, ��Ʈ��ũ
 *          = ���Ŭ����(��� �ȿ� ���Ŭ������ ��)
 *            class A
 *            {
 *               ========
 *                 ����
 *               ========
 *                 �޼ҵ�
 *               ========
 *                 ������
 *               ========  ==> �������� ���Ǵ� ����, �޼ҵ�
 *               class B   ==> AŬ������ ������ �ִ� ��� �޼ҵ�, ���� => ����� �����Ӵ�
 *               {
 *                  ========
 *                    ����
 *                  ========
 *                    �޼ҵ�
 *                  ========
 *                    ������
 *                  ========
 *               }
 *            }
 *            
 *          = �͸��� Ŭ����: ���(extends)���� �������̵��� �����ϴ� => ����ϸ� �ӵ��� ������
 *             class A
 *             {
 *                public void display(){}
 *             }
 *             class B extends A
 *             {
 *                public void display(){}
 *             }
 *             
 *             class A
 *             {
 *                public void display(){}
 *             }
 *             class B extends A
 *             {
 *                A a=new A(){
 *                   public void display(){}
 *                }
 *             }
 *          = ����Ŭ����: ���󵵰� ���� ����
 *            class A
 *            {
 *               public void display()
 *               {
 *                  class B
 *                  {
 *                  
 *                  }
 *               }
 *            }
 *    5) ���� Ŭ����: ����� �� �� ���� Ŭ����(���������θ� ����� ����) => ����
 *                 String, Math, System ... (������ ��� �״�� ���) Ȯ�� �Ұ�
 *       ���������� final class className{
 *          ===============
 *            ����
 *          ===============
 *            �޼ҵ�
 *          ===============
 *            ������
 *          ===============
 *        }       
 */
import javax.swing.*;
import javax.swing.table.*;
// extends JFrame => (JFrame�� ����) => ��ӹ��� ���븸 ����
public class Ŭ�������� extends JFrame{
	JTable table;
	DefaultTableModel model;
	public Ŭ��������()
	{
		String[] col= {"�̸�","�ּ�","��ȭ"};
		String[][] row=new String[0][3];
		model=new DefaultTableModel(row,col) {
			
			@Override
			public boolean isCellEditable(int row,int column) {
				// TODO Auto-generated method stub
				return false;
			}
			// �������̵�
			
		};
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		add("Center",js);
		String[] data= {"ȫ�浿","����","010-0000-0000"};
		model.addRow(data);
		setSize(450, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ŭ��������();
	}

}
