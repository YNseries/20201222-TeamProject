package com.sist.network;
import java.net.*;
import java.io.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Socket s=new Socket("211.238.142.181",3355);   // �ڿ� ���ڴ� ������Ʈ ��� ��
			// ���ǽ� ���ο����� ���� ����. �ߺ��Ǵ� port ����
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			// s=����
			String msg=in.readLine();
			System.out.println(msg);
		}catch(Exception ex) {}
	}
	
}
