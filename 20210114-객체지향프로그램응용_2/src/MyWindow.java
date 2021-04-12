import javax.swing.*;
// is-a  상속클래스. 상속을 내리는 애가 커
// long(8) < float(4)
// (MyWindow)JFrame 
public class MyWindow extends JFrame {
	JButton b =new JButton("Click");
	JButton b1=new JButton("Click");
	JButton b2=new JButton("Click");
	JButton b3=new JButton("Click");
	JButton b4=new JButton("Click");
	public MyWindow()
	{
		add("North",b);
		add("Center",b1);
		add("South",b2);
		add("East",b3);
		add("West",b4);
		setSize(640, 480);  // 윈도우 크기 결정
		setVisible(true);   // 보여달라
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// MyWindow m=(MyWindow)new JFrame();
		MyWindow m=new MyWindow();
		// int a=(int)10L;
	}

}
