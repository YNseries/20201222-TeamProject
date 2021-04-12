package com.sist.main;
/*
 *    클래스의 종류
 *    1) 일반 클래스
 *       접근지정어 class className{
 *          ===============
 *            변수(공통,각자)
 *          ===============
 *            메소드 (기능)
 *          ===============
 *            생성자
 *          ===============
 *       }
 *    2) 추상클래스(단일상속): 미완성 클래스(메소드만 선언) => 공통적인 기능이 있는 경우
 *       접근지정어 abstract class className{
 *          ===============
 *            변수(공통,각자)
 *          ===============
 *            구현된 메소드
 *          ===============
 *            선언된 메소드 => 반드시 상속받은 클래스가 구현해서 사용
 *            예) 먹는다(), 걷는다() ...
 *               버튼 클릭, 마우스 클릭
 *            오버라이딩: 프로그램에 맞게 구현해서 사용
 *          ===============
 *            생성자
 *          ===============
 *       }
 *    ***3) 추상클래스를 보완 => 인터페이스(다중상속)
 *       배, 자동차, 비행기
 *       class transformer implements 배,자동자,비행기
 *       접근지정어 interface interface명{
 *          ===============
 *           변수: 상수형 변수
 *          ===============
 *           선언된 메소드
 *          ===============
 *           구현된 메소드 => JDK 1.8 이상
 *             default
 *             static
 *          ===============
 *       }
 *    4) 내부 클래스: 윈도우프로그램, 쓰레드, 네트워크
 *          = 멤버클래스(멤버 안에 멤버클래스가 들어감)
 *            class A
 *            {
 *               ========
 *                 변수
 *               ========
 *                 메소드
 *               ========
 *                 생성자
 *               ========  ==> 공통으로 사용되는 변수, 메소드
 *               class B   ==> A클래스가 가지고 있는 모든 메소드, 변수 => 사용이 자유롭다
 *               {
 *                  ========
 *                    변수
 *                  ========
 *                    메소드
 *                  ========
 *                    생성자
 *                  ========
 *               }
 *            }
 *            
 *          = 익명의 클래스: 상속(extends)없이 오버라이딩이 가능하다 => 상속하면 속도가 느려짐
 *             class A
 *             {
 *                public void display(){}
 *             }
 *             class B extends A
 *             {
 *                public void display(){}
 *             }
 *             
 *             class A
 *             {
 *                public void display(){}
 *             }
 *             class B extends A
 *             {
 *                A a=new A(){
 *                   public void display(){}
 *                }
 *             }
 *          = 지역클래스: 사용빈도가 거의 없다
 *            class A
 *            {
 *               public void display()
 *               {
 *                  class B
 *                  {
 *                  
 *                  }
 *               }
 *            }
 *    5) 종단 클래스: 상속을 할 수 없는 클래스(독립적으로만 사용이 가능) => 포함
 *                 String, Math, System ... (제공한 기능 그대로 사용) 확장 불가
 *       접근지정어 final class className{
 *          ===============
 *            변수
 *          ===============
 *            메소드
 *          ===============
 *            생성자
 *          ===============
 *        }       
 */
import javax.swing.*;
import javax.swing.table.*;
// extends JFrame => (JFrame은 유지) => 상속받은 내용만 변경
public class 클래스종류 extends JFrame{
	JTable table;
	DefaultTableModel model;
	public 클래스종류()
	{
		String[] col= {"이름","주소","전화"};
		String[][] row=new String[0][3];
		model=new DefaultTableModel(row,col) {
			
			@Override
			public boolean isCellEditable(int row,int column) {
				// TODO Auto-generated method stub
				return false;
			}
			// 오버라이딩
			
		};
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		add("Center",js);
		String[] data= {"홍길동","서울","010-0000-0000"};
		model.addRow(data);
		setSize(450, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 클래스종류();
	}

}
