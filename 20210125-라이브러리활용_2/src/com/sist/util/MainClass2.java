package com.sist.util;
// StringTokenizer => java.util.*
/*
 *    �ܾ�� ���ڿ��� �и��ϴ� ����(������)
 *    = hasMoreTokens()   ���� ��Ȯ�ϰ� �� ��
 *    = countTokens()     ������ �� �� ����
 *    = nextToken()       �ϳ��� ���� �� ��
 */
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String colors="red|yellow|blue|green|black|white";
		StringTokenizer st=new StringTokenizer(colors,"|"); // ���� colors �߿� �� �ڸ����� ����
		System.out.println(st.countTokens());
		/*while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}*/
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());  // ���� ������ �� �ٰ� ���� ���
	}

}
