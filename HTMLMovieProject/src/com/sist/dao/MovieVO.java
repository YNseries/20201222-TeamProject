package com.sist.dao;
/*
 *  MNO      NOT NULL NUMBER(4)     
	TITLE             VARCHAR2(200) 
	GENRE             VARCHAR2(100) 
	POSTER            VARCHAR2(200) 
	ACTOR             VARCHAR2(300) 
	REGDATE           VARCHAR2(200) 
	GRADE             VARCHAR2(50)  
	DIRECTOR          VARCHAR2(100) 
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
@Getter
@Setter
public class MovieVO {
	private int mno;
	private String title;
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	private int hit;
	
}
