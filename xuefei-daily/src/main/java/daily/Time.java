package daily;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/17 7:56 PM
 * @Version 1.0
 */
public class Time {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
//        System.out.println(getLastDayOfWeek(calendar));
//
//        System.out.println(getEndDayOfWeek(calendar));

        calendar.setTimeInMillis(1708654858000L);
        System.out.println(getLastDayOfWeek(calendar));

        System.out.println(getEndDayOfWeek(calendar));
    }
    public static Long getEndDayOfWeek(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 1 - (dayOfWeek == 0 ? 7 : dayOfWeek);
        calendar.add(Calendar.DATE, offset + 6);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 获取某年某周的最后一天，时间戳
     *
     * @return 某年某周的最后一天
     */
    public static Long getLastDayOfWeek(Calendar calendar) {
        //因为calender每周第一天是周日，而我们统计的周次是从周一开始算，所以周日的周次需要减一
        int week = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? calendar.get(Calendar.WEEK_OF_YEAR) - 1 :
                calendar.get(Calendar.WEEK_OF_YEAR);
        return getLastDayOfWeekEnd(calendar.get(Calendar.YEAR), week, Calendar.MONDAY, 1);
    }




    public static Long getFirstDayOfWeek(Calendar calendar) {
        //因为calender每周第一天是周日，而我们统计的周次是从周一开始算，所以周日的周次需要减一
        int week = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? calendar.get(Calendar.WEEK_OF_YEAR) - 1 :
                calendar.get(Calendar.WEEK_OF_YEAR);
        return getFirstDayOfWeek(calendar.get(Calendar.YEAR), week, Calendar.MONDAY, 1);
    }

    public static Long getFirstDayOfWeek(int year, int week, int firstDayInWeek, int minimalDaysInFirstWeek) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置周
        cal.set(Calendar.WEEK_OF_YEAR, week);
        // 设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, firstDayInWeek);
        cal.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);

        setBeginTime(cal);
        return cal.getTime().getTime();
    }

    private static void setBeginTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }



    public static Long getLastDayOfWeekEnd(int year, int week, int firstDayInWeek, int minimalDaysInFirstWeek) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置周
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.setMinimalDaysInFirstWeek(minimalDaysInFirstWeek);
        // 设置该周第一天为星期一
        cal.setFirstDayOfWeek(firstDayInWeek);
        // 设置最后一天是星期日
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);

        setEndTime(cal);
        return cal.getTime().getTime();
    }

    private static void setEndTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
    }
}
