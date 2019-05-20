package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        char min = Character.MAX_VALUE;
        for(char letter : letters) {
            if(letter > target && letter < min) {
                min = letter;
            }
        }
        if(min == Character.MAX_VALUE)
            target -= 26;
        for(char letter : letters) {
            if(letter > target && letter < min) {
                min = letter;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget test = new FindSmallestLetterGreaterThanTarget();
        char[] letters = new char[] {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(test.nextGreatestLetter(letters, target));

        letters = new char[] {'c', 'f', 'j'};
        target = 'c';
        System.out.println(test.nextGreatestLetter(letters, target));

        letters = new char[] {'c', 'f', 'j'};
        target = 'd';
        System.out.println(test.nextGreatestLetter(letters, target));

        letters = new char[] {'c', 'f', 'j'};
        target = 'g';
        System.out.println(test.nextGreatestLetter(letters, target));

        letters = new char[] {'c', 'f', 'j'};
        target = 'j';
        System.out.println(test.nextGreatestLetter(letters, target));

        letters = new char[] {'c', 'f', 'j'};
        target = 'k';
        System.out.println(test.nextGreatestLetter(letters, target));
    }
}
