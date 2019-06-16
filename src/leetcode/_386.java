package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _386 {

    List<Integer> result = new ArrayList<>();
    int n;
    private void recursive(int base) {
        for(int i = 0; i < 10 - base % 10 && base + i <= n; i++) {
            result.add(base + i);
            recursive((base + i) * 10);
        }

    }
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        recursive(1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _386().lexicalOrder(120));
    }




}
