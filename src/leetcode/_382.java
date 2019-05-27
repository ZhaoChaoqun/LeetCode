package leetcode;

import java.util.Random;

public class _382 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    Random random;
    ListNode head;
    /*@param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public _382(ListNode head) {
        random = new Random();
        this.head = head;
    }

    /*Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        ListNode result = head;
        for(ListNode node = head.next; node != null; node = node.next)
            // 选择第i个元素的概率是1/i
            if(random.nextInt(++count) == 0)
                result = node;
        return result.val;
    }
}

