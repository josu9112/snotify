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

public class DepartureBoard {

	private Token token;
	private final String baseRequestAddress = "https://api.vasttrafik.se/bin/rest.exe/v2/departureBoard";
	private String startId;
	private String stopId;
	private String date;
	private String time;
	private int useVasttag;
	private int useLongDistanceTrain;
	private int useRegionalTrain;
	private int useBus;
	private int useBoat;
	private int useTram;
	private int excludeDR;
	private int timeSpan;
	private int maxDeparturesPerLine;
	private int needJourneyDetail;
	
	public DepartureBoard(Token token) {
		this.token = token;
		resetParameters();
	}
	
	public void setAllParameters(String startId, String date, String time, boolean useVasttag, boolean useLongDistanceTrain, boolean useRegionalTrain,
			boolean useBus, boolean useBoat, boolean useTram, boolean excludeDR, int timeSpan, int maxDeparturesPerLine, boolean needJourneyDetail,
			String stopId) {
		this.startId = startId;
		this.date = date;
		this.time = time;
		this.stopId = stopId;
		this.stopId = stopId;
		this.timeSpan = timeSpan;
		this.maxDeparturesPerLine = maxDeparturesPerLine;
		if(useVasttag) {this.useVasttag = 1;} else {this.useVasttag = 0;}
		if(useLongDistanceTrain) {this.useLongDistanceTrain = 1;} else {this.useLongDistanceTrain = 0;}
		if(useRegionalTrain) {this.useRegionalTrain = 1;} else {this.useRegionalTrain = 0;}
		if(useBus) {this.useBus = 1;} else {this.useBus = 0;}
		if(useBoat) {this.useBoat = 1;} else {this.useBoat = 0;}
		if(useTram) {this.useTram = 1;} else {this.useTram = 0;}
		if(excludeDR) {this.excludeDR = 1;} else {this.excludeDR = 0;}
		if(needJourneyDetail) {this.needJourneyDetail = 1;} else {this.needJourneyDetail = 0;}
	}
	
	public void resetParameters() {
		this.startId = null;
		this.date = null;
		this.time = null;
		this.stopId = null;
		this.stopId = null;
		this.timeSpan = 0;
		this.maxDeparturesPerLine = 0;
		this.useVasttag = 1;
		this.useLongDistanceTrain = 1;
		this.useRegionalTrain = 1;
		this.useBus = 1;
		this.useTram = 1;
		this.excludeDR = 1;
		this.needJourneyDetail = 1;
	}
	 
	public void setStartId(String startId){
		this.startId = startId;
	}
	
	public void setStopId(String stopId){
		this.stopId = stopId;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public void setTimeSpan(int timeSpan) {
		this.timeSpan = timeSpan;
	}
	
	public void setMaxDeparturesPerLine(int maxDeparturesPerLine) {
		this.maxDeparturesPerLine = maxDeparturesPerLine;
	}
	
	public void setUseVasttag(boolean useVasttag) {
		if(useVasttag) {this.useVasttag = 1;} else {this.useVasttag = 0;}
	}
	
	public void setUseLongDistanceTrain(boolean useLongDistanceTrain) {
		if(useLongDistanceTrain) {this.useLongDistanceTrain = 1;} else {this.useLongDistanceTrain = 0;}
	}
	
	public void setUseRegionalTrain(boolean useRegionalTrain) {
		if(useRegionalTrain) {this.useRegionalTrain = 1;} else {this.useRegionalTrain = 0;}
	}
	
	public void setUseBus(boolean useBus) {
		if(useBus) {this.useBus = 1;} else {this.useBus = 0;}
	}
	
	public void setUseBoat(boolean useBoat) {
		if(useBoat) {this.useBoat = 1;} else {this.useBoat = 0;}
	}
	
	public void setUseTram(boolean useTram) {
		if(useTram) {this.useTram = 1;} else {this.useTram = 0;}
	}
	
	public void setExcludeDR(boolean excludeDR) {
		if(excludeDR) {this.excludeDR = 1;} else {this.excludeDR = 0;}
	}
	
	public void setNeedJourneyDetail(boolean needJourneyDetail) {
		if(needJourneyDetail) {this.needJourneyDetail = 1;} else {this.needJourneyDetail = 0;}
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
		String trimmedstring = "{" + jsonresponse.substring(jsonresponse.indexOf("\"Departure\""), jsonresponse.length()-1);
		
		return new JSONObject(trimmedstring).getJSONArray("Departure");
	}
	
	private String buildRequestLink() {
		if(this.startId == null || this.date == null || this.time == null)
			return null;
		
		String requestLink = baseRequestAddress + "?id=" + this.startId + "&date=" + this.date + "&time=" + this.time;
		
		if(this.stopId != null)
			requestLink = requestLink + "&direction=" + this.stopId;
		if(this.useVasttag == 0)
			requestLink = requestLink + "&useVas=0";
		if(this.useLongDistanceTrain == 0)
			requestLink = requestLink + "&useLDTrain=0";
		if(this.useRegionalTrain == 0)
			requestLink = requestLink + "&useRegTrain=0";
		if(this.useBus == 0)
			requestLink = requestLink + "&useBus=0";
		if(this.useBoat == 0)
			requestLink = requestLink + "&useBoat=0";
		if(this.useTram == 0)
			requestLink = requestLink + "&useTram=0";
		if(this.excludeDR == 0)
			requestLink = requestLink + "&excludeDR=0";
		if(this.needJourneyDetail == 0)
			requestLink = requestLink + "&useLDTrain=0";
		if(this.timeSpan != 0)
			requestLink = requestLink + "&useLDTrain=" + this.timeSpan;
		if(this.maxDeparturesPerLine != 0)
			requestLink = requestLink + "&useLDTrain=" + this.maxDeparturesPerLine;
		if(this.needJourneyDetail == 0)
			requestLink = requestLink + "&useLDTrain=0";
		
		requestLink = requestLink + "&format=json";
		
		return requestLink;
	}
}
