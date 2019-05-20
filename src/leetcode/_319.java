package leetcode;

import java.util.Arrays;

public class _319 {

    public static void main(String[] args) {
        _319 test = new _319();
        for(int i =1; i<=64; i++)
            System.out.println(i +  " " + test.bulbSwitch(i) +  " " + test.bulbSwitch2(i));
//        System.out.println(test.bulbSwitch(3));
        System.out.println(test.bulbSwitch(4));
//        System.out.println(test.bulbSwitch(5));
        System.out.println(test.bulbSwitch(5000));
    }


    public int bulbSwitch(int n) {
        int result = 1;
        return (int)Math.sqrt(n);
    }

    public int bulbSwitch3(int n) {
        int result = 1;
        for(int i = 2; i <= n; i++) {
            int factor = 1;
            for(int j = 2; j < i; j++) {
                if(i % j == 0)
                    factor++;
            }
            if(factor % 2 == 0)
                result++;
        }
        return result;
    }

    public int bulbSwitch2(int n) {
        int[] array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = i-1; j < n; j += i) {
                if(array[j] == 0)
                    array[j] = 1;
                else
                    array[j] = 0;
            }
//            System.out.println(Arrays.toString(array));
        }
        int count = 0;
        for(int i = 0; i < n; i++)
            if(array[i] == 1)
                ++count;
        return count;
    }

    int factor(int n) {
        int factor = 1;
        for (int i = 2; i < n; i++)
            if(n % i == 0)
                factor++;
        return factor;
    }
}
