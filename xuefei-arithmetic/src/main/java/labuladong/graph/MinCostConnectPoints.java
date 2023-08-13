package labuladong.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/23 4:03 PM
 * @Version 1.0
 */
public class MinCostConnectPoints {

	int minCostConnectPoints(int[][] points) {
		int n = points.length;
		// 生成所有边及权重
		List<int[]> edges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int xi = points[i][0], yi = points[i][1];
				int xj = points[j][0], yj = points[j][1];
				// 用坐标点在 points 中的索引表示坐标点
				edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
			}
		}
		// 将边按照权重从小到大排序
		edges.sort((a, b) -> {
			return a[2] - b[2];
		});
		// 执行 Kruskal 算法
		int mst = 0;
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
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
		return mst;
	}

}
