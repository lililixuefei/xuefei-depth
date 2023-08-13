package daily.prefixand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/21 11:46 AM
 * @Version 1.0
 */
public class BestClosingTime {

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] f = new int[n + 2];
        int[] g = new int[n + 2];
        //计算前缀有几个N
        // 认为下标从1开始，最后答案减1
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] + (customers.charAt(i - 1) == 'N' ? 1 : 0);
        }
        //计算后缀有几个Y
        g[n + 1] = 0;
        for (int i = n; i > 0; i--) {
            g[i] = g[i + 1] + (customers.charAt(i - 1) == 'Y' ? 1 : 0);
        }
        //依次遍历找最少代价
        int ans = 0, best = Integer.MAX_VALUE;
        for (int i = 1; i <= n + 1; i++) {
            int tmp = f[i - 1] + g[i];
            if (tmp < best) {
                ans = i;
                best = tmp;
            }
        }
        return ans - 1;
    }

}
