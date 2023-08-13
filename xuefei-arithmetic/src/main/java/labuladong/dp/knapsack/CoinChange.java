package labuladong.dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 7:11 PM
 * @Version 1.0
 */
public class CoinChange {

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
//        System.out.println(coinChange1(coins, 11));
        System.out.println(coinChange(coins, 5));
    }

    public static int coinChange(List<Integer> coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static int coinChange1(List<Integer> coins, int amount) {
        return dp(amount, coins);
    }


    public static int dp(int n, List<Integer> coins) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subproblem = dp(n - coin, coins);
            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }
}
