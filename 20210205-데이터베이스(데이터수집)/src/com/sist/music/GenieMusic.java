package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *    Oracle ¿¬°á ÇÁ·Î±×·¥ÀÌ Áß½É(¿À¶óÅ¬: µ¥ÀÌÅÍº£ÀÌ½º(µ¥ÀÌÅÍ¸¦ ÀúÀåÇÏ´Â Àå¼Ò => µ¥ÀÌÅÍ °øÀ¯))
 *    1. µ¥ÀÌÅÍÇü
 *       ¼ýÀÚÇü
 *        NUMBER(10), NUMBER(7,2)
 *        ==========  ===========
 *           int         double
 *       ¹®ÀÚÇü
 *        CHAR, VARCHAR2, CLOB => String
 *       ³¯Â¥Çü
 *        DATE => Date
 *    ===> int, double, String, Date
 *    2. µ¥ÀÌÅÍ¸¦ ¸ð¾Æ¼­ Àü¼Û
 *       ArrayList => Á¦³×¸¯½º(µ¥ÀÌÅÍÇü ÅëÀÏ)
 *    3. Connection, Statement, ResultSet
 *    4. ¿¹¿ÜÃ³¸®
 *   =====================================
 */
// À¥ Å©·Ñ¸µ
public class GenieMusic {
	public void getGenieMusic()
	{
		try
		{
			MusicDAO dao=new MusicDAO();  // for¹® ¾È¿¡ µé¾î°¡¸é ¾ÈµÊ
			int k=201;  // ¿©±ä °íÀ¯¹øÈ£ÀÌ±â ¶§¹®¿¡ TOP200 ÀÌÈÄ¿¡ ÁøÇà=> 201ºÎÅÍ
			for(int i=1;i<=2;i++)  // i<=4(TOP 200ÀÏ ¶§), i<=2(Àå¸£º° Â÷Æ®ÀÏ ¶§)
			{
				// TOP 200
				//Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210210&hh=14&rtm=Y&pg="+i).get();
				//                                                                          ³¯Â¥======== =====½Ã°£
				// Àå¸£º° Â÷Æ®
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20210209&genrecode=M0100&pg="+i).get();
				// title, singer, album, poster, state, idcrement, rank
				Elements title=doc.select("tr.list a.title");  // <a class="title">
				Elements singer=doc.select("tr.list a.artist");
				Elements album=doc.select("tr.list a.albumtitle");
				Elements poster=doc.select("tr.list a.cover img");
				Elements etc=doc.select("tr.list span.rank");
				for(int j=0;j<title.size();j++)
				{
					System.out.println("¼øÀ§:"+k);  // Å×ÀÌºí1
					System.out.println("Á¦¸ñ:"+title.get(j).text());  // Å×ÀÌºí2
					System.out.println("°¡¼ö:"+singer.get(j).text());  // Å×ÀÌºí3
					System.out.println("¾Ù¹ü:"+album.get(j).text());  // Å×ÀÌºí4
					System.out.println("Æ÷½ºÅÍ:"+poster.get(j).attr("src"));  // Å×ÀÌºí5
					String str=etc.get(j).text();
					// À¯Áö
					// 2ÇÏ°­ => ¼ýÀÚ Á¦°Å ÇÊ¿ä
					// 1»ó½Â => ¼ýÀÚ Á¦°Å ÇÊ¿ä
					// new
					String id="";
					String state=str.replaceAll("[^°¡-ÆR/^a-z]", "");  // ÇÑ±Û,¿µ¹®À» Á¦¿ÜÇÏ°í ³ª¸ÓÁö´Â °ø¹é
					if(state.equals("À¯Áö"))
					{
						id="0";
					}
					else if(str.equals("new"))
					{
						id="0";
					}
					else
					{
						id=str.replaceAll("[^0-9]", "");  // ¼ýÀÚ Á¦¿ÜÇÏ°í ³ª¸ÓÁö´Â °ø¹é
					}
					System.out.println("»óÅÂ:"+state);  // Å×ÀÌºí6
					System.out.println("µîÆø:"+id);  // Å×ÀÌºí7
					//System.out.println("»óÅÂ:"+etc.get(j).text());
					System.out.println("==============================================");
					// µ¥ÀÌÅÍ ¸ð¾Æ¼­ => MusicDAO·Î Àü¼Û => ¿À¶óÅ¬¿¡ Insert
					GenieMusicVO vo=new GenieMusicVO();
					vo.setNo(k);
					vo.setCno(2);  // 1 TOP 200   2 Àå¸£
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					vo.setAlbum(album.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					vo.setState(state);
					vo.setIdcrement(Integer.parseInt(id));
					
					dao.genieMusicInsert(vo);
					
					Thread.sleep(100);   // ¿À¶óÅ¬ ¿­°í ´Ý´Â ½Ã°£ÀÌ ²Ï °É¸®´Ï±î ¼Óµµ ¸ÂÃç¼­ ¿Ã¶ó¿Ã ¼ö ÀÖµµ·Ï Áö¿¬µÇ´Â ½Ã°£ °É¾îÁà¾ß ÇÔ
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
