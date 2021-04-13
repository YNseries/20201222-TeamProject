package com.sist.io;
/*
 *    1|1|�ҿ�(2020)|8.6|�ִϸ��̼�/��Ÿ��|2021.01.20 |107��|��ü������|��Ʈ ����|���� �Ŀ���|//img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F71454256ae63506a7fee5e03cf929b9b65a4f433|1|���� ��� �������� �¾�� �Ǿ�����? ������ ���� �� ��ȥ���� �ӹ��� ���¾�� �� ������ �ִٸ�? ���忡�� ���� ���������� ���ϴ� �������� �޿� �׸��� �ְ��� ���� ���� Ŭ������ �����ϰ� �� �� ��, ����ġ ���� ���� ��ȥ�� �Ǿ� ���¾�� �� ���󡯿� ��������. ź�� �� ��ȥ���� ����� �Բ� �ڽ��� ���ɻ縦 �߰��ϸ� ���� �������� �߱��ϴ� ���¾�� �� ���� �������� �� ������ �����ϰ� ������ ���� �;����� �ʴ� �ô����� ��ȥ ��22���� ���䰡 �ȴ�. ����, ����, �׷��� ���൵ ����Ǳ� ������ ��ȥ ��22�� ���� ���뿡 ������ ��22���� ���� �������� �ʿ��� ������ �״� �ٽ� ������ ���ư� ���� ���뿡 �� �� ������?
 */
import java.io.*;
// ����ȭ => ObjectOutputStream
// ������ȭ => ObjectInputStream
import java.util.*;
class Sawon implements Serializable
{
	private int sabun;  //0
	private String name;
	private String dept;
	private String loc;
	transient private int pay;  // ������ ���ܽ�ų ��� transient ��� => 0 ���
	// getter setter
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	// constructor using field
	public Sawon(int sabun, String name, String dept, String loc, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.loc = loc;
		this.pay = pay;
	}
	
}
public class MainClass10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			ArrayList<Sawon> list=new ArrayList<Sawon>();
			list.add(new Sawon(1,"ȫ�浿","���ߺ�","����",3000));
			list.add(new Sawon(2,"��û��","�����","�λ�",3600));
			list.add(new Sawon(3,"�����","�ѹ���","���",3100));
			list.add(new Sawon(4,"������","��ȹ��","����",3200));
			list.add(new Sawon(5,"������","������","����",3800));
			
			// ���
			for(Sawon s:list)
			{
				System.out.println("�̸�:"+s.getName());
				System.out.println("�μ�:"+s.getDept());
				System.out.println("�ٹ���:"+s.getLoc());
				System.out.println("����:"+s.getPay());
				System.out.println("==========");
			}
			
			File file=new File("c:\\download\\sawon.txt");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			// ��ü ������ ���Ͽ� ����
			oos.writeObject(list);
			oos.close();
			System.out.println("���� �Ϸ�!!");
		}catch(Exception ex) {}
	}

}
