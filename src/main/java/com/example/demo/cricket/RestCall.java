package com.example.demo.cricket;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestCall {

	public static void main(String[] args) throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api-eu1.tatum.io/v3/ethereum/wallet";
		String project_key = "RS_P_1545962206745726979";
		String api_key = "RS5:f726436167fc7ea9a7e3aaab3e7cbec7";
		String body = "{\n  \"api_key\": \"" + api_key + "\"\n}";
		String token="";

		String url1 = "https://api.sports.roanuz.com/v5/core/" + project_key + "/auth/";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(body,headers);
		String ans = restTemplate.exchange(url1, HttpMethod.POST, entity, String.class).getBody();
//		System.err.println(ans.toString());
		
	    JSONObject myResponse = new JSONObject(ans);
	    
//	    System.err.println(myResponse);
	    
//	    System.out.println("Token is " + myResponse.get("data"));
	    
	    JSONObject data_object=new JSONObject(myResponse.getJSONObject("data").toString());
	    
	    
//	    System.out.println("data -"+data_object);
	    
	
	    token=data_object.getString("token");
	    
//	    System.out.println(token);
	    System.out.println("-----------------------------------------------------------------");
	    
	    String url2 = "https://api.sports.roanuz.com/v5/cricket/"+project_key+"/featured-matches/";
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("rs-token", token);
		HttpEntity<String> entity1 = new HttpEntity<String>(headers1);
		String ans2 = restTemplate.exchange(url2, HttpMethod.GET, entity1, String.class).getBody();
		
//		System.out.println(ans2.toString());
		
		JSONObject myResponse1 = new JSONObject(ans2);
		
//		System.out.println(myResponse1);
		
		JSONObject data_object2=new JSONObject(myResponse1.getJSONObject("data").toString());
		
		String matches=data_object2.get("matches").toString();
		
		String matches1=matches.substring(1);
		
//		System.out.println(matches1);
		
		JSONObject play = new JSONObject(matches1);
//		System.out.println(play);
		
		JSONObject play1=new JSONObject(play.getJSONObject("players").toString());
//		System.out.println(play1);
		
        String player=play.getJSONObject("players").toString();
        
        JSONObject play2 = new JSONObject(player);
        System.out.println(play2);
        
        JSONObject play22=new JSONObject(play2.getJSONObject("va_chakravathi").toString());
        
        String player_score=play2.getJSONObject("va_chakravathi").toString();
        
       
        
        
        
        		
        
        
//        System.out.println(score1);
        
//        System.out.println(player);
//		
//		String player1=matches.substring(1);
//		
//		JSONObject play2 = new JSONObject(player1);
		
//		JSONObject play11=new JSONObject(play2.getJSONObject("play").toString());
//		
		
//		System.out.println(play2);
		
		
		
	
		
		
		
		
		
		
	    
	}
}
