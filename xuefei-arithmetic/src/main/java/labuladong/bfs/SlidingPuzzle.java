package labuladong.bfs;

import java.util.*;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/31 10:42 AM
 * @Version 1.0
 */
public class SlidingPuzzle {

	int[][] neighbours = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

	public int slidingPuzzle(int[][] board) {

		// 转码为字符串
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < board.length; i++) {
			for (int temp : board[i]) {
				sb.append(temp);
			}
		}
		String initial = sb.toString();

		// 已经是最终解
		if ("123450".equals(initial)) {
			return 0;
		}

		int step = 0;
		Queue<String> queue = new LinkedList<>();
		queue.offer(initial);
		Set<String> set = new HashSet<>();
		set.add(initial);

		while (!queue.isEmpty()) {
			step++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String current = queue.poll();
				// 枚举当前字符串通过和"0"交换产生的所有情况
				assert current != null;
				for (String next : getNext(current)) {
					if (!set.contains(next)) { // 去重
						if (next.equals("123450")) {
							return step;
						} else {
							queue.offer(next);
							set.add(next);
						}
					}
				}
			}
		}
		return -1;
	}

	public List<String> getNext(String current) {
		List<String> list = new ArrayList<>();
		char[] cur = current.toCharArray();
		int x = current.indexOf('0');
		for (int y : neighbours[x]) {
			swap(cur, x, y);
			list.add(new String(cur));
			swap(cur, x, y); // 复原
		}
		return list;
	}

	public void swap(char[] array, int x, int y) {
		char temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
