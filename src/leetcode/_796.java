package leetcode;

public class _796 {
    public static void main(String[] args) {
//        System.out.println(new _796().rotateString("abcdef", "fabcde"));
        System.out.println(new _796().rotateString("bbbacddceeb", "ceebbbbacdd"));
    }

    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.equals(B)) return true;
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        for(int i = 1; i < charsA.length; i++) {
            int j = i;
            for(; j < charsA.length && charsA[j] == charsB[j-i]; j++);
            if(j != charsA.length) continue;
            j = 0;
            for(; j < i && charsA[j] == charsB[charsA.length - i + j]; j++);
            if(j == i) return true;
        }
        return false;
    }
}
