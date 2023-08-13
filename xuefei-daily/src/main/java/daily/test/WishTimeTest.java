package daily.test;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/23 11:02 AM
 * @Version 1.0
 */
public class WishTimeTest {

    public static void main(String[] args) {
        System.out.println(getDayTime() * 1000L + 86400000);
        System.out.println(getNextDayStartTime());

        System.out.println(getDayTime() * 1000L);
    }

    public static Integer getDayTime() {
        long current = System.currentTimeMillis() + 8 * 3600000;
        Integer time = (int) (current / (1000 * 3600 * 24) * (3600 * 24) - 8 * 3600); //时间戳是8点开始算的
        return time;
    }

    /**
     * 获取接下来一天的开始时间
     *
     * @return
     */
    public static Long getNextDayStartTime() {
        long current = 1677513600000L + 8 * 3600000;
        return (current / (1000 * 3600 * 24) * (3600 * 24) - 8 * 3600) * 1000L + 86400000;
    }
}
