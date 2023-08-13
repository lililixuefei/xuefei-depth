package labuladong.lru;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/29 10:18 AM
 * @Version 1.0
 */
public class Node {
	public int key, val;
	public Node next, prev;
	public Node(int k, int v) {
		this.key = k;
		this.val = v;
	}
}
