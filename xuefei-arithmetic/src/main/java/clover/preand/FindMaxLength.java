package clover.preand;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/20 7:37 下午
 * @Version 1.0
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            int t = sum[i];
            if (map.containsKey(t)) {
                ans = Math.max(ans, i - map.get(t));
            }
            if (!map.containsKey(t)) {
                map.put(t, i);
            }
        }
        return ans;
    }
}
