package labuladong.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/8 10:26 AM
 * @Version 1.0
 */
public class LengthOfLIS {

	public static void main(String[] args) {
		int[] nums = new int[]{10, 9, 25, 37, 101, 18};
		System.out.println(lengthOfLIS(nums));
		System.out.println(lengthOfLIS2(nums));

		for (int i = 0; i < 1000; i++) {
			int[] array = buildRandomArray(1000);
			int i1 = lengthOfLIS(array);
			int i2 = lengthOfLIS2(array);
			System.out.println(i1 + " == " + i2);
		}
	}

	private static int[] buildRandomArray(int i) {
		Random random = new Random();
		int[] nums = new int[i];
		for (int j = 0; j < i; j++) {
			nums[j] = random.nextInt(i);
		}
		return nums;
	}


	public static int lengthOfLIS2(int[] nums) {
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
		for (int j : dp) {
			res = Math.max(res, j);
		}
		return res;
	}


	// wrong
	public static int lengthOfLIS(int[] nums) {
		// 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
