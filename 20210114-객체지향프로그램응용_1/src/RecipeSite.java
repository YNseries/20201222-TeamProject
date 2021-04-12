// ���� �б� => recipe.json
import java.io.*;  // ���� �����, �޸� �����, ��Ʈ��ũ ����

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 *    1. �䱸���� �м�
 *    2. ���α׷��� �����ϱ� ���� => �����߻��� ���� ����
 */
public class RecipeSite {
	public Recipe[] recipeAllData()  // instance method
	{
		Recipe[] recipe=new Recipe[146854];
		StringBuffer data=new StringBuffer();
		// IO => ����ó�� �ؾ���
		try
		{
			// ������� ����
			// ������ �о ���ڿ��� ����
			FileReader fr=new FileReader("c:\\javaDev\\recipe.json");
			int i=0;  // ����: 1���ڸ� �д´� => ���ڹ�ȣ. ������ ���������� �о����
			// -1: ������ ��(EOF, BOF) - End Of File/Begin Of File
			while((i=fr.read())!=-1)
			{
				data.append(String.valueOf((char)i));
			}
			fr.close();
			
			String json=data.toString();
			// System.out.println(json);
			JSONParser parser=new JSONParser();
			JSONObject re=(JSONObject)parser.parse(json);
			JSONArray arr=(JSONArray)re.get("recipe");
			System.out.println("arr="+arr);
			System.out.println(arr.size());
			for(i=0;i<arr.size();i++)
			{
				JSONObject obj=(JSONObject)arr.get(i);
				recipe[i]=new Recipe();
				String a=((String)obj.get("no"));
				System.out.println("a="+a);
				recipe[i].setNo(Integer.parseInt(a));
				recipe[i].setTitle((String)obj.get("title"));
				// 1. Ŭ���� ����ȯ, ����ó��, ���̺귯��(����ȭ)
				recipe[i].setChef((String)obj.get("chef"));
				recipe[i].setPoster((String)obj.get("poster"));
				recipe[i].setLink((String)obj.get("link"));  // setxxx: ���� �޼ҵ�
			}
			
		}catch(Exception ex) {
			// ������ �� ��츦 ����ϴ� ���α׷�
			ex.printStackTrace();
		}
		return recipe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeSite rs=new RecipeSite();  // recipeAllData()�� ����ȴ�
		Recipe[] recipe=rs.recipeAllData();
		System.out.println("===================== ������ ��� =====================");
		for(Recipe r:recipe)
		{
			System.out.println("��ȣ:"+r.getNo());  // �޸� ���� �о�� �� getXxx() => �޼ҵ带 �̿��ؼ� ���
			System.out.println("����:"+r.getTitle());
			System.out.println("����:"+r.getChef());
			System.out.println(r.getHit());
			System.out.println("====================================================");
		}

	}

}
