package leetcode;

import java.util.*;

public class _752 {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        Set<String> deadendSet = new HashSet<>();
        for(String deadend : deadends)
            deadendSet.add(deadend);
        for(int count = 1; !queue.isEmpty(); count++) {
            for(int i = 0, size = queue.size(); i < size; i++) {
                String from = queue.poll();
                if(deadendSet.contains(from))
                    continue;
                List<String> neighbors = neighbors(from);
                for(String neighbor : neighbors) {
                    if(neighbor.equals(target))
                        return count;
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }


    private List<String> neighbors(String from) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = from.toCharArray();
        for(int i = 0; i < 4; i++) {
            char oldValue = chars[i];
            if(oldValue == '9') {
                chars[i] = '0';
            } else {
                chars[i] = (char) (oldValue + 1);
            }
            neighbors.add(new String(chars));
            if(oldValue == '0') {
                chars[i] = '9';
            } else {
                chars[i] = (char) (oldValue - 1);
            }
            neighbors.add(new String(chars));
            chars[i] = oldValue;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        _752 test = new _752();
        System.out.println(test.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(test.openLock(new String[] {"8888"}, "0009"));
        System.out.println(test.openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println(test.openLock(new String[] {"0000"}, "8888"));
        System.out.println((int)'0');
        System.out.println((int)'9');
        System.out.println((int)'1');
    }
}
