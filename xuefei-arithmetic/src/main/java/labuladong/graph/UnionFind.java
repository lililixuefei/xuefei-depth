package labuladong.graph;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/23 11:40 AM
 * @Version 1.0
 */
public class UnionFind {

	// 记录连通分量
	private int count;
	// 节点 x 的父节点是 parent[x]
	private final int[] parent;

	// 新增一个数组记录树的“重量”
	private int[] size;

	/* 构造函数，n 为图的节点总数 */
	public UnionFind(int n) {
		// 一开始互不连通
		this.count = n;
		// 父节点指针初始指向自己
		parent = new int[n];
		// 最初每棵树只有一个节点
		// 重量应该初始化 1
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	/* 将 p 和 q 连接 */
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}

		// 小树接到大树下面，较平衡
		if (size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		count--;
	}

	// 判断节点 p 和节点 q 是否连通
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}

	/* 返回某个节点 x 的根节点 */
	private int find(int x) {
		// 根节点的 parent[x] == x
		while (parent[x] != x) {
			x = parent[x];
		}
		return x;
	}

	/* 返回当前的连通分量个数 */
	public int count() {
		return count;
	}

}
