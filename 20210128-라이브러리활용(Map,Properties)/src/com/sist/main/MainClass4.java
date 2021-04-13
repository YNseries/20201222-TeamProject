package com.sist.main;
import java.io.FileInputStream;
import java.util.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		prop.load(new FileInputStream("C:\\JavaDev\\JavaStudy\\20210128-라이브러리활용(Map,Properties)\\src\\com\\sist\\main\\db.properties"));
		System.out.println("이름:"+prop);
	}

}
