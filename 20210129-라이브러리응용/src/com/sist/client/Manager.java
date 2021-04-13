package com.sist.client;
import java.util.*;
public class Manager {
	private ArrayList<String> list=
			new ArrayList<String>();
	public ArrayList<String> allData()
	{
		return list;  // 목록
	}
	public void insert(String name)
	{
		list.add(name);  // 저장
	}

}
