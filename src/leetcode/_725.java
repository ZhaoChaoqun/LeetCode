package leetcode;

import java.util.Arrays;

public class _725 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        for(ListNode node = root; node != null; count++, node = node.next);
        ListNode[] result = new ListNode[k];
        for(int i = 0; root != null; i++, k--) {
            result[i] = root;
            ListNode node = root;
            int average = count % k == 0 ? count / k : count / k + 1;
            count -= average;
            for(int j = 1; j < average && node.next != null; j++) {
                node = node.next;
            }
            root = node.next;
            node.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        _725 test = new _725();
        System.out.println(Arrays.toString(test.splitListToParts(node1, 5)));
    }
}
