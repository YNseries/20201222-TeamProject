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
	private Date hiredate;
	private int sal;
	private DeptVO dvo=new DeptVO();  // JOIN
}
