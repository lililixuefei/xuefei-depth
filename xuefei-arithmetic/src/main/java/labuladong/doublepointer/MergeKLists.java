package labuladong.doublepointer;

import labuladong.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/1 10:16 上午
 * @Version 1.0
 */
public class MergeKLists {

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

}
