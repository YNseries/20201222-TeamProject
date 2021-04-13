package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// https://www.10000recipe.com/recipe/list.html
/*
 * <li class="common_sp_list_li">
                <div class="common_sp_thumb">
                    <a href="/recipe/6940325" class="common_sp_link">
                                                <img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/28/c37e0db0e0386d453eda2be45e26b9c01_m.jpg">
                    </a>
                </div>
                <div class="common_sp_caption">
                    <div class="common_sp_caption_tit line2">닭봉간장조림~ 십년째 만들어 먹는 양념 공유해요!</div>
                    <div class="common_sp_caption_rv_name" style="display: inline-block; vertical-align: bottom;">
                        <a href="/profile/recipe.html?uid=reora"><img src="https://recipe1.ezmember.co.kr/cache/rpf/2020/06/25/e95dbdcf4122fe67c45511b5c4f6f4c71.jpg">요리하는러라</a>
                    </div>
                    <div class="common_sp_caption_rv">
                                                    <span class="common_sp_caption_rv_star"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"></span>
                            <span class="common_sp_caption_rv_ea">(64)</span>
                                                <span class="common_sp_caption_buyer" style="vertical-align: middle;">조회수 7.1만</span>
                    </div>
                </div>
            </li>
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Document doc=Jsoup.connect("https://www.10000recipe.com/recipe/list.html").get();
			Elements poster=doc.select("img[src*=/recipe/]");
			for(int i=0;i<poster.size();i++)
			{
				System.out.println(poster.get(i).attr("arc"));
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
