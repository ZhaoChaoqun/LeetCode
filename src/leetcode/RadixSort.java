package leetcode;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {

    private void radixSort(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int exp = 1;
        for (; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    private void countSort(int[] array, int exp) {
        int[] count = new int[10];
        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        int[] aux = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--)
            aux[--count[(array[i] / exp) % 10]] = array[i];
        System.arraycopy(aux, 0, array, 0, aux.length);
    }

    public static void main(String[] args) {
        RadixSort test = new RadixSort();
        Random random = new Random();
//        int[] array = new int[100];
//        for(int i = 0; i < 100; i++)
//            array[i] = random.nextInt(Integer.MAX_VALUE) + 1;
        int[] array = new int[]{2001175215, 142955488, 1840971332, 2131764058, 888059502, 1256538821, 1344987857, 1889778637, 1636621615, 996898170, 842785497, 1640198779, 1326502262, 1605788671, 1781040372, 1890925956, 141392875, 912919870, 859734167, 16029882, 1083796977, 820192929, 1920936766, 609008769, 878660583, 1373401790, 385961525, 1288446160, 949510395, 908955950, 1937657604, 1843785300, 677795494, 1320008059, 1256797301, 1484660659, 1628875208, 2067395383, 890024515, 1030173933, 455743328, 637893929, 2056652129, 1613003487, 992205543, 1691628963, 2084899555, 1186072802, 619198538, 1722414575, 467049357, 46380688, 1194290051, 83292903, 222615031, 1467902887, 1233762259, 1450726564, 1556717913, 1212369925, 809693342, 419780431, 608850681, 2010800595, 163542498, 427058963, 1041760302, 1531086783, 240270933, 1791543603, 1105110800, 851866977, 2108369179, 1863353399, 332789694, 315813823, 1165390113, 1843616066, 6891595, 982007788, 1731836953, 695124095, 204987717, 4272587, 227073810, 411564730, 942199012, 376175857, 1777603251, 1501325835, 870810316, 825596328, 1194520851, 527008684, 2033244799, 634266640, 699086648, 1172884716, 1013401186, 915738465};
        System.out.println(Arrays.toString(array));
//        test.radixSort(array);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
