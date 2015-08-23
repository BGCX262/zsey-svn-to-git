package cn.com.kington.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڲ���������
 * @author ������
 *
 */
public class DateTools {
	
	public static String formatDate(Date date, String pattern) {
		if (date == null){
			throw new IllegalArgumentException("date is null");
		}
		
		if (pattern == null){
			throw new IllegalArgumentException("pattern is null");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		
		return formatter.format(date);
	}
	
	public static String formatDate(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
}
