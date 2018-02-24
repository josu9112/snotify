package snotify;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;


/**
 * @author John Sundemo & Rustam Stanikzai
 *	Class Token is used to create and recieve an access-token from Västtrafik.
 */
public class Token {

	private TokenResponse response;
	private String client_id;
	private String client_secret;
	
	
	/**
	 * Constructs a Token.
	 * @param client_id from vasttrafik encoded with Base64
	 * @param client_secret from vasttrafik encoded with Base64
	 */
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

	/**
	 * Get acces-token in a String
	 * @return Returns the access-token
	 */
	public String getAccessToken() {
		return response.getAccessToken();
	}
	
	
	/**
	 * Renews access-token
	 */
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
		Scanner scan = new Scanner(new FileReader("C:\\Users\\John\\Desktop\\vast.txt"));
		
		String id = scan.nextLine();
		id = id.substring(id.indexOf(" ")+1);
		String secret = scan.nextLine();
		secret = secret.substring(secret.indexOf(" ")+1);
		
		scan.close();
		
		Token token = new Token(id, secret);
		
//		DepartureBoard dep = new DepartureBoard(token);
//		dep.setStartId("9022014019110016");
//		dep.setTime("18:10");
//		dep.setDate("2018-02-19");
		
//		LocationName loc = new LocationName(token);
//		loc.setLocationName("Kungsbacka");
		
//		NearbyStops nearAdd = new NearbyStops(token);
//		nearAdd.setCoordLat("57.489536");
//		nearAdd.setCoordLong("12.0800506");
//		
//		JSONArray arr = nearAdd.executeRequest();
//		
//		for(int i = 0; i < arr.length(); i++)
//			System.out.println(arr.get(i));
		
	}

}
