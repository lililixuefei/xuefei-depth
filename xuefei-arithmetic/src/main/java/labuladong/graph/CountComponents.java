package labuladong.graph;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/23 2:32 PM
 * @Version 1.0
 */
public class CountComponents {

	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		// 将每个节点进行连通
		for (int[] e : edges) {
			uf.union(e[0], e[1]);
		}
		// 返回连通分量的个数
		return uf.count();
	}

}
