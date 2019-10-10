package com.it.webui.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　侯文　2014年5月8日 　<br/>
 * <p>
 * 时间工具类
 * <p>
 * @author 侯文
 * 
 * @version 1.0,2014年5月8日 <br/>
 * 
 */
public class DateUtils {
	public static Date str2Date(String strDate, String formater) {
		if (strDate == null) {
			return null;
		}
		if (formater == null) {
			formater = "yyyy-MM-dd";
		}
		SimpleDateFormat df = new SimpleDateFormat(formater);
		Date date = new Date();
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			pe.getStackTrace();
		}
		return date;
	}
	
	/**
	 * 得到当前日期的 yyyy-MM-dd 以日期格式返回
	 * @return
	 */
	public static Date getTodayDD(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = getToday();
		Date date = new Date();
		try {
			date = df.parse(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date ymdStr2Date(String strDate) {
		String formater = "yyyy-MM-dd";
		return str2Date(strDate, formater);
	}

	public static Date ymdHmsStr2Date(String strDate) {
		String formater = "yyyy-MM-dd HH:mm:ss";
		return str2Date(strDate, formater);
	}

	public static Date ymdHmStrToDate(String strDate) {
		String formater = "yyyy-MM-dd HH:mm";
		return str2Date(strDate, formater);
	}

	public static String getThisMonth() {
		return formaterDate(new Date(), "yyyy-MM");
	}

	public static String getNextMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		return formaterDate(c.getTime(), "yyyy-MM");
	}

	public static String getPreviousMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, -1);// 减一个月，变为上月的1号
		return formaterDate(c.getTime(), "yyyy-MM");
	}

	public static String getMonth(String date,int num) {
		Calendar c = Calendar.getInstance();
		if(StringUtils.isNotEmpty(date)){
			c.setTime(DateUtils.ymdStr2Date(date));
		}
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, num);// 减一个月，变为上月的1号
		return formaterDate(c.getTime(), "yyyy-MM-dd");
	}
	/**
	* 计算两个日期之间相差的月数
	* @param date1
	* @param date2
	* @return
	*/
	public static int getMonths(Date date1, Date date2) {
	   int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);
			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);
			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
					.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}

	@SuppressWarnings("unchecked")
	public static List getMonthList(String startDate,String endDate){
		if(StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			return new ArrayList();
		}
		List<String> dateList = new ArrayList<String>();
		//得到两个日期之间有多少月
		int num = getMonths(ymdStr2Date(startDate),ymdStr2Date(endDate));
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtils.ymdStr2Date(startDate));
		dateList.add(formaterDate(c.getTime(), "yyyy-MM"));
		for(int i=0; i<num; i++){
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			dateList.add(formaterDate(c.getTime(), "yyyy-MM"));
		}
		return dateList;
	}
	/**
	 * 获取当前星期（中国, 如：星期日,星期一,星期二）
	 */
	public static String cnWeek() {
		Calendar c = GregorianCalendar.getInstance();
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		String[] s = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		return s[c.get(Calendar.DAY_OF_WEEK) - 1];
	}

	/**
	 * 获取当前日期（中国,yyyy年MM月dd日）
	 */
	public static String cnToday() {
		return formaterDate(new Date(), "yyyy年MM月dd日");

	}

	public static String getYear(String ymd) {
		return ymd.substring(0, 4);
	}
	
	public static int getYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}

	public static String getMonth(String ymd) {
		return ymd.substring(5, 7);
	}
	
	/**
	 * 得到当前日期 再加上你指定的天数 所得到的新日期
	 * @param days
	 * @return
	 */
	public static Date getNewDayNumDate(int days){
		String today = getToday();
		String newDay = getNewDayNumDate(today,days);
		return ymdStr2Date(newDay);
	}

	/**
	 * 将日期字符串加天数转换成新日期字符串
	 * 
	 * @param strDate
	 *            原日期字符串:yyyy-MM-dd
	 * @param days
	 *            增加的天数
	 */
	public static String getNewDayNumDate(String strDate, int days) {
		String[] date = strDate.split("-"); // 将要转换的日期字符串拆分成年月日
		int year, month, day;
		year = Integer.parseInt(date[0]);
		month = Integer.parseInt(date[1]) - 1;
		day = Integer.parseInt(date[2]);
		GregorianCalendar d = new GregorianCalendar(year, month, day);
		d.add(Calendar.DATE, days);
		return DateFormat.getDateInstance().format(d.getTime());
	}
	
	
	public static Date getNewDayDate(Date date , int days){
		if(date != null ){
	        Calendar c =  Calendar.getInstance();	
	        c.setTime(date);
	        c.add(Calendar.DAY_OF_MONTH, days);
	        return c.getTime();
		}
		return null;
	}
	
	/**
	 * 将日期字符串加天数转换成标准日期字符串
	 * 
	 * @param strDate
	 *            原日期字符串:yyyy-M-d
	 * @return String
	 *            yyyy-MM-dd
	 */
	public static String getFormatDate(String strDate) {
	    String[] date = strDate.split("-"); // 将要转换的日期字符串拆分成年月日
	    int year, month, day;
	    year = Integer.parseInt(date[0]);
	    month = Integer.parseInt(date[1]) - 1;
	    day = Integer.parseInt(date[2]);
	    GregorianCalendar d = new GregorianCalendar(year, month, day);
	    return formaterDate(d.getTime(),"yyyy-MM-dd");
	}

	/**
	 * 从当前时间的字符串格式,带有微秒
	 */
	public static String ymdHmss() {
		Date currentTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmssSSS");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String ymdHmDate(Long time) {
		if (time == null) {
			return "";
		} else {
			if (time <= 0) {
				return "";
			} else {
				return ymdHm(new Date(time));
			}
		}
	}
	
	/**
	 * 将日期字符串加天数转换成新日期字符串
	 * 
	 * @param strDate
	 *            原日期字符串:yyyy-MM-dd
	 * @param days
	 *            减少的天数
	 */
	public static Date getNewDayPrevDate(Date date, int days) {
		if(date != null ){
			 Calendar c =  Calendar.getInstance();	
		        c.setTime(date);
		        c.add(c.DAY_OF_MONTH, -days);
		        return c.getTime();
		}
		return null;
	}
	
	public static String getNewDayPrevDate(String strDate, int days) {
		String[] date = strDate.split("-"); // 将要转换的日期字符串拆分成年月日
		int year, month, day;
		year = Integer.parseInt(date[0]);
		month = Integer.parseInt(date[1]) - 1;
		day = Integer.parseInt(date[2]);
		GregorianCalendar d = new GregorianCalendar(year, month, day);
		d.add(Calendar.DATE, -days);
		return DateFormat.getDateInstance().format(d.getTime());
	}

	public static String[] getTodayStartEnd() {
		String today = DateUtils.getToday();
		return new String[] { today + " 00:00:00", today + " 23:59:59" };
	}

	public static String getPrevOneDay(int day) {
		return "";
	}

	public static String ymd(Date date) {
		return formaterDate(date, null);
	}

	public static String formaterDate(Date date, String formater) {
		if (date == null) {
			return "";
		}
		if (formater == null) {
			formater = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formater);
		return sdf.format(date);
	}

	public static String ymdHm(Date date) {
		return formaterDate(date, "yyyy-MM-dd HH:mm");
	}

	public static String hms(Date date) {
		String s = DateUtils.formaterDate(date, "yyyy-MM-dd HH:mm:ss");
		s = s.substring(11);
		return s.replaceAll(":", "");
	}

	public static String hms() {
		return hms(new Date());
	}

	public static String ym(Date date) {
		return formaterDate(date, "yyyy-MM");
	}

	/**
	 * 获取时间的长字符串形式 "yyyy-MM-dd HH:mm:ss"
	 */
	public static String ymdHms(Date date) {
		return formaterDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getToday() {
		return formaterDate(new Date(), "yyyy-MM-dd");
	}
    
    /**
     * 获取当前时间的长字符串形式 "yyyy-MM-dd HH:mm:ss"
     */
	public static String getNow() {
	    return formaterDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
    
	public static String getYestoday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_YEAR,
				calendar.get(Calendar.DAY_OF_YEAR) - 1);
		return ymd(calendar.getTime());
	}
	
	public static String getThisYear() {
		return formaterDate(new Date(), "yyyy");
	}

	public static String getNotFormatToday() {
		return getToday().replaceAll("-", "");
	}

	// 计算当月最后一天,返回字符串
	public static String getMonthLastDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		c.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		return ymd(c.getTime());
	}

	// 计算当月第一天,返回字符串
	public static String getMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		return ymd(c.getTime());
	}

	public static Date[] getMonthStartAndEndDate() {
		Calendar calendar = Calendar.getInstance();
		Date[] dates = new Date[2];
		Date firstDateOfMonth, lastDateOfMonth; // 得到当天是这月的第几天
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, -(dayOfMonth - 1));
		firstDateOfMonth = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, calendar
				.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		lastDateOfMonth = calendar.getTime();
		dates[0] = ymdHmsStr2Date(DateUtils.ymd(firstDateOfMonth)
				+ " 00:00:00");
		dates[1] = ymdHmsStr2Date(DateUtils.ymd(lastDateOfMonth)
				+ " 23:59:59");
		return dates;
	}

	/**
	 * 得到当前日期的下周一0：00：00到下周日23：59：59时间两端的Date
	 * 
	 * @return Date[2]两端的日期
	 */
	public static Date[] getNextWeekDays() {
		return getNextWeekDays(new Date());
	}

	public static String getPrevMonthToday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.MONDAY, c.get(Calendar.MONDAY) - 1);
		return ymdHms(c.getTime());
	}

	public static String getPrevTenDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 10);
		return ymdHms(c.getTime());
	}

	public static Date[] getLastWeekDays() {
		return getLastWeekDays(new Date());
	}

	/**
	 * 得到当前日期的下周一0：00：00到下周日23：59：59时间两端的Date
	 * 
	 * @param date
	 *            传入的日期
	 * @return Date[2]两端的日期
	 */
	public static Date[] getNextWeekDays(Date date) {
		return getWeekDate(date, 0, 6);
	}

	/**
	 * 得到当前日期的上周一0：00：00到下周日23：59：59时间两端的Date
	 * 
	 * @param date
	 *            传入的日期
	 * @return Date[2]两端的日期
	 */
	public static Date[] getLastWeekDays(Date date) {
		return getWeekDate(date, -14, 6);
	}

	/**
	 * 得到当前日期的本周一0：00：00到下周日23：59：59时间两端的Date
	 * 
	 * @param date
	 *            传入的日期
	 * @return Date[2]两端的日期
	 */
	public static Date[] getThisWeekDays(Date date) {
		return getWeekDate(date, -7, 6);
	}

	public static Date[] getThisWeekDays() {
		return getThisWeekDays(new Date());
	}

	/**
	 * 取得某天所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(String startDate) {
		if (StringUtils.isEmpty(startDate)) {
			return null;
		}
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(DateUtils.ymdStr2Date(startDate));
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}

	/**
	 * 取得某天所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(String currentDate) {
		if (StringUtils.isEmpty(currentDate)) {
			return null;
		}
		Calendar c = new GregorianCalendar();
		c.setTime(DateUtils.ymdStr2Date(currentDate));
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
		return c.getTime();
	}

	public static Date[] getWeekDate(Date date, int start,
			int end) {
		// 将要返回的日期
		Date[] days = new Date[2];

		// 日历
		Calendar calendar = new GregorianCalendar();
		// 设置日历为当前时间
		calendar.setTime(date);
		// 得到今天是周几
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
		// 得到当前是全年的第几周
		int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
		// 加入不是周日，设置日期到下一周

		if (dayofweek != 1) {
			if(weekofYear == 1){
				weekofYear = 53;
			}
			calendar.set(Calendar.WEEK_OF_YEAR, weekofYear + 1);
		}

		
		int nextWeekDay = calendar.get(Calendar.DATE);
		// 设置日历为下周第一天,+2是下周从星期一开始，星期一是每周的第2天

		calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
		calendar.add(Calendar.DATE, start);
		days[0] = calendar.getTime();
		String sd = ymd(days[0]) + " 00:00:00";
		days[0] = ymdHmsStr2Date(sd);

		calendar.add(Calendar.DATE, end);
		days[1] = calendar.getTime();
		String ed = ymd(days[1]) + " 23:59:59";
		days[1] = ymdHmsStr2Date(ed);
		return days;
	}

	/**
	 * 获得前十天时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getPrevTenDay(int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - day);
		return ymdHms(c.getTime());
	}

	/**
	 * 获得前一个时间的前几天时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getPrevTenDay(String date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtils.ymdStr2Date(date));
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - day);
		return ymd(c.getTime());
	}
	
	/**
	 * 获得前一个时间的前几天时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getOpposeDay(String date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtils.ymdStr2Date(date));
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + day);
		return ymd(c.getTime());
	}

	/**
	 * 获得前一个时间的后几天时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getAfterSomeDayYms(String date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(DateUtils.ymdStr2Date(date));
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + day);
		return ymd(c.getTime());
	}

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return 2个日期是否属于同一周
	 */
	public static boolean isSameWeek(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR)) {
				return true;
			}
		} else if ((1 == subYear) && (11 == cal2.get(Calendar.MONTH))) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR)) {
				return true;
			}
		} else if ((-1 == subYear) && (11 == cal1.get(Calendar.MONTH))) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR)) {
				return true;
			}
		}
		return false;
	}

	public static String getMonthName(String month) {
		String monthname = "december";
		if ("01".equals(month)) {
			monthname = "january";
		} else if ("02".equals(month)) {
			monthname = "february";
		} else if ("03".equals(month)) {
			monthname = "march";
		} else if ("04".equals(month)) {
			monthname = "april";
		} else if ("05".equals(month)) {
			monthname = "may";
		} else if ("06".equals(month)) {
			monthname = "june";
		} else if ("07".equals(month)) {
			monthname = "july";
		} else if ("08".equals(month)) {
			monthname = "august";
		} else if ("09".equals(month)) {
			monthname = "september";
		} else if ("10".equals(month)) {
			monthname = "october";
		} else if ("11".equals(month)) {
			monthname = "november";
		}
		return monthname;
	}
	public static String getMonthSeasonName(String englishName) {
		String name = "12月";
		if ("january".equals(englishName)) {
			name = "1月";
		} else if ("february".equals(englishName)) {
			name = "2月";
		} else if ("march".equals(englishName)) {
			name = "3月";
		} else if ("april".equals(englishName)) {
			name = "4月";
		} else if ("may".equals(englishName)) {
			name = "5月";
		} else if ("june".equals(englishName)) {
			name = "6月";
		} else if ("july".equals(englishName)) {
			name = "7月";
		} else if ("august".equals(englishName)) {
			name = "8月";
		} else if ("september".equals(englishName)) {
			name = "9月";
		} else if ("october".equals(englishName)) {
			name = "10月";
		} else if ("november".equals(englishName)) {
			name = "11月";
		} else if ("spring".equals(englishName)) {
			name = "第一季度";
		} else if ("summer".equals(englishName)) {
			name = "第二季度";
		} else if ("autumn".equals(englishName)) {
			name = "第三季度";
		} else if ("winter".equals(englishName)) {
			name = "第四季度";
		}
		return name;
	}

	public static String[] getSeason(String month) {
		String[] seasonTime = new String[] { "", "", "", "", "" };
		if ("01".equals(month) || "02".equals(month) || "03".equals(month)) {
			seasonTime[0] = "01-01";
			seasonTime[1] = "03-31";
			seasonTime[2] = "january+february+march";
			seasonTime[3] = "第一季度";
			seasonTime[4] = "spring";
		} else if ("04".equals(month) || "05".equals(month)
				|| "06".equals(month)) {
			seasonTime[0] = "04-01";
			seasonTime[1] = "06-30";
			seasonTime[2] = "april+may+june";
			seasonTime[3] = "第二季度";
			seasonTime[4] = "summer";
		} else if ("07".equals(month) || "08".equals(month)
				|| "09".equals(month)) {
			seasonTime[0] = "07-01";
			seasonTime[1] = "03-30";
			seasonTime[2] = "july+august+september";
			seasonTime[3] = "第三季度";
			seasonTime[4] = "autumn";
		} else if ("10".equals(month) || "11".equals(month)
				|| "12".equals(month)) {
			seasonTime[0] = "10-01";
			seasonTime[1] = "12-31";
			seasonTime[2] = "october+november+december";
			seasonTime[3] = "第四季度";
			seasonTime[4] = "winter";
		}
		return seasonTime;
	}

	/**
	 * 得到一个日期是周几
	 */
	public static String getWeekCS(Date date) {

		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		String[] s = { "sunday", "monday", "tuesday", "wednesday",
				"thursday", "friday", "saturday" };
		return s[c.get(Calendar.DAY_OF_WEEK) - 1];
	}

	/**
	 * 得到一个日期是周几
	 */
	public static String getWeekInNum(Date date) {

		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		int weekDayNum = c.get(Calendar.DAY_OF_WEEK)-1;
		if(weekDayNum == 0){
			weekDayNum = 7;
		}
		return String.valueOf(weekDayNum);
	}

	/**
	 * 根据两个日期段得到这个时间段所有的周一和周日的日期
	 */
	@SuppressWarnings("unchecked")
	public static List getWeek(String startDate, String endDate) throws Exception {
		if(StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			return new ArrayList();
		}
		List<String> dateList = new ArrayList<String>();
		// 得开始日期所在的周一，和结束日期所在的周末
		startDate = ymd(getFirstDayOfWeek(startDate));
		endDate = ymd(getLastDayOfWeek(endDate));
		String date;
		// 得到两个日期之间有多少周
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
				Locale.ENGLISH); // 设定格式
		dateFormat.setLenient(false);
		Date start = dateFormat.parse(startDate);
		Date end = dateFormat.parse(endDate);
		long temp = ((end.getTime() - start.getTime()) / 1000);// 秒数
		temp = temp / (60 * 60 * 24); // 天数
		temp = temp / 7; // 周数
		// 根据周数将每周开始日期和结束日期打包
		int j = -1;
		for (int i = 0; i <= temp; i++) {
			j = j + 1;
			date = getAfterSomeDayYms(startDate, j);
			j = j + 6;
			date = date + "~" + getAfterSomeDayYms(startDate, j);
			dateList.add(date);
		}
		// 对结果进行倒序排序使得最近的日期在上边
		Collections.reverse(dateList);
		return dateList;
	}

	public static String getTomorrow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_YEAR,
				calendar.get(Calendar.DAY_OF_YEAR) + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}

	@SuppressWarnings("unchecked")
	public static List makeHourList() {
		List list = new ArrayList();
		for (int i = 0; i < 24; i++) {
			if (i < 10) {
				list.add((new StringBuilder("0")).append(i).toString());
			} else {
				list.add(String.valueOf(i));
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static List makeMininuteList() {
		List list = new ArrayList();
		for (int i = 0; i < 6; i++) {
			list.add((new StringBuilder(String.valueOf(String.valueOf(i)))).append("0").toString());
		}
		return list;
	}

	/**
	 *  取传入时间的小时值
	 * @param endDate
	 * @return
	 */
	public static String makeHour(Date endDate) {
		String hour = "";
		if (endDate != null) {
			DateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String after = format.format(endDate);
			hour = after.substring(11, 13);
		}
		return hour;
	}

	public static String makeMini(Date endDate) {
		String mini = "";
		if (endDate != null) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String after = format.format(endDate);
			mini = after.substring(14, 16);
		}
		return mini;
	}
	
	/**
	 * 得到当前时间的 小时和分（hh:mm）
	 * @param date
	 * @return
	 */
	public static String getHourAndMinute(Date date){
		String hour = makeHour(date);
		String minute = makeMini(date);
		
		return hour + ":" + minute;
	}

	@SuppressWarnings("unchecked")
	public static List getTomorrowList() {
		List<String> dateList = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tomorrow = sdf.format(calendar.getTime());
		dateList.add(tomorrow);
		for (int i = 0; i < 6; i++) {
			calendar.set(6, calendar.get(6) + 1);
			tomorrow = sdf.format(calendar.getTime());
			dateList.add(tomorrow);
		}

		return dateList;
	}
	
	public static String getWeekStartDateString(String startDate) {
		return getWeekDateString(startDate, 0);
	}
	
	public static String getWeekEndDateString(String endDate) {
		return getWeekDateString(endDate, 6);
	}
	
	public static String getWeekDateString(String currentDate, int day) {
		// 日历
		Calendar calendar = new GregorianCalendar();
		// 设置日历为当前时间
		calendar.setTime(ymdStr2Date(currentDate));
		// 得到今天是周几
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
		// 加入不是周日，设置日期到下一周
		if (dayofweek == 1) {
			calendar.set(Calendar.WEEK_OF_YEAR, weekofYear - 1);
		}
		int nextWeekDay = calendar.get(Calendar.DATE);
		// 设置日历为下周第一天,+2是下周从星期一开始，星期一是每周的第2天
		calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
		calendar.add(Calendar.DATE, day);
		return ymd(calendar.getTime());
	}
	
	public static Date[] getWeekStartAndEndDate(Date currentDate, int start) {
        // 将要返回的日期
        Date[] days = new Date[2];
        if(null != currentDate){
            // 日历
            Calendar calendar = new GregorianCalendar();
            // 设置日历为当前时间
            calendar.setTime(currentDate);
            // 得到今天是周几
            int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
            int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
            // 加入不是周日，设置日期到下一周
            if (dayofweek == 1) {
                calendar.set(Calendar.WEEK_OF_YEAR, weekofYear - 1);
            }
            // 得到当前是全年的第几周
            int nextWeekDay = calendar.get(Calendar.DATE);
            // 设置日历为下周第一天,+5是下周从星期四开始，星期四是每周的第5天
            calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
            calendar.add(Calendar.DATE, start);
            days[0] = calendar.getTime();
            days[0] = ymdHmsStr2Date(ymd(days[0]) + " 00:00:00");
            calendar.add(Calendar.DATE, 6);
            days[1] = calendar.getTime();
            days[1] = ymdHmsStr2Date(ymd(days[1]) + " 23:59:59");
        }
        return days;
    }
	
	public static String[] getWeekStartAndEndDate(String currentDate, int start) {
		// 将要返回的日期
		String[] days = new String[2];
        if(StringUtils.isEmpty(currentDate)){
            return days;
        }
		// 日历
		Calendar calendar = new GregorianCalendar();
		// 设置日历为当前时间
		calendar.setTime(ymdStr2Date(currentDate));
		// 得到今天是周几
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
		// 加入不是周日，设置日期到下一周
		if (dayofweek == 1) {
			if(weekofYear == 1){
				weekofYear = 53;
			}
			calendar.set(Calendar.WEEK_OF_YEAR, weekofYear - 1);
		}
		// 得到当前是全年的第几周
		int nextWeekDay = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
		calendar.add(Calendar.DATE, start);
		days[0] = ymd(calendar.getTime());
		calendar.add(Calendar.DATE, 6);
		days[1] = ymd(calendar.getTime());
		return days;
	}
	
	public static String[] getThisWeekStartEndDays() {
		return getWeekStartAndEndDate(ymd(new Date()), 0);
	}
	
	public static String[] getLastWeekStartEndDays() {
		return getWeekStartAndEndDate(ymd(new Date()), -7);
	}
	
	public static String[] getNextWeekStartEndDays() {
		return getWeekStartAndEndDate(ymd(new Date()), 7);
	}

	@SuppressWarnings("unchecked")
	public static List getWeekDateList(String date) throws ParseException {
		List<String> dateList = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		Date dateVar = ymd.parse(date);
		calendar.setTime(dateVar);
		dateList.add(date);
		for (int i = 1; i <= 6; i++) {
			calendar.set(6, calendar.get(6) + 1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String tomorrow = sdf.format(calendar.getTime());
			dateList.add(tomorrow);
		}
		return dateList;
	}
	
	public static String getNextDay(String currentDate) {
		Date d = ymdStr2Date(currentDate);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
		return ymd(c.getTime());
	}
	
	/**
	 * 获得开始时间和结束时间之间的时间列表
	 * @param startDate
	 * @param endDate
	 * @return List<String>
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public static List getDateList(String startDate, String endDate) throws ParseException {
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH); // 设定格式
		Date start = dateFormat.parse(startDate);
		Date end = dateFormat.parse(endDate);
		long day = ((end.getTime() - start.getTime()) / 1000);// 秒数
		day = day / (60 * 60 * 24); // 天数
		for (int i = 0; i <= day; i++) {
			String date = getAfterSomeDayYms(startDate, i);
			dateList.add(date);
		}
		return dateList;
	}	
	
	/**
	 * 判断所给时间在月的第几周
	 * @param date 输入时间
	 * @return 第几周
	 */
	public static int weekOfMonth(String date) {
		Date d = ymdStr2Date(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(Calendar.WEEK_OF_MONTH);
	}
	
	/**
	 * 获取当前星期几
	 */
	public static int weekDay(String date) {
		Date d = ymdStr2Date(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		return c.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	/**
	 * 时间判断，昨天/今天
	 * @return
	 */
	public static String getSubmitDate(String setTime) {
		 Date time = new Date();
	     if(time.after(DateUtils.ymdHmsStr2Date(DateUtils.getToday()+setTime))){
	     	return DateUtils.getToday();
	     }else{
	        return DateUtils.getYestoday();
	     }
	}
	
	/**
	 * 时间判断，上周/本周
	 * @return周一
	 */
	public static String getWeekStartDate(String setTime) {
		 Date time = new Date();
		 if(time.after(DateUtils.ymdHmsStr2Date(DateUtils.getToday()+setTime))){
			 	return DateUtils.getWeekStartAndEndDate(DateUtils.getToday(), 0)[0];
		    }else{
		    	return DateUtils.getWeekStartAndEndDate(DateUtils.getYestoday(), 0)[0];
		}
	}
	
	/**
	 * 时间判断，上周/本周
	 * @return
	 */
	public static String getWeekEndDate(String setTime) {
		 Date time = new Date();
		 if(time.after(DateUtils.ymdHmsStr2Date(DateUtils.getToday()+setTime))){
			 	return DateUtils.getWeekStartAndEndDate(DateUtils.getToday(), 0)[1];
		    }else{
		    	return DateUtils.getWeekStartAndEndDate(DateUtils.getYestoday(), 0)[1];
		}
	}
	
	/**
	 * 时间判断，上周/本周
	 * @param setTime 几点前
	 * @return
	 */
	public static String[] getWeekStartEndDate(String setTime) {
		 Date time = new Date();
		 if(time.after(DateUtils.ymdHmsStr2Date(DateUtils.getToday()+setTime))){
			 	return DateUtils.getWeekStartAndEndDate(DateUtils.getToday(), 0);
		    }else{
		    	return DateUtils.getWeekStartAndEndDate(DateUtils.getYestoday(), 0);
		}
	}
	
	/**
	 * 返回当前月的英文名
	 * @return
	 */
	public static String getMonthInEnglish(){
		String month = getMonth(ymd(new Date()));
		return getMonthInEnglish(month);
	}
	
	/**
	 * 返回当前季的英文名
	 * @return
	 */
	public static String getSeasonInEnglish(){
		String month = getMonth(ymd(new Date()));
		String season = getSeason(month)[4];
		return season;
	}
	
	/**
	 * 根据数字名的月返回英文名的月
	 * @param monthInNum
	 * @return
	 */
	public static String getMonthInEnglish(String monthInNum){
		if("01".equals(monthInNum)){
    		return "january";
    	}else if("02".equals(monthInNum)){
    		return "february";
    	}else if("03".equals(monthInNum)){
    		return "march";
    	}else if("04".equals(monthInNum)){
    		return "april";
    	}else if("05".equals(monthInNum)){
    		return "may";
    	}else if("06".equals(monthInNum)){
    		return "june";
    	}else if("07".equals(monthInNum)){
    		return "july";
    	}else if("08".equals(monthInNum)){
    		return "august";
    	}else if("09".equals(monthInNum)){
    		return "september";
    	}else if("10".equals(monthInNum)){
    		return "october";
    	}else if("11".equals(monthInNum)){
    		return "november";
    	}else {
    		return "december";
    	}
	}
	
	/**
	 * 根据某月返回上一个月数字名
	 * @param montth
	 * @return
	 */
	public static String getLastMonth(String montth){
		if("01".equals(montth)){
    		return "12";
    	}else if("02".equals(montth)){
    		return "01";
    	}else if("03".equals(montth)){
    		return "02";
    	}else if("04".equals(montth)){
    		return "03";
    	}else if("05".equals(montth)){
    		return "04";
    	}else if("06".equals(montth)){
    		return "05";
    	}else if("07".equals(montth)){
    		return "06";
    	}else if("08".equals(montth)){
    		return "07";
    	}else if("09".equals(montth)){
    		return "08";
    	}else if("10".equals(montth)){
    		return "09";
    	}else if("11".equals(montth)){
    		return "10";
    	}else {
    		return "11";
    	}
	}
	
	/**
	 * 返回给定年的上一年
	 * @param year
	 * @return
	 */
	public static String getLastYear(String year){
		int yearInt = Integer.parseInt(year);
		return String.valueOf(yearInt - 1);
	}
	
	public static String getYear(String year, int num){
		if(StringUtils.isEmpty(year)){
			return "";
		}
		int yearInt = Integer.parseInt(year);
		return String.valueOf(yearInt + num);
	}
	
	/**
	 * 根据给定的季度（1，2，3，4），返回季度内的月份数组
	 * @param season
	 * @return
	 */
	public static String[] getMonthArrayOnSeason(String season){
		String[] monthArray = new String[3];
		if("1".equals(season)){
			monthArray[0] = "01";
			monthArray[1] = "02";
			monthArray[2] = "03";
			return monthArray;
		}
		if("2".equals(season)){
			monthArray[0] = "04";
			monthArray[1] = "05";
			monthArray[2] = "06";
			return monthArray;
		}
		if("3".equals(season)){
			monthArray[0] = "07";
			monthArray[1] = "08";
			monthArray[2] = "09";
			return monthArray;
		}
		if("4".equals(season)){
			monthArray[0] = "10";
			monthArray[1] = "11";
			monthArray[2] = "12";
			return monthArray;
		}
		return monthArray;
	}
	
	/**
	 * 返回日期date 前推beforHour小时后的 日期
	 * @param date
	 * @param beforHour
	 * @return
	 */
	public static Date getBeforHourDate(Date date, int beforHour){
		
		if(date != null){
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.set(Calendar.HOUR, c.get(Calendar.HOUR)-beforHour);
			
			return c.getTime();
		}
		return null;
	}
	
	/**
	 * 返回日期 date 加上 afterHour 小时之后的日期
	 * @param date
	 * @param afterHour
	 * @return
	 */
	public static Date getAfterHourDate(Date date, int afterHour){
		if(date != null ){
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.HOUR_OF_DAY, afterHour);
			return c.getTime();
		}
		return null;
	}
	
	/**
	 * 返回日期 date 加上 afterMinute 分钟之后的日期
	 * @param date
	 * @param afterHour
	 * @return
	 */
	public static Date getAfterMinuteDate(Date date, int afterMinute){
		if(date != null ){
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MINUTE, afterMinute);
			return c.getTime();
		}
		return null;
	}
	
	public static Date getsetDate(Date date , int hours , int minute){
		if(date!=null){
			Calendar c = Calendar.getInstance();
			date = DateUtils.getFormatDate(date);
			c.setTime(date);
			c.set(Calendar.HOUR_OF_DAY, hours);
			c.set(Calendar.MINUTE, minute);
			return c.getTime();
		}
		return null;
	}
	
	public static Date getFormatDate(Date date){
		if(date != null ){
		
			String str = DateUtils.formaterDate(date, "yyyy-MM-dd");
			date = DateUtils.str2Date(str, "yyyy-MM-dd");
			String strDate = DateUtils.formaterDate(date,"yyyy-MM-dd HH:mm:ss");
			date = DateUtils.str2Date(strDate, "yyyy-MM-dd HH:mm:ss");
			return date;
		}
		return null;
	}
	
	/**
	 * 比较两个时间，date1 大于 date2 返 1 ， date1 小于 date2 返 -1 ，相等返回 0 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compartToDate(Date date1 , Date date2){
		if( date1!= null && date2!=null ){
			if(date1.getTime() > date2.getTime() ){
				return 1;
			}else if(date1.getTime()<date2.getTime()){
				return -1;
			}else{
				return 0;
			}
		}
        return 0;		
	}
	
	public static int getDateState(Date date){
		
		if(date!=null){
			Date date1 = DateUtils.getsetDate(date, 9, 30);
			
			Date date2 = DateUtils.getsetDate(date, 12, 0);
			
			Date date3 = DateUtils.getsetDate(date, 13, 0);
			
			Date date4 = DateUtils.getsetDate(date, 18, 30);
		
			if( date1.getTime() < date.getTime() && date.getTime() < date2.getTime() ){
				return 0;
			}else if( date2.getTime() < date.getTime() && date.getTime() < date3.getTime() ){
				return 1;
			}else if(date3.getTime() < date.getTime() && date.getTime() < date4.getTime() ){
				return 2;
			}else{
				return 3;
			}
			
		}
		return 0;
		
	}
	
	/**
	 * 取给定日期的前一天
	 * @param date
	 * @return
	 */
	public static Date getLastDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR,
				calendar.get(Calendar.DAY_OF_YEAR) - 1);
		return calendar.getTime();
	}
	
	/**
	 * 返回两个日期之间的日期列表，
	 * 其中不包括 参数较大日期，包括 参数较小的日期
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public static List getDayListBetween2Date(Date beginDate, Date endDate){
		
		List dayList = new ArrayList();
		
		Calendar c = Calendar.getInstance();
		
		if(beginDate.compareTo(endDate) <= 0){
			int day = getDayNumBetween2Date(beginDate, endDate);
			dayList.add(beginDate);
			c.setTime(beginDate);
			for(int i=0; i<day; i++){
				c.add(Calendar.DATE, 1);
				if(!isEqualsInYMD(endDate, c.getTime())){
					dayList.add(c.getTime());
				}
			}
			return dayList;
		}else {
			int day = getDayNumBetween2Date(endDate, beginDate);
			dayList.add(endDate);
			c.setTime(endDate);
			for(int i=0; i<day; i++){
				c.add(Calendar.DATE, 1);
				if(!isEqualsInYMD(beginDate, c.getTime())){
					dayList.add(c.getTime());
				}
			}
			return dayList;
		}
		
	}
	
	/**
	 * 返回两时间的相差天数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getDayNumBetween2Date(Date d1, Date d2){  
		
		if(isEqualsInYMD(d1, d2)){
			return 0;
		}
		
		long l = d2.getTime()-d1.getTime();   
		int day = (int) (l/(24*60*60*1000));
		if(day < 0){
			day = (-day);
		}
		
		int m = (int) (l%(24*60*60*1000));
		Calendar c = Calendar.getInstance();
		if(d1.compareTo(d2)<=0){
			c.setTime(d1);
			c.add(Calendar.MILLISECOND, m);
			if(isEqualsInYMD(d1, c.getTime())){
				return day;
			}else{
				return day+1;
			}
		}else{
			c.setTime(d2);
			c.add(Calendar.MILLISECOND, m);
			if(isEqualsInYMD(d2, c.getTime())){
				return day;
			}else{
				return day+1;
			}
		}
		
	}
	
	/**
	 * 两个时间是否是 同年 同月 同日
	 * 如果是，则返回true，否则返回false
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isEqualsInYMD(Date d1, Date d2){
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(d1);
		int year1 = c.get(Calendar.YEAR);
		int dayOfYear1 = c.get(Calendar.DAY_OF_YEAR);
		
		c.setTime(d2);
		int year2 = c.get(Calendar.YEAR);
		int dayOfYear2 = c.get(Calendar.DAY_OF_YEAR);
		
		if(year1 != year2){
			return false;
		}
		if(dayOfYear1 != dayOfYear2){
			return false;
		}
		
		return true;
	}
	
    /**
     * 获得当前月的前 i 个月
     * @param i (henrry)
     * return 月的数组
     */
    public static String[] getMonthArr(int i){
        String arr[] = new String[i];
        Calendar c = Calendar.getInstance();
        int temp = 0;
        int tempp = 0;
        int year = 0;
        int month = 0;
        int m = i-1;
        for(int j=0;j<m;j++){
            if(i>12){
                temp = (i-1)/12;
                tempp = (i-1)%12;
                year  = c.get(Calendar.YEAR)-temp;
                month = c.get(Calendar.MONTH)-tempp+1;
                if(month<10 && month >0){
                    arr[j] = year+"-0"+month;
                }else if(month<0){
                    month = 12+month;
                    if(month<10){
                        arr[j] = (year-1)+"-0"+month;
                    }else{
                        arr[j] = (year-1)+"-"+month;
                    }
                }else if(month == 0){
                    arr[j] = (year-1)+"-"+12;
                }else{
                    arr[j] = year+"-"+month;
                }
            }else{
                year  = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH)-i+2;
                if(month<10 && month >0){
                    arr[j] = year+"-0"+month;
                }else if(month<0){
                    month = 12+month;
                    if(month<10){
                        arr[j] = (year-1)+"-0"+month;
                    }else{
                        arr[j] = (year-1)+"-"+month;
                    }
                }else if(month==0){
                    arr[j] = (year-1)+"-"+12;
                }else{
                    arr[j] = year+"-"+month;
                }
            }
            i--;
        }
        int monthNow = c.get(Calendar.MONTH);
        if(monthNow>8){
        	arr[m] = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1);
        }else{
        	arr[m] = c.get(Calendar.YEAR) + "-0" + (c.get(Calendar.MONTH)+1);
        }
        return arr;
    }
    
    /**
     * 根据某月英文名返回一个月数字
     * @param montth
     * @return
     */
    public static String getMonthNumber(String monthEnName){
        if("january".equals(monthEnName)){
            return "01";
        }else if("february".equals(monthEnName)){
            return "02";
        }else if("march".equals(monthEnName)){
            return "03";
        }else if("april".equals(monthEnName)){
            return "04";
        }else if("may".equals(monthEnName)){
            return "05";
        }else if("june".equals(monthEnName)){
            return "06";
        }else if("july".equals(monthEnName)){
            return "07";
        }else if("august".equals(monthEnName)){
            return "08";
        }else if("september".equals(monthEnName)){
            return "09";
        }else if("october".equals(monthEnName)){
            return "10";
        }else if("november".equals(monthEnName)){
            return "11";
        }else if("december".equals(monthEnName)){
            return "12";
        }else if("spring".equals(monthEnName)){
            return "01";
        }else if("summer".equals(monthEnName)){
            return "04";
        }else if("autumn".equals(monthEnName)){
            return "07";
        }else{
            return "10";
        }
    }
    
    /**
     * 得到两个时间之间的差距，根据type可返回分别以天，时，分为单位的整数
     * @param d1
     * @param d2
     * @param type
     * @return
     */
    public static int getBetweenDateGap(Date d1, Date d2, String type){
    	long time1 = d1.getTime();
		long time2 = d2.getTime();
		long m = (time1-time2)/1000;
		int nDay = (int)m/(24*60*60);      
		int nHour = (int)(m-nDay*24*60*60)/(60*60);
		int nMinute = (int)(m-nDay*24*60*60-nHour*60*60)/60;
		int mSecond = (int)(m-nDay*24*60*60-nHour*60*60);
		if("day".equals(type)){
			return nDay;
		}else if("minute".equals(type)){
			return nMinute;
		}else if("hour".equals(type)){
			return nHour;
		}else if("second".equals(type)){
			return mSecond;
		}
		return nMinute;
    }

	/**
	 * *
	 * 通过月份计算季度 *
	 * @param
	 * month *
	 * @return
	 */
	public static int getQuarter(int month) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("month is invalid.");
		}
		return (month - 1) / 3 + 1;
	}
	
	/**获得时间
	 * @param type：日期显示方式（"yyyy-mmm-dd"，"yyyy-mmm-dd~yyyy-mmm-dd"）
	 * month *
	 * @return
	 */	
	public static String getDayAndWeekDate(String type,String functionName,String date, int day) {
		if (StringUtils.isEmpty(date)) {
			date = ymd(new Date());
		}
		date = getOpposeDay(date, day);
		StringBuffer reText = new StringBuffer();
		
		if(!"day".equals(type)){
			String endDate = getOpposeDay(date, 6);
			reText.append("<a href=\"javascript:void(0)\" style=\"background:url(/images/button/left_row.gif) no-repeat;background-position:5 5;float:left;width:25px;height:20px;\" onclick=\"selectPlanDate('"+type+"'," + functionName + ",'-7')\"></a>\n");
			reText.append("<span id=\"submitSelectDateId\" value=\"" + date + "\" style=\"font-weight:800;float:left;\">" + date + "~"+endDate+"</span>\n");
			reText.append("<a href=\"javascript:void(0)\" style=\"background:url(/images/button/right_row.gif) no-repeat ;background-position:5 5;float:left;width:25px;height:20px;\"  onclick=\"selectPlanDate('"+type+"'," + functionName + ",'7')\" style=\"cursor:hand\"></a>\n");
		} else {
			reText.append("<a href=\"javascript:void(0)\" style=\"background:url(/images/button/left_row.gif) no-repeat ;background-position:5 5;float:left;width:25px;height:20px;\" onclick=\"selectPlanDate('"+type+"',"+functionName+",'-1')\"></a>\n");
			reText.append("<span id=\"submitSelectDateId\" value=\"" + date + "\" style=\"font-weight:800;float:left;\">" + date + "日</span>\n");
			reText.append("<a href=\"javascript:void(0)\" style=\"background:url(/images/button/right_row.gif) no-repeat ;background-position:5 5;float:left;width:25px;height:20px;\" onclick=\"selectPlanDate('"+type+"',"+functionName+",'1')\"></a>\n");
		}
		return reText.toString();
	}
	
	public static void main(String args[]) {
/*        String  s1 = DateUtils.getYear("2010",-1);
		List<String> list = DateUtils.getMonthList("2009-03-01","2010-07-04");
		QuarterBean[] quarters = DateUtils.getRecentQuarters("2010-03-01",4);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
			System.out.println(list.get(i).substring(list.get(i).length()-2, list.get(i).length()));
			System.out.println(list[i].getDate());
		}
		System.out.println("----->" + s1);*/
		
		//Date date = DateUtils.getAfterMinuteDate(new Date(), 120);
//		int date = DateUtils.compartToDate(new Date(),DateUtils.ymdHmsStr2Date("2010-12-15 12:52:22"));
		//String str = DateUtils.formaterDate(date, "yyyy-MM-dd");
		//date = DateUtils.str2Date(str, "yyyy-MM-dd");
		//int sdf = DateUtils.getDateState(DateUtils.ymdHmsStr2Date("2010-11-30 14:52:22"));//(new Date(), 12, 0);
		//String s = DateUtils.ymdHm(sdf);
		Date date = getNewDayNumDate(-1);
		String str = DateUtils.formaterDate(date, "yyyy-MM-dd");
		//int ss = DateUtils.getDayNumBetween2Date(date,new Date());
		System.out.println(str);
		//System.out.println(date);

	}
}