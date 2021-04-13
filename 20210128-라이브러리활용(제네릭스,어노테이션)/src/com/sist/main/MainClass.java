package com.sist.main;
/*
 *     제네릭스: 데이터형을 통일해서 사용
 *     형식) <className> => 자바에서 제공하는 컬렉션의 모든 데이터형 => Object
 *          => Object를 다른 데이터형으로 변환
 *          장점:
 *              1. 데이터형의 안정성
 *              2. 형변환이 없고 소스가 간결함
 *          예) ArrayList<String>
 *             ArrayList<int> (X) => ArrayList<Integer>
 *             ArrayList<MovieVO>
 *     public class ArrayList<T>
 *     {
 *         T t;
 *         public ArrayList()
 *         {
 *             if(제네릭스=null)
 *             {
 *                 T=Object;     // default를 Object로 걸어둠
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
 *     ArrayList<String> => T => String(한번에 데이터형 바뀌고, 리턴형 바뀜)
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
 *     E => Element (값 입력)
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
