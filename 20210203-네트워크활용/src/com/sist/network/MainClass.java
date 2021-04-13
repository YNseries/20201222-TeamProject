package com.sist.network;
/*
 *    �ڹ� ��Ʈ��ũ(��Ʈ���(�系), ���ͳ� ������ �Ŀ� ����� �ǰ� �ϴ�)
 *      �ڹ� => �系�޽���
 *      �ڹ� => ȭ��UI, C => ����
 *      ===================== ��) ī��
 *    TCP
 *      1) ���Ἲ
 *      2) �ŷڼ�
 *      3) �ӵ� ����
 *      4) => FTP(��������), SMTP(Send Mail), TELNET(���ϼ� ���� �����, ���� ���� ��� x), HTTP(��)
 *    UDP
 *      1) �񿬰Ἲ
 *      2) �ŷڼ��� ����
 *      3) �ӵ��� ������
 *      4) => ����, ��Ƽ�̵��(ȭ��) => 24������
 *    
 *    ��� => TCP / UDP
 *           ���Ἲ, �ŷڼ�, �ӵ� => RTCP
 *    
 *    �ڹٿ��� ��Ʈ��ũ => 
 *        �ĺ���: IP(��ȭ��ȣ), PORT(���ἱ) => ����(IP: ����), Ŭ���̾�Ʈ(����)
 *              =====================
 *              PORT: 0~65535 (0~1023 �����)
 *              FTP(21), SMTP(25), TELNET(23), HTTP(80), ����Ŭ����(1521)
 *              MS-SQL(1433), ������(27017), 8080,4000
 *    1) ��������
 *       1:��, 1:1(���α׷�, ����, Ŭ���̾�Ʈ): ȭ��, ����
 *       ====
 *       1. ������ �޴� ���α׷� => ����
 *       2. �����ڸ��� ���� ����� �����ϰ� �����(������: ���)
 *          class Server
 *          {
 *              ������ ���� ����
 *              class ��� extends Thread
 *              {
 *                  
 *              }
 *          }
 *          http://www.daum.net/aaa/index.html
 *          *** Socket: ������(�ڵ���)
 *          ������ ����ϴ� Ŭ����
 *            ServerSocket
 *             1) ip, port�� �����Ѵ�   bind() => ����
 *             2) ��� ���� => listen()
 *             3) ����     => accept() => ip(�߽����� ��ȭ��ȣ) => ����
 *             4) ���� => ��û ���� read()
 *             5) ���� => write()
 *          ����� ����ϴ� Ŭ����
 *             Socket
 *    2) Ŭ���̾�Ʈ ���� ���
 *       ���� => ��û => ���� �޾Ƽ� ���
 */
import java.io.*;
import java.net.*;
// 1. URL
/*
 *     http://www.daum.net/movie/list.jsp => URL
 *                        =============== URI
 *     = URLConnection: �������� ����(�ؼ� ������ ���� ��)
 *     = URLEncoder: �ѱ� ��ȯ  ==> ���� �� encoding => ���� �� decoding => %EC%9E%90%EB%B0%94
 *                                     =========
 *                                     getBytes() �ڹ� = %EC%9E%90%EB%B0%94
 *                                     oq=�ڹ�
 *     1. ������, ��Ʈ��ũ => 1byte: 1byte�� ��ȯ getBytes() => ��������
 *     https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&aqs=chrome..69i57j0i10l2j0i131i433j0i433j0i131i433j69i65l2.2320j1j7&sourceid=chrome&ie=UTF-8  
 */
// 2. Socket, ServerSocket
// https://search.naver.com/search.naver?where=news&query=%EC%98%81%ED%99%94
public class MainClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			URL url=new URL("http://newssearch.naver.com/search.naver?where=rss&query="
					+URLEncoder.encode("��ȭ","UTF-8"));
			// URL ����
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();  // naver�� ����
			if(conn!=null)	// ���� �Ǿ��ٸ�
			{
				BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				                                                           // �ѱ��� ������ ������ ���� ========
				while(true)
				{
					String msg=in.readLine();  // �� �پ� �о�
					if(msg==null)  // ���̻� ���� ������ ���� ���
					{
						break;
					}
					System.out.println(msg);
				}
			}
		}catch(Exception ex) {}
	}

}
