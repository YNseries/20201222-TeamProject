package com.sist.lib;
// 배열&클래스 => 메모리 주소 싸움!
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={10,20,30,40,50};
		
		int[] arr1=new int[5];  // 0,0,0,0,0
		arr1[0]=10; 
		arr1[1]=20;
		arr1[2]=30;
		arr1[3]=40;
		arr1[4]=50;  // 일일이 이런식으로 넣는 것보다 클론을 쓰는게 훨씬 편하니까
		
		int[] arr2=arr.clone();
		/* int[] arr1=arr;
		System.out.println("arr1="+arr1);
		System.out.println("arr="+arr);
		arr1[0]=100;
		System.out.println(arr[0]);
		
		int[] arr2=arr.clone();  // clone하면 메모리 주소 바뀜
		arr2[1]=1000;
		System.out.println("arr[1]="+arr[1]);
		System.out.println("arr2="+arr2);*/ // 다른 메모리에서 바뀌었기 떄문에 위에는 영향x 주소 바뀜

	}

}
