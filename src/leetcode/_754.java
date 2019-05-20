package leetcode;

public class _754 {

    public static void main(String[] args) {
        _754 test = new _754();
            System.out.println(30 + ": " + test.reachNumber(30));
    }
    private int recursive(int current, int target, int step) {
        if(current + step == target)
            return step;
        if(current + step > target)
            return recursive(current - step, target, step + 1);
        if(current - step < -target)
            return recursive(current + step, target, step + 1);
        int right = recursive(current + step, target, step + 1);
        if(right == -1)
            return recursive(current - step, target, step + 1);
        return Math.min(right, recursive(current - step, target, step + 1));
    }
    public int reachNumber(int target) {
        if(target == 0) return 0;
        return recursive(0, target, 1);
    }
}
