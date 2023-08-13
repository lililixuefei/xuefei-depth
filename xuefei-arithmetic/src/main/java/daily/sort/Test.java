package daily.sort;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/23 5:12 PM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,565,6,2323,12,4,35};
        Arrays.stream(sort(nums)).forEach(System.out::println);
    }

    public static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
