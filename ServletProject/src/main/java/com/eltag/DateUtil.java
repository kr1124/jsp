package com.eltag;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
	private static SimpleDateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd");
	public static String format(Date date) {
		return formmatter.format(date);
	}
}
