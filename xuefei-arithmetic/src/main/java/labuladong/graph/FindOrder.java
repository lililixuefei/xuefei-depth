package labuladong.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/17 8:17 PM
 * @Version 1.0
 */
public class FindOrder {

	// 记录一次递归堆栈中的节点
	boolean[] onPath;
	// 记录遍历过的节点，防止走回头路
	boolean[] visited;
	// 记录图中是否有环
	boolean hasCycle = false;
	// 记录后序遍历结果
	List<Integer> postorder = new ArrayList<>();


	// 4 {{1,0},{2,0},{3,1},{3,2}}
	// r [0,2,1,3]   or   [0,1,2,3]
	// w [0,1,3,2]

	int[] findOrder(int numCourses, int[][] prerequisites) {
		// 先保证图中无环
		if (!canFinish(numCourses, prerequisites)) {
			return new int[]{};
		}
		// 建图
		List<Integer>[] graph = buildGraph(numCourses, prerequisites);

		// 进行 DFS 遍历
		visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			traverse(graph, i);
		}

		// 将后序遍历结果反转，转化成 int[] 类型
		Collections.reverse(postorder);
		int[] res = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			res[i] = postorder.get(i);
		}
		return res;
	}

	void traverse(List<Integer>[] graph, int s) {
		if (visited[s]) {
			return;
		}

		visited[s] = true;
		for (int t : graph[s]) {
			traverse(graph, t);
		}
		// 后序遍历位置
		postorder.add(s);
	}

	boolean canFinish(int numCourses, int[][] prerequisites) {

		List<Integer>[] graph = buildGraph(numCourses, prerequisites);

		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			// 遍历图中的所有节点
			traverse1(graph, i);
		}
		// 只要没有循环依赖可以完成所有课程
		return !hasCycle;
	}

	List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
		// 图中共有 numCourses 个节点
		List<Integer>[] graph = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] edge : prerequisites) {
			int from = edge[1], to = edge[0];
			// 添加一条从 from 指向 to 的有向边
			// 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
			graph[from].add(to);
		}
		return graph;
	}

	void traverse1(List<Integer>[] graph, int s) {
		if (onPath[s]) {
			// 出现环
			hasCycle = true;
		}

		if (visited[s] || hasCycle) {
			// 如果已经找到了环，也不用再遍历了
			return;
		}
		// 前序代码位置
		visited[s] = true;
		onPath[s] = true;
		for (int t : graph[s]) {
			traverse1(graph, t);
		}
		// 后序代码位置
		onPath[s] = false;
	}

}
