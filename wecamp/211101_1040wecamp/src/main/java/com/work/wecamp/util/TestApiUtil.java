package com.work.wecamp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.work.wecamp.camp.dto.Campsite;

public class TestApiUtil {
	
	public static String requestApi(Long rows) {
		String result = "";
		try {
			
			/*기본 정보 목록 조회*/
			StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList"); /*URL*/
			
			/*서비스키*/
			
			/*5HOS89ZTrKAX6f3abOfiRAzM7LCEsAP%2FTFf4gIL1ZytuV76QhJmrmvQCgJfRftSmuih5PuXg8J3rHjHgWW3HSQ%3D%3D*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=5HOS89ZTrKAX6f3abOfiRAzM7LCEsAP%2FTFf4gIL1ZytuV76QhJmrmvQCgJfRftSmuih5PuXg8J3rHjHgWW3HSQ%3D%3D");
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=1");
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + rows );
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=ETC");
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=openAPI");
			urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=json");
			
			/*URL 완성*/
			URL url = new URL(urlBuilder.toString());
			
			System.out.println(url);
			/*연결*/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			/*GET방식, JSON 형태*/
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader bf;
	        
	        /*응답 성공/실패 여부 */
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            bf = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        String line;
	        
	        /*line에 연결된 inputSteam에서 읽어온 값을 넣는다.*/
	        while ((line = bf.readLine()) != null) {
	            sb.append(line);
	        }
	        
	        /*연결,스트림 닫기*/
	        conn.disconnect();
	        bf.close();

	        /*문자열 형태로 저장*/	     
	        result = sb.toString();
	        
	        
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		return result;
	}
	

	/*XML 형태로 가져온 것을 JSON으로 변경*/
	public static List<Map<String,Object>> getJsonList(){
		JSONArray item = null;
		Long numRows = Long.parseLong("3000");
		
		try {
			/*JSON Parsing*/
			JSONParser jp = new JSONParser();
			JSONObject obj = (JSONObject) jp.parse(requestApi(numRows));
			
	
			obj = (JSONObject)obj.get("response");
			obj = (JSONObject)obj.get("body");
			
			Long rows = (Long)obj.get("numOfRows");
			Long totalCount = (Long)obj.get("totalCount");
			
			
			
			if(rows > totalCount) {
				System.out.println("rows가 더 크다.");
			}else {
				System.out.println("totalCount가 더 크다.");
				numRows = totalCount;
				
				jp = new JSONParser();
				obj = (JSONObject) jp.parse(requestApi(numRows));
				
				obj = (JSONObject)obj.get("items");
				
				
				
				/*JSON Array*/
				item = (JSONArray) obj.get("item");
				
				return item;
			}
		
			
			
			obj = (JSONObject)obj.get("items");
			
			/*JSON Array*/
			item = (JSONArray) obj.get("item");
			
			

			// JsonArray 객체 object 변환 
//			for(int i = 0; i < item.size(); i++) {
//				jsonObj = (JSONObject) item.get(i);
//				jsonMap = new ObjectMapper().readValue(jsonObj.toJSONString(), Map.class);
//	
//				keys = jsonMap.keySet().iterator();
//			}
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	//실질적인 사용
	/*JsonArray 가져와서 하나씩 꺼내서 List 객체에 담음 */
	public static List<Campsite> getCampList(){
		Campsite campsite = null;
		
		List<Map<String,Object>> jsonCampList = getJsonList();
		List<Campsite> campList = new ArrayList<Campsite>();
		
		
		
		for(Map<String,Object> campMap : jsonCampList) {
			campsite = new Campsite();
			
			/*맵에서 가져오기*/
			for(String key : campMap.keySet()) {
				//System.out.println(String.format("키 : %s, 값 : %s",key , campMap.get(key).toString()));
				
				if (campMap.containsKey("contentId")) {
					campsite.setCampsiteNo(campMap.get("contentId").toString());
				}
				if(campMap.containsKey("facltNm")) {
					campsite.setFacltNm(campMap.get("facltNm").toString());
				}
				if(campMap.containsKey("lineIntro")) {
					campsite.setLineIntro(campMap.get("lineIntro").toString());
				}
				if(campMap.containsKey("intro")) {
					campsite.setDetailIntro(campMap.get("intro").toString());
				}
				if(campMap.containsKey("induty")) {
					campsite.setInduty(campMap.get("induty").toString());
				}
				if(campMap.containsKey("lctCl")) {
					campsite.setLctCl(campMap.get("lctCl").toString());
				}
				if(campMap.containsKey("doNm")) {
					campsite.setDoNm(campMap.get("doNm").toString());
				}
				if(campMap.containsKey("sigunguNm")) {
					campsite.setSigungu(campMap.get("sigunguNm").toString());
				}
				if(campMap.containsKey("zipcode")) {
					campsite.setZipcode(campMap.get("zipcode").toString());
				}
				if(campMap.containsKey("addr1")) {
					campsite.setAddr1(campMap.get("addr1").toString());
				}
				if(campMap.containsKey("addr2")) {
					campsite.setAddr2(campMap.get("addr2").toString());
				}
				if(campMap.containsKey("mapX")) {
					campsite.setLon(Double.parseDouble(campMap.get("mapX").toString()));
				}
				if(campMap.containsKey("mapY")) {
					campsite.setLat(Double.parseDouble(campMap.get("mapY").toString()));
				}
				if(campMap.containsKey("tel")) {
					campsite.setTel(campMap.get("tel").toString());
				}
				if(campMap.containsKey("homepage")) {
					campsite.setHomepage(campMap.get("homepage").toString());
				}
				if(campMap.containsKey("resveUrl")) {
					campsite.setResveUrl(campMap.get("resveUrl").toString());
				}
				if(campMap.containsKey("glampInnerFclty")) {
					campsite.setGlampInner(campMap.get("glampInnerFclty").toString());
				}
				if(campMap.containsKey("caravInnerFclty")) {
					campsite.setCaravanInner(campMap.get("caravInnerFclty").toString());
				}
				if(campMap.containsKey("operPdCl")) {
					campsite.setOperationP(campMap.get("operPdCl").toString());
				}
				if(campMap.containsKey("operDeCl")) {
					campsite.setOperationD(campMap.get("operDeCl").toString());
				}
				if(campMap.containsKey("trlerAcmpnyAt")) {
					campsite.setTrlerYn(campMap.get("trlerAcmpnyAt").toString());
				}
				if(campMap.containsKey("caravAcmpnyAt")) {
					campsite.setCaravYn(campMap.get("caravAcmpnyAt").toString());
				}
				if(campMap.containsKey("sbrsCl")) {
					campsite.setSbrsCl(campMap.get("sbrsCl").toString());
				}
				if(campMap.containsKey("sbrsEtc")) {
					campsite.setSbrsEtc(campMap.get("sbrsEtc").toString());
				}
				if(campMap.containsKey("posblFcltyCl")) {
					campsite.setPosblFcl(campMap.get("posblFcltyCl").toString());
				}
				if(campMap.containsKey("themaEnvrnCl")) {
					campsite.setThemaEnv(campMap.get("themaEnvrnCl").toString());
				}if(campMap.containsKey("animalCmgCl")) {
					campsite.setAnimalCmg(campMap.get("animalCmgCl").toString());
				}if(campMap.containsKey("firstImageUrl")) {
					campsite.setThumbnail(campMap.get("firstImageUrl").toString());
				}
			}
			campList.add(campsite);
		}
		
		return campList;
		
		//System.out.println(campsite.toString());
	}
	
	
	public void test(String[] args) {
		getCampList();
	}
}
