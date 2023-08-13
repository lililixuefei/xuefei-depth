package labuladong.array.diff;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/25 10:48 AM
 * @Version 1.0
 */
public class GetModifiedArray {

	int[] getModifiedArray(int length, int[][] updates) {

		// nums 初始化为全 0
		int[] nums = new int[length];
		// 构造差分解法
		Difference df = new Difference(nums);

		for (int[] update : updates) {
			int i = update[0];
			int j = update[1];
			int val = update[2];
			df.increment(i, j, val);
		}

		return df.result();
	}

}
