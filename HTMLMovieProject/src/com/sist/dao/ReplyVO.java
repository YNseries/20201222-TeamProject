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
	private Date regdate;   // ��¥�� ���� ����, �Է��� �ð��� ����� �� ���� => TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS')
	// TO_CHAR�� �׻� ������ �ϳ� �� �߰��� ��� ��
	private String dbday;
}
