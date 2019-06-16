package leetcode;

import java.util.LinkedList;

public class _433 {
    public static void main(String[] args) {
        _433 test = new _433();
        System.out.println(test.minMutation("AACCGGTT","AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(test.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(test.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        int i = 0;
        for(; i < bank.length; i++)
            if(end.equals(bank[i]))
                break;
        if(i == bank.length) return -1;
        int[] visited = new int[bank.length];
        visited[i] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(i);
        int step = 0;
        for(; !queue.isEmpty();) {
            step++;
            for(int j = 0, length = queue.size(); j < length; j++) {
                int index = queue.poll();
                if(isNeighbor(start, bank[index])) {
                    return step;
                }
                for(i = 0; i < bank.length; i++) {
                    if(visited[i] == 0 && isNeighbor(bank[i], bank[index])) {
                        visited[i] = 1;
                        queue.offer(i);
                    }
                }
            }

        }

        return -1;
    }

    private boolean isNeighbor(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int diff = 0;
        for(int i = 0; i < ac.length; i++) {
            if(ac[i] != bc[i]) {
                if(++diff == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
