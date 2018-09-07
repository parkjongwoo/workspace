package com.naverapi.search.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naverapi.search.condition.NaverSearchCondition;

/**
 * naver API 예제 및 \@ResponseBody,produces 사용한 json 응답.
 * 
 *  
 * 
 * @author goott3-4
 *
 */
@Controller
public class NaverBookSearchController {

	@RequestMapping(value = "/booksearch", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String getBook(NaverSearchCondition condition) {
		System.out.println("keyword:" + condition.toString());
		String clientId = "CEz8ZdrjBgnlIRgBQ1n5";
		String clientSecret = "AKZk6r1F8_";
		
		StringBuffer response = null;
		try {
//			String text = URLEncoder.encode(keyword, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/book.json" + condition.buidQueryString(); // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			System.out.println("apiURL:"+apiURL);
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
			response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
//			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(response==null) {			
			return "{\"result\":\"nodata\"}";
		}else {
			
			return response.toString();
		}
	}
}
