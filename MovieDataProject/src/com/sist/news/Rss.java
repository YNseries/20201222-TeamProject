package com.sist.news;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rss {
	private Channel channel=new Channel();

	public Channel getChannel() {
		return channel;
	}
	@XmlElement   // 태그에서 값을 갖고와라! => Setter 위에 놓는거 잊으면 안됨.
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
