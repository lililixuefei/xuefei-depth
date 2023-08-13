package labuladong.list;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/21 11:21 上午
 * @Version 1.0
 */
public class MiddleNode {

    ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }

}
