package com.sist.main;
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map=new HashMap();
		// MyBatis => ���� Map �������� �Ǿ�����
		map.put("MovieAllData", "SELECT * FROM movie");
		map.put("MovieDetailData", "SELECT * FROM movie WHERE mno=1");
		map.put("movieDelete", "DELETE FROM movie WHERE mno=1");
		//                     ============================== ����Ŭ ����
		System.out.println(map.get("movieAllData"));
		System.out.println(map.get("movieDelete"));
	}

}
