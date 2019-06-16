package leetcode;

public class _421 {
    public static void main(String[] args) {
        _421 test = new _421();
        System.out.println(test.findMaximumXOR(new int[] {3, 10, 5, 25, 2, 8}));
    }
    class TrieNode {
        TrieNode zero;
        TrieNode one;
        int value;

        TrieNode(int value) {
            this.value = value;
        }
    }
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int bits = 32 - Integer.numberOfLeadingZeros(max);
        TrieNode root = new TrieNode(0);
        for(int i = 0; i < nums.length; i++) {
            TrieNode node = root;
            for (int bit = bits - 1; bit >= 0; bit--) {
                if (((nums[i] >> bit) & 1) == 1) {
                    if (node.one == null)
                        node.one = new TrieNode(1);
                    node = node.one;
                } else {
                    if (node.zero == null)
                        node.zero = new TrieNode(0);
                    node = node.zero;
                }
            }
        }
        int maximumXOR = 0;
        for(int i = 0; i < nums.length; i++) {
            TrieNode node = root;
            int xor = 0;
            for (int bit = bits - 1; bit >= 0; bit--) {
                if (((nums[i] >> bit) & 1) == 1) {
                    if (node.zero != null) {
                        xor += 1 << bit;
                        node = node.zero;
                    } else {
                        node = node.one;
                    }
                } else {
                    if (node.one != null) {
                        xor += 1 << bit;
                        node = node.one;
                    } else {
                        node = node.zero;
                    }
                }
            }
            maximumXOR = Math.max(maximumXOR, xor);
        }
        return maximumXOR;
    }

}
