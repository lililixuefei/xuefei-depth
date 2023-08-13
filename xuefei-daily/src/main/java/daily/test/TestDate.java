package daily.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/19 5:15 PM
 * @Version 1.0
 */
public class TestDate {

	public static void main(String[] args) {

		System.out.println(getWeekNumInYear(new Date(1673257680000L)));


	}


	/**
	 * 获取日期属于当年第几周, 跨年的周会被计算到下一年
	 *
	 * @param date 日期
	 * @return 当年第几周
	 */
	public static int getWeekNumInYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.setMinimalDaysInFirstWeek(7);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
}
