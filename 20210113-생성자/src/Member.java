import java.io.*;  //inputStream / outputStream : 입출력
// 파일명을 잘못 입력할 경우 => 사전에 방지(예외처리)
public class Member {
	String name;  // 선언하는 영역. (파일 읽기,제어문 불가)
	String sex;
	String addr;
	String tel;
	Member(){
		// 파일 읽어서 대입
		try {
		FileReader fr=new FileReader(new File("c:\\javaDev\\member.txt"));
		String data="";
		int c=0;
		// fr.read(): 파일에 있는 데이터를 1 글자씩 읽어온다(정수로 읽음)
		// -1: EOF(파일의 끝까지 읽으라는 말)
		while((c=fr.read())!=-1)
		{
			data+=String.valueOf((char)c);  // 때문에 char로 바꿔주는 것
		}
		fr.close();
		System.out.println(data);
		String[] s=data.split(",");  // ,별로 분리하는 메소드
		name=s[0];
		sex=s[1];
		addr=s[2];
		tel=s[3];
	}catch(Exception ex) {}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m=new Member();
		System.out.println("이름:"+m.name);
		System.out.println("성별:"+m.sex);
		System.out.println("주소:"+m.addr);
		System.out.println("전화:"+m.tel);

	}

}
