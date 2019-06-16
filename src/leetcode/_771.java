package leetcode;

public class _771 {

    public int numJewelsInStones(String J, String S) {
        int[] jArray = new int['z' - 'A' + 1];
        for(char c : J.toCharArray()) {
           jArray[c - 'A']++;
        }
        int count = 0;
        for(char c : S.toCharArray()) {
            if(jArray[c - 'A'] > 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _771().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new _771().numJewelsInStones("z", "ZZ"));
    }
}
