package labuladong.dp;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/8 10:56 AM
 * @Version 1.0
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("zabcde", "acez"));
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
        // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
        // base case: dp[0][..] = dp[..][0] = 0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 现在 i 和 j 从 1 开始，所以要减一
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    // 备忘录，消除重叠子问题
    static int[][] memo;

    /* 主函数 */
    public static int longestCommonSubsequence3(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        return dp(s1, 0, s2, 0);
    }

    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    public static int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        // 如果之前计算过，则直接返回备忘录中的答案
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 根据 s1[i] 和 s2[j] 的情况做选择
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }

    public static int longestCommonSubsequence2(String s1, String s2) {
        return dp2(s1, 0, s2, 0);
    }

    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    public static int dp2(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + dp2(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 中至少有一个字符不在 lcs 中，
            // 穷举三种情况的结果，取其中的最大结果
            return max(
                    // 情况一、s1[i] 不在 lcs 中
                    dp2(s1, i + 1, s2, j),
                    // 情况二、s2[j] 不在 lcs 中
                    dp2(s1, i, s2, j + 1),
                    // 情况三、都不在 lcs 中
                    dp2(s1, i + 1, s2, j + 1));
        }
    }

    private static int max(int i, int j, int k) {
        return Math.max(i, Math.max(j, k));
    }
}
