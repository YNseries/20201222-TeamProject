package com.sist.string;
// split => �и�  ==> regex (regular expression) ���Խ�
public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String color="red?blue?green?black?yellow?magenta";  // substring �� 6�� ��� ��
		String[] colors=color.split("\\?");
		
		for(String s:colors)
		{
			System.out.println(s);
		}
	}

}
