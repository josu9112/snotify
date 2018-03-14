package snotify;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

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

public class Main {

	private static ArrayList<PublicTransportation> pt;
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileReader("C:\\Users\\John\\Desktop\\vast.txt"));
		String id = scan.nextLine();
		id = id.substring(id.indexOf(" ")+1);
		String secret = scan.nextLine();
		secret = secret.substring(secret.indexOf(" ")+1);
		scan.close();
		Token token = new Token(id, secret);
		DepartureBoard dep = new DepartureBoard(token);
		
		
		dep.setStartId("9021014019110000");
		dep.setTime("16:00");
//		dep.setTimeSpan(1440);
		dep.setDate("2018-03-10");
//		String date = "2018-03-05";
//		int day = 5;
//		pt = new ArrayList<PublicTransportation>();
		
		JSONObject obj = dep.executeRequest();
		JSONArray arr = null;
		try {
			arr = obj.getJSONArray("Departure");
		}catch(Exception e) {
			System.out.println("Inga åkturer");
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		
		
		
		if(arr != null) {
			for(int i = 0; i < arr.length(); i++) {
//				PrintWriter print = new PrintWriter(arr.getJSONObject(i).getString("sname").toString()+".txt");
				
				JourneyDetail temp = new JourneyDetail(token);
				temp.setJourneyDetailRefLink(arr.getJSONObject(i).getJSONObject("JourneyDetailRef").get("ref").toString());
				System.out.println(temp.executeRequest().toString());
				
//				for(int j = 0; j < array.length(); j++) 
//					print.println(array.getJSONObject(j).toString());
//					
//				print.close();
			}
		}		
		
		
		
		
		
		
		
		
		
		
		
		/* Kod för att få ut alla linjer från en station, alla veckodagar*/
//		for(int i = 5; i <= 11; i++) {
//			
//			if(day>=10) {
//				date = date.substring(0, date.length()-2)+day;
//				dep.setDate(date);
//			}
//			else {
//				date = date.substring(0, date.length()-1)+day;
//				dep.setDate(date);
//			}
//			
//			JSONObject obj = dep.executeRequest();
//			JSONArray arr = null;
//			if(obj != null) {
//				try {
//					arr = obj.getJSONArray("Departure");
//				}catch(Exception e) {
//					obj = obj.getJSONObject("Departure");
//				}
//			}
//			
//			if(arr != null) {
//				for(int j = 0; j < arr.length(); j ++) {
//					JSONObject tempObj = arr.getJSONObject(j);
//					if(!tempObj.has("booking")) {
//						PublicTransportation temp = new PublicTransportation(tempObj.get("sname").toString(), tempObj.get("name").toString(), tempObj.get("journeyid").toString(), tempObj.get("JourneyDetailRef").toString());
//						addPT(temp,date);
//					}
//				}
//			}
//			else if(obj != null) {
//				if(!obj.has("booking")) {
//					PublicTransportation temp = new PublicTransportation(obj.get("sname").toString(), obj.get("name").toString(), obj.get("journeyid").toString(), obj.get("JourneyDetailRef").toString());
//					addPT(temp,date);
//				}
//			}
//			
//			day++;
//		}
//		
//		PrintWriter writer = new PrintWriter("linjerkba.txt");
//		writer.print("Typ ; "+"Linje ; "+"JourneyID ; "+"Dagar ; "+"JourneyIDRef");
//		for(PublicTransportation a : pt) {
//			writer.println();
//			writer.print(a.getType());
//			writer.print(" ; "+a.getLinje());
//			writer.print(" ; "+a.getJourneyid()+" ; ");
//			ArrayList<String> days = a.getDays();
//			for(int i = 0; i < days.size(); i++) {
//				if(i==0)
//					writer.print(days.get(i));
//				else 
//					writer.print(", "+days.get(i));
//			}
//			writer.print(" ; "+a.getJourneyDetailRef());
//		}
		
		
//		JSONObject obj = dep.executeRequest();
//		JSONArray arr = null;
//		if(obj != null) {
//			try {
//				arr = obj.getJSONArray("Departure");
//			}catch(Exception e) {
//				obj = obj.getJSONObject("Departure");
//			}
//		}
//		else {
//			System.out.println("No objects!");
//		}
//		
//		if(arr != null) {
//			for(int i = 0; i < arr.length(); i ++)
//				System.out.println(arr.getJSONObject(i).toString());
//		}
//		else if(obj != null) {
//			System.out.println(obj.toString());
//		}
		
	
		
		
		
		
		
//		JourneyDetail det = new JourneyDetail(token);
//		det.setJourneyDetailRefLink("https://api.vasttrafik.se/bin/rest.exe/v2/journeyDetail?ref=143070%2F69073%2F402086%2F153354%2F80%3Fdate%3D2018-02-28%26station_evaId%3D4945001%26station_type%3Ddep%26format%3Djson%26");
//		det.executeRequest();
		
//		JourneyDetail det2 = new JourneyDetail(token);
//		
//		det2.setJourneyDetailRefLink("https://api.vasttrafik.se/bin/rest.exe/v2/journeyDetail?ref=157491%2F66731%2F48072%2F28473%2F80%3Fdate%3D2018-02-28%26station_evaId%3D4945001%26station_type%3Ddep%26format%3Djson%26");
//		det2.executeRequest();
		
		
//		LocationName loc = new LocationName(token);
//		loc.setLocationName("Kungsbacka");
		
//		NearbyStops nearAdd = new NearbyStops(token);
//		nearAdd.setCoordLat("57.489536");
//		nearAdd.setCoordLong("12.0800506");

		
//		JSONArray arr = dep.executeRequest();
//		
//		for(int i = 0; i < arr.length(); i++)
//			System.out.println(arr.get(i));
		
		
		/* Sålla stationer */
//		Scanner scan = new Scanner(new FileReader("C:\\Users\\John\\workspace\\snotify\\allstops3.txt"));
//		StringBuilder builder = new StringBuilder();
//		while(scan.hasNextLine())
//			builder.append(scan.nextLine());
//		scan.close();
//		String trimmedstring = builder.toString();
//		
//		JSONArray arr = new JSONObject(trimmedstring).getJSONArray("StopLocation");
//		JSONArray noDuplicates = new JSONArray();
//		
//		PrintWriter writer2 = new PrintWriter("allstops1.txt");
//		writer2.print("{\"StopLocation\":[");
//		for(int i = 0; i < arr.length(); i++) {
//			JSONObject obj = arr.getJSONObject(i);
//			
//			if(!obj.has("track")) { 
//				if(i != 0)
//					writer2.print("," + arr.get(i).toString());
//				else
//					writer2.print(arr.get(i).toString());
//			}
//		}
//		writer2.print("]}");
//		writer2.close();
		
	}
	
	private static void addPT(PublicTransportation toBeChecked, String date) {
		
		for(PublicTransportation a : pt) {
			if(a.compareTo(toBeChecked)) {
				a.setWeekdayDay(date);
				return;
			}
		}
		toBeChecked.setWeekdayDay(date);
		pt.add(toBeChecked);
	}
	
	

}
