package snotify;

import java.io.IOException;

import org.json.JSONArray;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;





public class Token {

	private TokenResponse response;
	private String client_id;
	private String client_secret;
	
	
	public Token(String client_id, String client_secret) {
		this.client_id = client_id;
		this.client_secret = client_secret;
		try {
			response = new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
					new GenericUrl("https://api.vasttrafik.se/token"), "POST")
							.set("redirect_uri", "https://api.vasttrafik.se/token").set("client_id", client_id)
							.set("client_secret", client_secret).set("grant_type", "client_credentials")
							.set("Content-type", "application/x-www-form-urlencoded").execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getAccessToken() {
		return response.getAccessToken();
	}
	
	public void renewToken() {
		try {
			response = new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
					new GenericUrl("https://api.vasttrafik.se/token"), "POST")
							.set("redirect_uri", "https://api.vasttrafik.se/token").set("client_id", client_id)
							.set("client_secret", client_secret).set("grant_type", "client_credentials")
							.set("Content-type", "application/x-www-form-urlencoded").execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) throws IOException {
		Token token = new Token("sSIf0MwMXPU2fgxgetm5_zd7Mc4a", "Ang2fYUT2o4Lb1gv3ez_TSxKMMoa");
		
//		DepartureBoard dep = new DepartureBoard(token);
//		dep.setStartId("9022014019110016");
//		dep.setTime("18:10");
//		dep.setDate("2018-02-19");
		
//		LocationName loc = new LocationName(token);
//		loc.setLocationName("Kungsbacka");
		
		NearbyStops nearAdd = new NearbyStops(token);
		nearAdd.setCoordLat("57.489536");
		nearAdd.setCoordLon("12.0800506");
		
		JSONArray arr = nearAdd.excecuteRequest();
		for(int i = 0; i < arr.length(); i++)
			System.out.println(arr.get(i));
	}

}
