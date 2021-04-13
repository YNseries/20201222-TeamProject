package com.sist.movie;
// 파일을 읽어서 VO에 값을 채운다
import java.io.*;
import java.util.*;  // StringTokenizer로 자른다는거!
/*
 *  MNO         NUMBER(4)     
	TITLE       VARCHAR2(100) 
	GENRE       VARCHAR2(100) 
	POSTER      VARCHAR2(200) 
	ACTOR       VARCHAR2(300) 
	REGDATE     VARCHAR2(100) 
	GRADE       VARCHAR2(50)  
	DIRECTOR    VARCHAR2(100) 
 */
// JDBC ===> DBCP ===> ORM ===> JPA
// ------------------------(MyBatis, HiberNate)
public class MovieManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			MovieDAO dao=new MovieDAO();
			StringBuffer sb=new StringBuffer();
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			//System.out.println(sb.toString());
			String data=sb.toString();
			String[] movie=data.split("\n");
			for(String s:movie)
			{
				System.out.println(s);
				StringTokenizer st=new StringTokenizer(s,"|");
				// VO에 저장 => 오라클로 전송
				MovieVO vo=new MovieVO();
				vo.setMno(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				// 오라클 연결
				dao.movieInsert(vo);  // 오라클에 데이터 추가
				// 오라클 닫기
				Thread.sleep(100);  // 시간을 좀 늦춰(0.1초)줘야 속도가 맞을 듯(열고 닫는 속도를 오라클이 못 따라가서 오류남)
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}

}
