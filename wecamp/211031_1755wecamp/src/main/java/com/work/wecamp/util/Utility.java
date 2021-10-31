package com.work.wecamp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;


public class Utility {
	public static String getCurrentDate() {

		SimpleDateFormat today = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		String strToday = today.format(calendar.getTime());
		return strToday;

	}
}
