package clover.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/28 5:14 PM
 * @Version 1.0
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow]) {
				slow++;
				// 维护 nums[0..slow] 无重复
				nums[slow] = nums[fast];
			}
			fast++;
		}
		// 数组长度为索引 + 1
		return slow + 1;
	}

}
