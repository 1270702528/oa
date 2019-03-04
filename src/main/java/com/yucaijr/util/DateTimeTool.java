package com.yucaijr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeTool {

	private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final long MILLI_SECONDS_DAY = 24 * 60 * 60 * 1000;// 一天的毫秒数


	
	/**
	 * 获取两个Date之间包含的日期
	 * 
	 * @param start
	 * @param end
	 */
	public static List<Object> getDates(Date start, Date end) {
		int size = (int) ((end.getTime() - start.getTime()) / MILLI_SECONDS_DAY);
		List<Object> dates = new ArrayList<Object>(size + 1);
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);

		dates.add(SHORT_DATE_FORMAT.format(cal.getTime()));
		for (int i = 0; i < size; i++) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			dates.add(SHORT_DATE_FORMAT.format(cal.getTime()));
		}
		return dates;
	}

	

	/**
	 * 获取两个Date之间包含的日期
	 * 
	 * @param d1
	 * @param d2
	 */
	public static List<Object> getDates(String d1, String d2) {
		try {
			if(d1==null || d1.equals("") ||d2.equals("") || d2.equals("")) {
				Date date=new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DAY_OF_YEAR,  -6);
				return getDates(cal.getTime(), date);
			}
			return getDates(SHORT_DATE_FORMAT.parse(d1), SHORT_DATE_FORMAT.parse(d2));
		} catch (ParseException e) {
		}
		return null;
	}

	

	public static String getToday() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		
		return sdf.format(new Date());
	}

}
