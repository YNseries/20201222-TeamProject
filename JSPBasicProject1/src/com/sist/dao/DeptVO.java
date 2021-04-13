package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
 *  DEPTNO NOT NULL NUMBER(10)   
	DNAME           VARCHAR2(14) 
	LOC             VARCHAR2(13) 
 */
@Setter
@Getter
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
}
