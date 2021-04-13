package com.sist.movie;
// ���Ͽ� ArrayList�� ����
import java.io.*;
import java.util.*;
public class ObjectSaveClass {
	/*
	 *  private int mno,cno;
		private String title;
		private String score;
		private String genre;
		private String regdate;
		private String time;
		private String grade;
		private String director;
		private String actor;
		private String poster;
		private String shoUser;
		private String story;
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// ���� �б�
			FileInputStream fis=new FileInputStream("c:\\javaDev\\daum_movie.txt");
			BufferedReader br=
					new BufferedReader(new InputStreamReader(fis));
			// ������ ���� ��ü�� �޸𸮿� ����
			ArrayList<MovieVO> list=new ArrayList<MovieVO>();
			while(true)
			{
				String movie_data=br.readLine();  // readLine() => \n������ �� ��
				if(movie_data==null)
					break;  // ���̻� ���� ���� ���� ��� => ����
				StringTokenizer st=new StringTokenizer(movie_data,"|");
				MovieVO vo=new MovieVO();
				// �ڸ���
				vo.setMno(Integer.parseInt(st.nextToken()));
				vo.setCno(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setScore(st.nextToken());
				vo.setGenre(st.nextToken());
				vo.setRegdate(st.nextToken());
				vo.setTime(st.nextToken());
				vo.setGrade(st.nextToken());
				vo.setDirector(st.nextToken());
				vo.setActor(st.nextToken());
				vo.setPoster("http:"+st.nextToken());
				vo.setShoUser(st.nextToken());
				vo.setStory(st.nextToken());
				list.add(vo);
			}
			fis.close();
			// ArrayList�� ����
			FileOutputStream fos=new FileOutputStream("c:\\download\\movie.txt");
			// Create, true => append
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			// ��ü ������ ����
			System.out.println("��ü ���� �Ϸ�!!");
		}catch(Exception ex) {}
	}

}
