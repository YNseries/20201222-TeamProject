package com.sist.dao;
/*
 *  NO      NOT NULL NUMBER       
	MNO              NUMBER       
	ID               VARCHAR2(20) 
	NAME             VARCHAR2(30) 
	MSG     NOT NULL CLOB         
	REGDATE          DATE   
 */

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReplyVO {
	private int no;
	private int mno;
	private String id;
	private String name;
	private String msg;
	private Date regdate;   // 날짜를 갖고 오면, 입력한 시간을 갖고올 수 없다 => TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS')
	// TO_CHAR는 항상 변수를 하나 더 추가해 줘야 함
	private String dbday;
}
