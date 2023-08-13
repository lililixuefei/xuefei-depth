package clover.slidingwindow;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/21 4:22 下午
 * @Version 1.0
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0, max = 0;
        for (int i = 0; i < n; i++) {
            cur += customers[i];
            if (i >= minutes) {
                cur -= customers[i - minutes];
            }
            max = Math.max(max, cur);
        }
        return ans + max;
    }

}
