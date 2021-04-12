import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ChefManager extends Object{
	public Chef[] chefAllData()
	{
		Chef[] chef=new Chef[500];
		try
		{	
			int k=0;
			for(int i=1;i<=5;i++)
			{
				Document doc=Jsoup.connect("https://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page="+i).get();
				// System.out.println(doc);
				Elements chef_name=doc.select("a.info_name_f");
				Elements mc1=doc.select("span.mem_cont1");
				Elements mc2=doc.select("span.mem_cont2");
				Elements mc3=doc.select("span.mem_cont3");
				Elements mc7=doc.select("span.mem_cont7");
				for(int j=0;j<chef_name.size();j++)
				{
					/* System.out.println(chef_name.get(j).text());
					System.out.println(mc1.get(j).text());
					System.out.println(mc2.get(j).text());
					System.out.println(mc3.get(j).text());
					System.out.println(mc7.get(j).text());
					System.out.println("======================"); */
					chef[k]=new Chef();   // 실제값은 이렇게 해야 저장됨
					chef[k].setChef(chef_name.get(j).text());
					chef[k].setMc1(mc1.get(j).text());
					chef[k].setMc1(mc2.get(j).text());
					chef[k].setMc1(mc3.get(j).text());
					chef[k].setMc1(mc7.get(j).text());
					k++;
				}
			}
		}catch(Exception ex){}
		return chef;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChefManager cm=new ChefManager();
		Chef[] chef=cm.chefAllData();
		for(Chef c:chef)
		{
			System.out.println("이름:"+c.getChef());
			System.out.println("레시피:"+c.getMc1());
			System.out.println("스크랩:"+c.getMc3());
			System.out.println("방문자:"+c.getMc7());
			System.out.println("소식지:"+c.getMc2());
		}
	}

}
