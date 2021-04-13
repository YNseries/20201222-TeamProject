package com.sist.main;
/*
 *     ���׸���: ���������� �����ؼ� ���
 *     ����) <className> => �ڹٿ��� �����ϴ� �÷����� ��� �������� => Object
 *          => Object�� �ٸ� ������������ ��ȯ
 *          ����:
 *              1. ���������� ������
 *              2. ����ȯ�� ���� �ҽ��� ������
 *          ��) ArrayList<String>
 *             ArrayList<int> (X) => ArrayList<Integer>
 *             ArrayList<MovieVO>
 *     public class ArrayList<T>
 *     {
 *         T t;
 *         public ArrayList()
 *         {
 *             if(���׸���=null)
 *             {
 *                 T=Object;     // default�� Object�� �ɾ��
 *             }
 *         }
 *         public void add(T t)
 *         {
 *         
 *         }
 *         public T get(int index)
 *         {
 *         }
 *         public void set(int index,T t)
 *     }
 *     
 *     ArrayList<String> => T => String(�ѹ��� �������� �ٲ��, ������ �ٲ�)
 */
class Box<T>
{
	T item;
	public void setItem(T item)
	{
		this.item=item;
	}
	public T getItem()
	{
		return item;
	}
}
/*
 *     T => Type (type=class)
 *     E => Element (�� �Է�)
 *     K => Key
 *     V => Value
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box=new Box();
		Box<String> box1=new Box<String>();
		String s=box1.getItem();
	}

}
