package com.sist.lib;
// equals => ��ü�� ������ �ִ� ���� ��
// == �ּҰ��� ��(�迭, Ŭ����), �Ϲݵ����ʹ� ���� ��
/*
 *     int a=(int)(Math.random()*100)+1 => 1~100 �����߻�     �̷��� ������ �ϴ� �ͺ���
 *                 ============= �� double������ int������ �ٲ�θ� ���ϰ���
 *     ���̺귯�� ������ �ܿ�� �� �ƴ�. ������� ���ǿ� �°� ����/����� �� �־�� ��  
 */
class B
{
	String name;
	// String addr;  // �̷��� ������ name/addr �� �� ������ �ƹ��� ��!
	public B(String name)  // name�� ���ض� ��� �Ǿ��־�, equals�� �������ؾ� �ּҰ��� �ƴ� ���Ӱ��� ���ϰ� ��.
	{
		this.name=name;
	}
	/* @Override  // �� ������ �� �� ���������� equals�� ������� �ּҸ� ����
	public boolean equals(Object obj) {
		//return super.equals(obj);      // ���� equals�� ����
		if(obj instanceof B)             // ���� ���� �ݵ�� equals �������ؼ� ��� ��
			return name.equals(((B)obj).name);
		else
			return false;
	} */
	
}
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b1=new B("ȫ�浿");
		B b2=new B("ȫ�浿");  // new �ϸ� ���� ����� ��. 
		B b3=b1;
		
		if(b1.equals(b2))  // ���⼭ equals�� ��(���Ӱ�)�� ���ϴ°��� �ƴ� �ּ�(��ü)�� ���ϴ� ��
		// �ƿ� if(b1.name.equlas(b2.name))�̶�� ����ϸ鼭 ���Ӱ��� ���ϰ� �� ���� ����
			System.out.println("b1�� b2�� �ּҰ��� ����");
		else
			System.out.println("b1�� b2�� �ּҰ��� �ٸ���");
		
		if(b1==b3)
			System.out.println("b1�� b3�� �ּҰ��� ����");
		else
			System.out.println("b1�� b3�� �ּҰ��� �ٸ���");

	}

}
