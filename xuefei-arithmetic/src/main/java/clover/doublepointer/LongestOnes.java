package clover.doublepointer;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/17 2:19 下午
 * @Version 1.0
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            tot += nums[i];
            while ((i - j + 1) - tot > k) {
                tot -= nums[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}
