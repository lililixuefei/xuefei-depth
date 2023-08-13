package labuladong.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/14 7:06 PM
 * @Version 1.0
 */
public class Fibonacci {


    int fib4(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }


    int fib3(int N) {
        int[] dp = new int[N + 1];
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }


    int fib2(int N) {
        if (N < 1) {
            return 0;
        }
        // 备忘录全初始化为 0
        int[] memo = new int[N + 1];
        // 初始化最简情况
        return helper(memo, N);
    }


    int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }


    int fib1(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib1(N - 1) + fib1(N - 2);
    }
}
