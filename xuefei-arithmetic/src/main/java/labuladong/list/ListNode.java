package labuladong.list;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/1 10:21 AM
 * @Version 1.0
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6};
        ListNode listNode = buildList(nums, 0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode buildList(int[] nums, int i) {
        if (i == nums.length) {
            return null;
        }
        ListNode listNode = new ListNode();
        listNode.val = nums[i];
        listNode.next = buildList(nums, i + 1);
        return listNode;
    }
}
