package labuladong.graph;

import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/23 2:56 PM
 * @Version 1.0
 */
public class MinimumCost {

	int minimumCost(int n, int[][] connections) {
		// 城市编号为 1...n，所以初始化大小为 n + 1
		UnionFind uf = new UnionFind(n + 1);
		// 对所有边按照权重从小到大排序
		Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
		// 记录最小生成树的权重之和
		int mst = 0;
		for (int[] edge : connections) {
			int u = edge[0];
			int v = edge[1];
			int weight = edge[2];
			// 若这条边会产生环，则不能加入 mst
			if (uf.connected(u, v)) {
				continue;
			}
			// 若这条边不会产生环，则属于最小生成树
			mst += weight;
			uf.union(u, v);
		}
		// 保证所有节点都被连通
		// 按理说 uf.count() == 1 说明所有节点被连通
		// 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
		return uf.count() == 2 ? mst : -1;
	}

}
