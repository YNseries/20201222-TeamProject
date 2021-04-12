import java.util.Scanner;
class Join
{
	private String name;
	private String id;
	private String pwd;
	private String pwdC;
	private int birth;
	private String sex;
	private String addr;
	private String num;
	private boolean sms;
	private String mail;
	private boolean info;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdC() {
		return pwdC;
	}
	public void setPwdC(String pwdC) {
		this.pwdC = pwdC;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public boolean getSms() {
		return sms;
	}
	public void setSms(boolean sms) {
		this.sms = sms;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean getInfo() {
		return info;
	}
	public void setInfo(boolean info) {
		this.info = info;
	}
	
	Join(){
		System.out.println("이름:"+name);
		System.out.println("아이디:"+id);
		System.out.println("비밀번호:"+pwd);
		System.out.println("비밀번호 확인:"+pwdC);
		System.out.println("생년월일:"+birth);
		System.out.println("성별:"+sex);
		System.out.println("주소:"+addr);
		System.out.println("휴대전화번호:"+num);
		System.out.println("SMS 수신여부(Y/N):"+sms);
		System.out.println("이메일:"+mail);
		System.out.println("정보수신메일(Y/N):"+info);
	}
	Join(String name,String id,String pwd,String pwdC,int birth,String sex,
			String addr,String num, boolean sms,String mail,boolean info)
	{
		System.out.println("this="+this);
	}
}
public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Join j=new Join();
		Scanner scan=new Scanner(System.in);
		System.out.print("이름:");
		String name=scan.next();
		System.out.print("아이디:");
		String id=scan.next();
		System.out.print("비밀번호:");
		String pwd=scan.next();
		System.out.print("비밀번호 확인:");
		String pwdC=scan.next();
		System.out.print("생년월일:");
		String birth=scan.next();
		System.out.print("성별:");
		String sex=scan.next();
		System.out.print("주소:");
		String addr=scan.next();
		System.out.print("휴대전화번호:");
		String num=scan.next();
		System.out.print("SMS 수신여부(Y/N):");
		String sms=scan.next();
		System.out.print("이메일:");
		String mail=scan.next();
		System.out.print("정보수신메일(Y/N):");
		String info=scan.next();

	}

}
