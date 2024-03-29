package clover.string;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/27 10:41 AM
 * @Version 1.0
 */
public class Compress {

	public int compress(char[] cs) {
		int n = cs.length;
		int i = 0, j = 0;
		while (i < n) {
			int idx = i;
			while (idx < n && cs[idx] == cs[i]) {
				idx++;
			}
			int cnt = idx - i;
			cs[j++] = cs[i];
			if (cnt > 1) {
				int start = j, end = start;
				while (cnt != 0) {
					cs[end++] = (char) ((cnt % 10) + '0');
					cnt /= 10;
				}
				reverse(cs, start, end - 1);
				j = end;
			}
			i = idx;
		}
		return j;
	}

	void reverse(char[] cs, int start, int end) {
		while (start < end) {
			char t = cs[start];
			cs[start] = cs[end];
			cs[end] = t;
			start++;
			end--;
		}
	}

}