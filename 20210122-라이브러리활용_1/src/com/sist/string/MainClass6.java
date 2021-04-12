package com.sist.string;
// split => 분리  ==> regex (regular expression) 정규식
public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String color="red?blue?green?black?yellow?magenta";  // substring 은 6번 써야 함
		String[] colors=color.split("\\?");
		
		for(String s:colors)
		{
			System.out.println(s);
		}
	}

}
