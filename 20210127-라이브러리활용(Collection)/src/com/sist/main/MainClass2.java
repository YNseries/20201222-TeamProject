package com.sist.main;
import java.util.*;
class SawonVO
{
	private int sabun;
	private String name;
	private String dept; // �μ�
	private String job;  // ����
	private int pay;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	// ������ ����: Source -> Constructor using field
	public SawonVO(int sabun, String name, String dept, String job, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList sawonList=new ArrayList();
		sawonList.add(new SawonVO(1,"ȫ�浿","���ߺ�","�븮",3600));  // ������ �����θ�, �̷��� �� ���� �� �� ����
		sawonList.add(new SawonVO(2,"��û��","�ѹ���","����",4000));  // ������ �߰� add()
		sawonList.add(new SawonVO(3,"�����","������","����",3600));
		sawonList.add(new SawonVO(4,"�̼���","��ȹ��","���",3000));
		sawonList.add(new SawonVO(5,"������","�����","�̻�",7000));
		
		System.out.println("�� �ο�:"+sawonList.size());  // ����� ���� size()
		System.out.println("============ ��� ���� =============");
		/*
		 *    Object obj=new String()
		 *    ======
		 */
		for(int i=0;i<sawonList.size();i++)  // Object�� �ϸ� get set ����� �� ����
		{
			SawonVO vo=(SawonVO)sawonList.get(i);  // ������ ������ ���� �� ���� ������ SawonVO�� ����ȯ �ؾ���
			                                       // ����� ������ �б� get()
			System.out.println("���:"+vo.getSabun());
			System.out.println("�̸�:"+vo.getName());
			System.out.println("�μ�:"+vo.getDept());
			System.out.println("����:"+vo.getJob());
			System.out.println("����:"+vo.getPay());
			System.out.println("=====================================");
		}
		
		System.out.println("================ ���� ================");
		SawonVO vo1=new SawonVO(6, "������", "���ߺ�", "���", 3000);
		sawonList.set(3, vo1);  // ����� ������ ���� set()
		
		for(int i=0;i<sawonList.size();i++)
		{
			SawonVO vo=(SawonVO)sawonList.get(i);
			System.out.println("���:"+vo.getSabun());
			System.out.println("�̸�:"+vo.getName());
			System.out.println("�μ�:"+vo.getDept());
			System.out.println("����:"+vo.getJob());
			System.out.println("����:"+vo.getPay());
			System.out.println("=====================================");
		}
		
		System.out.println("================ ���� ================");
		sawonList.remove(2);  // ����� ������ ���� remove()
		
		for(int i=0;i<sawonList.size();i++)
		{
			SawonVO vo=(SawonVO)sawonList.get(i);
			System.out.println("���:"+vo.getSabun());
			System.out.println("�̸�:"+vo.getName());
			System.out.println("�μ�:"+vo.getDept());
			System.out.println("����:"+vo.getJob());
			System.out.println("����:"+vo.getPay());
			System.out.println("=====================================");
		}
		
		System.out.println("============= ��ü ���� =============");
		sawonList.clear();  // ��ü ���� clear()
		
		System.out.println("�ο�:"+sawonList.size());
		
		ArrayList a1=new ArrayList();
		//a1.add()
		ArrayList<String> a2=new ArrayList<String>();
		//a2.add()
		ArrayList<Integer> a3=new ArrayList<Integer>();
		//a3.add()
		ArrayList<SawonVO> a4=new ArrayList<SawonVO>();
		//a4.add()
	}

}
