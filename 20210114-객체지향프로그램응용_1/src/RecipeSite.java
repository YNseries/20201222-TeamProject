// 파일 읽기 => recipe.json
import java.io.*;  // 파일 입출력, 메모리 입출력, 네트워크 입출

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 *    1. 요구사항 분석
 *    2. 프로그램을 제작하기 전에 => 에러발생에 대한 예측
 */
public class RecipeSite {
	public Recipe[] recipeAllData()  // instance method
	{
		Recipe[] recipe=new Recipe[146854];
		StringBuffer data=new StringBuffer();
		// IO => 예외처리 해야함
		try
		{
			// 정상수행 문장
			// 파일을 읽어서 문자열로 저장
			FileReader fr=new FileReader("c:\\javaDev\\recipe.json");
			int i=0;  // 단점: 1글자를 읽는다 => 문자번호. 때문에 정수형으로 읽어야함
			// -1: 파일의 끝(EOF, BOF) - End Of File/Begin Of File
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
				// 1. 클래스 형변환, 예외처리, 라이브러리(최적화)
				recipe[i].setChef((String)obj.get("chef"));
				recipe[i].setPoster((String)obj.get("poster"));
				recipe[i].setLink((String)obj.get("link"));  // setxxx: 쓰기 메소드
			}
			
		}catch(Exception ex) {
			// 에러가 날 경우를 대비하는 프로그램
			ex.printStackTrace();
		}
		return recipe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeSite rs=new RecipeSite();  // recipeAllData()가 저장된다
		Recipe[] recipe=rs.recipeAllData();
		System.out.println("===================== 레시피 목록 =====================");
		for(Recipe r:recipe)
		{
			System.out.println("번호:"+r.getNo());  // 메모리 값을 읽어올 때 getXxx() => 메소드를 이용해서 통신
			System.out.println("제목:"+r.getTitle());
			System.out.println("쉐프:"+r.getChef());
			System.out.println(r.getHit());
			System.out.println("====================================================");
		}

	}

}
