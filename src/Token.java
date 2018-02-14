import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.joda.time.LocalDate;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;


public class Token {

	private TokenResponse response;

	public Token(String client_id, String client_secret) {
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

	public static void main(String[] args) throws IOException {
		Token token = new Token("sSIf0MwMXPU2fgxgetm5_zd7Mc4a", "Ang2fYUT2o4Lb1gv3ez_TSxKMMoa");
		HttpTransport trans = new NetHttpTransport();
//		JacksonFactory json = new JacksonFactory();
		
		HttpRequestFactory requestFact = trans.createRequestFactory(new HttpRequestInitializer() {
			@Override
			public void initialize(HttpRequest request) {
				request.getHeaders().setAuthorization("Bearer " + token.getAccessToken());
			}
		});
		LocalDate date = new LocalDate();
		String time = java.time.LocalTime.now().toString().substring(0,5);
		ArrayList<String> datelist = new ArrayList<String>();
		
		HttpRequest req = requestFact.buildGetRequest(new GenericUrl("https://api.vasttrafik.se/bin/rest.exe/v2/departureBoard"));
		req.setHeaders(new HttpHeaders().setAuthorization("Bearer " + token.getAccessToken())
				.set("id", "789L").set("date", date).set("time", time).set("direction", "789L"));
		HttpResponse resp = req.execute();
		System.out.println(resp.parseAsString());
		
	}

}
