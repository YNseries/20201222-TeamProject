package com.sist.lib;
// MessageFormat => SQL 문장을 만들 때
/*
 *    SQL
 *     = DML
 *       = SELECT
 *       = INSERT
 *       = UPDATE
 *       = DELETE
 *     = DDL
 *     = DCL
 *     = TCL
 *     
 *     PL/SQL
 */
import java.text.*;
// 데이터를 정해진 양식으로 출력할 때 추로 사용(오라클 형식)
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="이름:{0}\n성별:{1}\n전화:{2}\n주소:{3}\n나이:{4}\n";
		Object[] obj= {"홍길동","남자","010-1111-1111","서울",30};
		// Object는 모든 데이터형을 받을 수 있다
		String result=MessageFormat.format(msg, obj);
		System.out.println(result);
	}

}
