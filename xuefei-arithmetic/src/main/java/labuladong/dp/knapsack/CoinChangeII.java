package labuladong.dp.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 7:11 PM
 * @Version 1.0
 */
public class CoinChangeII {


    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
//        System.out.println(coinChange1(coins, 11));
//        System.out.println(coinChange(11, coins));
    }

    public static int coinChange(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

}
