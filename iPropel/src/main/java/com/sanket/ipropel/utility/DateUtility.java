package com.sanket.ipropel.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	public static Date returnIncrementedDate(int numberToIncrement) {

		String dt = "2017-04-20"; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DATE, numberToIncrement); // number of days to add
		dt = sdf.format(c.getTime()); // dt is now the new date

		try {
			return sdf.parse(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return null;
		}

	}
	
	public static long returnDateDifferenceInMinutes(Date newDate, Date oldDate){
		
		try{
			long diff = newDate.getTime() - oldDate.getTime();
		

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		System.out.println("Difference in Minutes: "+ diff);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
		
		if(diffSeconds>100){
			return diffSeconds;
		}
		else if(diffMinutes>100){
			return diffMinutes;
		}else if(diffHours>100){
			return diffHours;
		}else{
			return diffDays;
		}
		}catch(DateTimeException e){
			e.printStackTrace();
			return 0;
		}
		
		
		
	}

	/*
	 * public static void main(String[] args){
	 * System.out.println("Date is: "+returnIncrementedDate(10)); }
	 */

}
