package leetcode;

public class _148 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = new _148().sortList(node1);
        System.out.println(result);
    }
    private ListNode[] quickSort(ListNode node) {
        if(node.next == null)
            return new ListNode[] {node, node};
        ListNode leftHead = null, left = null;
        ListNode rightHead = null, right = null;
        ListNode target = node;
        node = node.next;
        for(; node != null; node = node.next) {
            if(node.val >= target.val) {
                if(rightHead == null) {
                    rightHead = node;
                    right = rightHead;
                } else {
                    right.next = node;
                    right = node;
                }
            } else {
                if(leftHead == null) {
                    leftHead = node;
                    left = leftHead;
                } else {
                    left.next = node;
                    left = node;
                }
            }
        }
        if(left != null)
            left.next = null;
        if(right != null)
            right.next = null;
        if(leftHead != null && rightHead != null) {
            ListNode[] leftNodes = quickSort(leftHead);
            ListNode[] rightNodes = quickSort(rightHead);
            leftNodes[1].next = target;
            target.next = rightNodes[0];
            return new ListNode[] {leftNodes[0], rightNodes[1]};
        } else if(leftHead == null) {
            ListNode[] rightNodes = quickSort(rightHead);
            target.next = rightNodes[0];
            return new ListNode[] {target, rightNodes[1]};
        } else {
            ListNode[] leftNodes = quickSort(leftHead);
            leftNodes[1].next = target;
            target.next = null;
            return new ListNode[] {leftNodes[0], target};
        }

    }

    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return quickSort(head)[0];
    }
}
