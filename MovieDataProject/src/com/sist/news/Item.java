package com.sist.news;

import javax.xml.bind.annotation.XmlElement;

/*
 *      <item>
			<title>장나라·정용화의 생활밀착 퇴마기…'대박부동산' 런칭 포스터 공개</title>
			<link>http://starin.edaily.co.kr/news/newspath.asp?newsid=01164406628983648</link>
			<description>
			<![CDATA[ 오는 4월 14일(수) 첫 방송을 앞둔 KBS2 새 수목드라마 ‘대박부동산’(극본 하수진, 이영화, 정연서/연출 박진석... 이영화, 정연서 작가, ‘학교 2017’, ‘맨몸의 소방관’, ‘간서치열전’ 등을 연출한 박진석 감독의 만남으로... ]]>
			</description>
			<pubDate>Mon, 15 Mar 2021 09:17:00 +0900</pubDate>
			<author>이데일리</author>
			<category>연예</category>
			<media:thumbnail url="https://imgnews.pstatic.net/image/thumb140/018/2021/03/15/4875409.jpg"/>
		</item>
 */
public class Item {
	private String title;
	private String link;
	private String description;
	private String pubDate;
	private String author;
	
	public String getTitle() {
		return title;
	}
	// element.text() @XmlElement, elemenent.attr() @XmlAttribute
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	@XmlElement
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	@XmlElement
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getAuthor() {
		return author;
	}
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
