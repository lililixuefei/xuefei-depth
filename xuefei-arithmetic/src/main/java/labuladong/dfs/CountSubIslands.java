package labuladong.dfs;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/29 7:50 PM
 * @Version 1.0
 */
public class CountSubIslands {

	int countSubIslands(int[][] grid1, int[][] grid2) {
		int m = grid1.length, n = grid1[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid1[i][j] == 0 && grid2[i][j] == 1) {
					// 这个岛屿肯定不是子岛，淹掉
					dfs(grid2, i, j);
				}
			}
		}
		// 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid2[i][j] == 1) {
					res++;
					dfs(grid2, i, j);
				}
			}
		}
		return res;
	}

	// 从 (i, j) 开始，将与之相邻的陆地都变成海水
	void dfs(int[][] grid, int i, int j) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}
		if (grid[i][j] == 0) {
			return;
		}

		grid[i][j] = 0;
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
	}

}
