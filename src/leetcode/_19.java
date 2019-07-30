package leetcode;

public class _19 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        for(ListNode node = head; node != null; node = node.next, length++);
        if(length == n)
            return head.next;
        ListNode node = head;
        for(int i = 1; i < length - n; i++)
            node = node.next;

        node.next = node.next.next;
        return head;
    }
}
