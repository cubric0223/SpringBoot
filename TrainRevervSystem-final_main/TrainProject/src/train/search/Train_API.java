package train.search;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * @author LJH
 */
public class Train_API {
	/*
	 * 기차 API 가져오는 클래스
	 */
	String st_sub;
	String en_sub;
	String date;
	String train_nm;
	
	public Train_API(String st_sub,String en_sub,String date,String train_nm) {
		this.st_sub = st_sub;
		this.en_sub = en_sub;
		this.date = date;
		this.train_nm = train_nm;
	}
	// 기차 API 가져오는 key값
	private static String key = "cXG%2BsVlagSV2%2FrTreOPObTV1p66Hho1fOgZi0uxSNS3GGBq7xLhMe9uPRSf3u4Ya%2BoyDgW4evwP42PU18PTy0g%3D%3D";
	// API 크롤링 정보 대입
    public JSONArray train_api() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","MS949") + "="+key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","MS949") + "=" + URLEncoder.encode("1", "MS949")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","MS949") + "=" + URLEncoder.encode("100", "MS949")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("_type","MS949") + "=" + URLEncoder.encode("json", "MS949")); /*데이터 타입(xml, json)*/
        urlBuilder.append("&" + URLEncoder.encode("depPlaceId","MS949") + "=" + URLEncoder.encode(st_sub, "MS949")); /*출발기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","MS949") + "=" + URLEncoder.encode(en_sub, "MS949")); /*도착기차역ID [상세기능3. 시/도별 기차역 목록조회]에서 조회 가능*/
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","MS949") + "=" + URLEncoder.encode(date, "MS949")); /*출발일(YYYYMMDD)*/
        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","MS949") + "=" + URLEncoder.encode(train_nm, "MS949")); /*차량종류코드*/
        URL url = new URL(urlBuilder.toString()); // url 정보
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
        conn.setRequestMethod("GET"); // API 크롤링 정보 get
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        // 버퍼 리더로 API 정보 가져옴
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        // 한줄씩 읽어 오기
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        // JSON 라이브러리로 API 정보 각 파트 정보 가져오기
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
			JSONObject response = (JSONObject)jsonObject.get("response");
			JSONObject body = (JSONObject)response.get("body");
			JSONObject items = (JSONObject)body.get("items");
			System.out.println(items);
			//JSON데이터를 넣어 JSON Object 로 만들어 준다.
			        
			//배열 추출
			JSONArray array = (JSONArray) items.get("item");
			 return array;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
    }
}