package com.sist.dao;

import lombok.Getter;
import lombok.Setter;
// VO => 반드시 table당 한 개씩 만든다
@Setter
@Getter
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
}
