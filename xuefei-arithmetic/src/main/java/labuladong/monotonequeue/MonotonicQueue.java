package labuladong.monotonequeue;

import java.util.LinkedList;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/1 4:27 PM
 * @Version 1.0
 */
public class MonotonicQueue {

    LinkedList<Integer> maxq = new LinkedList<>();

    public void push(int n) {
        // 将小于 n 的元素全部删除
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        // 然后将 n 加入尾部
        maxq.addLast(n);
    }

    public int max() {
        return maxq.getFirst();
    }

    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}
