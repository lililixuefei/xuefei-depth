package clover.preand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/17 10:24 上午
 * @Version 1.0
 */
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex.pivotIndex(nums));

        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(pivotIndex.pivotIndex(nums2));

        int[] nums3 = new int[]{2, 1, -1};
        System.out.println(pivotIndex.pivotIndex(nums3));

    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int num : nums) {
            total += num;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum == total - sum - nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }


    public int pivotIndex_preand(int[] nums) {
        int n = nums.length;
        int[] preAnd = new int[n + 1];
        preAnd[0] = 0;
        for (int i = 1; i <= n; i++) {
            preAnd[i] = preAnd[i - 1] + nums[i - 1];
        }

        for (int i = 1; i < preAnd.length; i++) {
            if (preAnd[i] == preAnd[n] - preAnd[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }
}
