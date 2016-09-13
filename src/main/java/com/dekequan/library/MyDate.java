package com.dekequan.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * 
 * <p>日期相关类</p>
 * @author TTM
 * @date 2016年9月13日 下午11:16:10
 * @version 1.0
 */
@SuppressWarnings("static-access")
public class MyDate {

	/**
     * this attribute use the 24 hour format date show year, month, day, hour, minute, second
     * 例如:2014-10-04 16:04:50
     */
    public String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * this attribute use the UTC(Coordinated Universal Time) format date
     * 例如:
     */
    public String UTCDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * this attribute show year, month, day
     * 例如:2014-10-04
     */
    public String dateFormat = "yyyy-MM-dd";

    /**
     * this attribute only show year, month
     * 例如:2014-10
     */
    public String dateShortFormat = "yyyy-MM";

    /**
     * this attribute only show year, week
     *
     */
    public String weekFormat = "yyyy-ww";

    /**
     * this attribute only show year, month
     *
     */
    public String monthFormat = "yyyy-MM";
    public String yearFormat = "yyyy";


    /**
     * 获得当前时间,按格式 yyyy-MM-dd HH:mm:ss进行解析,并以Date类型返回
     * @return 返回Date类型时间，如：Wed Oct 29 11:04:30 CST 2014
     */
    public synchronized Date getCurrentTimeD() {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);

        Date date = null;
        try {
            date = df.parse(getCurrentTime());
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 获得当前时间,按格式 yyMMdd 进行解析,并以Date类型返回
     * @return 返回Date类型时间，如：Thu Jan 21 00:00:00 CST 2021
     */
    public Date getCurrentShortDateD() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMdd");

        Date date = new Date();
        try {
            date = df.parse(getCurrentTime());
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 获得当前时间,按格式为yyMMddHHmmss的字符串类型返回
     * @return 返回字符串类型时间，如：141029110430,表示 14年10月29日11时04分30秒
     */
    public String getCurrentDigitDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");

        return df.format(new Date());
    }

    /**
     * 获得亚洲上海的当前时间,按格式为yyyy-MM-dd HH:mm:ss的字符串类型返回
     * @return 返回字符串类型时间，如：2014-10-29 11:04:30
     */
    public synchronized String getCurrentDateTime() {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符

        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);

        return df.format(new Date());
    }

    /**
     * 获得亚洲上海的当前时间,按格式yyyy-MM-dd HH:mm:ss进行解析后返回Date类型时间
     * @return 返回Date类型时间，如：Wed Oct 29 11:04:30 CST 2014
     */
    public synchronized Date getCurrentDateTimeD() {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符

        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Date date = new Date();
        try {
            df.parse(getCurrentTime());
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 获得当前时间,按格式为yyyyMMddHHmmss的字符串类型返回
     * @return 返回字符串类型时间，如：20141029110430,表示2014年10月29日11时04分30秒
     */
    public String getCurrentFullDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        return df.format(new Date());
    }

    /**
     * 将指定时间，按世界标准时间以 yyyy-MM-dd HH:mm:ss格式返回字符串类型的时间
     * @param date 指定时间
     * @param dateTimeFormat 指定格式
     * @return  返回字符串类型的时间,如:2014-10-29 11:04:30
     */
    public String toUTCDateString(Date date, String dateTimeFormat) {
        if (null == dateTimeFormat) {
            dateTimeFormat = this.dateTimeFormat;
        }
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        return df.format(date);
    }

    /**
     * 获得当前时间,按世界标准时间以 yyyy-MM-dd'T'HH:mm:ss'Z 格式返回字符串类型的时间
     * @return 返回字符串类型的时间,形如: 2014-10-29T03:04:30Z
     */
    public String getCurrentUTCDatetime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        return df.format(getCurrentDateTimeD());
    }

