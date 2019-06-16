package leetcode;

public class _148_2 {

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
        ListNode result = new _148_2().sortList(node1);
        System.out.println(result);
    }
    private ListNode mergeSort(ListNode node) {
        ListNode head1 = node;
        ListNode head2 = node.next;
        ListNode node1 = head1;
        ListNode node2 = head2;
        for(node = node2.next; node != null;) {
            node1.next = node;
            node1 = node1.next;
            node = node.next;
            if(node == null)
                break;
            node2.next = node;
            node2 = node2.next;
            node = node.next;
        }
        node1.next = null;
        if(head1.next != null)
            head1 = mergeSort(head1);
        if(head2.next != null)
            head2 = mergeSort(head2);
        return merge(head1, head2);

    }
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(; node1 != null && node2 != null;) {
            if(node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
                node = node.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        for(; node1 != null; node1 = node1.next) {
            node.next = node1;
            node = node.next;
        }
        for(; node2 != null; node2 = node2.next) {
            node.next = node2;
            node = node.next;
        }
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        return mergeSort(head);
    }
}
