package snotify;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class NearbyStops {

	private Token token;
	private final String baseRequestAddress = "https://api.vasttrafik.se/bin/rest.exe/v2/location.nearbystops";
	private String coordLat;
	private String coordLon;
	private int maxNo;
	private int maxDist;
	
	
	public NearbyStops(Token token) {
		this.token = token;
		this.coordLat = null;
		this.coordLon = null;
		this.maxNo = 0;
		this.maxDist = 0;
	}
	
	public void setCoordLat(String coordLat) {
		this.coordLat = coordLat;
	}
	
	public void setCoordLon(String coordLon) {
		this.coordLon = coordLon;
	}
	
	public void setMaxNo(int maxNo) {
		this.maxNo = maxNo;
	}
	
	public void setMaxDist(int maxDist) {
		this.maxDist = maxDist;
	}
	
	public JSONArray excecuteRequest() throws IOException {
		String requestLink = buildRequestLink();
		if(requestLink == null)
			return null;
		
		HttpTransport trans = new NetHttpTransport();
		
		HttpRequestFactory requestFact = trans.createRequestFactory(new HttpRequestInitializer() {
			@Override
			public void initialize(HttpRequest request) {
				request.getHeaders().setAuthorization("Bearer " + token.getAccessToken());
			}
		});
		
		HttpRequest req = requestFact.buildGetRequest(new GenericUrl(requestLink));
		req.setHeaders(new HttpHeaders().setAuthorization("Bearer " + this.token.getAccessToken()));
		req.setConnectTimeout(30000);
		req.setReadTimeout(30000);
		HttpResponse resp = req.execute();
		
		String jsonresponse = resp.parseAsString();
		String trimmedstring = "{" + jsonresponse.substring(jsonresponse.indexOf("\"StopLocation\""), jsonresponse.length()-1);
		
		return new JSONObject(trimmedstring).getJSONArray("StopLocation");
	}
	
	private String buildRequestLink() {
		if(this.coordLon == null || this.coordLat == null)
			return null;
		
		String stringRequest = baseRequestAddress + "?originCoordLat=" + this.coordLat + "&originCoordLong=" + this.coordLon;
		
		if(this.maxNo != 0)
			stringRequest = stringRequest + "&maxNo=" + maxNo;
		if(this.maxDist != 0)
			stringRequest = stringRequest + "&maxDist=" + maxDist;
		
		return stringRequest + "&format=json";
	}
	
}
