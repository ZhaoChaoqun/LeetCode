package leetcode;

public class _445 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private int recursive(ListNode node1, ListNode node2, int i, int j) {
        if(node1 == null)
            return 0;
        int value;
        if(i > j) {
            value = node1.val + recursive(node1.next, node2, i - 1, j);
        } else {
            value = node1.val + node2.val + recursive(node1.next, node2.next, i - 1, j - 1);
        }
        node1.val = value % 10;
        return value / 10;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2;
        int i = 0, j = 0;
        for(; node1 != null; i++, node1 = node1.next);
        for(; node2 != null; j++, node2 = node2.next);
        if(i < j) {
            int tmp = i;
            i = j;
            j = tmp;
            ListNode node = l1;
            l1 = l2;
            l2 = node;
        }
        int carry = recursive(l1, l2, i, j);
        if(carry == 1) {
            ListNode root = new ListNode(1);
            root.next = l1;
            return root;
        }
        return l1;
    }

    public static void main(String[] args) {

    }
}
