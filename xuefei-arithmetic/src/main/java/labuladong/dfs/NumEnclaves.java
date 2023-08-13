package labuladong.dfs;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/29 7:31 PM
 * @Version 1.0
 */
public class NumEnclaves {

	int numEnclaves(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		// 淹掉靠边的陆地
		for (int i = 0; i < m; i++) {
			dfs(grid, i, 0);
			dfs(grid, i, n - 1);
		}
		for (int j = 0; j < n; j++) {
			dfs(grid, 0, j);
			dfs(grid, m - 1, j);
		}

		// 数一数剩下的陆地
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					res += 1;
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
			// 已经是海水了
			return;
		}
		// 将 (i, j) 变成海水
		grid[i][j] = 0;
		// 淹没上下左右的陆地
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
	}

}
