package clover.preand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/17 11:59 上午
 * @Version 1.0
 */
public class MaxAbsoluteSum {

    public static void main(String[] args) {
        MaxAbsoluteSum maxAbsoluteSum = new MaxAbsoluteSum();
        int[] nums = new int[]{1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum.maxAbsoluteSum(nums));

        int[] nums2 = new int[]{2, -5, 1, -4, 3, -2};
        System.out.println(maxAbsoluteSum.maxAbsoluteSum(nums2));
    }

    public int maxAbsoluteSum(int[] nums) {
        int[] preAnd = new int[nums.length + 1];
        preAnd[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preAnd[i] = preAnd[i - 1] + nums[i - 1];
        }
        int maxAbsoluteSum = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            min = Math.min(min, preAnd[i]);
            max = Math.max(max, preAnd[i]);
            maxAbsoluteSum = max(maxAbsoluteSum, Math.abs(preAnd[i] - min), Math.abs(preAnd[i] - max));
        }
        return maxAbsoluteSum;
    }

    public int max(int a, int b, int c) {
        return Math.max(c, Math.max(a, b));
    }

}
