package snotify;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PublicTransportation {

	private String journeyid;
	private String type;
	private String linje;
	private ArrayList<String> days;
	private String journeyDetailRef;
	
	
	
	public PublicTransportation(String type, String linje, String journeyid, String journeyDetailRef) {
		this.type = type;
		this.linje = linje;
		this.journeyid = journeyid;
		this.journeyDetailRef = journeyDetailRef;
		days = new ArrayList<String>();
		
	}
	
	public PublicTransportation(String type, String linje, String journeyid, String journeyDetailRef, String weekday) {
		this.type = type;
		this.linje = linje;
		this.journeyid = journeyid;
		this.journeyDetailRef = journeyDetailRef;
		days = new ArrayList<String>();
		days.add(weekday);
	}
		
	
	public boolean compareTo(PublicTransportation pt) {
		return (this.journeyid.equals(pt.journeyid)) ? true : false;
	}
	
	
	public void setWeekdayDay(String date) {
		String weekday = determineWeekday(date);
		
		for(String a : this.days) {
			if(a.equals(weekday))
				return;
		}
		this.days.add(weekday);
	}

	public String getJourneyid() {
		return journeyid;
	}

	public String getType() {
		return type;
	}

	public String getLinje() {
		return linje;
	}

	public ArrayList<String> getDays() {
		return days;
	}

	public String getJourneyDetailRef() {
		return journeyDetailRef;
	}
	
	private static String determineWeekday(String date){
		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = null;
		try {
			dt1 = format1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		return format2.format(dt1);
	}
	
}
