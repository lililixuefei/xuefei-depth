package labuladong.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/26 10:44 AM
 * @Version 1.0
 */
public class Pick {

	int sz;

	private final Random rand = new Random();

	Map<Integer, Integer> mapping = new HashMap<>();

	public Pick(int n, int[] blacklist) {
		sz = n - blacklist.length;
		for (int b : blacklist) {
			mapping.put(b, 666);
		}
		int last = n - 1;
		for (int b : blacklist) {
			// 如果 b 已经在区间 [sz, N)
			// 可以直接忽略
			if (b >= sz) {
				continue;
			}
			while (mapping.containsKey(last)) {
				last--;
			}
			mapping.put(b, last);
			last--;
		}
	}

	int pick() {
		// 随机选取一个索引
		int index = rand.nextInt(sz);
		// 这个索引命中了黑名单，
		// 需要被映射到其他位置
		if (mapping.containsKey(index)) {
			return mapping.get(index);
		}
		// 若没命中黑名单，则直接返回
		return index;
	}


}
