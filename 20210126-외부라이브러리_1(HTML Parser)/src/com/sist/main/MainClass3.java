package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/*
	<td><a href="#" class="cover" onclick="fnViewAlbumLayer('81858755');return false;"><span class="mask"></span><img src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/858/755/81858755_1611302348643_1_140x140.JPG/dims/resize/Q_80,0" onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" alt="�� ���� ���� ���ؿ� (�ٸ����� ������ X 10CM)"></a></td>
                                <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo('92070716');return false;">�� ���� ���� ������</a></td>
                                <td class="info">
                                    
                                    
                                    <a href="#" class="title ellipsis" title="���" onclick="fnPlaySong('92070716','1');return false;">
                                        
                                            
                                        
                                        
                                        
                                        
                                            
                                                �� ���� ���� ���ؿ� (�ٸ����� ������ X 10CM)</a>

                                        <a href="#" class="artist ellipsis" onclick="fnViewArtist('80044692');return false;">10CM</a>
                                        
                                        <div class="toggle-button-box">
                                            <button type="button" class="btn artist-etc" onclick="fnRelationArtistList('92070716');">��</button>
                                            <ul class="list" id="RelationArtist_92070716"></ul>
                                        </div>
                                        
                                        <i class="bar">|</i>
                                        <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer('81858755');return false;">�� ���� ���� ���ؿ� (�ٸ����� ������ X 10CM)</a>
                                </td>                                       
 */
import org.jsoup.select.Elements;

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// https://try.jsoup.org/
		try
		{
			// for(int i=1;i<=4,i++)  // ������ ���� �� 4�ʱ��� 
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title=doc.select("td.info a.title");  // td.info ��� ����
			Elements singer=doc.select("td.info a.artist");
			Elements album=doc.select("td.info a.albumtitle");
			
			for(int i=0;i<title.size();i++)
			{
				System.out.println(title.get(i).text());
				System.out.println(singer.get(i).text());
				System.out.println(album.get(i).text());
				System.out.println("====================================================");
			}
			
		}catch(Exception ex) {}

	}

}
