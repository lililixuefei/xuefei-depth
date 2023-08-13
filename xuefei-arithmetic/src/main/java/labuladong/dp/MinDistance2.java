package labuladong.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/16 11:36 上午
 * @Version 1.0
 */
public class MinDistance2 {

	int minEditDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		return dp(s1, s1.length() - 1, s2, s2.length() - 1);
	}

	public static void main(String[] args) {
		MinDistance2 minDistance2 = new MinDistance2();
		String s1 = "horse";
		String s2 = "ros";

		System.out.println(minDistance2.minEditDistance_dp(s1, s2));
		System.out.println(minDistance2.minEditDistance_dp_2(s1, s2));
	}


	int minEditDistance_dp(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[m][n];
	}

	int minEditDistance_dp_2(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		Node[][] dp = new Node[m + 1][n + 1];
		dp[0][0] = new Node();
		dp[0][0].val = 0;
		dp[0][0].choice = 0;
		for (int i = 1; i <= m; i++) {
			dp[i][0] = new Node();
			dp[i][0].val = i;
			dp[i][0].choice = 2;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = new Node();
			dp[0][j].val = j;
			dp[0][j].choice = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = new Node();
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j].val = dp[i - 1][j - 1].val;
					dp[i][j].choice = 0;
					System.out.println("i = " + s1.charAt(i - 1) + ", j = " + s2.charAt(j - 1) + "什么都不做");
				} else {
					int value1 = dp[i - 1][j].val + 1;
					int value2 = dp[i][j - 1].val + 1;
					int value3 = dp[i - 1][j - 1].val + 1;
					int minValue = min(value1, value2, value3);

					dp[i][j].val = minValue;
					if (value1 == minValue) {
						System.out.println("i = " + s1.charAt(i - 1) + ", j = " + s2.charAt(j - 1) + "删除");
						dp[i][j].choice = 2;
					} else if (value2 == minValue) {
						dp[i][j].choice = 1;
						System.out.println("i = " + s1.charAt(i - 1) + ", j = " + s2.charAt(j - 1) + "插入");
					} else {
						dp[i][j].choice = 3;
						System.out.println("i = " + s1.charAt(i - 1) + ", j = " + s2.charAt(j - 1) + "替换");
					}
				}
			}
		}
		return dp[m][n].val;
	}

	class Node {
		public int val;
		public int choice;
		// 0 代表啥都不做
		// 1 代表插入
		// 2 代表删除
		// 3 代表替换
	}


	public static int dp(String s1, int i, String s2, int j) {
		// base case
		if (i == -1) {
			return j + 1;
		}
		if (j == -1) {
			return i + 1;
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return dp(s1, i - 1, s2, j - 1);
		} else {
			return min(dp(s1, i - 1, s2, j) + 1,  // 删除
					dp(s1, i, s2, j - 1) + 1,  // 插入
					dp(s1, i - 1, s2, j - 1)) + 1;  // 替换
		}
	}


	private static int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}

}