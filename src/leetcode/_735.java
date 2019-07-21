package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class _735 {

    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int asteroid : asteroids) {
            if(asteroid < 0) {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if(stack.peek() == -asteroid) {
                    stack.pop();
                }
            } else {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--)
            result[i] = stack.pop();
        return result;
    }

    public static void main(String[] args) {
        _735 test = new _735();
        int[] asteroids = new int[] {8, -8};
        System.out.println(Arrays.toString(test.asteroidCollision(asteroids)));
    }

}
