package clover.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/23 4:52 下午
 * @Version 1.0
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate_2(nums, 3));

        int[] nums1 = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums1, 1));

        int[] nums2 = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums2, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            while (right - left > k) {
                left++;
            }
            if (nums[right] == nums[left]) {
                return true;
            }
            right++;
        }
        return false;
    }

    public static boolean containsNearbyDuplicate_2(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
