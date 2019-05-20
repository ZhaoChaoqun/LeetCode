package leetcode;

public class _748 {
    public static void main(String[] args) {
        System.out.println(new _748().shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}));
        System.out.println(new _748().shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] license = licensePlate.toCharArray();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < words.length; i++) {
            int[] array = new int[26];
            for(char c : words[i].toCharArray())
                array[c - 'a']++;
            int j = 0;
            for(; j < license.length; j++) {
                if(license[j] >= 'a' && license[j] <= 'z') {
                    if(--array[license[j] - 'a'] < 0)
                        break;
                } else if (license[j] >= 'A' && license[j] <= 'Z') {
                    if(--array[license[j] - 'A'] < 0)
                        break;
                }
            }
            if(j == license.length && words[i].length() < min) {
                min = words[i].length();
                minIndex = i;
            }
        }
        return words[minIndex];
    }
}
