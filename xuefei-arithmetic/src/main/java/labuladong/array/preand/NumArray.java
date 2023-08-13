package labuladong.array.preand;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/1/30 5:15 PM
 * @Version 1.0
 */
public class NumArray {

    private int[] preNums;

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(0, 5));
    }

    public NumArray(int[] nums) {
        // 构建前缀和数组
        this.preNums = buildPreNums(nums);
    }

    private int[] buildPreNums(int[] nums) {
        int[] prefixAndArray = new int[nums.length + 1];
        int prefixAnd = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            prefixAndArray[i] = (prefixAnd += nums[i - 1]);
        }
        return prefixAndArray;
    }

    /**
     * 查询闭区间 [left, right] 的累加和
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        // base case
        if (left < 0 || left > preNums.length - 1 || right < 0 || right > preNums.length - 1) {
            throw new IllegalArgumentException("left or right illegal");
        }
        return preNums[right + 1] - preNums[left];
    }

}
