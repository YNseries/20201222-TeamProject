package com.sist.dao;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private DeptVO dvo=new DeptVO();   // JOIN => 포함 클래스
	/*
	 *    public DeptVO getDvo()
	 *    {
	 *    	  return dvo;
	 *    }
	 */
}
