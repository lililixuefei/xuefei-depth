package labuladong.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/8 10:32 AM
 * @Version 1.0
 */
public class MaxEnvelopes {

	// envelopes = [[w, h], [w, h]...]
	public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;

		// 按宽度升序排列，如果宽度一样，则按高度降序排列
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
			}
		});

		// 对高度数组寻找 LIS
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = envelopes[i][1];
		}

		return lengthOfLIS(height);
	}

	int lengthOfLIS(int[] nums) {
		// 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
		int[] dp = new int[nums.length];
		// base case：dp 数组全都初始化为 1
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
