package com.sist.network;
import java.net.*;
import java.io.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Socket s=new Socket("211.238.142.181",3355);   // 뒤에 숫자는 서버포트 줘야 함
			// 강의실 내부에서만 접근 가능. 중복되는 port 없음
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			// s=서버
			String msg=in.readLine();
			System.out.println(msg);
		}catch(Exception ex) {}
	}
	
}
