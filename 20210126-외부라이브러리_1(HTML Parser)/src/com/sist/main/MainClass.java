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
			// 다음 서버에 연결
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			if(conn!=null)	// 다음에 연결되었다면
			{																	// 유티코드로 갖고와라 =======
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
			ex.printStackTrace();  // 오류처리(오류난 위치 확인)
		}
	}

}
