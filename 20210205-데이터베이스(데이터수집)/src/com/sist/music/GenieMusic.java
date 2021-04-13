package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *    Oracle ���� ���α׷��� �߽�(����Ŭ: �����ͺ��̽�(�����͸� �����ϴ� ��� => ������ ����))
 *    1. ��������
 *       ������
 *        NUMBER(10), NUMBER(7,2)
 *        ==========  ===========
 *           int         double
 *       ������
 *        CHAR, VARCHAR2, CLOB => String
 *       ��¥��
 *        DATE => Date
 *    ===> int, double, String, Date
 *    2. �����͸� ��Ƽ� ����
 *       ArrayList => ���׸���(�������� ����)
 *    3. Connection, Statement, ResultSet
 *    4. ����ó��
 *   =====================================
 */
// �� ũ�Ѹ�
public class GenieMusic {
	public void getGenieMusic()
	{
		try
		{
			MusicDAO dao=new MusicDAO();  // for�� �ȿ� ���� �ȵ�
			int k=201;  // ���� ������ȣ�̱� ������ TOP200 ���Ŀ� ����=> 201����
			for(int i=1;i<=2;i++)  // i<=4(TOP 200�� ��), i<=2(�帣�� ��Ʈ�� ��)
			{
				// TOP 200
				//Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210210&hh=14&rtm=Y&pg="+i).get();
				//                                                                          ��¥======== =====�ð�
				// �帣�� ��Ʈ
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20210209&genrecode=M0100&pg="+i).get();
				// title, singer, album, poster, state, idcrement, rank
				Elements title=doc.select("tr.list a.title");  // <a class="title">
				Elements singer=doc.select("tr.list a.artist");
				Elements album=doc.select("tr.list a.albumtitle");
				Elements poster=doc.select("tr.list a.cover img");
				Elements etc=doc.select("tr.list span.rank");
				for(int j=0;j<title.size();j++)
				{
					System.out.println("����:"+k);  // ���̺�1
					System.out.println("����:"+title.get(j).text());  // ���̺�2
					System.out.println("����:"+singer.get(j).text());  // ���̺�3
					System.out.println("�ٹ�:"+album.get(j).text());  // ���̺�4
					System.out.println("������:"+poster.get(j).attr("src"));  // ���̺�5
					String str=etc.get(j).text();
					// ����
					// 2�ϰ� => ���� ���� �ʿ�
					// 1��� => ���� ���� �ʿ�
					// new
					String id="";
					String state=str.replaceAll("[^��-�R/^a-z]", "");  // �ѱ�,������ �����ϰ� �������� ����
					if(state.equals("����"))
					{
						id="0";
					}
					else if(str.equals("new"))
					{
						id="0";
					}
					else
					{
						id=str.replaceAll("[^0-9]", "");  // ���� �����ϰ� �������� ����
					}
					System.out.println("����:"+state);  // ���̺�6
					System.out.println("����:"+id);  // ���̺�7
					//System.out.println("����:"+etc.get(j).text());
					System.out.println("==============================================");
					// ������ ��Ƽ� => MusicDAO�� ���� => ����Ŭ�� Insert
					GenieMusicVO vo=new GenieMusicVO();
					vo.setNo(k);
					vo.setCno(2);  // 1 TOP 200   2 �帣
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					vo.setAlbum(album.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					vo.setState(state);
					vo.setIdcrement(Integer.parseInt(id));
					
					dao.genieMusicInsert(vo);
					
					Thread.sleep(100);   // ����Ŭ ���� �ݴ� �ð��� �� �ɸ��ϱ� �ӵ� ���缭 �ö�� �� �ֵ��� �����Ǵ� �ð� �ɾ���� ��
					k++;
				}
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenieMusic gm=new GenieMusic();
		gm.getGenieMusic();
	}

}
