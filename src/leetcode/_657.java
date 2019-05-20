package leetcode;

public class _657 {


    public static void main(String[] args) {
        _657 test = new _657();
        System.out.println(test.judgeCircle("UD"));
        System.out.println(test.judgeCircle("LL"));
        System.out.println(test.judgeCircle("L"));
    }
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0)
            return false;
        char[] chars = moves.toCharArray();
        int up = 0, left = 0;
        for(char move : chars) {
            if(move == 'L')
                ++left;
            else if(move == 'R')
                --left;
            else if(move == 'U')
                ++up;
            else
                --up;
        }
        return left == 0 && up == 0;
    }
}
