package com.sist.thread;

public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Runnable r=()->{
        	for(int i=0;i<10;i++)
        	{
        		System.out.println(i);
        	}
        };
        
        Thread t=new Thread(r);
        t.start();
	}

}