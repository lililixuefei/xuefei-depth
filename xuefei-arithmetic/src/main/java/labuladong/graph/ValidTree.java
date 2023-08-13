package labuladong.graph;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/23 2:44 PM
 * @Version 1.0
 */
public class ValidTree {

	// 判断输入的若干条边是否能构造出一棵树结构
	boolean validTree(int n, int[][] edges) {
		// 初始化 0...n-1 共 n 个节点
		UnionFind uf = new UnionFind(n);
		// 遍历所有边，将组成边的两个节点进行连接
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			// 若两个节点已经在同一连通分量中，会产生环
			if (uf.connected(u, v)) {
				return false;
			}
			// 这条边不会产生环，可以是树的一部分
			uf.union(u, v);
		}
		// 要保证最后只形成了一棵树，即只有一个连通分量
		return uf.count() == 1;
	}

}
