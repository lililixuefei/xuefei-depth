package labuladong.array;

import java.util.*;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/26 10:31 AM
 * @Version 1.0
 */
public class RandomizedSet {

	private final Map<Integer, Integer> idxMap;
	private final List<Integer> nums;
	private final Random rand = new Random();

	/**
	 * Initialize your data structure here.
	 */
	public RandomizedSet() {
		this.nums = new ArrayList<>();
		this.idxMap = new HashMap<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
	 */
	public boolean insert(int val) {
		//不能重复，要判重，但是数组的查找是O（n），用用哈希map判重
		if (idxMap.containsKey(val)) {
			return false;
		}
		idxMap.put(val, nums.size());
		nums.add(val);//向一个动态数组的末尾插入元素，平均时间复杂度是O（1）
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified element.
	 */
	public boolean remove(int val) {
		//如果不存在这个元素，直接返回false
		if (!idxMap.containsKey(val)) {
			return false;
		}

		// 拿到需要删除的元素在列表中的索引位置
		int index = idxMap.get(val);

		// 将列表中的最后一个元素覆盖掉需要删除的元素
		int lastNum = nums.get(nums.size() - 1);
		nums.set(index, lastNum);

		// 更新最后一个元素的索引
		idxMap.put(lastNum, index);

		// 删除数组列表中的最后一个元素
		nums.remove(nums.size() - 1);
		// 从 map 中删除指定的元素
		idxMap.remove(val);
		return true;
	}

	/**
	 * Get a random element from the set.
	 */
	public int getRandom() {//随机访问数组中的元素
		return nums.get(rand.nextInt(nums.size()));
		//上面可以随机访问的Random接口private Random rand = new Random();
		//索引的范围是0到数组的长度-1，nextInt 不包含最大值，不用减1
	}

}
