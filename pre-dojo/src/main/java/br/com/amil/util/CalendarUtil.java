package br.com.amil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	
	private CalendarUtil() {
	}
	
	
	public static Calendar toCalendar(String time, String pattern) {
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar toCalendar = null;
		try {
			Date date = format.parse(time);
			toCalendar = Calendar.getInstance();
			toCalendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return toCalendar;
		  
	}
	
}
