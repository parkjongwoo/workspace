import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.naverapi.search.condition.NaverSearchCondition;

public class NaverAPIHadoopSourceMain {

	public static void main(String[] args) {
		String clientId = "CEz8ZdrjBgnlIRgBQ1n5";
		String clientSecret = "AKZk6r1F8_";
		NaverSearchCondition condition = new NaverSearchCondition();
		condition.setQuery("해리포터");
		condition.setDisplay(100);
		try {
//			String text = URLEncoder.encode(keyword, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book.json" + condition.buidQueryString(); // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			System.out.println("apiURL:" + apiURL);
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer jsonResult = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				jsonResult.append(inputLine);
			}

			br.close();
			JSONObject json = new JSONObject(jsonResult.toString());
			jsonResult.setLength(0);
			JSONArray list = json.getJSONArray("items");
			JSONObject item = null;

			for (int i = 0; i < list.length(); i++) {
				item = list.getJSONObject(i);
				jsonResult.append(item.get("image")).append(',');
				jsonResult.append(item.get("title")).append(',');
				jsonResult.append(item.get("publisher")).append(',');
				jsonResult.append(item.get("author")).append(',');
				jsonResult.append(item.get("isbn")).append(',');
				jsonResult.append(item.get("price")).append(',');
				jsonResult.append(item.get("pubdate")).append('\n');
			}
//			System.out.println(jsonResult.toString());

			File file = new File("./movie-batch-log/moviedata.txt");

			try {
				// 파일에 문자열을 쓴다.
				// 하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
				// 파일이 손산될 우려가 있다.
				FileWriter fw = new FileWriter(file);
				fw.write(jsonResult.toString());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
