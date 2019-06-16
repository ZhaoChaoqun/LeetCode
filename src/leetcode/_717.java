package leetcode;

public class _717 {

    private boolean backtracking(int[] bits, int i) {
        if(i == bits.length) return false;
        if(i == bits.length - 1 && bits[i] == 0) return true;
        if(bits[i] == 1) {
            return backtracking(bits, i + 2);
        } else {
            return backtracking(bits, i + 1) || backtracking(bits, i + 2);
        }
    }

    public boolean isOneBitCharacter(int[] bits) {
        return backtracking(bits, 0);
    }

    public static void main(String[] args) {
        System.out.println(new _717().isOneBitCharacter(new int[] {1, 0, 0}));
        System.out.println(new _717().isOneBitCharacter(new int[] {1, 1, 1, 0}));
    }
}
