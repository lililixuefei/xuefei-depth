package labuladong.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/20 5:56 PM
 * @Version 1.0
 */
public class PermuteRepeat {

	List<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();

	public List<List<Integer>> permuteRepeat(int[] nums) {
		backtrack(nums);
		return res;
	}

	// 回溯算法核心函数
	void backtrack(int[] nums) {
		// base case，到达叶子节点
		if (track.size() == nums.length) {
			// 收集叶子节点上的值
			res.add(new LinkedList(track));
			return;
		}

		// 回溯算法标准框架
		for (int i = 0; i < nums.length; i++) {
			// 做选择
			track.add(nums[i]);
			// 进入下一层回溯树
			backtrack(nums);
			// 取消选择
			track.removeLast();
		}
	}

}
