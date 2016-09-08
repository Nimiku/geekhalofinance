package cn.geekhalo.webtech.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import org.apache.log4j.Logger;

public class TimeUtil {
	private static Logger log = Logger.getLogger(TimeUtil.class);
	public static final String DATE_TIME_17 = "yyyyMMddHHmmssSSS";
	public static final String DATE_TIME_14 = "yyyyMMddHHmmss";
	public static final String DATE_TIME_12 = "yyyy-MM-dd HH:mm"; //时间格式化修复,否则时间转换错误 2015.11.09 by majg
	public static final String DATE_8 = "yyyyMMdd";
	public static final String FORMAT_DATE_10 = "yyyy-MM-dd";
	public static final String FORMAT_DATE_CN_11 = "yyyy年MM月dd日";
	public static final String FORMAT_DATE_TIME_19 = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_FOR_SIGN = "MM月dd日";
	public static String getFormatedCurrentDate() {
		SimpleDateFormat dateSDF = new SimpleDateFormat(DATE_8);
		return dateSDF.format(new java.util.Date());
	}
	public static String getFormatTodayForSign(){
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_FOR_SIGN);
		return format.format(new java.util.Date());
	}
	
	public static String  getFormartDateTime19(Date date){
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATE_TIME_19);
		return format.format(date);
	}
	
	public static String  getFormartDateTime12(Date date){
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_12);
		return format.format(date);
	}
	
	public static String  getFormartDateTime10(Date date){
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATE_10);
		return format.format(date);
	}
    /**
     * 返回当前系统时间的年月日
     *
     * @return
     */
    public static synchronized String getCurrentTime() {
        SimpleDateFormat timeformat = new SimpleDateFormat(FORMAT_DATE_TIME_19);
        Date date = new Date();
        return timeformat.format(date);
    }

	public static String getCurrentMonth() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		return getFormatedMonth(year, month);
	}
	public static int getCurrentYear(){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year;
	}
	//工作日日期转化方法
	public static String getWorkDate(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == Calendar.FRIDAY) {
			c.add(Calendar.DAY_OF_MONTH, 3);
		} else if (dayOfWeek == Calendar.SATURDAY) {
			c.add(Calendar.DAY_OF_MONTH, 2);
		} else {
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}
	public static String getWorkDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (null!=date) {
			try {
				Date dat = sdf.parse(date);
				Calendar c = Calendar.getInstance();
				c.setTime(dat);
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

				if (dayOfWeek == Calendar.SATURDAY) {
					c.add(Calendar.DAY_OF_MONTH, 2);
				}
				if (dayOfWeek == Calendar.SUNDAY) {
					c.add(Calendar.DAY_OF_MONTH, 1);
				}
				return sdf.format(c.getTime());
			} catch (ParseException e) {
				throw new RuntimeException("日期格式不正确");
			}
		}
		else return getWorkDate();
	}
	public static String getFormatedCurrentDateOfChiness() {
		SimpleDateFormat dateSDF = new SimpleDateFormat("yyyy年MM月dd日");	

		return dateSDF.format(new java.util.Date());
	}
	/**
	 * 计算两个时间之间隔了多久的方法
	 */
	public static String TimeDiff(String pBeginTime, String pEndTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		  Long beginL = format.parse(pBeginTime).getTime();
		  Long endL = format.parse(pEndTime).getTime();
		  Long day = (endL - beginL)/86400000;
		  Long hour = ((endL - beginL)%86400000)/3600000;
		  Long min = ((endL - beginL)%86400000%3600000)/60000;
		  return ("实际请假" + day + "小时" + hour + "分钟" + min);
		 }
		 
  /**
   * 计算过了多长时间（单位是分钟）
   */
	public static long computeMinutesInterval(String pBeginTime, String pEndTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		  try {
			Long beginL = format.parse(pBeginTime).getTime();
			Long endL = format.parse(pEndTime).getTime();
			Long min = (endL - beginL)/60000;
			return min;
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
		
	}
	
	public static long computeDaysInterval(String pBeginTime, String pEndTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  try {
			Long beginL = format.parse(pBeginTime).getTime();
			Long endL = format.parse(pEndTime).getTime();
			return (endL - beginL)/86400000;
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}
	
	/**
	 * date 格式yyyyMMdd字符串 转换为yyyy年MM月dd日
	 * 
	 * @param date
	 * @return
	 */
	public static String getFormatedCurrentDateOfChiness(String dateStr) {
		SimpleDateFormat dateSDF8 = new SimpleDateFormat(DATE_8);
		SimpleDateFormat dateSDF = new SimpleDateFormat("yyyy年MM月dd日");
		if(dateStr == null || dateStr.equals("")){
			return "";
		}
		try {
			Date d = dateSDF8.parse(dateStr);
			return dateSDF.format(d);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}

	public static String getFormatedDate(long time) {
		SimpleDateFormat dateSDF = new SimpleDateFormat(DATE_8);
		return dateSDF.format(new java.util.Date(time));
	}

	public static String getFormatedDate6(String date) {
		String rtDate = date.replaceAll("-", "");
		rtDate = rtDate.substring(2, 8);
		return rtDate;
	}

	public static String getFormatedDate(java.util.Date date) {
		SimpleDateFormat dateSDF = new SimpleDateFormat(DATE_8);
		return dateSDF.format(date);
	}
	
	public static String getFormatedDate11(java.util.Date date) {
		SimpleDateFormat dateSDF = new SimpleDateFormat(FORMAT_DATE_CN_11);
		return dateSDF.format(date);
	}

	public static String getFormatedDate(int year, int month, int date) {
		return Integer.toString(year)
				+ (month >= 10 ? Integer.toString(month) : "0" + month)
				+ (date >= 10 ? Integer.toString(date) : "0" + date);
	}

	public static String getFormatedMonth(int year, int month) {
		return Integer.toString(year)
				+ (month >= 10 ? Integer.toString(month) : "0" + month);
	}

	/**
	 * format time as HHmmssSSS
	 */
	public static String getFormatedCurrentTime9() {
		SimpleDateFormat timeSDF9 = new SimpleDateFormat("HHmmssSSS");
		return timeSDF9.format(new java.util.Date());
	}

	public static String getFormatedCurrentTime6() {
		SimpleDateFormat timeSDF6 = new SimpleDateFormat("HHmmss");
		return timeSDF6.format(new java.util.Date());
	}

	/**
	 * 获取当前时间 返回格式yyyyMMddHHmmssSSS
	 * 
	 * @return
	 */

	public static String getCurrentTime17ByMillis() {
		SimpleDateFormat timeSDF17 = new SimpleDateFormat(DATE_TIME_17);
		return timeSDF17.format(new java.util.Date());
	}

	public static String getCurrentDateTime10() {
		SimpleDateFormat timeSDF15 = new SimpleDateFormat("yyMMddHHmm");
		return timeSDF15.format(new java.util.Date());
	}
	/**
	 * 将指定格式的时间字符串格式化为yyyyMMddHHmmssSSS的时间
	 * 
	 * @param time
	 * @param formatStr
	 * @return
	 */
	public static String getTime17ByMillis(String time, String formatStr) {
		if (time == null || time.equals("")) {
			return "";
		}
		SimpleDateFormat timeSDF = new SimpleDateFormat(formatStr);
		try {
			Date date = timeSDF.parse(time);
			SimpleDateFormat timeSDF17 = new SimpleDateFormat(DATE_TIME_17);
			return timeSDF17.format(date);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}

	}

	/**
	 * 将yyyyMMdd格式的日期字符串转换为yyyy-MM-dd格式
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatDate8(String dateStr) {
		if (dateStr == null || dateStr.equals(""))
			return "";
		SimpleDateFormat dateSDF8 = new SimpleDateFormat(DATE_8);
		SimpleDateFormat dateSDF10 = new SimpleDateFormat(FORMAT_DATE_10);
		try {
			Date date = dateSDF8.parse(dateStr);
			return dateSDF10.format(date);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 将yyyy-MM-dd格式的日期字符串转换为yyyyMMdd格式
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatDate10(String dateStr) {
		if (dateStr == null || dateStr.equals(""))
			return "";
		SimpleDateFormat dateSDF8 = new SimpleDateFormat(DATE_8);
		SimpleDateFormat dateSDF10 = new SimpleDateFormat(FORMAT_DATE_10);
		try {
			Date date = dateSDF10.parse(dateStr);
			return dateSDF8.format(date);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的日期字符串转换为yyyyMMddHHmmssSSS格式
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatTime19(String dateStr) {
		if (dateStr == null || dateStr.equals(""))
			return "";
		SimpleDateFormat dateSDF17 = new SimpleDateFormat(DATE_TIME_17);
		SimpleDateFormat dateSDF19 = new SimpleDateFormat(FORMAT_DATE_TIME_19);
		try {
			Date date = dateSDF19.parse(dateStr);
			return dateSDF17.format(date);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}
	/**
	 * 将yyyyMMddHHmmss格式的日期字符串转换为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatTime14(String dateStr) {
		if (dateStr == null || dateStr.equals(""))
			return "";
		SimpleDateFormat dateSDF14 = new SimpleDateFormat(DATE_TIME_14);
		SimpleDateFormat dateSDF19 = new SimpleDateFormat(FORMAT_DATE_TIME_19);
		try {
			Date date = dateSDF14.parse(dateStr);
			return dateSDF19.format(date);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的日期字符串转换为yyyy年MM月dd日格式
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatTimeChinese10(String dateStr) {
		if (dateStr == null || dateStr.equals(""))
			return "";

		SimpleDateFormat dateSDF17 = new SimpleDateFormat(DATE_TIME_17);
		try {
			dateSDF17.parse(dateStr);
			String dateStr2 = dateStr.substring(0, 8);
			return getFormatedCurrentDateOfChiness(dateStr2);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}
	/**
	 * 将yyyy-MM-dd 格式的日期字符串转换为yyyy年MM月dd日格式
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatDateChinese10(String dateStr) {
		if (dateStr == null || dateStr.equals(""))
			return "";
		
		SimpleDateFormat dateSDF8 = new SimpleDateFormat(FORMAT_DATE_10);
		try {
			dateSDF8.parse(dateStr);
			String dateStr2 = dateStr.replace("-", "");
			return getFormatedCurrentDateOfChiness(dateStr2);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 将yyyyMMddHHmmssSSS格式的时间字符串格式化为指定格式的时间字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String formatTime17ByMillis(String time, String format) {
		if (time == null || time.equals("")) {
			return "";
		}
		SimpleDateFormat timeSDF17 = new SimpleDateFormat(DATE_TIME_17);
		try {
			Date date = timeSDF17.parse(time);
			SimpleDateFormat dateSDF = new SimpleDateFormat(format);
			return dateSDF.format(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 将format格式的时间转换为newFormat格式的时间
	 * 
	 * @param time
	 * @param format
	 * @param newFormat
	 * @return
	 */
	public static String format(String time, String format, String newFormat) {
		if (time == null || "".equals(time.trim())) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		SimpleDateFormat newsdf = new SimpleDateFormat(newFormat);
		try {
			return newsdf.format(sdf.parse(time));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param date
	 * @return
	 */
	public static String formatDate10ToTime17(String date) {
		return format(date, FORMAT_DATE_10, DATE_TIME_17);
	}

	/**
	 * 获取指定日(yyyy-MM-dd)的开始时间
	 * 
	 * @return
	 */
	public static String getDateBeginTime(String date) {
		if (date == null || "".equals(date.trim())) {
			return "";
		}
		return formatDate10(date) + "000000000";
	}

	/**
	 * 获取指定日(yyyy-MM-dd)的结束时间
	 * 
	 * @return
	 */
	public static String getDateEndTime17(String date) {
		if (date == null || "".equals(date.trim())) {
			return "";
		}
		return formatDate10(date) + "235959999";
	}

	public static String getTime17ByMillis(long time) {
		SimpleDateFormat timeSDF17 = new SimpleDateFormat(DATE_TIME_17);

		return timeSDF17.format(time);
	}

	public static String getTime17ByMillis(long time, String format) {
		if (null == format || "".equals(format)) {
			return "";
		}
		SimpleDateFormat timeSDF17 = new SimpleDateFormat(format);
		return timeSDF17.format(time);
	}

	public static long getTime17ByMillis(String time) {
		SimpleDateFormat timeSDF17 = new SimpleDateFormat(DATE_TIME_17);
		long rtTime = 0;
		try {
			rtTime = timeSDF17.parse(time).getTime();
		} catch (Exception ex) {
			log.error("TimeUtil.getTime17ByMillis(String time):param:"+time,ex);
		}
		return rtTime;
	}

	public static String getCurrentDateTime12() {
		SimpleDateFormat timeSDF12 = new SimpleDateFormat(DATE_TIME_12);
		return timeSDF12.format(new java.util.Date());
	}
	public static String formatToDate12(Date date ){
		SimpleDateFormat timeSDF12 = new SimpleDateFormat(FORMAT_DATE_TIME_19);
		return timeSDF12.format(date);
	}
	public static String getCurrentDateTime14() {
		SimpleDateFormat timeSDF12 = new SimpleDateFormat(DATE_TIME_14);
		return timeSDF12.format(new java.util.Date());
	}

	public static String getDateTime12(long time) {
		SimpleDateFormat timeSDF12 = new SimpleDateFormat(DATE_TIME_12);
		return timeSDF12.format(time);
	}

	public static long getMinuteRangeByMillis(long time1, long time2) {
		return (time1 - time2) / (1000 * 60);
	}

	public static String getPreYear(String date) {
		int y = Integer.parseInt(date.substring(0, 4));
		return Integer.toString(y - 1);
	}

	public static String getThisYear(String date) {
		return date.substring(0, 4);
	}

	public static String getYear(String date) {
		return date.substring(0, 4);
	}

	public static String getDate(String date) {
		return date.substring(4, 8);
	}

	public static String getNextYear(String date) {
		int y = Integer.parseInt(date.substring(0, 4));
		return Integer.toString(y + 1);
	}

	public static int getLastDateOfMonth(int year, int month) {
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			return 30;
		} else if (month == 2) {
			if (isRenNian(year))
				return 29;
			else
				return 28;
		} else {
			return 31;
		}
	}

	public static String getPreDate(String date, int count) {
		for (int i = 0; i < count; i++)
			date = getPreDate(date);
		return date;
	}

	public static String getNextDate(String date, int count) {
		for (int i = 0; i < count; i++)
			date = getNextDate(date);
		return date;
	}

	public static String getPreMonth(String month) {
		int y = Integer.parseInt(month.substring(0, 4));
		int m = Integer.parseInt(month.substring(4, 6));
		if (--m < 1) {
			m = 12;
			y--;
		}
		return getFormatedMonth(y, m);
	}

	public static String getNextMonth(String month) {
		int y = Integer.parseInt(month.substring(0, 4));
		int m = Integer.parseInt(month.substring(4, 6));
		if (++m > 12) {
			m = 1;
			y++;
		}
		return getFormatedMonth(y, m);
	}

	public static String getPreDate(String date) {
		int y = Integer.parseInt(date.substring(0, 4));
		int m = Integer.parseInt(date.substring(4, 6));
		int d = Integer.parseInt(date.substring(6, 8));

		if (d > 1)
			return getFormatedDate(y, m, d - 1);
		if ((m == 2) || (m == 4) || (m == 6) || (m == 8) || (m == 9)
				|| (m == 11)) {
			return getFormatedDate(y, m - 1, 31);
		} else if ((m == 5) || (m == 7) || (m == 10) || (m == 12)) {
			return getFormatedDate(y, m - 1, 30);
		} else if (m == 3) {
			if (isRenNian(y))
				return getFormatedDate(y, 2, 29);
			else
				return getFormatedDate(y, 2, 28);
		} else { // m == 1 and d==1
			return getFormatedDate(y - 1, 12, 31);
		}
	}

	// n should between 1 to 12
	public static String getDayOfNextNMonth(String date, int n) {
		int y = Integer.parseInt(date.substring(0, 4));
		int m = Integer.parseInt(date.substring(4, 6));
		int d = Integer.parseInt(date.substring(6, 8));
		m += n;
		if (m > 12) {
			m -= 12;
			y++;
		}
		if (d > 28) {
			if (m == 2) {
				if (isRenNian(y))
					m = 29;
				else
					m = 28;
			}
		}
		if (d == 31) {
			if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
				d = 30;
			}
		}
		return getFormatedDate(y, m, d);
	}

	public static String getDayOfNextYear(String date) {
		int y = Integer.parseInt(date.substring(0, 4));
		int m = Integer.parseInt(date.substring(4, 6));
		int d = Integer.parseInt(date.substring(6, 8));
		if ((m == 2) && (d == 29)) {
			return getFormatedDate(y + 1, 2, 28);
		} else {
			return getFormatedDate(y + 1, m, d);
		}
	}

	public static String getNextDate(String date) {
		int y = Integer.parseInt(date.substring(0, 4));
		int m = Integer.parseInt(date.substring(4, 6));
		int d = Integer.parseInt(date.substring(6, 8));
		if (d < 28) {
			return getFormatedDate(y, m, d + 1);
		} else if (d == 31) {
			if (m == 12)
				return getFormatedDate(y + 1, 1, 1);
			else
				return getFormatedDate(y, m + 1, 1);
		} else if (d == 30) {
			if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
				return getFormatedDate(y, m + 1, 1);
			} else {
				return getFormatedDate(y, m, 31);
			}
		} else if (d == 29) {
			if (m == 2)
				return getFormatedDate(y, 3, 1);
			else
				return getFormatedDate(y, m, 30);
		} else { // d = 28
			if (m == 2) {
				if (isRenNian(y))
					return getFormatedDate(y, m, 29);
				else
					return getFormatedDate(y, 3, 1);
			} else {
				return getFormatedDate(y, m, 29);
			}
		}
	}

	public static boolean isTimeValid(int y, int m, int d) {
		if ((y < 1000) || (y > 9999) || (m < 1) || (m > 12) || (d < 1)
				|| (d > 31))
			return false;
		if ((d == 31)
				&& ((m == 2) || (m == 4) || (m == 6) || (m == 9) || (m == 11)))
			return false;
		if (((d == 30) && (m == 2))
				|| ((d == 29) && (m == 2) && (!isRenNian(y)))) {
			return false;
		}
		return true;
	}

	public static boolean isTimeValid(int y, int m) {
		if ((y < 1000) || (y > 9999) || (m < 1) || (m > 12))
			return false;
		return true;
	}

	public static boolean isDateValid(String date) {
		try {
			if (date.length() == 8) {
				int y = Integer.parseInt(date.substring(0, 4));
				int m = Integer.parseInt(date.substring(4, 6));
				int d = Integer.parseInt(date.substring(6, 8));
				if (TimeUtil.isTimeValid(y, m, d))
					return true;
			}
		} catch (NumberFormatException ne) {

		}
		return false;
	}

	public static boolean isRenNian(int year) {
		if (year != year / 4 * 4) {
			return false;
		}
		if (year != year / 100 * 100) {
			return true;
		}
		if (year != year / 400 * 400) {
			return false;
		}
		return true;
	}

	public static long getDayStart(String datestr) {// YYYYMMDD
		int year = Integer.parseInt(datestr.substring(0, 4)) - 1900;
		int month = Integer.parseInt(datestr.substring(4, 6)) - 1;
		int date = Integer.parseInt(datestr.substring(6, 8));

		GregorianCalendar cal = new GregorianCalendar(year + 1900, month, date,
				0, 0, 0);
		/*
		 * Date d = new Date(year,month,date,0,0,0); return d.getTime();
		 */
		return cal.getTimeInMillis();
	}

	public static long getDayEnd(String datestr) {// YYYYMMDD
		int year = Integer.parseInt(datestr.substring(0, 4)) - 1900;
		int month = Integer.parseInt(datestr.substring(4, 6)) - 1;
		int date = Integer.parseInt(datestr.substring(6, 8));

		GregorianCalendar cal = new GregorianCalendar(year + 1900, month, date,
				23, 59, 60);
		return cal.getTimeInMillis();

		/*
		 * Date d = new Date(year,month,date,23,59,60); return d.getTime();
		 */
	}

	public static String getDateDisplay(String showdate, String year,
			String month, String date) {
		StringBuffer sb = new StringBuffer(16);
		sb.append(showdate.substring(0, 4)).append(year).append(
				showdate.substring(4, 6)).append(month).append(
				showdate.substring(6, 8)).append(date);
		return sb.toString();
	}

	public static String getFormatCurrentDateTime19() {
		SimpleDateFormat dateSDF = new SimpleDateFormat(FORMAT_DATE_TIME_19);
		return dateSDF.format(new java.util.Date());
	}

	public static String getFormatCurrentTime8() {
		SimpleDateFormat dateSDF = new SimpleDateFormat("HH:mm:ss");
		return dateSDF.format(new java.util.Date());
	}

	public static String getFormatCurrentDate10() {
		SimpleDateFormat dateSDF = new SimpleDateFormat(FORMAT_DATE_10);
		return dateSDF.format(new java.util.Date());
	}
	
	public static String getOracleQuerynextDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat dateSDF = new SimpleDateFormat(FORMAT_DATE_10);
		return dateSDF.format(c.getTime());
	}
	public static Date stringToDate(String time) {
		SimpleDateFormat formatter;
		int tempPos = time.indexOf("AD");
		time = time.trim();
		formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
		if (tempPos > -1) {
			time = time.substring(0, tempPos) + "公元"
					+ time.substring(tempPos + "AD".length());// china
			formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
		}
		tempPos = time.indexOf("-");
		if (tempPos > -1 && (time.indexOf(" ") < 0)) {
			formatter = new SimpleDateFormat("yyyyMMddHHmmssZ");
		} else if ((time.indexOf("/") > -1) && (time.indexOf(" ") > -1)) {
			formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		} else if ((time.indexOf("-") > -1) && (time.indexOf(" ") > -1)) {
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if ((time.indexOf("/") > -1) && (time.indexOf("am") > -1)
				|| (time.indexOf("pm") > -1)) {
			formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
		} else if ((time.indexOf("-") > -1) && (time.indexOf("am") > -1)
				|| (time.indexOf("pm") > -1)) {
			formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
		}
		ParsePosition pos = new ParsePosition(0);
		java.util.Date ctime = formatter.parse(time, pos);
		return ctime;
	}

	public static Date nextDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	/**
	 * 返回前一天的日期 格式YYYY-MM-DD
	 * @return
	 */
	public static String getYesterdayDate(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		String year = "" + c.get(Calendar.YEAR);
		String s = year + "-";
		int month = c.get(Calendar.MONTH) + 1;
		if (month < 10) {
			s = s + "0" + month;
		} else {
			s = s + month;
		}
		int day = c.get(Calendar.DATE) + 1;
		if (day < 10) {
			s = s + "-0" + day;
		} else {
			s = s + "-" + day;
		}
		return s;
	}

	public static java.util.Date dateAdd(String flag, int num,
			java.util.Date dtBegin){
		java.util.Date dBefore = dtBegin;
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(dBefore);
		int field = Calendar.SECOND;
		if (flag.equals("s"))
			field = Calendar.SECOND;
		if (flag.equals("m"))
			field = Calendar.MINUTE;
		if (flag.equals("h"))
			field = Calendar.HOUR;
		if (flag.equals("d"))
			field = Calendar.DAY_OF_YEAR;
		if (flag.equals("M"))
			field = Calendar.MONTH;
		if (flag.equals("w"))
			field = Calendar.WEEK_OF_YEAR;
		if (flag.equals("y"))
			field = Calendar.YEAR;
		gc.add(field, num);
		dBefore = gc.getTime();
		return (dBefore);
	}

	/**
	 * 根据Date对象返回yyyy-MM-dd HH:mm:ss字符串
	 * 
	 * @param FieldValue
	 * @return
	 * @throws Exception
	 */
	public static String getDateString(java.util.Date FieldValue) {
		String sDate = "";
		Calendar cNow = Calendar.getInstance();
		Date aFieldValue = (Date) FieldValue;
		cNow.setTime(aFieldValue);
		sDate = sDate + cNow.get(Calendar.YEAR) + "-";
		if (1 + cNow.get(Calendar.MONTH) < 10)
			sDate = sDate + "0" + (1 + cNow.get(Calendar.MONTH)) + "-";
		else
			sDate = sDate + (1 + cNow.get(Calendar.MONTH)) + "-";
		if (cNow.get(Calendar.DAY_OF_MONTH) < 10)
			sDate = sDate + "0" + cNow.get(Calendar.DAY_OF_MONTH);
		else
			sDate = sDate + cNow.get(Calendar.DAY_OF_MONTH);
		if (cNow.get(Calendar.HOUR_OF_DAY) < 10)
			sDate = sDate + " 0" + cNow.get(Calendar.HOUR_OF_DAY);
		else
			sDate = sDate + " " + cNow.get(Calendar.HOUR_OF_DAY);
		if (cNow.get(Calendar.MINUTE) < 10)
			sDate = sDate + ":0" + cNow.get(Calendar.MINUTE);
		else
			sDate = sDate + ":" + cNow.get(Calendar.MINUTE);
		if (cNow.get(Calendar.SECOND) < 10)
			sDate = sDate + ":0" + cNow.get(Calendar.SECOND);
		else
			sDate = sDate + ":" + cNow.get(Calendar.SECOND);
		return (sDate);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回输入的时间与当前时间的日期差
	 * 
	 * @param time
	 *            yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static int minusNow(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_10);
		Date date = sdf.parse(time);
		int x = (int) ((getMillis(date) - getMillis(new Date())) / (24 * 3600 * 1000));
		return x;
	}

	/**
	 * 返回输入的时间的日期差 
	 * @param date1 起始日期 yyyy-MM-dd
	 * @param date2 终止日期 yyyy-MM-dd
	 * @return
	 */
	public static int getDateMinus(String date1,String date2){
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_10);
		int result = 0;
		try {
			Date da1 = sdf.parse(date1);
			Date da2 = sdf.parse(date2);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(da1);
			c2.setTime(da2);
			while(c1.before(c2)){
				c1.add(Calendar.DATE, 1);
				result ++;
			}
		} catch (ParseException e) {
			result = -1;
		}
		return result;
	}
	/**
	 * 根据传入日期和天数计算日期并返回中文格式日期
	 * @param date 起始日期 yyyy-MM-dd
	 * @param days 天数
	 * @return 小于等于0返回其实日期
	 */
	public static String getFinishDay(String date){
		SimpleDateFormat csdf = new SimpleDateFormat(FORMAT_DATE_CN_11);
		SimpleDateFormat cs = new SimpleDateFormat(FORMAT_DATE_10);
		if(date!=null){
			try {
				return csdf.format(cs.parse(date));
			} catch (ParseException e) {
				throw new RuntimeException("日期格式不正确",e);
			}
		}
		
		else return csdf.format(new Date());
	}
	public static String getDateAfterDays(String date, int days) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_10);
		SimpleDateFormat csdf = new SimpleDateFormat(FORMAT_DATE_CN_11);
		
		String finishDate = "";
		try {
			Date start = sdf.parse(date);
			if (days < 1) {
				return csdf.format(start);
			}
			Calendar c = Calendar.getInstance();
			c.setTime(start);
			while (days > 0) {
				c.add(Calendar.DATE, 1);
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				if (dayOfWeek != Calendar.SATURDAY
						&& dayOfWeek != Calendar.SUNDAY) {
					days--;
				}
			}
			finishDate = sdf.format(c.getTime());
		} catch (ParseException e) {
			return finishDate;
		}
		return finishDate;
	}
	/**
	 * 根据开始日期和工作日计算完成日期（跳过周末）
	 * @param date 开始日期 格式 yyyy-MM-dd 不符合要求返回空串
	 * @param workday 大于0 否则返回开始日期
	 * @return 结束日期
	 */
	public static String getFinishDateByWorkday(String date, int workday) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_10);
		String finishDate = "";
		if (workday < 1) {
			return date;
		}
		try {
			Date start = sdf.parse(date);
			start.getTime();
			Calendar c = Calendar.getInstance();
			c.setTime(start);
			while (workday > 0) {
				c.add(Calendar.DATE, 1);
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				if (dayOfWeek != Calendar.SATURDAY
						&& dayOfWeek != Calendar.SUNDAY) {
					workday--;
				}
			}
			finishDate = sdf.format(c.getTime());
		} catch (ParseException e) {
			return finishDate;
		}
		return finishDate;
	}
	public static void main(String[] args) throws ParseException {
		
		System.out.println(getCurrentTime());
		System.out.println(computeMinutesInterval("2012-11-18 12:35","2012-11-19 12:36"));
		String today = TimeUtil.getFormatCurrentDate10();
		System.out.println(today);
		String laYear = Integer.parseInt(today.substring(0,4))-1+today.substring(4);
		System.out.println(laYear);
		//测试用例
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == Calendar.TUESDAY

				) {
			c.add(Calendar.DAY_OF_MONTH, 2);
		}
		if(dayOfWeek == Calendar.SUNDAY){
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		SimpleDateFormat timeSDF15 = new SimpleDateFormat("yyMMddHHmm");
		System.out.println(timeSDF15.format(c.getTime()));
	}
	
	public static Date parseStringToDateAsyyyyMMdd(String parseStr){
		SimpleDateFormat format = new SimpleDateFormat(DATE_8);
		Date date;
		try {
			date = format.parse(parseStr);
		} catch (ParseException e) {
			return new Date();
		}
		return date;
	}
	
	public static String getNowDateStrAsyyyyMMdd(){
		SimpleDateFormat format = new SimpleDateFormat(DATE_8);
		return format.format(new Date());
	}
	public static Date parseStringToDateAsyyyyMMddHHmmss(String parseStr){
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_14);
		Date date;
		try {
			date = format.parse(parseStr);
		} catch (ParseException e) {
			return new Date();
		}
		return date;
	}
	public static Date parseStringToDateAsyyyyMMddHHmm(String parseStr){
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_12);
		Date date;
		try {
			date = format.parse(parseStr);
		} catch (ParseException e) {
			return new Date();
		}
		return date;
	}
	public static String formatDateToyyyyMMdd(Date date){
		SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATE_10);
		return format.format(date);
	}
	/**
	 * 根据天数的间隔获取下一个日期
	 * @param oldDate
	 * @param days
	 * @return
	 */
	public static Date getNextDateByDays(Date oldDate,int days){
		Calendar c = Calendar.getInstance();
		c.setTime(oldDate);
		c.add(Calendar.DAY_OF_WEEK, days);
		return c.getTime();
	}
	/**
	 * 根据相隔的天数算下一个日期
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date getNextDateByBetweenDays(Date date,int i){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, i);
		Date e = c.getTime();
		return e;
	}
	/**
	 * 根据日期加的月份算得几个月的日期
	 * @param paymentDate
	 * @param i
	 * @return
	 */
	public static Date getNextMonthDateByDate(Date paymentDate, int i) {
		Calendar c=Calendar.getInstance();
		c.setTime(paymentDate);
		c.add(Calendar.MONTH, i);
		Date e = c.getTime();
		return e;
	}

	public static int compareTimeString(Map<String, String> o1,
			Map<String, String> o2) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = format.parse(o1.get("payTime"));
			Date d2 = format.parse(o2.get("payTime"));
			if(d1.getTime()>d2.getTime()){
				return 1;
			}
			if(d1.getTime()==d2.getTime()){
				return 0;
			}
			else{
				return -1;
			}
		} catch (ParseException e) {
			return 0;
		}
		
	}
	
	/**
	 * 根据给定的日期计算几个月后的日期
	 * @param month
	 * @param date
	 * @return
	 */
	public static Date getEndDateByPaymentDate(int month, Date date) {
		Date payDate = getEndDateByDays(date, 1);
		Calendar c = Calendar.getInstance();
		c.setTime(payDate);
		c.add(Calendar.MONTH, month);
		return c.getTime();
	}
	/**
     * 得到两日期相差几个月
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    public static int getMonth(Date startDate, Date endDate) {
	    int monthday;
	    //开始时间与今天相比较
        Calendar starCal = Calendar.getInstance();
        starCal.setTime(startDate);

        int sYear = starCal.get(Calendar.YEAR);
        int sMonth = starCal.get(Calendar.MONTH);
        int sDay = starCal.get(Calendar.DATE);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int eYear = endCal.get(Calendar.YEAR);
        int eMonth = endCal.get(Calendar.MONTH);
        int eDay = endCal.get(Calendar.DATE);

        monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

        if (sDay < eDay) {
            monthday = monthday + 1;
        }
        return monthday;
    }
    
    public static Date getEndDateByDays(Date start,int days){
    	Calendar c=Calendar.getInstance();
		c.setTime(start);
		c.add(Calendar.DAY_OF_MONTH, days);
		Date e = c.getTime();
		return e;
    }
	 /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

       return Integer.parseInt(String.valueOf(between_days));
    }

	/**
	*字符串的日期格式的计算
	*/
    public static int daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

       return Integer.parseInt(String.valueOf(between_days));
    }
    public static Date getNowStartTime(){
		 Calendar todayStart = Calendar.getInstance();  
		 todayStart.setTime(new Date());
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND,0);
        return todayStart.getTime();
	 }
	 public static Date getNowEndTime(){
		 Calendar todayStart = Calendar.getInstance();
		 todayStart.setTime(new Date());
        todayStart.set(Calendar.HOUR_OF_DAY, 23);  
        todayStart.set(Calendar.MINUTE, 59);  
        todayStart.set(Calendar.SECOND, 59);  
        return todayStart.getTime();
	 }
	 public static Date getBeforeDateBetweenDays(int days){
		 Calendar todayStart = Calendar.getInstance();
		 todayStart.setTime(new Date());
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0); 
        todayStart.add(Calendar.DAY_OF_MONTH, days);
        return todayStart.getTime();
	 }
	 
	/**
	 * 获取下一个工作日
	 * @param start
	 * @return
	 */
	public static Date getNextWorkDay(Date start){
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == Calendar.SATURDAY){
			//如果是周六,那么加两天到下周一
			c.add(Calendar.DAY_OF_MONTH, 2);
		}
		if (dayOfWeek == Calendar.SUNDAY){
			//如果是周日那么加一天
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		return c.getTime();
	}
	
	public static Date getNextDateByMinutesInterval(int minutes,Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}
	
	//中金要求的日期格式
	public static String getZhongJinDateFormatForInvest(Date date){
		SimpleDateFormat dateSDF = new SimpleDateFormat(DATE_8);
		return dateSDF.format(date);
	}
	public static String getZhongJinEndDateByDaysForInvest(Date start,int days){
    	Calendar c=Calendar.getInstance();
		c.setTime(start);
		c.add(Calendar.DAY_OF_MONTH, days);
		Date e = c.getTime();
		return getZhongJinDateFormatForInvest(e);
    }
}
