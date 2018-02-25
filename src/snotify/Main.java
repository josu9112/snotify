package snotify;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

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
