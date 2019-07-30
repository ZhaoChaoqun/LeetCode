package leetcode;

public class _2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private void singleAdd(ListNode result, ListNode l2, int carrybit) {
        result.next = l2;
        if(carrybit == 1) {
            for(; l2.next != null; l2 = l2.next) {
                l2.val += 1;
                if(l2.val < 10)
                    break;
                l2.val %= 10;
            }
            if(l2.next == null) {
                l2.val += 1;
                if(l2.val >= 10) {
                    l2.val %= 10;
                    l2.next = new ListNode(1);
                }
            }
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int carrybit = 0;
        for(; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next, result = result.next) {
            int val = l1.val + l2.val + carrybit;
            if(val >= 10) {
                result.next = new ListNode(val % 10);
                carrybit = 1;
            } else {
                result.next = new ListNode(val);
                carrybit = 0;
            }
        }
        if(l2 != null) {
            singleAdd(result, l2, carrybit);
        } else if(l1 != null) {
            singleAdd(result, l1, carrybit);
        } else if(carrybit == 1) {
            result.next = new ListNode(1);
        }
        return node.next;
    }
}