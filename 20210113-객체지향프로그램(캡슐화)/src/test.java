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
		System.out.println("�̸�:"+name);
		System.out.println("���̵�:"+id);
		System.out.println("��й�ȣ:"+pwd);
		System.out.println("��й�ȣ Ȯ��:"+pwdC);
		System.out.println("�������:"+birth);
		System.out.println("����:"+sex);
		System.out.println("�ּ�:"+addr);
		System.out.println("�޴���ȭ��ȣ:"+num);
		System.out.println("SMS ���ſ���(Y/N):"+sms);
		System.out.println("�̸���:"+mail);
		System.out.println("�������Ÿ���(Y/N):"+info);
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
		System.out.print("�̸�:");
		String name=scan.next();
		System.out.print("���̵�:");
		String id=scan.next();
		System.out.print("��й�ȣ:");
		String pwd=scan.next();
		System.out.print("��й�ȣ Ȯ��:");
		String pwdC=scan.next();
		System.out.print("�������:");
		String birth=scan.next();
		System.out.print("����:");
		String sex=scan.next();
		System.out.print("�ּ�:");
		String addr=scan.next();
		System.out.print("�޴���ȭ��ȣ:");
		String num=scan.next();
		System.out.print("SMS ���ſ���(Y/N):");
		String sms=scan.next();
		System.out.print("�̸���:");
		String mail=scan.next();
		System.out.print("�������Ÿ���(Y/N):");
		String info=scan.next();

	}

}
