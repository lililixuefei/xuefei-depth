package clover.preand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/20 8:22 下午
 * @Version 1.0
 */
public class MaxScore {

    public int maxScore(String s) {
        int n = s.length(), ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (s.charAt(i - 1) - '0');
        }
        for (int i = 1; i <= n - 1; i++) {
            int a = i - sum[i], b = sum[n] - sum[i];
            ans = Math.max(ans, a + b);
        }
        return ans;
    }

}
