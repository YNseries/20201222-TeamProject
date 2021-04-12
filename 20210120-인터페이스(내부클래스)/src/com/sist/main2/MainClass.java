package com.sist.main2;
/*
 *    키워드: 클래스명, 메소드명(제외)
 */
interface DataBase
{
	public void connect();
	public void disconnect();
}
class Oracle implements DataBase  // 대기업
{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("오라클 연결");
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("오라클 닫기");
	}
	
}
class MsSQL implements DataBase  // 중소기업. 무료
{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("MsSQL 연결");
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("MsSQL 닫기");
	}
	
}
class MySQL implements DataBase
{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("MySQL 연결");
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("MySQL 닫기");
	}
	
}
class DB2 implements DataBase  // 금융기업, 공공기업
{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("DB2 열기");
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("DB2 닫기");
	}
}
// interface는 주로 하는 역할: 여러개의 클래스를 모아서 관리하는 프로그램(Web에서 주로 사용: 스프링)
// JSP(제일 많이 가르치고, 많이 이용해서, 잘 뽑힘) / Asp.net(비싸) / PHP
// Web => 데이터베이스(ANSI) 연결
// Java: 인터페이스(하나로 모든 데이터를 연결)     C#: 클래스(모든 클래스를 외워야 하는 단점)
class Container
{
	public DataBase dbSelect(String type)
	{
		DataBase db=null;  // 나중에 이렇게 말고 Map 사용할거야
		if(type.equals("Oracle"))  // 하나씩 모인거 = 컴퍼넌트  => 컴퍼넌트 여러개 모인 것 = 컨테이너
			db=new Oracle();
		else if(type.equals("MsSQL"))
			db=new MsSQL();
		else if(type.equals("MySQL"))
			db=new MySQL();
		else if(type.equals("DB2"))
			db= new DB2();
		return db;
	}
}
/*
 *    인터페이스: 리모콘에 비유됨
 *    =======
 *       자바가 리모콘을 제작하는 업체였음 => 부도 => 브라우저(네스케이프) 업체: 웹 중심
 *       
 *       HTML5 => MS는 제외(Google, FireFox, 오페라는 호환됨) => HTML은 추상적, HTML5는 알기쉽게: 시멘텍
 *       ex. 동영상: HTML <object>   HTML5 <video>
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container c=new Container();
		DataBase db=c.dbSelect("Oracle");
		db.connect();
		db.disconnect();
		System.out.println("==============");
		db=c.dbSelect("DB2");
		db.connect();
		db.disconnect();
	}

}
