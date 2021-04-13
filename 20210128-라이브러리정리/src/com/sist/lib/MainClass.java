package com.sist.lib;
/*
 *     java.lang
 *       Object
 *        = clone(): ����
 *        = toString(): ���ڿ� ��ȯ
 *       String
 *        = length(): ���� ����
 *        = equals(): ���ڿ� ��(��ҹ��� ����)
 *        = substring(): ���ڸ� �ڸ� �� ���
 *        = indexOf(), lastIndexOf(): ���� ã��
 *        = trim(): �¿��� ���� ����
 *        = replace(): ���ڸ� ����(Ư�� �ܺο��� ����� �� �ʿ���� ���� ����)
 *        = valueOf(): ��� ���������� ���ڿ��� ��ȯ
 *        = split(): ���ڿ� �����ؼ� �и�
 *       StringBuffer
 *        = append(): ���ڿ� ����(����ȭ)
 *       Integer
 *        = parseInt(): ���ڿ��� ������ ��ȯ
 *       Double
 *        = parseDouble()
 *       Boolean
 *        = parseBoolean()
 *       Math
 *        = random(): ���� �߻�
 *        = ceil(): �ø�
 *     java.util
 *       StringTokenizer
 *        = hasMoreTokens() => while()
 *        = nextToken(): �ڸ� ���ڿ��� �� ���� ������ �� ��
 *       =========================
 *       ArrayList
 *        = add()
 *        = size()
 *        = get()
 *       Vector
 *        = addElement() => add()
 *        = elementAt() => get()
 *        = size()
 *       HashMap
 *        = put(): ����
 *        = get(): ������ �б�
 *       ========================= �÷���: �������� ó�� => �����ͷ� ����(���׸���) <Type>
 *         ������̼�: �ε���(ã������ ������)
 *         Ŭ������ ���� ��� => ã�� ���� ������ �����ش� => �����(IoC) => ��ƾ �Ŀ﷯
 *         1. Ŭ����
 *         2. �޼ҵ� ==> �Ű�����
 *         3. �������
 *         4. ������
 *       =================================
 *       Properties
 *        = load() => ���� �б�(.properties)
 *        = getProperty()
 *       ================================= ���� (key=��)
 *       Date : �ý����� ��¥�� �о�� => ������ �ٸ� �˸� �� (Date date=new Date())
 *          ����Ŭ
 *          ��������
 *          CHAR, VARCHAR2, CLOB ==> String
 *          NUMBER               ==> int, double
 *          DATE, TIMESTAMP      ==> Date
 *          BLOB, BFILE          ==> InputStream
 *       Calendar: �޷�
 *          = month: 0~11
 *          = week: 1~7
 *     java.text
 *       SimpleDateFormat
 *          = format()
 *          = yyyy, MM, dd, hh, mm, ss ==> ����Ŭ TO_CHAR ����ϸ� ��
 *     ��Ÿ ���̺귯��
 *     ==========
 *       jsoup, simple-json, jaxb
 *     ==========
 *       java.sql: ����Ŭ
 *     ==========
 */
// Sawon ��������(����� ���� Ŭ����(��������))
/*
 *     �⺻ ��������: �޸𸮿� �� ��ü�� ����
 *     ���� ��������: �������� �����Ͱ� ����Ǳ� ������ ����� ��ġ(�ּ�, ����)�� Ȯ��
 *     =========
 *       ���α׷��Ӱ� ���� ����(���� ���������� ����(�迭)/�ٸ� ���������� ����(Ŭ����))
 *       
 *       ��ȭ: ����, �⿬, ����
 *       
 *       Object obj=new A();
 *       double       int
 *       A a=new Object()
 *       int       double
 */
import java.util.*;
class Sawon
{
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private int pay;                // ��������
	
	// �ʱⰪ(������ �����) => ������ �� ����,  ���浵 �ϰ� �����ڵ� ȣ���ϱ� ���ؼ� getter/setter �ؾ� ��
	public Sawon(int sabun, String name, String dept, String job, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	
	public void print()
	{
		System.out.println("���:"+sabun);
		System.out.println("�̸�:"+name);
		System.out.println("�μ�:"+dept);
		System.out.println("����:"+job);
		System.out.println("����:"+pay);
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ��� ����
		//Sawon sa1=new Sawon(1,"ȫ�浿","���ߺ�","�븮",4000);
		//sa1.print();
		// �̸� Collection�� �̷� �����͸� �����Ѵٰ� �˷��ָ� => ���������� Object�� ���� �˷��� ������������ ����
		ArrayList<Sawon> list=new ArrayList<Sawon>();  // Sawon[] 
		// => �����ʹ� ��� ���� �ϱ� ���ؼ� ���� ������ ��ƾ� ��
		list.add(new Sawon(1, "ȫ�浿1", "���ߺ�", "�븮", 4000));  //0
		list.add(new Sawon(2, "ȫ�浿2", "������", "����", 6000));  //1
		list.add(new Sawon(5, "ȫ�浿5", "���ߺ�", "���", 3000));  //2
		list.add(new Sawon(6, "ȫ�浿6", "�ѹ���", "���", 3000));  //3
		list.add(new Sawon(3, "ȫ�浿3", "��ȹ��", "���", 3000));  //4
		list.add(new Sawon(4, "ȫ�浿4", "�����", "����", 5000));  //5
		
		// ������ �ִ�(�ε��� ��ȣ) => ����� ����, �ߺ��� ������ ÷�� ����
		// ���
		for(Sawon s:list)
		{
			s.print();
			System.out.println("==============");
		}
		
		// ���׸��� ���� ��
		ArrayList list1=new ArrayList();
		list1.add(new Sawon(1, "ȫ�浿1", "���ߺ�", "�븮", 4000));  //0
		list1.add(new Sawon(2, "ȫ�浿2", "������", "����", 6000));  //1
		
		for(Object o:list1)
		{
			Sawon s=(Sawon)o;
			s.print();
		}
		
		// ���׸��� ������ �� �� �ؾ� ���� �ȳ�
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("id", "admin");
		String id=map.get("id");
		System.out.println(id);
		
		HashMap map1=new HashMap();
		map1.put("id", "hong");
		id=(String)map1.get("id");
		System.out.println(id);
		id=map1.get("id").toString();
		System.out.println(id);
	}

}
