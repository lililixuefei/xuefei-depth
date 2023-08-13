package clover.preand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/20 6:45 下午
 * @Version 1.0
 */
public class LargestSumOfAverages {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(largestSumOfAverages(nums, 3));
    }

    public static double largestSumOfAverages(int[] nums, int m) {
        int n = nums.length;
        double[] sum = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        double[][] f = new double[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                if (j == 1) {
                    f[i][1] = sum[i] / i;
                } else {
                    for (int k = 2; k <= i; k++) {
                        f[i][j] = Math.max(f[i][j], f[k - 1][j - 1] + (sum[i] - sum[k - 1]) / (i - k + 1));
                    }
                }
            }
        }
        return f[n][m];
    }
}
