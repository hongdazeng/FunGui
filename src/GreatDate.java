/**
 * Created by Hongda Zeng on 10/12/2015.
 * This class helps display and get the date.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GreatDate {

    String monthShort[] = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"};
    String monthLong[] = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"};
    GregorianCalendar calendar = new GregorianCalendar();

    boolean isLeapYear = false;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public GreatDate() {
        refresh();
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String getMonthShort() {
        return monthShort[month];
    }

    public String getMonthLong() {
        return monthLong[month];
    }

    public String getDate(boolean a) {
        String str;
        if (a) {
            str = (getMonthLong() + " " + day + ", " + year);
        } else {
            str = (getMonthShort() + " " + day + ", " + year);
        }
        return str;
    }

    public String getTime() {
        return (hour + ":" + minute + ":" + second);
    }

    public void refresh() {
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);

        if (calendar.isLeapYear(year)) {
            isLeapYear = true;
        }
    }
}
