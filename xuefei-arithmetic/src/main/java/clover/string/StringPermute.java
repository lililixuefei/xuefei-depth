package clover.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/27 10:32 AM
 * @Version 1.0
 */
public class StringPermute {

	int N = 10;

	Set<String> set = new HashSet<>();

	boolean[] vis = new boolean[N];

	public String[] permutation(String s) {
		char[] cs = s.toCharArray();
		dfs(cs, 0, "");
		String[] ans = new String[set.size()];
		int idx = 0;
		for (String str : set) {
			ans[idx++] = str;
		}
		return ans;
	}

	void dfs(char[] cs, int u, String cur) {
		int n = cs.length;
		if (u == n) {
			set.add(cur);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (vis[i]) {
				continue;
			}
			vis[i] = true;
			dfs(cs, u + 1, cur + cs[i]);
			vis[i] = false;
		}
	}

}
