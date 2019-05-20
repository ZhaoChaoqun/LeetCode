package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _390 {


    public static void main(String[] args) {

    }
    public int lastRemaining(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++)
            set.add(i);
        int step = 2;
        while (set.size() != 1) {
            for (int i = 1; i <= n; i += step)
                set.remove(i);
        }
        while (set.size() != 1) {
            for (int i = 1; i <= n; i += step)
                set.remove(i);
        }
        return 0;
    }
}
