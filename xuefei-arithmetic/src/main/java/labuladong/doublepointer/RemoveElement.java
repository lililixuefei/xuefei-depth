package labuladong.doublepointer;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/28 11:44 上午
 * @Version 1.0
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
