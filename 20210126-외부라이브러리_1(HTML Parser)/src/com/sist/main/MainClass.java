package com.sist.main;
import java.util.*;

import java.io.*;
import java.net.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String path="https://movie.daum.net/magazine/new";
			URL url=new URL(path);
			// ���� ������ ����
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			if(conn!=null)	// ������ ����Ǿ��ٸ�
			{																	// ��Ƽ�ڵ�� ����Ͷ� =======
				BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTP-8"));
				while(true)
				{
					String msg=br.readLine();
					if(msg==null)break;
					System.out.println(msg);
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();  // ����ó��(������ ��ġ Ȯ��)
		}
	}

}
