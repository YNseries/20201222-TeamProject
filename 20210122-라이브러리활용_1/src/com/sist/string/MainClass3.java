package com.sist.string;
// 문자열 결합: concat(),+
import java.util.Scanner;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("성 입력:");
		String first=scan.next();
		System.out.print("이름 입력:");
		String second=scan.next();
		// 문자열 결합
		String name=first.concat(second);
		System.out.println("이름:"+name);
		// 한번에 결합하기
		System.out.println("이름:"+first+second);
	}

}