    /**
     * 将指定时间，按世界标准时间以 yyyy-MM-dd'T'HH:mm:ss'Z 格式返回字符串类型的时间
     * @param date 指定时间
     * @return 返回字符串类型的时间,形如: 2014-10-29T03:04:30Z
     */
    public String toUTCDateString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        return df.format(date);
    }

    /**
     * 将格式为yyyy-MM-dd的字符串类型时间转化成毫秒数
     * @param dateStr 指定的格式为yyyy-MM-dd的字符串
     * @return 返回long类型的毫秒数,例如：指定时间为 2014-10-29，转成毫秒数为1414540800000
     */
    public Long dateToUTCMicroSecs(String dateStr) {
        return dateToUTCMicroSecs(dateStr, "yyyy-MM-dd");
    }

    /**
     * 将指定格式的字符串类型时间转化成毫秒数
     * @param dateStr 指定的字符串类型时间
     * @param format 指定的格式
     * @return 返回long类型的毫秒数,例如：指定时间为 2014-10-29，转成毫秒数为1414540800000
     */
    public Long dateToUTCMicroSecs(String dateStr, String format) {
        Date date = null;
        Long microSecs = 0L;
        try {
            DateFormat df = new SimpleDateFormat(format);
            date = df.parse(dateStr);
            Calendar cal = Calendar.getInstance(TimeZone.getDefault());
            cal.setTime(date);
            microSecs = date.getTime() + cal.getTimeZone().getRawOffset();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return microSecs;
    }

    /**
     * 将指定的毫秒数转化成格式为yyyy-MM-dd字符串类型的日期
     * @param microSecs 指定的毫秒数
     * @return	返回字符串类型的日期,例如：指定毫秒数为1414540800000，则字符串类型的日期为2014-10-29
     */
    public String UTCMicroSecsToDate(Long microSecs) {
        try {
            DateFormat df = new SimpleDateFormat(dateFormat);
            Calendar cal = Calendar.getInstance(TimeZone.getDefault());

            return df.format(microSecs - cal.getTimeZone().getRawOffset());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获得亚洲上海的当前时间,并以格式为yyyy-MM-dd'T'HH:mm:ss'+08:00的字符串类型时间返回
     * @return	返回字符串类型时间,形如:2014-10-29T11:04:30+08:00
     */
    public String getChinaTimeZoneTime() {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+08:00'");

        return df.format(new Date());
    }

    /**
     * 获得指定区的日期
     * @param timeZoneStr 给定的时区
     * @param dateFormat 要显示的日期格式
     * @param locale 地区
     * @param date 日期类型的日期
     * @return
     */
    public String getTimeZoneDateTime(String timeZoneStr, String dateFormat, Locale locale, Date date) {
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneStr);
        SimpleDateFormat outputFormat = new SimpleDateFormat(dateFormat, locale);
        outputFormat.setTimeZone(timeZone);

        return outputFormat.format(date);
    }

    /**
     * 获得当前时间，并将其以 yyMMdd 格式字符串类型时间返回
     * @return 返回字符串类型时间,形如:141029
     */
    public String getCurrentShortDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMdd");

        return df.format(new Date());
    }

    /**
     * 获得当前时间的秒数部分
     * @return 返回秒数部分,例如：当前时间为2014-10-29 11:04:30,则返回的秒数部分为30
     */
    public String getCurrentSecends() {
        SimpleDateFormat df = new SimpleDateFormat("ss");

        return df.format(new Date());
    }

    /**
     * 获得当前时间，并将其以 2014-10-04 格式的日期类型显示出来
     * @return
     */
    public Date getCurrentLongDateD() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        try {
            date = df.parse(getCurrentTime());
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 获得当前时间，并将其以 yyyy-MM-dd 格式的字符串类型时间返回
     * @return	返回字符串类型时间,形如:2014-10-29
     */
    public String getCurrentLongDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        return df.format(new Date());
    }

    /**
     * 获得当前时间，并将其以 yyyy,MM,dd 格式的字符串类型显示出来
     * @return 返回字符串类型时间,形如:2014,10,29
     */
    public String getCurrentLongStringDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy,MM,dd");

        return df.format(new Date());
    }

    /**
     * 获得当前时间，并将其以 2014-10-04 格式的日期类型显示出来
     * @return
     */
    public Date getCurrentDateD() {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);

        Date date = new Date();
        try {
            date = df.parse(getCurrentDate());
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 获得当前时间，并将其以 yyyy-MM-dd HH:mm:ss 格式的字符串类型时间返回
     * @return	返回字符串类型时间,形如:2014-10-29 11:04:30
     */
    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);

        return df.format(new Date());
    }

    /**
     * 获得当前时间，并将其以 yyyy-MM 格式的字符串类型时间返回
     * @return 返回字符串类型时间,形如:2014-10
     */
    public String getCurrentMonthOnly() {
        SimpleDateFormat df = new SimpleDateFormat(dateShortFormat);

        return df.format(new Date());
    }

    /**
     * 获得在指定格式为yyyy-MM的字符串类型时间上增加或减少月份数后的字符串类型时间
     * @param count 增加或减少月份数
     * @param dateStr 格式为yyyy-MM的字符串类型时间
     * @return 返回增加或减少月份数后的字符串类型时间,例如：count为 2,dateStr为 2014-10,则返回 2014-12
     */
    public String getMonthOnly(Integer count, String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateShortFormat);
        Calendar calDate = Calendar.getInstance();
        if (null != dateStr) {
            calDate.setTime(parseShortDate(dateStr));
        }
        calDate.add(Calendar.MONTH, count);

        return df.format(calDate.getTime());
    }

    /**
     * 获得当前时间，并将其以 yyyy-MM-dd 格式的字符串类型时间返回
     * @return 返回字符串类型时间,形如:2014-10-29
     */
    public String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);

        return df.format(new Date());
    }

    /**
     * 获得当前时间，并将其以 yyyy-MM 格式的字符串类型时间返回
     * @return	返回字符串类型时间,形如:2014-10
     */
    public String getCurrentMonth() {
        SimpleDateFormat df = new SimpleDateFormat(monthFormat);

        return df.format(new Date());
    }

    /**
     * 将字符串类型的日期增加指定的天数后
     * @param count 要增加的天数
     * @param format 指定日期格式
     * @param dateStr 要转化的字符串类型的日期
     * @return
     */
    public Date getDateD(int count, String format, String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(format);

        Date date = new Date();
        try {
            date = df.parse(getDate(count, format, dateStr));
        } catch (Exception e) {
        }

        return date;
    }

    /**
     * 获得在指定格式的字符串类型时间上增加或减少天数后的字符串类型时间
     * @param count	增加或减少天数
     * @param format 指定的格式
     * @param dateStr 字符串类型时间
     * @return	返回增加或减少天数后的字符串类型时间,例如：count为 2,format为 yyyy-MM-dd, dateStr为 2014-10-29,则返回 2014-10-31
     */
    public String getDate(int count, String format, String dateStr) {
        Calendar calDate = Calendar.getInstance();
        if (null != dateStr) {
            calDate.setTime(parseDate(dateStr));
        }
        calDate.add(Calendar.DATE, count);
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(calDate.getTime());
    }

    /**
     * 将字符串类型的日期转成形如 2014-10-04 的日期类型的日期
     * @param dateStr 字符串类型的日期
     * @return 日期类型的日期
     */
    public Date parseDate(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);

        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 将字符串类型的日期转成形如 2014-10 的日期类型的日期
     * @param dateStr 字符串类型的日期
     * @return 日期类型的日期
     */
    public Date parseShortDate(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateShortFormat);

        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 获得在格式为yyyy-MM-dd HH:mm:ss的字符串类型时间上增加或减少天数后的字符串类型时间
     * @param count 增加或减少天数
     * @param dateStr 格式为yyyy-MM-dd HH:mm:ss的字符串类型时间
     * @return	返回增加或减少天数后的字符串类型时间,例如：count为 2, dateStr为 2014-10-29 11:04:30,则返回 2014-10-31 11:04:30
     */
    public String getDateTime(int count, String dateStr) {
        Calendar calDate = Calendar.getInstance();
        if (null != dateStr) {
            calDate.setTime(parseDate(dateStr, dateTimeFormat));
        }
        calDate.add(Calendar.DATE, count);
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);

        return sdf.format(calDate.getTime());

    }

    /**
     * 获得在当前时间格式为yyyy-MM-dd HH:mm:ss的字符串类型时间上增加或减少天数后的字符串类型时间
     * @param count 传入增加或减少的天数
     * @return 返回增加或减少天数后的字符串类型时间,例如：count为 2,当前时间为2014-10-29 11:04:30, 则返回 2014-10-31 11:04:30
     */
    public String getDateTime(int count) {
        return getDateTime(count, getCurrentDateTime());
    }

    /**
     * 获得在当前时间格式为yyyy-MM-dd HH:mm:ss的字符串类型时间上增加或减少工作日后的字符串类型时间
     * @param count 传入增加或减少的工作日
     * @return 返回增加或减少天数后的字符串类型时间,例如：count为 2, 当前时间为2014-10-29 11:04:30, 则返回 2014-10-31 11:04:30
     */
    public String getWorkingDateTime(int count) {
        GregorianCalendar cal = new GregorianCalendar();
        Date date = getDateTimeD(count);
        cal.setTime(date);
        if (count < 0) {
            if (Calendar.SATURDAY == cal.get(cal.DAY_OF_WEEK) || Calendar.SUNDAY == cal.get(cal.DAY_OF_WEEK)) {
                return getDateTime(count - 2);
            }
        } else {
            if (Calendar.SATURDAY == cal.get(cal.DAY_OF_WEEK) || Calendar.SUNDAY == cal.get(cal.DAY_OF_WEEK)) {
                return getDateTime(count + 2);
            }
        }

        return getDateTime(count);
    }


    public Date getDateTimeD(int count) {
        return parseDate(getDateTime(count, getCurrentDateTime()));
    }

    /**
     * 获得在格式为yyyy-MM-dd的字符串类型时间上增加或减少天数后的字符串类型时间
     * @param count 增加或减少天数
     * @param dateStr 格式为yyyy-MM-dd的字符串类型时间
     * @return	返回增加或减少天数后的字符串类型时间,例如：count为 2,dateStr为 2014-10-29, 则返回 2014-10-31
     */
    public String getDate(int count, String dateStr) {
        Calendar calDate = Calendar.getInstance();
        if (null != dateStr) {
            calDate.setTime(parseDate(dateStr, dateFormat));
        }
        calDate.add(Calendar.DATE, count);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        return sdf.format(calDate.getTime());
    }

    /**
     * 获得在当前时间格式为yyyy-MM-dd的字符串类型时间上增加或减少天数后的字符串类型时间
     * @param count 增加或减少天数
     * @return	返回增加或减少天数后的字符串类型时间,例如：count为 2,当前时间为 2014-10-29, 则返回 2014-10-31
     */
    public String getDate(int count) {
        return getDate(count, getCurrentDate());
    }

    /**
     * 将字符串类型的日期转成指定格式的日期类型的日期
     * @param dateStr 字符串类型的日期
     * @param dateTimeFormat 指定日期格式
     * @return
     */
    public Date parseDate(String dateStr, String dateTimeFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 将字符串类型的日期按 yyyy-MM-dd 格式进行解析后的Long类型的日期
     * @param dateStr 字符串类型的日期
     * @return
     */
    public Long parseDateToTime(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);

        Long minSecs = 0L;
        try {
            minSecs = df.parse(dateStr).getTime();
        } catch (Exception e) {
        }

        return minSecs;
    }

    /**
     * 将字符串类型的日期按 yyyy/MM/dd 格式
     * @param dateStr 字符串类型的日期
     * @return
     */
    public String formatDate(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dateTime = null;
        String date = null;
        try {
            dateTime = df.parse(dateStr);
            date = sdf.format(dateTime);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 将字符串类型的日期转成以2014-10-04 16:04:50格式的Long类型的日期
     * @param dateStr 字符串类型的日期
     * @return
     */
    public Long parseDateTimeToTime(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Long minSecs = 0L;
        try {
            minSecs = df.parse(dateStr).getTime();
        } catch (Exception e) {
        }

        return minSecs;
    }

    /**
     * 将字符串类型的日期转成指定格式的Long类型的日期
     * @param dateStr 字符串类型的日期
     * @param format 指定日期格式
     * @return
     */
    public Long parseDateFormatToTime(String dateStr, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Long minSecs = 0L;
        try {
            minSecs = df.parse(dateStr).getTime();
        } catch (Exception e) {
        }

        return minSecs;
    }

    /**
     * 将字符串类型的日期先转成形如2014-10-04 16:04:50的日期,再转成以毫秒为单位的Long类型的日期
     * @param dateStr
     * @return
     */
    public Long dateTimeToSecs(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);

        Long minSecs = 0L;
        try {
            minSecs = df.parse(dateStr).getTime() / 1000;
        } catch (Exception e) {
        }

        return minSecs;
    }

    /**
     * 将字符串类型的日期先转成指定格式的日期,再转成以毫秒为单位的Long类型的日期
     * @param dateStr
     * @return
     */
    public Long dateTimeToSecs(String dateStr, String timeFormat) {
        SimpleDateFormat df = new SimpleDateFormat(timeFormat);

        Long minSecs = 0L;
        try {
            minSecs = df.parse(dateStr).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return minSecs;
    }

    /**
     * 将Long类型的日期转成形如2014-10-04 16:04:50的字符串类型的日期
     * @param secs
     * @return
     */
    public String secsToDateTime(Long secs) { // secs为秒
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        String date = df.format(new Date(secs * 1000));

        return date;
    }

    /**
     * 获得亚洲上海的当前时间,按格式为yyyy-MM-dd HH:mm:ss的字符串类型返回
     * @param dateTimeStr
     * @return
     */
    public Date parseDateTime(String dateTimeStr) {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);

        Date date = null;
        try {
            date = df.parse(dateTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }


    public Date parseUTCDateTime(String dateTimeStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = df.parse(dateTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }


    public Long UTCToSecs(String dateTimeStr) {
        SimpleDateFormat df = new SimpleDateFormat(UTCDateTimeFormat);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Long secs = 0L;
        try {
            secs = df.parse(dateTimeStr).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return secs;
    }

    /**
     * 获得在指定格式为yyyy-MM-dd'T'HH:mm:ss'Z'的字符串类型时间上增加或减少分钟数后的字符串类型的世界标准时间
     * @param dateTimeStr 指定格式为yyyy-MM-dd'T'HH:mm:ss'Z'的字符串类型时间
     * @param mins 增加或减少分钟数
     * @return  返回字符串类型的世界标准时间,例如：dateTimeStr为 2014-10-29T11:04:30Z,mins为 2,则返回 2014-10-29T11:06:30Z
     */
    public String UTCDateTimeAddMin(String dateTimeStr, int mins) {
        SimpleDateFormat df = new SimpleDateFormat(UTCDateTimeFormat);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Long secs = UTCToSecs(dateTimeStr);
        Long newSecs = secs + mins * 60;
        String date = df.format(new Date(newSecs * 1000));

        return date;
    }

    /**
     * 获得在指定格式为yyyy-MM-dd'T'HH:mm:ss'Z'的字符串类型时间上增加或减少秒数后的字符串类型的世界标准时间
     * @param dateTimeStr 指定格式为yyyy-MM-dd'T'HH:mm:ss'Z'的字符串类型时间
     * @param addSecs 增加或减少秒数
     * @return  返回字符串类型的世界标准时间,例如：dateTimeStr为 2014-10-29T11:04:30Z,addSecs为 2,则返回 2014-10-29T11:04:32Z
     */
    public String UTCDateTimeAddSecs(String dateTimeStr, Long addSecs) {
        SimpleDateFormat df = new SimpleDateFormat(UTCDateTimeFormat);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Long secs = UTCToSecs(dateTimeStr);
        Long newSecs = secs + addSecs;
        String date = df.format(new Date(newSecs * 1000));

        return date;
    }

    /* 返回两个时间的相差秒数 */
    public long dateTimeDiffer(String dateTime1, String dateTime2) {
        return dateTimeToSecs(dateTime1) - dateTimeToSecs(dateTime2);
    }

    /* 返回现在与给定时间的相差秒数 */
    public long dateTimeDiffer(String dateTime2) {
        return dateTimeToSecs(getCurrentDateTime()) - dateTimeToSecs(dateTime2);
    }

    /**
     * 获得在指定格式为yyyy-MM-dd HH:mm:ss 的字符串类型时间上增加或减少分钟数后的字符串类型的世界标准时间
     * @param mins 增加或减少分钟数
     * @return  返回字符串类型的世界标准时间,例如：dateTimeStr为 2014-10-29T11:04:30Z,mins为 2,则返回 2014-10-29T11:06:30Z
     */
    public String getDateTimeAddMin(int mins) {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.MILLISECOND, 1000 * 60 * mins);

        return df.format(new Date(cal.getTimeInMillis()));
    }

    public String getDateTimeAddMin(int mins, String dateTimeFormat) {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.MILLISECOND, 1000 * 60 * mins);

        return df.format(new Date(cal.getTimeInMillis()));
    }

    public String getCurrentDateAddMin(int mins, String dateTimeFormat) {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区
        TimeZone.setDefault(zone);// 设置时区,使得输出时间与现在所处地区时间相符
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.MINUTE, mins);

        return df.format(new Date(cal.getTimeInMillis()));
    }


    public String dateTimeAddSecs(String dateTimeStr, Long addSecs) {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Long secs = dateTimeToSecs(dateTimeStr);
        Long newSecs = secs + addSecs;
        String date = df.format(new Date(newSecs * 1000));

        return date;
    }

    public String dateAdd(int sec, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        if (null == dateStr) {
            date = new Date();
        } else {
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, sec);

        return sdf.format(cal.getTime());
    }


    public String changeSecToReadable(Long sec) {
        StringBuilder readableTime = new StringBuilder();

        readableTime.append(sec / (60 * 60 * 24));
        readableTime.append("天");
        readableTime.append(sec % (60 * 60 * 24) / (60 * 60));
        readableTime.append("时");
        readableTime.append(sec % (60 * 60 * 24) % (60 * 60) / 60);
        readableTime.append("分");
        readableTime.append(sec % (60 * 60 * 24) % (60 * 60) % 60);
        readableTime.append("秒");
        return readableTime.toString();
    }

    /**
     * number表示几个月    比如上一个月是-1    上上个月是-2
     * 获得当前时间的上一个月的时间,并以yyyy-MM-dd HH:mm:ss的格式返回字符串类型时间
     * @return 返回字符串类型时间,例如：当前时间为2014-10-29 11:04:30,则返回 2014-09-29 11:04:30
     */
    public String getLastMonthDateTime(int number) {
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, number);
        Date dd = cal.getTime();
        return df.format(dd);
    }

    public Integer getMinute(String dateTimeStr) {
        Date date = parseDateTime(dateTimeStr);

        return getMinute(date);
    }

    public Integer getMinute(Date date) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.MINUTE);
    }

    public Integer getHour(String dateTimeStr) {
        Date date = parseDateTime(dateTimeStr);

        return getHour(date);
    }

    public Integer getHour(Date date) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public Integer getDay(String dateTimeStr) {
        Date date = parseDateTime(dateTimeStr);

        return getDay(date);
    }

    public Integer getDay(Date date) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.DATE);
    }

    public Integer getMonth(String dateTimeStr) {
        Date date = parseDateTime(dateTimeStr);

        return getMonth(date);
    }

    public Integer getMonth(Date date) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.MONTH);
    }

    public Integer getYear(String dateTimeStr) {
        Date date = parseDateTime(dateTimeStr);

        return getYear(date);
    }

    public Integer getYear(Date date) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.YEAR);
    }


    public Integer secsToDay(Long seconds) {
        long day = seconds / (24 * 60 * 60);
        Integer dayInt = (int) Math.floor(day);

        return dayInt;

    }

    /**
     * 获得当前时间提前一天后的时间，并以yyyy-MM-dd HH:mm:ss格式返回该字符串类型的时间
     * @return 返回字符串类型的时间,例如：当前时间为 2014-10-29 11:04:30,则返回 2014-10-28 11:04:30
     */
    public String getPast24DateTime() {
        return getDateTime(-1, getCurrentDateTime());
    }

    public String parseDateByWeek(String date) {
        SimpleDateFormat dfForDate = new SimpleDateFormat(dateFormat);
        SimpleDateFormat dfForWeek = new SimpleDateFormat(weekFormat);
        try {
            return dfForWeek.format(dfForDate.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFirstDayOfThisMonth() {
        return getCurrentMonth() + "-01";
    }

    /* 日期格式: 1970-01-01 */
    public Integer subtractDates(String leftDate, String rightDate) {
        return subtractDates(parseDate(leftDate), parseDate(rightDate));
    }

    public Integer subtractDates(Date leftDate, Date rightDate) {
        long diff = Math.abs(leftDate.getTime() - rightDate.getTime());

        return (int) (diff / (24 * 60 * 60 * 1000));
    }

    /**
     *
     * @return
     */
    public Calendar getCurrentLongDateCalendar() {
        Calendar calendar;
        try {
            Date newDate = getCurrentLongDateD();
            calendar = Calendar.getInstance();
            calendar.setTime(newDate);
            System.out.println(calendar.getTime());

            return calendar;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }


    public Integer dateDayTimeDiffer(String dateTime1, String dateTime2){

        long quot = 0;
        DateFormat ft = new SimpleDateFormat(dateFormat);
        try {
            Date date1 = ft.parse(dateTime1);
            Date date2 = ft.parse(dateTime2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Math.abs(Integer.parseInt(String.valueOf(quot)));
    }

    /**
     * 把时间段拆分为日期集合
     *
     * 返回日期集合, 例如输入2014-06-01, 2016-06-03, 输出 [2014-06-01, 2014-06-02, 2014-16-03]}
     */
    public ArrayList<String> splitDateRange(String startDate, String endDate) {
        ArrayList<String> dates = new ArrayList<String>();
        do {
            dates.add(startDate);
            startDate = getDate(1, startDate);
        } while (startDate.compareTo(endDate) < 0);

        dates.add(endDate);

        return dates;
    }

    /**
     * 把时间段拆分为日期集合对
     *
     * 返回日期集合对, 例如输入2014-06-01, 2016-06-03, 输出 [[2014-06-01, 2014-06-02], [2014-06-02, 2014-16-03]]
     */
    public ArrayList<ArrayList<String>> splitDateRangeToPair(String startDate, String endDate) {
        ArrayList<String> dates = splitDateRange(startDate, endDate);
        ArrayList<ArrayList<String>> datePairs = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < dates.size() - 1;) {
            ArrayList<String> ds = new ArrayList<String>();
            ds.add(dates.get(i));
            ds.add(dates.get(++i));
            datePairs.add(ds);
        }

        return datePairs;
    }

    /**
     * 把时间段拆分为日期集合对
     *
     * 返回日期集合对, 例如输入2014-06-01 11:00:00, 2016-06-01 14:00:00, 输出 {2014-06-01 11:00:00 : 2014-06-01 12:00:00,... 2014-06-01 13:00:00:2014-06-01 14:00:00}
     */
    public LinkedHashMap<String, String> splitDateRangeToHour(String startDate, String endDate, int hour) {
        LinkedHashMap<String, String> hourMap = new LinkedHashMap<String, String>();
        Calendar calDate = Calendar.getInstance();
        do{
            if (null != dateTimeFormat) {
                calDate.setTime(parseDate(startDate, dateTimeFormat));
            }
            calDate.add(Calendar.HOUR,  +hour);
            SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
            String oneHourDate = sdf.format(calDate.getTime());
            if (oneHourDate.compareTo(endDate) > 0) {
                oneHourDate = endDate;
            }
            hourMap.put(startDate, oneHourDate);
            startDate = oneHourDate;
        } while(startDate.compareTo(endDate) < 0);
        return hourMap;
    }



    /**
     * 将指定的Date类型的日期以yyyy-MM-dd HH:mm:ss格式返回字符串类型的时间
     * @param date 指定的Date类型的日期
     * @return 返回字符串类型的时间,例如：date为 Wed Oct 29 11:04:30 CST 2014,则返回 2014-10-29 11:04:30
     */
    public String getDateTimeString(Date date){
        SimpleDateFormat df = new SimpleDateFormat(dateTimeFormat);
        return df.format(date);
    }

    public String getDateTimeString(String date, String forMate) {
        SimpleDateFormat formatDate = new SimpleDateFormat(forMate);
        String str = null;
        try {
            Date time = formatDate.parse(date);
            str = formatDate.format(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getNextDayTime(String startDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Calendar c = Calendar.getInstance();// 获得一个日历的实例
        Date date = null;
        String nextDate = "";
        try {
            date = sdf.parse(startDate);// 初始日期
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            nextDate = sdf.format(c.getTime());
        } catch (Exception e) {
            System.out.println("------------DateFormatError---------");
            return null;
        }
        return nextDate;
    }

    /**
     *
     * 根据时间求取当前周的第一天 <功能详细描述>
     * @param time
     * @param dateformate
     * @return
     * @see [类、类#方法、类#成员]
     */
    public String getFirstDateOfWeekByTime(String time, String dateformate) {
        Calendar c = Calendar.getInstance();// 获得一个日历的实例
        Date date = this.getDateD(0, dateformate, time);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        c.roll(Calendar.DAY_OF_WEEK, 7);
        return this.getDateTimeString(c.getTime());
    }

    /**
     *
     * 根据时间求取当前月的第一天 <功能详细描述>
     *
     * @param time
     * @param dateformate
     * @return
     * @see [类、类#方法、类#成员]
     */
    public String getFirstDateOfMonthByTime(String time, String dateformate) {
        Calendar c = Calendar.getInstance();// 获得一个日历的实例
        Date date = this.getDateD(0, dateformate, time);
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return this.getDateTimeString(c.getTime());
    }

    /**
     * 根据时间求取当前月的最后一天 <功能详细描述>
     *
     * @param time
     * @param dateformate
     * @return
     * @see [类、类#方法、类#成员]
     */
	public String getLastDateOfMonthByTime(String time, String dateformate){
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        Date date = this.getDateD(0, dateformate, time);
        calendar.setTime(date);
        //得到一个月最最后一天日期(31/30/29/28)
        int maxDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        calendar.set(calendar.DAY_OF_MONTH, maxDay);
        calendar.set(calendar.HOUR_OF_DAY,23);
        calendar.set(calendar.MINUTE,59);
        calendar.set(calendar.SECOND,59);
        return getDateTimeString(calendar.getTime());
    }

    /**
     *
     * <一句话功能简述>
     * <功能详细描述>
     * @param date
     * @return
     * @see [类、类#方法、类#成员]
     */
    public XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return gc;
    }

    /**
     *
     * <一句话功能简述>
     * <功能详细描述>
     * @param cal
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public  Date convertToDate(XMLGregorianCalendar cal) throws Exception{
        GregorianCalendar ca = cal.toGregorianCalendar();
        return ca.getTime();
    }

    /**
     * 格林威治时间转在北京时间
     * @param utcTime
     * @return
     */
    public String utcDate2BeijingDate(String utcTime) {
        SimpleDateFormat utcFormater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localFormater.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    /**
     * UTC时间转在当地时间
     * @param utcTime
     * @return
     */
    public String utcDate2BeijingDate(String utcTime,String format) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(format);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        localFormater.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    /**
     * 获取当前为星期几,从星期日~星期六对应的值是1~7
     *
     * @return 星期几
     */
    public static int getDayOfWeek() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        return cal.get(Calendar.DAY_OF_WEEK);
    }

	
}
