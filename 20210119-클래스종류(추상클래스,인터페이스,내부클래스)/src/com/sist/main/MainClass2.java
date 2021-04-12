package com.sist.main;
abstract class Common{
	protected abstract int x,y;
	public void movie(int x,int y) {}
	public void stop() {}
}

class 전투병 extends Common{
	   //private int x,y;
	   public void movie(int x,int y) {}
	   //public void stop() {}
	   public void use() {}  // 전투병
	}
	class 탱크 extends Common{
	   //private int x,y;
	   public void movie(int x,int y) {}
	   //public void stop() {}
	   void changeMode() {}  // 탱크
	}
	class 수송선 extends Common
	{
	   //private int x,y;
	   public void movie(int x,int y) {}
	   //public void stop() {}
	   public void load() {}  // 수송선
	   public void unload() {}  // 수송선
	}

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
